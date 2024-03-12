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
            case KeyEvent.VK_W -> gamePanel.getGame().getMainShip().setUp(true);
            case KeyEvent.VK_A -> gamePanel.getGame().getMainShip().setLeft(true);
            case KeyEvent.VK_S -> gamePanel.getGame().getMainShip().setDown(true);
            case KeyEvent.VK_D -> gamePanel.getGame().getMainShip().setRight(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.getGame().getMainShip().setUp(false);
            case KeyEvent.VK_A -> gamePanel.getGame().getMainShip().setLeft(false);
            case KeyEvent.VK_S -> gamePanel.getGame().getMainShip().setDown(false);
            case KeyEvent.VK_D -> gamePanel.getGame().getMainShip().setRight(false);
        }

    }




}
