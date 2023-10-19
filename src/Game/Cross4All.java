package Game;

import Game.Actors.Car;
import Game.Grid.Grid;
import Game.Actors.Player.Player;
import Game.Isometric.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

/** Main game logic */
public class Cross4All implements Game{
    private Grid grid;
    private Player player;
    //private LinkedList<Car> cars;
    private LinkedList<IsoCar> isoCars;

    public Cross4All(){
        Rectangle rect = new Rectangle(10,10, (64 * 25), (64*24) / 1.75);
        rect.draw();
        this.grid = new Grid();
        new IsoGrid();
        RoadFactory.createRoads();

        //this.cars = new LinkedList<Car>();
        this.isoCars = new LinkedList<IsoCar>();
        this.player = new Player(isoCars);
        player.getPlayerController().keyboardInit();
    }

    public void run() {
        while (true) { //Todo create game loop logic

                if (isoCars.size() < 100) {
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
}
