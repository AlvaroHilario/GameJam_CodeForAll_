package Game;

import Game.Grid.Grid;

public enum Lanes{
    FIRST(3, MovementDir.LEFT),
    SECOND(5, MovementDir.RIGHT),
    THIRD(10, MovementDir.LEFT),
    FOURTH(12, MovementDir.RIGHT),
    FIFTH(17, MovementDir.LEFT),
    SIXTH(19, MovementDir.RIGHT);

    private final int rowNumber;
    private final MovementDir moveDir;

    public int getStartRow(){
        return rowNumber;
    }

    public MovementDir getMoveDir(){
        return this.moveDir;
    }

    /* Returns the starting column*/
    public int getStartCol(){
        int imageWidth = Util.getImageWidth(CarFactory.getCarImage(moveDir));
        return this.moveDir.equals(MovementDir.RIGHT) ? 0 :  Grid.COLS - (imageWidth / Grid.CELLSIZE);
    }

    Lanes(int rowNumber, MovementDir moveDir){
        this.rowNumber = rowNumber;
        this.moveDir = moveDir;
    }
}
