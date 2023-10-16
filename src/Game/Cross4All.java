package Game;

import Game.Actors.Car;
import Game.Grid.Grid;
import Game.Actors.Player.Player;

import java.util.LinkedList;

/**
 * Main game logic
 */
public class Cross4All implements Game {
    private final Grid grid;
    private final Player player;
    private final LinkedList<Car> cars;

    public Cross4All() {
        this.grid = new Grid();
        this.cars = new LinkedList<>();
        this.player = new Player();
        player.getPlayerController().keyboardInit();
    }

    public void run() {

        while (true) { //Todo create game loop logic

        while(true){ //Todo create game loop logic

            if(cars.size() < 20)
                CarFactory.generateCar(cars);
            }

            for (int i = 0; i < cars.size(); i++) {

                //FIXME the car going to the right -> is pushing the window direction
                if (cars.get(i).getCarPic().getX() < Grid.PADDING ||
                        cars.get(i).getCarPic().getX() + cars.get(i).getCarPic().getWidth() > Grid.getWidth()) {
                    cars.get(i).deleteCar();
                    cars.remove(i);
                }
            }

            for (Car car : cars) {
                car.move();
            }

            try {
                Thread.sleep(25);
            } catch (Exception e) {
                System.out.println("Add exception");
            }
        }
    }

    private void updateCars() {

    }

    private void updatePlayer() {

    }
}
