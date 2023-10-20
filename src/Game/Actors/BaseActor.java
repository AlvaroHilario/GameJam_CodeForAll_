package Game.Actors;

import Game.Util;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/** This class should be inherited to the rest of the objects that have colission*/
public abstract class BaseActor { //Todo review the functionality in this class
    private int x,y;
    protected int colPos,rowPos;

    protected BaseActor(int col, int row){
        this.colPos = col;
        this.rowPos = row;
        setX();
        setY();
    }

    private void setX(){
        x = Util.getColX(colPos);
    }

    private void setY(){
        y = Util.getRowY(rowPos);
    }
}
