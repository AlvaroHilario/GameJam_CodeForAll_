package Game.Actors.Player;

import Game.Actors.BaseActor;
import Game.Isometric.Helper;
import Game.Isometric.IsoCar;
import Game.Isometric.Grid;
import Game.MovementDir;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

/**
 * Used to create our main player
 */
public class Player extends BaseActor {

    private static Picture playerPic; //This is a source of errors
    private final Controller playerController;
    private static int playerSpeed = 64;
    private LinkedList<IsoCar> carList;
    private boolean isAlive;

    public Player(LinkedList<IsoCar> carList) {
        super(48, 3);
        this.playerController = new Controller(this);
        this.carList = carList;
        this.isAlive = true;
        showPlayer();
    }

    private void showPlayer() {
        int[] initialPos = Helper.toIso(Grid.COLS / 2, Grid.ROWS - 2);

        String playerImage = getImagePlayer();
        playerPic = new Picture(initialPos[0], initialPos[1], playerImage);
        playerPic.draw();
    }

    public Controller getPlayerController() {
        return playerController;
    }

    public String getImagePlayer() {
        return "src/resources/player.png";
    }


    public void moveUp() {
        if (Helper.gridLimitsUp(playerPic, playerSpeed)) {
            double[] diff = Helper.translateMovement(playerPic, MovementDir.UP, playerSpeed);
            playerPic.translate(diff[0], diff[1]);
        }
    }

    public static Picture getPlayerPic() {
        return playerPic;
    }

    public void moveDown() {
        if (Helper.gridLimitsDown(playerPic, playerSpeed)) {
            double[] diff = Helper.translateMovement(playerPic, MovementDir.DOWN,playerSpeed);

            playerPic.translate(diff[0], diff[1]);
        }
    }

    public void moveLeft() {
        if(Helper.gridLimitsLeft(playerPic, playerSpeed)) // Left limit
        {
            double[] diff = Helper.translateMovement(playerPic, MovementDir.LEFT, playerSpeed);
            playerPic.translate(diff[0], diff[1]);
        }
    }

    public void moveRight() {
        if(Helper.gridLimitsRight(playerPic, playerSpeed)){
            double[] diff = Helper.translateMovement(playerPic, MovementDir.RIGHT, playerSpeed);
            playerPic.translate(diff[0], diff[1]);
        }
    }

    public LinkedList<IsoCar> getCarList() {
        return carList;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return isAlive;
    }

}
