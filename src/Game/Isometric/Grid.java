package Game.Isometric;

import Game.Difficulty;
import Game.Lanes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

/** Main grid, where we will place our objects */
public class Grid {
    private Picture background;
    public static final int PADDING = 10;
    public static final int CELLSIZE = 128;
    public static final int COLS = 24;
    public static final int ROWS = 24;
    public Picture[][] isoGrid;
    public Grid(Difficulty difficulty){
        this.isoGrid = new Picture[COLS][ROWS];

            for(int x = 0;x<ROWS;x++){
                for(int y = 0;y<COLS;y++){
                    int[] isoCoords = Helper.toIso(x, y);
                    int fx = isoCoords[0];//
                    int fy = isoCoords[1];//

                    String picPath = getTileImage(y,x); //Old method

                    GridImage tileObj = GridImage.getTile(x,y, difficulty);
                    fy += tileObj.getOffset();
                    picPath = tileObj.getFilename();

                    isoGrid[x][y] = new Picture(fx, fy, picPath);
                    isoGrid[x][y].draw();
                }
            }
    }

    public String getTileImage(int cols, int rows){
        return cols>21 ? cols==23 ? "resources/beach.png" : "resources/beachSand.png": "resources/grass.png";
    }

    public int getRowsOffsets(int cols, int rows){
        if(rows == 0 && cols < 22)
            for(Lanes l : Lanes.values()){

                if(l.getStartRow() == cols)
                    return 0;
            }
        return 15;
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


    public enum GridImage{
        GRASS("resources/grass.png", 0),
        BEACH("resources/beachSand.png", 0),
        SEA("resources/beach.png", 0),
        HILL("resources/hillS2.png", -15),
        HILLEND("resources/hillSWE.png", -15),
        SIDEWALK("resources/sidewalk.png", -17),
        SIDETREE("resources/sidewalktree.png", -17);

        private String filename;
        private int offset; //Used to get the hills in the proper place
        GridImage(String filename, int offset){
            this.filename = filename;
            this.offset = offset;
        }

        public int getOffset() {
            return offset;
        }

        public String getFilename() {
            return filename;
        }

        public static GridImage getTile(int col, int row, Difficulty difficulty){

            if(row == 0)
                return Math.random() < 0.75 ? SIDEWALK : SIDETREE;

            if(col > 0 && row < 22)
                return GRASS;

            if(col == 0 && row < 22){ //HILLS
                for(Lanes l : Lanes.values()){

                    if(row == l.getStartRow() && l.getDifficulty().ordinal() <= difficulty.ordinal())
                        return GRASS;

                }
                return row == 21 ? HILLEND : HILL;
            }

            if(row == 22)
                return BEACH;

            return SEA;
        }
    }

}
