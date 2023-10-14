package Game.Actors;

import Game.Grid.Grid;

//Todo remove this class and assign this functionality to BaseActor
public class Position {
    private int x,y;
    private int colPos,rowPos;
    private Grid grid;

    Position(int col, int row){
        this.colPos = col;
        this.rowPos = row;
        this.grid = grid;
        setX();
        setY();
    }

    private void setX(){
        x = Grid.PADDING + (colPos * Grid.CELLSIZE * (Grid.SCALE + 1));
    }

    private void setY(){
        y = Grid.PADDING + (rowPos * Grid.CELLSIZE * (Grid.SCALE + 1));
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
