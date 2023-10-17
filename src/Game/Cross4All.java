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
    //private LinkedList<Car> cars;
    private LinkedList<IsoCar> isoCars;

    public Cross4All(){
        this.grid = new Grid();
        new IsoGrid();
        RoadFactory.createRoads();
        //this.cars = new LinkedList<Car>();
        this.isoCars = new LinkedList<IsoCar>();
        this.player = new Player();
        player.getPlayerController().keyboardInit();

    }

    public void run() {

        //IsoCar car = new IsoCar(0,4);
        //IsoCar car2 = new IsoCar(0,0);

        //int[] isoCoords = Helper.toIso(24, 24); //End coordinates for the car

        //End coordinates for row 4 is 42 (24+24 - 4)

        //int[] isoCoords2 = Helper.toIso(24, 8); //End coordinates for the car

        while (true) {

            /*
            if( (car.getCarPic().getX() + car.getCarPic().getY()) - (car.getCarPic().getWidth() + car.getCarPic().getHeight()) > isoCoords[0] + isoCoords[1]){
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
        }*/


            while (true) { //Todo create game loop logic

                if (isoCars.size() < 20)
                    CarFactory.generateIsoCar(isoCars);

                for (int i = 0; i < isoCars.size(); i++) {

                    //FIXME the car going to the right -> is pushing the window direction
                    if (isoCars.get(i).getMoveDir().equals(MovementDir.RIGHT) && !Helper.gridLimitsRight(isoCars.get(i).getCarPic())) {
                        isoCars.get(i).deleteCar();
                        isoCars.remove(i);
                    }

                    //FIXME the car going to the right -> is pushing the window direction
                    if (isoCars.get(i).getMoveDir().equals(MovementDir.LEFT) && !Helper.gridLimitsLeft(isoCars.get(i).getCarPic())) {
                        isoCars.get(i).deleteCar();
                        isoCars.remove(i);
                    }
                }

                for (int i = 0; i < isoCars.size(); i++) {
                    isoCars.get(i).move();
                }

                try {
                    Thread.sleep(25);
                } catch (Exception e) {
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
    }
}
