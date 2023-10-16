package Game.Isometric;

import java.util.Vector;

public class Helper {
    private static int TILE_WIDTH_HALF = IsoGrid.COLS/2;
    private static int TILE_HEIGHT_HALF = IsoGrid.ROWS/2;

    private static int TILE_WIDTH_QUARTER = TILE_WIDTH_HALF/2;
    private static int TILE_HEIGHT_QUARTER = TILE_HEIGHT_HALF/2;

    public static int[] toIso(int x, int y){

        int i = (x - y) * TILE_WIDTH_HALF;
        int j = (x + y) * TILE_HEIGHT_QUARTER;

        i += 800-TILE_WIDTH_HALF;
        j+=100;

        return new int[]{i,j};
    }

    public static int[] toGrid(double i, double j){

        i-=800;
        j-=100;

        double tx = Math.ceil(((i / TILE_WIDTH_HALF) + (j / TILE_HEIGHT_QUARTER))/2);
        double ty = Math.ceil(((j / TILE_HEIGHT_QUARTER) - (i / TILE_WIDTH_HALF))/2);

        int x = (int) Math.ceil(tx)-1;
        int y = (int) Math.ceil(ty)-1;

        return new int[]{x, y};
    }
}
