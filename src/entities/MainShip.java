package entities;

import utilz.SpriteUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.EngineConstants.*;

public class MainShip extends Entity {
    private BufferedImage[][] engineEffectAnis, mainShipBases, engines;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int engineEffect = BURST_IDLE;
    private boolean moving = false;
    private boolean left, up, right, down;
    private float playerSpeed = 2.0f;

    private SpriteUtil spriteUtil = new SpriteUtil();


    public MainShip(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {
        updatePos();
        updateAniTick();
        setAnimation();
    }

    public void render(Graphics g) {
        g.drawImage(engines[0][2], (int) x, (int) y, 96, 96, null);
        g.drawImage(engineEffectAnis[engineEffect][aniIndex], (int) x, (int) y, 96, 96, null);
        g.drawImage(mainShipBases[0][1], (int) x, (int) y, 96, 96, null);
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

    private void setAnimation() {
        if (moving)
            engineEffect = BURST_POWER_UP;
        else
            engineEffect = BURST_IDLE;
    }

    private void updatePos() {

        moving = false;

        if (left && !right) {
            x -= playerSpeed;
            moving = true;
        } else if (right && !left) {
            x += playerSpeed;
            moving = true;
        }


        if (up && !down) {
            y -= playerSpeed;
            moving = true;
        } else if (down && !up) {
            y += playerSpeed;
            moving = true;
        }

    }

    private void loadAnimations() {

        engineEffectAnis = spriteUtil.getSpriteSheet("/mainShip/engine effects/engine_effects_sprite.png", 48, 48, 8, 7);
        mainShipBases = spriteUtil.getSpriteSheet("/mainShip/bases/main_ship_atlas.png", 48, 48, 1, 4);
        engines = spriteUtil.getSpriteSheet("/mainShip/engines/engines_sprite.png", 48, 48, 1, 4);
        /*
        InputStream is = getClass().getResourceAsStream("/mainShip/engine effects/engine_effects_sprite.png");

        try {

            BufferedImage img = ImageIO.read(is);

            engineEffectAnis = new BufferedImage[8][7];
            for (int j = 0; j < engineEffectAnis.length; j++)
                for (int i = 0; i < engineEffectAnis[j].length; i++)
                    engineEffectAnis[j][i] = img.getSubimage(i * 48, j * 48, 48, 48);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
*/
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
