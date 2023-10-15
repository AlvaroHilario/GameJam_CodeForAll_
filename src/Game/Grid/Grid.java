package Game.Grid;

import Game.CarFactory;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

/**
 * Main grid, where we will place our objects
 */
public class Grid { //Maybe we could extend from Rectangle
    private Picture background;
    public static final int PADDING = 10;
    public static final int CELLSIZE = 16;
    public static final int COLS = 32;
    public static final int ROWS = 24;

    public Grid() {
        this.background = new Picture(PADDING, PADDING, "src/resources/fMap.png");
        this.background.draw();

        //CarFactory.generateStartRows(this); //Testing
    }

    public int getCols() {
        return COLS;
    }

    public int getRows() {
        return ROWS;
    }

    public static int getWidth() {
        return (CELLSIZE * COLS) + PADDING;
    }

    public Picture getBackground() {
        return background;
    }

    public static int getHeight() {
        return (CELLSIZE * ROWS) + PADDING;
    }

    private int getScreenWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    private int getScreenHeight() {
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    private int getCellSize() {
        return CELLSIZE;
    }
}
