package Game.Actors;

import Game.Grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/** Used to create a car */
public class Car extends BaseActor {

    private Picture carPic;
    public Car(){
        super(48, 3);
        this.carPic = new Picture(pos.getX(), pos.getY(), "src/resources/car.png");
        this.carPic.grow((Grid.CELLSIZE * Grid.SCALE) + Grid.PADDING, (Grid.CELLSIZE * Grid.SCALE) + Grid.PADDING);
        //this.carPic.translate((pos.getX() * Grid.SCALE), pos.getY() * Grid.SCALE);
        this.carPic.draw();

    }

    public void move(){
        this.carPic.translate(4 * -1, 0);
    }

    public Picture getCarPic() {
        return carPic;
    }

    public void deleteCar(){
        this.carPic.delete();
    }
}
