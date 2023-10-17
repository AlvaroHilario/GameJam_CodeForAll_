package Game.Isometric;

import Game.Actors.BaseActor;
import Game.MovementDir;
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
        double[] movement = this.moveDir.equals(MovementDir.RIGHT) ?  Helper.translateMovement(this.carPic, MovementDir.RIGHT, 25) : Helper.translateMovement(this.carPic, MovementDir.LEFT, 25);
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
