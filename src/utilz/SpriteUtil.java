package utilz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class SpriteUtil {

    private BufferedImage[][] loadSpriteAtlas(String path, int subImageWidth, int subImageHeight, int rows, int columns) {
        BufferedImage[][] sprites = null;
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedImage img = ImageIO.read(is);
            sprites = new BufferedImage[rows][columns];
            for (int j = 0; j < rows; j++) {
                for (int i = 0; i < columns; i++) {
                    sprites[j][i] = img.getSubimage(i * subImageWidth, j * subImageHeight, subImageWidth, subImageHeight);
                }
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sprites;
    }

    public BufferedImage[][] getSpriteAtlas(String path, int subImageWidth, int subImageHeight, int rows, int columns) {
        return loadSpriteAtlas(path, subImageWidth, subImageHeight, rows, columns);
    }



    /*
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

    private void importMulti() {
        idleMainShipAni = new BufferedImage[4];
        for (int i = 1; i <= idleMainShipAni.length; i++) {
            idleMainShipAni[i - 1] = importImgWithParameter("/mainShip/test/" + i + ".png");
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
     */


}
