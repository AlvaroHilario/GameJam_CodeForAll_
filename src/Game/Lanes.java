package Game;

import Game.Grid.Grid;
import Game.Isometric.IsoCar;
import Game.Isometric.IsoGrid;

public enum Lanes{
    FIRST(4, MovementDir.LEFT),
    SECOND(5, MovementDir.RIGHT);
    /*
    THIRD(8, MovementDir.LEFT),
    FOURTH(9, MovementDir.RIGHT),
    FIFTH(10, MovementDir.LEFT),
    SIXTH(11, MovementDir.RIGHT);*/

    private final int rowNumber;
    private final MovementDir moveDir;

    public int getStartRow(){
        return rowNumber;
    }

    public MovementDir getMoveDir(){
        return this.moveDir;
    }

    public int getStartCol(){
        int imageWidth = Util.getImageWidth(CarFactory.getCarImage(moveDir));
        return this.moveDir.equals(MovementDir.RIGHT) ? 0 : IsoGrid.COLS;
    }

    Lanes(int rowNumber, MovementDir moveDir){
        this.rowNumber = rowNumber;
        this.moveDir = moveDir;
    }
}
