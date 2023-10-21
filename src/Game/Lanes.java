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


        //FIXME Not efficient, it's lagging the game
       /* while(tempLane.getDifficulty().ordinal() > difficulty.ordinal()){
            tempLane = Lanes.values()[(int)(Math.random() * Lanes.values().length)];
        }*/

        if(difficulty.equals(Difficulty.EASY)){
            return Lanes.values()[(int)((Math.random() * (8 - 4)) + 4)];
        } else if (difficulty.equals(Difficulty.MEDIUM)) {
            return Lanes.values()[(int)((Math.random() * (8 - 2)) + 2)];
        }else{
            return Lanes.values()[(int)(Math.random() * Lanes.values().length)];
        }
    }
}
