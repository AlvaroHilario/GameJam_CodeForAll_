package Game.Isometric;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

/** Main grid, where we will place our objects */
public class Grid { //Maybe we could extend from Rectangle
    private Picture background;
    public static final int PADDING = 10;
    public static final int CELLSIZE = 128;
    public static final int COLS = 24;
    public static final int ROWS = 24;
    public Picture[][] isoGrid;
    public Grid(){
        this.isoGrid = new Picture[COLS][ROWS];

            for(int x = 0;x<ROWS;x++){
                for(int y = 0;y<COLS;y++){
                    int[] isoCoords = Helper.toIso(x, y);
                    int fx = isoCoords[0];//
                    int fy = isoCoords[1];//

                    String picPath = getTileImage(y,x);


                    isoGrid[x][y] = new Picture(fx, fy, picPath);
                    isoGrid[x][y].draw();
                }
            }
    }

    public String getTileImage(int cols, int rows){
        return cols>21 ? cols==23 ? "src/resources/beach.png" : "src/resources/beachSand.png": "src/resources/grass.png";
    }

    public int getCols() {
        return COLS;
    }

    public int getRows() {
        return ROWS;
    }

    public int getWidth(){
        return (CELLSIZE * COLS) + PADDING;
    }

    public Picture getBackground() {
        return background;
    }

    public int getHeight(){
        return (CELLSIZE * ROWS) + PADDING;
    }

    private int getScreenWidth(){
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    private int getScreenHeight(){
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    private int getCellSize(){
        return this.CELLSIZE;
    }
}
