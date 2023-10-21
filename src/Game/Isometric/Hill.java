package Game.Isometric;

import Game.Difficulty;
import Game.Lanes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Hill {
    private LinkedList<Picture> hills;
    public Hill(Difficulty difficulty) {
        this.hills = new LinkedList<>();

        for (int row = 0; row < Grid.ROWS; row++) {

            int[] isoCoords = Helper.toIso(0, row);
            int fx = isoCoords[0];//
            int fy = isoCoords[1];//

            Grid.GridImage tileObj = Grid.GridImage.getTile(0, row, difficulty);
            fy += tileObj.getOffset();
            String picPath = tileObj.getFilename();

            if (tileObj.equals(Grid.GridImage.HILL) || tileObj.equals(Grid.GridImage.HILLEND)) {
                Picture newHill = new Picture(fx, fy, picPath);
                newHill.draw();
                hills.add(newHill);
            }
        }
    }

    public LinkedList<Picture> getHills() {
        return hills;
    }
}
