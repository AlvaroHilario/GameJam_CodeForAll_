package Game;

import Game.Actors.Player.Player;
import Game.Isometric.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;

/** Main game logic */
public class Cross4All implements Game, KeyboardHandler {
    private Player player;
    private LinkedList<IsoCar> isoCars;
    private Keyboard keyboard;
    private boolean clicked = false;

    public Cross4All(){
        Menu menu = new Menu(this);
        while (!clicked) {
            try {
                Thread.sleep(25);
            } catch (Exception e) {
                System.out.println("Add exception");
            }
        }
        init();
        //Rectangle rect = new Rectangle(10,10, (64 * 25), (64*24) / 1.75);
        //rect.draw();


        new Grid();
        RoadFactory.createRoads();

        this.isoCars = new LinkedList<IsoCar>();
        this.player = new Player(isoCars);
        player.getPlayerController().keyboardInit();


        Props newProp = new Props(23,23, "src/resources/beach.png");
    }

    public void run() {
        while (true) { //Todo create game loop logic

                if (isoCars.size() < 200) {
                    CarFactory.generateIsoCar(isoCars);
                }

                //player.getPlayerPic().delete();
                //player.getPlayerPic().draw();

                for(IsoCar c : isoCars){
                    if( c.checkCollision(player) || !player.isAlive()) {

                        player.getPlayerPic().delete();
                        player = new Player(isoCars);
                    }

                        //System.exit(100);
                }

                for (int i = 0; i < isoCars.size(); i++) {

                    //FIXME the car going to the right -> is pushing the window direction
                    if (isoCars.get(i).getMoveDir().equals(MovementDir.RIGHT) && !Helper.gridLimitsRight(isoCars.get(i).getCarPic())) {
                        isoCars.get(i).deleteCar();
                        isoCars.remove(i);
                    }
                    else if (isoCars.get(i).getMoveDir().equals(MovementDir.LEFT) && !Helper.gridLimitsLeft(isoCars.get(i).getCarPic())) {
                        isoCars.get(i).deleteCar();
                        isoCars.remove(i);
                    }
                }

                for (int i = 0; i < isoCars.size(); i++) {
                    isoCars.get(i).move();
                }

                try {
                    Thread.sleep(25);
                } catch (Exception e) {
                    System.out.println("Add exception");
                }
        }
    }

    private void init(){
        keyboard = new Keyboard(this);
        KeyboardEvent quitGame = new KeyboardEvent();
        quitGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        quitGame.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(quitGame);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        System.out.println("Quited game.");
        System.exit(1);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

}
