package Game.Isometric;

import Game.Actors.BaseActor;
import Game.Actors.Player.Player;
import Game.MovementDir;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/** Used to create a car */
public class IsoCar{

    private Picture carPic;
    private MovementDir moveDir;
    private int savedStartRow;

    public IsoCar(int startCol, int startRow, MovementDir moveDir, String carImage){
        this.moveDir = moveDir;
        this.savedStartRow = startRow;
        int[] isoCoords = Helper.toIso(startCol, startRow);
        int fx = isoCoords[0];//
        int fy = isoCoords[1];//
        this.carPic = new Picture(fx, fy + getImageOffset(), carImage);
        carPic.draw();
    }

    public boolean checkCollision(Player player) {
        double carWidth = carPic.getWidth();
        double carHeight = carPic.getHeight();
        double playerWidth = player.getPlayerPic().getWidth();
        double playerHeight = player.getPlayerPic().getHeight();
        double playerMiddleX = player.getPlayerPic().getX() + playerWidth / 2;
        double playerMiddleY = player.getPlayerPic().getY() + playerHeight / 1.25;

        double finalCarX = (carPic.getX() + carWidth/2) - 15;
        double finalCarY = (carPic.getY() + carHeight / 2) - 15;
        double finalWidthX = finalCarX + carWidth/2;
        double finalHeightY = finalCarY + carHeight /2;

        //Alternative collision
        //return playerMiddleX > finalCarX &&  playerMiddleY > finalCarY && playerMiddleX < finalWidthX && playerMiddleY < finalHeightY;

        int[] gridPos = Helper.toGrid(carPic.getX() + carWidth / 2, carPic.getY() + carHeight / 2);
        int[] gridPosPlayer = Helper.toGrid(playerMiddleX, playerMiddleY);

        return gridPos[0] == gridPosPlayer[0] && gridPos[1] == gridPosPlayer[1];
    }


    public void showCar(){
        this.carPic.draw();
    }

    private String getCarImage(){
        return this.moveDir.equals(MovementDir.RIGHT) ? "src/resources/Roadster_64R.png" : "src/resources/Roadster_64L.png";
    }

    private int getImageOffset(){
        return this.moveDir.equals(MovementDir.RIGHT) ? -25 : -15;
    }

    public void move(){
        double[] movement = this.moveDir.equals(MovementDir.RIGHT) ?  Helper.translateMovement(this.carPic, MovementDir.RIGHT, 10) : Helper.translateMovement(this.carPic, MovementDir.LEFT, 10);
        this.carPic.translate(movement[0], movement[1]);
    }

    public Picture getCarPic() {
        return carPic;
    }

    public void deleteCar(){
        this.carPic.delete();
    }

    /* Only returns the X/Horizontal distance*/
    public float getXDistance(IsoCar car){
        return Math.abs(this.carPic.getX() - car.carPic.getX());
    }


    public int getX() {
        return carPic.getX();
    }

    public MovementDir getMoveDir() {
        return moveDir;
    }

    public int getSavedStartRow() {
        return savedStartRow;
    }

    public int getY() {
        return carPic.getY();
    }
}
