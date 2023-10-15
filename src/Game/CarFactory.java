package Game;

import Game.Actors.Car;
import Game.Grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class CarFactory {

    public static LinkedList<Integer> leftRows;
    public static LinkedList<Integer> rightRows;

    public static String getCarImage(MovementDir moveDir) {
        return MovementDir.LEFT.equals(moveDir) ? "src/resources/carW.png" : "src/resources/carX.png";
    }

    /* This is used to get the starting rows by the color of the tarmac */
    public static int generateStartRows(Grid grid) {

        Picture backgroundImage = grid.getBackground();
        for (int i = 0; i < grid.getBackground().pixels(); i *= grid.getBackground().getWidth()) {

            Color pixelColor = backgroundImage.getColorAt(i);

            if (pixelColor.getRed() == 64 && pixelColor.getGreen() == 156 && pixelColor.getBlue() == 98) {
                int startRow = Util.getPixelPos(i);
                System.out.println("Found");
            }

        }

        Color color = grid.getBackground().getColorAt(grid.getBackground().getX() + Util.getRowY(5));
        System.out.printf("R: %d G: %d B: %d", color.getRed(), color.getGreen(), color.getBlue());
        return 1;
    }

    public static void generateCar(LinkedList<Car> cars) {

        //Todo this is a bad implementation
        int startRow = Math.random() < 0.3 ? 4 : Math.random() < 0.5 ? 8 : 11;
        MovementDir moveDir = startRow == 11 ? MovementDir.RIGHT : MovementDir.LEFT;

        String carImage = getCarImage(moveDir);
        int imageWidth = Util.getImageWidth(carImage);

        int startCol = moveDir.equals(MovementDir.RIGHT) ? 0 : Grid.COLS - (imageWidth / Grid.CELLSIZE);

        for (Car c : cars) {

            int what = Util.getColX(startCol);
            float distanceX = Util.getDistance(c.getX(), Util.getColX(startCol));
            float distanceY = Util.getDistance(c.getY(), Util.getRowY(startRow));

            float minDistance = (float) ((Math.random() * 250) + 50);

            if (distanceX < minDistance && distanceY < 1)
                return;
        }

        cars.add(new Car(startCol, startRow, carImage, moveDir));
    }
}
