package Game.Isometric;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Road {
    private Picture background;
    public static final int PADDING = 10;
    public static final int CELLSIZE = 128;
    public static final int COLS = 24;
    public static final int ROWS = 24;
    private Picture[] rightRoadGrid;
    private Picture[] leftRoadGrid;

    public Road(int startRow){
        RoadRight roadRight = new RoadRight(startRow);
        RoadLeft roadLeft = new RoadLeft(startRow + 1);
    }

    public Picture[] getLeftRoadGrid() {
        return leftRoadGrid;
    }

    public Picture[] getRightRoadGrid() {
        return rightRoadGrid;
    }

    public class RoadRight {
        public RoadRight(int row) {
            rightRoadGrid = new Picture[ROWS];

            for (int x = 0; x < ROWS; x++) {
                int[] isoCoords = Helper.toIso(x, row);
                int fx = isoCoords[0];//
                int fy = isoCoords[1];//
                rightRoadGrid[x] = new Picture(fx, fy, "resources/lotE.png");
                rightRoadGrid[x].draw();
            }
        }
    }

    public class RoadLeft {
        public RoadLeft(int row) {
            leftRoadGrid = new Picture[ROWS];

            for (int x = 0; x < ROWS; x++) {
                int[] isoCoords = Helper.toIso(x, row);
                int fx = isoCoords[0];//
                int fy = isoCoords[1];//
                leftRoadGrid[x] = new Picture(fx, fy, "resources/lotW.png");
                leftRoadGrid[x].draw();
            }
        }
    }
}