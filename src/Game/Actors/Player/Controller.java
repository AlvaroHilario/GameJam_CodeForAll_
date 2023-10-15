package Game.Actors.Player;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/** Used to handle the input*/
public class Controller  implements KeyboardHandler {

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

        keyboard.addEventListener(rightKeyPressed);
        keyboard.addEventListener(leftKeyPressed);
        keyboard.addEventListener(downKeyPressed);
        keyboard.addEventListener(upKeyPressed);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
