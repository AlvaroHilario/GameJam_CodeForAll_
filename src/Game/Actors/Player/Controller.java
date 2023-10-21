package Game.Actors.Player;

import Game.Isometric.IsoCar;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Used to handle the input
 */
public class Controller implements KeyboardHandler {

    private Player playerOwner;
    private boolean canMove;

    public Controller(Player playerOwner){
        this.playerOwner = playerOwner;
        this.canMove = true;
    }

    public void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightKeyPressed = new KeyboardEvent();
        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent downKeyPressed = new KeyboardEvent();
        downKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKeyPressed.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKeyPressed.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent upKeyReleased = new KeyboardEvent();
        upKeyReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        upKeyReleased.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent rightKeyReleased = new KeyboardEvent();
        rightKeyReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rightKeyReleased.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent leftKeyReleased = new KeyboardEvent();
        leftKeyReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        leftKeyReleased.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent downKeyReleased = new KeyboardEvent();
        downKeyReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        downKeyReleased.setKey(KeyboardEvent.KEY_DOWN);
        
        //Press listeners
        keyboard.addEventListener(rightKeyPressed);
        keyboard.addEventListener(leftKeyPressed);
        keyboard.addEventListener(downKeyPressed);
        keyboard.addEventListener(upKeyPressed);

        //Key releases
        keyboard.addEventListener(upKeyReleased);
        keyboard.addEventListener(downKeyPressed);
        keyboard.addEventListener(leftKeyPressed);
        keyboard.addEventListener(rightKeyPressed);
        keyboard.addEventListener(downKeyReleased);
        keyboard.addEventListener(leftKeyReleased);
        keyboard.addEventListener(rightKeyReleased);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        for (IsoCar c : playerOwner.getCarList()) {
            if (c.checkCollision(playerOwner)) {
                playerOwner.setAlive(false);
            }
        }

        if(canMove) {

            if(playerOwner == null)
                return;

            if(!playerOwner.isAlive())
                return;

            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_LEFT:
                    playerOwner.moveLeft();
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    playerOwner.moveRight();
                    break;
                case KeyboardEvent.KEY_UP:
                    playerOwner.moveUp();
                    break;
                case KeyboardEvent.KEY_DOWN:
                    playerOwner.moveDown();
                    break;
            }

            for (IsoCar c : playerOwner.getCarList()) {
                if (c.checkCollision(playerOwner)) {
                    playerOwner.setAlive(false);
                }
            }
            canMove = false;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        canMove = true;
    }
}
