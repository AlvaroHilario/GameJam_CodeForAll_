package Game.Isometric;

import Game.Actors.BaseActor;
import Game.MovementDir;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/** Used to create a car */
public class IsoCar extends BaseActor {

    private Picture carPic;
    private MovementDir moveDir;

    public IsoCar(int startCol, int startRow){
        super(startCol, startRow); //Our cars occupy 3x2 cols X rows
        this.moveDir = moveDir;

            int[] isoCoords = Helper.toIso(startCol, startRow);
            int fx = isoCoords[0];//
            int fy = isoCoords[1];//
            this.carPic = new Picture(fx, fy - 15, "src/resources/Roadster_64R.png");
            carPic.draw();
    }

    public void showCar(){
        this.carPic.draw();
    }

    public void move(){

        int[] cenasOld = Helper.toIso(this.carPic.getX(), this.carPic.getY());
        int[] cenas = Helper.toIso(this.carPic.getX(), this.carPic.getY());
        int[] newCenas = new int[2];
        newCenas[0]= cenas[0] - cenasOld[0];
        newCenas[1]= cenas[1] - cenasOld[1];



        double xDiff = (double)(newCenas[0]) + 8.0f;
        double yDiff = (double)(newCenas[1]) + 4.0f;

        this.carPic.translate(xDiff, yDiff);
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

    @Override
    public int getX() {
        return carPic.getX();
    }

    @Override
    public int getY() {
        return carPic.getY();
    }
}
