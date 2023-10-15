package Game;

import Game.Actors.Car;
import Game.Grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class CarFactory {

    public static String getCarImage(){
        return "src/resources/carW.png";
    }

    public static void generateCar(LinkedList<Car> cars){

        //Todo this is a bad implementation
        String carImage = getCarImage();
        int imageWidth = Util.getImageWidth(carImage);
        int startCol = Grid.COLS - (imageWidth / Grid.CELLSIZE);
        int startRow = 4;

        for(Car c : cars){

            int what = Util.getColX(startCol);
            float distanceX = Util.getDistance(c.getX() , Util.getColX(startCol));
            float distanceY = Util.getDistance(c.getY(), Util.getRowY(startRow));

            float minDistance = (float)((Math.random() * 250) + 50);

            if(distanceX < minDistance)
                return;
        }

       cars.add(new Car(startCol, startRow, carImage));
    }
}
