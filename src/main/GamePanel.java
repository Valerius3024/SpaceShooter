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

    public static final String MAIN_SHIP_ATLAS_PNG = "/mainShip/test/1.png";
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img;
    private BufferedImage[] idleMainShipAni;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        importImg();
        loadAnimations();

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadImages(){
        img = importImg(MAIN_SHIP_ATLAS_PNG)
    }

    private void loadAnimations() {
        idleMainShipAni = new BufferedImage[3];
        for (int i = 0; i < idleMainShipAni.length; i++) {
            //idleMainShipAni[i] = importImg();
        }
    }


    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/mainShip/bases/main_ship_atlas.png");

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

    /*

    public BufferedImage importImg(String filePath) {
        InputStream is = getClass().getResourceAsStream(filePath);
        BufferedImage ing;

        try {
            ing = ImageIO.read(is);
            return ing;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                return ing;
            } catch (IOException e) {

                e.printStackTrace();
            }

        }

    }

    private BufferedImage[] importImg(String filePath, int x) {

        BufferedImage[] arr = new BufferedImage[x];
        for (int i = 0; i < x; i++) {
            arr[x] = importImg(x+""+filePath);
        }
        return arr;
    }

     */




    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
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

        g.drawImage(img.getSubimage(0, 0, 48, 48), (int) xDelta - 30, (int) yDelta - 30, 128, 128, null);
        //g.drawImage(img, (int) xDelta, (int) yDelta, 128, 128, null);
    }


}
