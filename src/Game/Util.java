package Game;

import Game.Grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Util {

    public static int getImageWidth(String imagePath){
        return new Picture(0,0, imagePath).getWidth();
    }

    public static int getImageHeight(String imagePath){
        return new Picture(0,0, imagePath).getHeight();
    }

    public static int getColX(int colPos){
        return Grid.PADDING + (colPos * Grid.CELLSIZE);
    }

    public static int getRowY(int rowPos){
            return Grid.PADDING + (rowPos * Grid.CELLSIZE);
    }

    public static float getDistance(int posOne, int posTwo){
        return Math.abs((float)posOne - (float)posTwo);
    }
}
