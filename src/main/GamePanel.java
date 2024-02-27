package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img;
    private BufferedImage[] idleMainShipAni;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        // importImg();

        importMulti();

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void importMulti() {
        idleMainShipAni = new BufferedImage[4];
        for (int i = 1; i <= idleMainShipAni.length; i++) {
            idleMainShipAni[i - 1] = importImgWithParameter("/mainShip/test/" + i + ".png");
        }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/mainShip/test/1.png");

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
        Dimension size = new Dimension(1000, 700);
        setPreferredSize(size);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //  g.drawImage(img.getSubimage(0, 0, 48, 48), (int) xDelta - 30, (int) yDelta - 30, 128, 128, null);
        g.drawImage(idleMainShipAni[0], (int) xDelta, (int) yDelta, 128, 128, null);
    }


}
