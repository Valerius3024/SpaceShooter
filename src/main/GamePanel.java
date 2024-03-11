package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.EngineConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img;
    private BufferedImage[] idleMainShipAni;
    private BufferedImage[][] engineEffectAnis;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int engineEffect = BURST_IDLE;
    private int mainShipDir = -1;
    private boolean moving = false;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        importImg();
        importMulti();
        loadAnimations();

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        engineEffectAnis = new BufferedImage[8][7];

        for (int j = 0; j < engineEffectAnis.length; j++) {
            for (int i = 0; i < engineEffectAnis[j].length; i++) {
                engineEffectAnis[j][i] = img.getSubimage(i * 48, j * 48, 48, 48);
            }
        }

    }

    private void importMulti() {
        idleMainShipAni = new BufferedImage[4];
        for (int i = 1; i <= idleMainShipAni.length; i++) {
            idleMainShipAni[i - 1] = importImgWithParameter("/mainShip/test/" + i + ".png");
        }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/mainShip/engine effects/engine_effects_sprite.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private BufferedImage importImgWithParameter(String filepath) {
        InputStream is = getClass().getResourceAsStream(filepath);
        try {
            BufferedImage read = ImageIO.read(is);
            return read;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }

    public void setDirection(int direction) {
        this.mainShipDir = direction;
        moving = true;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void updateAniTick() {

        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= getSpriteAmount(engineEffect))
                aniIndex = 0;
        }

    }

    private void setAnimation(){
        if (moving)
            engineEffect = BURST_POWER_UP;
        else
            engineEffect = BURST_IDLE;
    }

    private void updatePos() {

        if (moving){
            switch (mainShipDir){
                case LEFT:
                    xDelta-=3;
                    break;
                case UP:
                    yDelta-=3;
                    break;
                case RIGHT:
                    xDelta+=3;
                    break;
                case DOWN:
                    yDelta+=3;
                    break;
            }
        }

    }

    public void updateGame(){
        updateAniTick();
        setAnimation();
        updatePos();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(img.getSubimage(0, 0, 48, 48), (int) xDelta, (int) yDelta, 96, 96, null);
        g.drawImage(importImgWithParameter("/mainShip/engines/Main Ship - Engines - Burst Engine.png").getSubimage(0, 0, 48, 48)
                , (int) xDelta, (int) yDelta, 96, 96, null);

        g.drawImage(engineEffectAnis[engineEffect][aniIndex], (int) xDelta, (int) yDelta+17, 96, 96, null);
        g.drawImage(idleMainShipAni[0], (int) xDelta, (int) yDelta, 96, 96, null);



    }



}
