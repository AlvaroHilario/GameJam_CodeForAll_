package Game;

import Game.Grid.Grid;
import Game.Isometric.Helper;
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

    public static double[] translateMovement(Picture pic, MovementDir moveDir, double speed){

        int[] cenasOld = Helper.toIso(pic.getX(), pic.getY());
        int[] cenas = Helper.toIso(pic.getX(), pic.getY());
        int[] newCenas = new int[2];
        newCenas[0]= cenas[0] - cenasOld[0];
        newCenas[1]= cenas[1] - cenasOld[1];

        double speedX = speed / 2;
        double speedY = speed / 4;

        double[] diff = new double[2];
        switch (moveDir){
            case UP:
                diff[0] = (double)(newCenas[0]) + speedX;
                diff[1] = (double)(newCenas[1]) - speedY;
                break;
            case DOWN:
                diff[0] = (double)(newCenas[0]) - speedX;
                diff[1] = (double)(newCenas[1]) + speedY;
                break;
            case LEFT:
                diff[0] = (double)(newCenas[0]) - speedX;
                diff[1] = (double)(newCenas[1]) - speedY;
                break;
            case RIGHT:
                diff[0] = (double)(newCenas[0]) + speedX;
                diff[1] = (double)(newCenas[1]) + speedY;
                break;
            default:
                diff[0] = 0;
                diff[1] = 0;
                break;
        }

        return diff;
    }

}
