package Game;

import Game.Actors.BaseActor;
import Game.Actors.Car;
import Game.Grid.Grid;
import Game.Actors.Player.Player;
import Game.Isometric.Helper;
import Game.Isometric.IsoCar;
import Game.Isometric.IsoGrid;

import java.util.LinkedList;

/** Main game logic */
public class Cross4All implements Game{
    private Grid grid;
    private Player player;
    private LinkedList<Car> cars;


    public Cross4All(){
        this.grid = new Grid();
        new IsoGrid();
        this.cars = new LinkedList<Car>();
    }

    public void run(){

        IsoCar car = new IsoCar(29,29);
        int[] isoCoords = Helper.toIso(2, 32);

        while(true){


            if(car.getY() < isoCoords[1]){
                car.deleteCar();
                car = new IsoCar(29,29);
            }

            car.move();

            try {
                Thread.sleep(150);
            }
            catch (Exception e){
                System.out.println("Add exception");
            }
        }
        /*
        while(false){ //Todo create game loop logic

            if(cars.size() < 20)
                CarFactory.generateCar(cars);

            for(int i = 0; i < cars.size(); i++){

                //FIXME the car going to the right -> is pushing the window direction
                if(cars.get(i).getCarPic().getX() < Grid.PADDING || cars.get(i).getCarPic().getX() + cars.get(i).getCarPic().getWidth()  > this.grid.getWidth()) {
                    cars.get(i).deleteCar();
                    cars.remove(i);
                }
            }

            for(int i = 0; i < cars.size(); i++){
                cars.get(i).move();
            }

            try {
                Thread.sleep(25);
            }
            catch (Exception e){
                System.out.println("Add exception");
            }
        }
        */
    }

    private void updateCars(){

    }

    private void updatePlayer(){

    }
}
