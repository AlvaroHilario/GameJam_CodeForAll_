package Game.Actors.Player;

import Game.Actors.BaseActor;
import Game.Grid.Grid;
import Game.Isometric.Helper;
import Game.Isometric.IsoCar;
import Game.Isometric.IsoGrid;
import Game.MovementDir;
import Game.Util;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
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
        int yInitialPosition = 362;
        int xInitialPosition = 250;

        int[] initialPos = Helper.toIso(IsoGrid.COLS / 2,IsoGrid.ROWS - 2);

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

    public static void moveUp() {
        if (Helper.gridLimitsUp(playerPic, playerSpeed)) {
            double[] diff = Helper.translateMovement(playerPic, MovementDir.UP, playerSpeed);
            playerPic.translate(diff[0], diff[1]);
        }
    }

    public static Picture getPlayerPic() {
        return playerPic;
    }

    public static void moveDown() {
        if (Helper.gridLimitsDown(playerPic, playerSpeed)) {
            double[] diff = Helper.translateMovement(playerPic, MovementDir.DOWN,playerSpeed);

            playerPic.translate(diff[0], diff[1]);
        }
    }

    public static void moveLeft() {

        if(Helper.gridLimitsLeft(playerPic, playerSpeed)) // Left limit
        {
            double[] diff = Helper.translateMovement(playerPic, MovementDir.LEFT, playerSpeed);
            playerPic.translate(diff[0], diff[1]);
        }
    }

    public static void moveRight() {
        if(Helper.gridLimitsRight(playerPic, playerSpeed)){
            double[] diff = Helper.translateMovement(playerPic, MovementDir.RIGHT, playerSpeed);
            playerPic.translate(diff[0], diff[1]);
        }
    }

    @Override
    public void move() {

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
