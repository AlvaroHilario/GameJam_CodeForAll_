package Game.Isometric;

import Game.Actors.BaseActor;
import Game.Actors.Player.Player;
import Game.MovementDir;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/** Used to create a car */
public class IsoCar{

    private Picture carPic;
    private MovementDir moveDir;
    private int savedStartRow;

    public IsoCar(int startCol, int startRow, MovementDir moveDir){
        this.moveDir = moveDir;
        this.savedStartRow = startRow;
        int[] isoCoords = Helper.toIso(startCol, startRow);
        int fx = isoCoords[0];//
        int fy = isoCoords[1];//
        this.carPic = new Picture(fx, fy + getImageOffset(), getCarImage());
        carPic.draw();
    }

    public boolean checkCollision(Player player) {
        int carX = carPic.getX();
        int carY = carPic.getY();
        int carWidth = carPic.getX();
        int carHeight = carPic.getY();
        int playerX = player.getPlayerPic().getX();
        int playerY = player.getPlayerPic().getY();
        int playerWidth = player.getPlayerPic().getWidth();
        int playerHeight = player.getPlayerPic().getHeight();

        int[] getCarPos = Helper.toGrid(carX, carY);
        int[] getPlayerPos = Helper.toGrid(playerX, playerY);

        return getCarPos[0] == getPlayerPos[0] && getCarPos[1] == getPlayerPos[1];
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
