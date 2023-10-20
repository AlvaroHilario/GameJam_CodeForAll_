package Game;

import Game.Isometric.Grid;

public enum Lanes{
    FIRST(2, MovementDir.LEFT),
    SECOND(3, MovementDir.RIGHT),
    THIRD(6, MovementDir.LEFT),
    FOURTH(7, MovementDir.RIGHT),
    FIFTH(10, MovementDir.LEFT),
    SIXTH(11, MovementDir.RIGHT),
    SEVEN(14, MovementDir.LEFT),
    EIGHT(15, MovementDir.RIGHT),
    NINE(18, MovementDir.RIGHT),
    TEN(19, MovementDir.RIGHT);

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
        return this.moveDir.equals(MovementDir.RIGHT) ? 0 : Grid.COLS;
    }

    Lanes(int rowNumber, MovementDir moveDir){
        this.rowNumber = rowNumber;
        this.moveDir = moveDir;
    }
}
