package Game.Isometric;

import Game.CarFactory;
import Game.Util;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

/** Main grid, where we will place our objects */
public class IsoGrid { //Maybe we could extend from Rectangle
    private Picture background;
    public static final int PADDING = 10;
    public static final int CELLSIZE = 128;
    public static final int COLS = 24;
    public static final int ROWS = 24;
    public Picture[][] isoGrid;
    public IsoGrid(){
        this.isoGrid = new Picture[COLS][ROWS];

            for(int x = 0;x<ROWS;x++){
                for(int y = 0;y<COLS;y++){
                    int[] isoCoords = Helper.toIso(x, y);
                    int fx = isoCoords[0];//
                    int fy = isoCoords[1];//
                    isoGrid[x][y] = new Picture(fx, fy, "src/resources/grass.png");
                    isoGrid[x][y].draw();
                }
            }
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
