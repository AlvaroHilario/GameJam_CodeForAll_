package Game;

import Game.Isometric.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements MouseHandler, KeyboardHandler {

    private Mouse mouse;
    private Keyboard keyboard;
    private Picture imgStartButton;
    private Picture imgQuitButton;
    private Picture imgTitle;
    private Picture background;
    private double mainWidth = (64 * 25);
    private double mainHeight = (64 * 24) / 1.75;
    public boolean clicked;
    private Cross4All cross4All;


    public Menu(Cross4All cross4All) {
        this.cross4All = cross4All;
        background = new Picture(Grid.PADDING, Grid.PADDING, "resources/Menu_BackgroundA.png");
        background.draw();
        startButton();

    }

    public void startButton() {
        imgTitle = new Picture((mainWidth / 2) - ((double) 886 / 2), Grid.PADDING, "resources/GameButton.png");
        imgTitle.draw();
        imgStartButton = new Picture((mainWidth / 2) - ((double) 322 / 2), Grid.PADDING + (134 * 3), "resources/Play_Button_BLUE.png");
        imgStartButton.draw();
        imgQuitButton = new Picture(mainWidth / 2 - ((double) 322 / 2), ((mainHeight + Grid.PADDING) - (134 * 2) - 20), "resources/QuitButton.png");
        imgQuitButton.draw();

        init();
    }

    private void init() {

        //Mouse

        mouse = new Mouse(this);

        MouseEvent mouseClick = new MouseEvent(0, 0, MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        MouseEvent mouseMove = new MouseEvent(0, 0, MouseEventType.MOUSE_MOVED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        //Keyboard

        keyboard = new Keyboard(this);

        KeyboardEvent startGame = new KeyboardEvent();
        startGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        startGame.setKey(KeyboardEvent.KEY_S);

        KeyboardEvent quitGame = new KeyboardEvent();
        quitGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        quitGame.setKey(KeyboardEvent.KEY_Q);

        keyboard.addEventListener(quitGame);
        keyboard.addEventListener(startGame);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (!clicked) {
            if (mouseEvent.getX() >= imgStartButton.getX() && mouseEvent.getX() <= imgStartButton.getX() + imgStartButton.getWidth() &&
                    mouseEvent.getY() - 24 >= imgStartButton.getY() && mouseEvent.getY() - 24 <= imgStartButton.getY() + imgStartButton.getHeight()) {
                imgQuitButton.delete();
                imgStartButton.delete();
                imgTitle.delete();
                System.out.println("Starting game.");
                setTrue();

            }
            if (mouseEvent.getX() >= imgQuitButton.getX() && mouseEvent.getX() <= imgQuitButton.getX() + imgQuitButton.getWidth() &&
                    mouseEvent.getY() - 24 >= imgQuitButton.getY() && mouseEvent.getY() - 24 <= imgQuitButton.getY() + imgQuitButton.getHeight()) {
                System.out.println("Quiting game.");
                setTrue();
                System.exit(1);
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (!clicked) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_S:
                    imgQuitButton.delete();
                    imgStartButton.delete();
                    imgTitle.delete();
                    clicked = true;
                    cross4All.setClicked(true);
                    setTrue();
                    break;
                case KeyboardEvent.KEY_Q:
                    setTrue();
                    System.exit(1);
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void setTrue() {
        clicked = true;
        cross4All.setClicked(true);
    }
}
