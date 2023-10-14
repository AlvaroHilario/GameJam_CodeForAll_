package Game;

import Game.Actors.Car;
import Game.Grid.Grid;

import java.util.LinkedList;

public class CarFactory {

    public static void generateCar(LinkedList<Car> cars){

        int col = 48; //todo modify this
        int row = 3;

        for(Car c : cars){

            if(c.getCarPic().getX() + c.getCarPic().getWidth() + 50 == ((48 * Grid.CELLSIZE) * (Grid.SCALE + 1)) + Grid.PADDING)
                return;

        }

       cars.add(new Car());
    }

}
