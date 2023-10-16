package Game;

import Game.Grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Shape;
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

    public static int getPixelPos(int gridPos){
        return Grid.PADDING + (gridPos * Grid.CELLSIZE);
    }

    public static int getGridPos(int pixel){
        return (pixel - Grid.PADDING) / Grid.CELLSIZE;
    }

    public static int getYRow(int yPixel){
        return (yPixel - Grid.PADDING) / Grid.CELLSIZE;
    }

    public static float getDistance(int posOne, int posTwo){
        return Math.abs((float)posOne - (float)posTwo);
    }

    public static float getDistance2D(Shape objOne, Shape objTwo){
        return (float)Math.sqrt(Math.pow(objTwo.getX() - objOne.getX(), 2) - Math.pow(objTwo.getY() - objOne.getY(), 2));
    }

}
