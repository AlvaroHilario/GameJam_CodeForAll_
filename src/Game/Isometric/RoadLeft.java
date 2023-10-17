package Game.Isometric;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RoadLeft {
    private Picture background;
    public static final int PADDING = 10;
    public static final int CELLSIZE = 128;
    public static final int COLS = 24;
    public static final int ROWS = 24;
    private Picture[] roadGrid;

    public RoadLeft(){
        this.roadGrid = new Picture[ROWS];

        int y = 5;

        for(int x = 0;x<ROWS;x++){
                int[] isoCoords = Helper.toIso(x, y);
                int fx = isoCoords[0];//
                int fy = isoCoords[1];//
                roadGrid[x] = new Picture(fx, fy, "src/resources/lotW.png");
                roadGrid[x].draw();
        }
    }
}
