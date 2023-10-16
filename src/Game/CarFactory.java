package Game;

import Game.Actors.Car;
import Game.Grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class CarFactory {

    public static LinkedList<Integer> leftRows;
    public static LinkedList<Integer> rightRows;


    public static String getCarImage(MovementDir moveDir){
        return MovementDir.LEFT.equals(moveDir) ? "src/resources/carW.png" : "src/resources/carX.png";
    }

    public static void generateCar(LinkedList<Car> cars){

        //Todo this is a bad implementation
        Lanes randomLane = Lanes.values()[(int)(Math.random() * Lanes.values().length)]; //Generates a random lane position

        for (Car c : cars) {

            int what = Util.getColX(randomLane.getStartCol());
            float distanceX = Util.getDistance(c.getX() , Util.getColX(randomLane.getStartCol()));
            float distanceY = Util.getDistance(c.getY(), Util.getRowY(randomLane.getStartRow()));

            float minDistance = (float) ((Math.random() * 250) + 50);

            if (distanceX < minDistance && distanceY < 1)
                return;
        }

       cars.add(new Car(randomLane.getStartCol(), randomLane.getStartRow(), getCarImage(randomLane.getMoveDir()), randomLane.getMoveDir()));
    }
}
