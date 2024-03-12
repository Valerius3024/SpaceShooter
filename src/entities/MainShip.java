package entities;

import utilz.SpriteUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.Directions.*;
import static utilz.Constants.Directions.DOWN;
import static utilz.Constants.EngineConstants.*;

public class MainShip extends Entity {
    private BufferedImage[][] engineEffectAnis, mainShipBases, engines;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int engineEffect = BURST_IDLE;
    private int mainShipDir = -1;
    private boolean moving = false;
    private SpriteUtil spriteUtil = new SpriteUtil();


    public MainShip(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {
        updateAniTick();
        setAnimation();
        updatePos();
    }

    public void render(Graphics g) {
        g.drawImage(engines[0][2], (int) x, (int) y, 96, 96, null);
        g.drawImage(engineEffectAnis[engineEffect][aniIndex], (int) x, (int) y, 96, 96, null);
        g.drawImage(mainShipBases[0][1], (int) x, (int) y, 96, 96, null);
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

    private void setAnimation() {
        if (moving)
            engineEffect = BURST_POWER_UP;
        else
            engineEffect = BURST_IDLE;
    }

    private void updatePos() {

        if (moving) {
            switch (mainShipDir) {
                case LEFT:
                    x -= 1;
                    break;
                case UP:
                    y -= 1;
                    break;
                case RIGHT:
                    x += 1;
                    break;
                case DOWN:
                    y += 1;
                    break;
            }
        }

    }

    private void loadAnimations() {

        engineEffectAnis = spriteUtil.getSpriteAtlas("/mainShip/engine effects/engine_effects_sprite.png", 48, 48, 8, 7);
        mainShipBases = spriteUtil.getSpriteAtlas("/mainShip/bases/main_ship_atlas.png", 48, 48, 1, 4);
        engines = spriteUtil.getSpriteAtlas("/mainShip/engines/engines_sprite.png", 48, 48, 1, 4);
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


}
