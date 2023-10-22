package Game.Isometric;

import Game.MovementDir;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/** Used to draw Props */
public class Props {
    private Picture propPic;
    private MovementDir moveDir;
    private int savedStartRow;

    public Props(int startCol, int startRow, String propPath, int imageOffset){
        this.savedStartRow = startRow;
        int[] isoCoords = Helper.toIso(startCol, startRow);
        int fx = isoCoords[0];//
        int fy = isoCoords[1];//
        this.propPic = new Picture(fx, fy + imageOffset, propPath);
        propPic.draw();
    }
}
