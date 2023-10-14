import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Character implements KeyboardHandler {

    private Rectangle character;
    private int heigthLimit;
    private int widthLimit;



    public Character(int fieldHeight, int fieldWidth) {
        this.heigthLimit = fieldHeight;
        this.widthLimit = fieldWidth;
        this.character = new Rectangle(100, 100, 48, 48);
        this.character.setColor(Color.PINK);
        this.character.fill();
        keyboardInit();
    }


    public void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKeyPressed.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent downKeyPressed = new KeyboardEvent();
        downKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKeyPressed.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent rightKeyPressed = new KeyboardEvent();
        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);

        keyboard.addEventListener(upKeyPressed);
        keyboard.addEventListener(downKeyPressed);
        keyboard.addEventListener(leftKeyPressed);
        keyboard.addEventListener(rightKeyPressed);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == keyboardEvent.KEY_UP) {
            character.translate(0,-10);
         } else if (keyboardEvent.getKey() == keyboardEvent.KEY_DOWN) {
            character.translate(0, 10);
        } else if (keyboardEvent.getKey() == keyboardEvent.KEY_LEFT) {
            character.translate(-10, 0);
        } else if (keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT) {
            character.translate(10, 0);
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
