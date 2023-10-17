package Game;

import Game.Actors.Car;
import Game.Grid.Grid;
import Game.Actors.Player.Player;
import Game.Isometric.*;

import java.util.LinkedList;

/** Main game logic */
public class Cross4All implements Game{
    private Grid grid;
    private Player player;
    private LinkedList<Car> cars;


    public Cross4All(){
        this.grid = new Grid();
        new IsoGrid();
        new RoadRight();
        new RoadLeft();
        this.cars = new LinkedList<Car>();
        this.player = new Player();
        player.getPlayerController().keyboardInit();

    }

    public void run(){

        IsoCar car = new IsoCar(0,4);
        int[] isoCoords = Helper.toIso(24, 24); //End coordinates for the car


        IsoCar car2 = new IsoCar(24,8);


        int[] isoCoords2 = Helper.toIso(24, 8); //End coordinates for the car

        int x =  Util.getColX(24);

        int y = Util.getRowY(8);


        while(true){


            if(car.getCarPic().getX() > isoCoords[0] / isoCoords[1]){
                car.deleteCar();
                car = new IsoCar(0,4);
            }

            car.move();

            try {
                Thread.sleep(50);
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
