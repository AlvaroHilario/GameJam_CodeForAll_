package Game;

import Game.Isometric.Grid;

public enum Lanes{
    FIRST(2, MovementDir.LEFT, Difficulty.HARD),
    SECOND(3, MovementDir.RIGHT, Difficulty.HARD),
    THIRD(6, MovementDir.LEFT, Difficulty.MEDIUM),
    FOURTH(7, MovementDir.RIGHT, Difficulty.MEDIUM),
    FIFTH(10, MovementDir.LEFT, Difficulty.EASY),
    SIXTH(11, MovementDir.RIGHT, Difficulty.EASY),
    SEVEN(14, MovementDir.LEFT, Difficulty.EASY),
    EIGHT(15, MovementDir.RIGHT, Difficulty.EASY),
    NINE(18, MovementDir.RIGHT, Difficulty.HARD),
    TEN(19, MovementDir.RIGHT, Difficulty.HARD);

    private final int rowNumber;
    private final MovementDir moveDir;
    private Difficulty difficulty;

    public Difficulty getDifficulty() {
        return difficulty;
    }

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

    Lanes(int rowNumber, MovementDir moveDir, Difficulty difficulty){
        this.rowNumber = rowNumber;
        this.moveDir = moveDir;
        this.difficulty = difficulty;
    }

    public static Lanes generateRandomLane(Difficulty difficulty){

        Lanes tempLane = Lanes.values()[(int)(Math.random() * Lanes.values().length)];

        while(tempLane.getDifficulty().ordinal() > difficulty.ordinal()){
            tempLane = Lanes.values()[(int)(Math.random() * Lanes.values().length)];
        }

        return tempLane;
    }
}
