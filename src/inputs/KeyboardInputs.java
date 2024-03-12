package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static utilz.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamePanel.getGame().getMainShip().setDirection(UP);
                break;
            case KeyEvent.VK_A:
                gamePanel.getGame().getMainShip().setDirection(LEFT);
                break;
            case KeyEvent.VK_S:
                gamePanel.getGame().getMainShip().setDirection(DOWN);
                break;
            case KeyEvent.VK_D:
                gamePanel.getGame().getMainShip().setDirection(RIGHT);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                gamePanel.getGame().getMainShip().setMoving(false);
                break;
        }

    }


}
