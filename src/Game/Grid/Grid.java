package Game.Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

/** Main grid, where we will place our objects */
public class Grid { //Maybe we could extend from Rectangle
    private Rectangle grid;
    public static final int PADDING = 10;
    public static final int CELLSIZE = 8;
    public static final int COLS = 32;
    public static final int ROWS = 24;
    public static final int SCALE = 2;
    public Grid(){
        this.grid = new Rectangle(PADDING,PADDING, getWidth(), getHeight());

        Picture newpic = new Picture(PADDING, PADDING, "C:\\Users\\Alexandre\\Desktop\\AcademiaDeCodigo\\GameTests\\Cross4All\\src\\resources\\fMap.png");
        newpic.grow(getWidth(),getHeight());
        newpic.translate(getWidth(), getHeight());
        newpic.draw();
        this.grid.draw();
    }

    public int getCols() {
        return COLS;
    }

    public int getRows() {
        return ROWS;
    }

    public int getWidth(){
        return (CELLSIZE * SCALE * COLS) + PADDING;
    }

    public int getHeight(){
        return (CELLSIZE * SCALE * ROWS) + PADDING;
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
