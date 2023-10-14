package Game;

import Game.Actors.Car;
import Game.Grid.Grid;
import Game.Actors.Player.Player;

import java.util.LinkedList;

/** Main game logic */
public class Cross4All implements Game{
    private Grid grid;
    private Player player;
    private LinkedList<Car> cars;


    public Cross4All(){
        this.grid = new Grid();
        this.cars = new LinkedList<Car>();
    }

    public void run(){

        while(true){

            if(cars.size() < 1)
                CarFactory.generateCar(cars);

            for(int i = 0; i < cars.size(); i++){
                if(cars.get(i).getCarPic().getX() < Grid.PADDING) {
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
    }

    private void updateCars(){

    }

    private void updatePlayer(){

    }
}
