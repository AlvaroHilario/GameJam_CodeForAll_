package Game;

import Game.Actors.BaseActor;
import Game.Actors.Car;
import Game.Isometric.Helper;
import Game.Isometric.IsoCar;

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

        for(BaseActor c : cars){

            float distanceX = Util.getDistance(c.getX() , Util.getColX(randomLane.getStartCol()));
            float distanceY = Util.getDistance(c.getY(), Util.getRowY(randomLane.getStartRow()));

            float minDistance = (float)((Math.random() * 250) + 50);

            if(distanceX < minDistance && distanceY < 1)
                return;
        }

       cars.add(new Car(randomLane.getStartCol(), randomLane.getStartRow(), getCarImage(randomLane.getMoveDir()), randomLane.getMoveDir()));
    }

    public static void generateIsoCar(LinkedList<IsoCar> cars){
        Lanes randomLane = Lanes.values()[(int)(Math.random() * Lanes.values().length)]; //Generates a random lane position

        for(IsoCar c : cars){

            int[] lanePos = Helper.toIso(randomLane.getStartCol(), randomLane.getStartRow());

            int[] carGridPos = Helper.toGrid(c.getCarPic().getX(), c.getCarPic().getY());

            int colDiff = Math.abs(randomLane.getStartCol() - carGridPos[0]);
            int rowDiff = Math.abs(randomLane.getStartRow() - c.getSavedStartRow());


            if(colDiff < 4 && rowDiff == 0 )
                return;
        }

        cars.add(new IsoCar(randomLane.getStartCol(), randomLane.getStartRow(), randomLane.getMoveDir()));
    }
}
