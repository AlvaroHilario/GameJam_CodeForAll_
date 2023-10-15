package Game.Actors;

import Game.Grid.Grid;
import Game.Util;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/** This class should be inherited to the rest of the objects that have colission*/
public abstract class BaseActor { //Todo review the functionality in this class
    private int x,y;
    protected int colPos,rowPos;
    private Shape shapeObj;
    //Todo private CollisionBox collisionBox;

    BaseActor(int col, int row){
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

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public void setColPos(int colPos) {
        this.colPos = colPos;
        setX();
    }

    public void setRowPosPos(int rowPos) {
        this.rowPos = rowPos;
        setY();
    }

    public int getColPos() {
        return colPos;
    }

    public int getRowPos() {
        return rowPos;
    }



}
