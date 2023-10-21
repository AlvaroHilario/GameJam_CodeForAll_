package Game;

import Game.Actors.BaseActor;
import Game.Isometric.Helper;
import Game.Isometric.IsoCar;

import java.util.LinkedList;
import java.util.List;

public class CarFactory {

    public static LinkedList<Integer> leftRows;
    public static LinkedList<Integer> rightRows;

    public static String getCarImage(MovementDir moveDir){
        CarPictures carPic = CarPictures.values()[(int)(Math.random() * CarPictures.values().length)];
        return carPic.getCarPic(moveDir);
    }

    public static void generateIsoCar(List<IsoCar> cars, int carspeed){
        Lanes randomLane = Lanes.values()[(int)(Math.random() * Lanes.values().length)]; //Generates a random lane position

        for(IsoCar c : cars){
            int[] carGridPos = Helper.toGrid(c.getCarPic().getX(), c.getCarPic().getY());

            int colDiff = Math.abs(randomLane.getStartCol() - carGridPos[0]);
            int rowDiff = Math.abs(randomLane.getStartRow() - c.getSavedStartRow());

            if(colDiff < 4 && rowDiff == 0 )
                return;
        }

        cars.add(new IsoCar(randomLane.getStartCol(), randomLane.getStartRow(), randomLane.getMoveDir(), CarFactory.getCarImage(randomLane.getMoveDir()), carspeed));
    }

    public static void generateIsoCar(List<IsoCar> cars, Difficulty difficulty){
        Lanes randomLane = Lanes.generateRandomLane(difficulty); //Generates a random lane position

        for(IsoCar c : cars){
            int[] carGridPos = Helper.toGrid(c.getCarPic().getX(), c.getCarPic().getY());
            int rowDiff = Math.abs(randomLane.getStartRow() - c.getSavedStartRow());

            if(rowDiff != 0)
                continue;

            int colDiff = Math.abs(randomLane.getStartCol() - carGridPos[0]);

            if(colDiff < 4)
                return;
        }

        cars.add(new IsoCar(randomLane.getStartCol(), randomLane.getStartRow(), randomLane.getMoveDir(), CarFactory.getCarImage(randomLane.getMoveDir()), difficulty.getCarSpeed()));
    }



    public enum CarPictures{
        CISTERN("src/resources/Cistern_64L.png", "src/resources/Cistern_64R.png"),
        FIRETRUCK("src/resources/Firetruck_64L.png", "src/resources/Firetruck_64R.png"),
        LUXURY("src/resources/Luxury_Car_64L.png", "src/resources/Luxury_Car_64R.png"),
        PICKUP("src/resources/Pick_up_64L.png", "src/resources/Pick_up_64R.png"),
        RACING("src/resources/Racing_Car_64L.png", "src/resources/Racing_Car_64R.png"),
        REGULAR("src/resources/Regular_Car_64L.png", "src/resources/Regular_Car_64R.png"),
        ROADSTER("src/resources/Roadster_64L.png", "src/resources/Roadster_64R.png");

        private String carPicLeft, carPicRight;

        CarPictures(String carPicLeft, String carPicRight){
            this.carPicLeft = carPicLeft;
            this.carPicRight = carPicRight;
        }

        public String getCarPic(MovementDir moveDir){
            return MovementDir.LEFT.equals(moveDir) ? this.carPicLeft : this.carPicRight;
        }
    }
}
