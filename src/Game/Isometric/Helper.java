package Game.Isometric;

import Game.MovementDir;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Vector;

public class Helper {
    private static int TILE_WIDTH_HALF = 64/2; //ImageWidth estamos a usar 64x64 tiles
    private static int TILE_HEIGHT_HALF = 64/2; //ImageHeight

    private static int TILE_WIDTH_QUARTER = TILE_WIDTH_HALF/2;
    private static int TILE_HEIGHT_QUARTER = TILE_HEIGHT_HALF/2;

    public static int[] toIso(int x, int y){

        int i = (x - y) * TILE_WIDTH_HALF;
        int j = (x + y) * TILE_HEIGHT_QUARTER;

        i += 810-TILE_WIDTH_HALF;
        j+=50;

        return new int[]{i,j};
    }

    public static int[] toGrid(double i, double j){

        i-=810;
        j-=50;

        double tx = Math.ceil(((i / TILE_WIDTH_HALF) + (j / TILE_HEIGHT_QUARTER))/2);
        double ty = Math.ceil(((j / TILE_HEIGHT_QUARTER) - (i / TILE_WIDTH_HALF))/2);

        int x = (int) Math.ceil(tx)-1;
        int y = (int) Math.ceil(ty)-1;

        return new int[]{x, y};
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

    public static boolean gridLimitsRight(Picture pic){
        int[] gridPos = Helper.toGrid(pic.getX() + pic.getWidth(), pic.getY() + pic.getHeight());
        return gridPos[0] < IsoGrid.COLS - 1 && gridPos[1] < IsoGrid.COLS - 1;
    }

    public static boolean gridLimitsLeft(Picture pic){
        int[] gridPos = Helper.toGrid(pic.getX() + pic.getWidth(), pic.getY() + 15);
        return gridPos[0] > 1 && gridPos[1] > 1;
    }

    public static boolean gridLimitsDown(Picture pic){
        int[] gridPos = Helper.toGrid(pic.getX(), pic.getY() + pic.getHeight());
        return gridPos[0] > 1 && gridPos[1] < IsoGrid.ROWS - 1;
    }

    public static boolean gridLimitsUp(Picture pic){
        int[] gridPos = Helper.toGrid(pic.getX() + pic.getWidth(), pic.getY() + pic.getHeight());
        return gridPos[0] > 1 && gridPos[1] > 1;
    }

    public static boolean gridLimitsRight(Picture pic, int speed){

        double[] newGridPos = Helper.translateMovement(pic, MovementDir.RIGHT, speed);

        int[] gridPos = Helper.toGrid(pic.getX() + newGridPos[0] + pic.getWidth(), pic.getY() + newGridPos[1] + pic.getHeight());
        return gridPos[0] < IsoGrid.COLS - 1 && gridPos[1] < IsoGrid.COLS - 1;
    }

    public static boolean gridLimitsLeft(Picture pic, int speed){

        double[] newGridPos = Helper.translateMovement(pic, MovementDir.LEFT, speed);


        int[] gridPos = Helper.toGrid(pic.getX() + newGridPos[0]+ pic.getWidth(), pic.getY() + newGridPos[1]);
        return gridPos[0] > -1 && gridPos[1] >-1;
    }

    public static boolean gridLimitsDown(Picture pic, int speed){

        double[] newGridPos = Helper.translateMovement(pic, MovementDir.DOWN, speed);


        int[] gridPos = Helper.toGrid(pic.getX() + newGridPos[0], pic.getY() + newGridPos[1] + pic.getHeight());
        return gridPos[0] > -1 && gridPos[1] < IsoGrid.ROWS - 1;
    }

    public static boolean gridLimitsUp(Picture pic, int speed){

        double[] newGridPos = Helper.translateMovement(pic, MovementDir.UP, speed);


        int[] gridPos = Helper.toGrid(pic.getX() + newGridPos[0], pic.getY() + newGridPos[1] - 10);
        return gridPos[0] > -1 && gridPos[1] > -1;
    }


}
