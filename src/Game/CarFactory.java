package Game;

import Game.Actors.BaseActor;
import Game.Isometric.Helper;
import Game.Isometric.IsoCar;

import java.util.LinkedList;

public class CarFactory {

    public static LinkedList<Integer> leftRows;
    public static LinkedList<Integer> rightRows;

    public static String getCarImage(MovementDir moveDir){
        return MovementDir.LEFT.equals(moveDir) ? "src/resources/Roadster_64L.png" : "src/resources/Roadster_64L.png";
    }


    public static void generateIsoCar(LinkedList<IsoCar> cars){
        Lanes randomLane = Lanes.values()[(int)(Math.random() * Lanes.values().length)]; //Generates a random lane position

        for(IsoCar c : cars){
            int[] carGridPos = Helper.toGrid(c.getCarPic().getX(), c.getCarPic().getY());

            int colDiff = Math.abs(randomLane.getStartCol() - carGridPos[0]);
            int rowDiff = Math.abs(randomLane.getStartRow() - c.getSavedStartRow());

            if(colDiff < 4 && rowDiff == 0 )
                return;
        }

        cars.add(new IsoCar(randomLane.getStartCol(), randomLane.getStartRow(), randomLane.getMoveDir()));
    }
}
