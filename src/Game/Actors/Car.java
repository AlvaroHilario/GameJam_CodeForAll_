package Game.Actors;

import Game.MovementDir;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/** Used to create a car */
public class Car extends BaseActor {

    private Picture carPic;
    private MovementDir moveDir;

    public Car(int startCol, int startRow, String carImage, MovementDir moveDir){
        super(startCol, startRow); //Our cars occupy 3x2 cols X rows
        this.moveDir = moveDir;
        this.carPic = new Picture(super.getX(), super.getY(), carImage);
        showCar();
    }

    public void showCar(){
        this.carPic.draw();
    }

    public void move(){

        //Todo just a draft implementation
        if(MovementDir.LEFT.equals(moveDir))
            this.carPic.translate(4 * -1, 0);
        else
            this.carPic.translate(4, 0);
    }

    public Picture getCarPic() {
        return carPic;
    }

    public void deleteCar(){
        this.carPic.delete();
    }

    /* Only returns the X/Horizontal distance*/
    public float getXDistance(Car car){
        return Math.abs(this.carPic.getX() - car.carPic.getX());
    }

    @Override
    public int getX() {
        return carPic.getX();
    }

    @Override
    public int getY() {
        return carPic.getY();
    }
}
