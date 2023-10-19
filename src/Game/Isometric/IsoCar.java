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
        double carWidth = carPic.getWidth();
        int carHeight = carPic.getHeight();
        int playerX = player.getPlayerPic().getX();
        int playerY = player.getPlayerPic().getY();
        int playerWidth = player.getPlayerPic().getWidth() / 2;
        int playerHeight = player.getPlayerPic().getHeight() / 2;
        double playerMiddleX = playerX + playerWidth;
        double playerMiddleY = playerY + playerHeight;

        double i = carX * 1.25;
        double j = carY * 0.75;

        double finalCarX = (carX + carWidth/2) - 15;
        double finalCarY = (carY + carHeight / 2) - 15;
        double finalWidthX = carWidth/2;
        double finalHeightY = carHeight /2;

        return playerMiddleX > finalCarX &&  playerMiddleY> finalCarY && playerMiddleX < finalWidthX && playerMiddleY < finalHeightY;
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
