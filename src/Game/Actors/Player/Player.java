package Game.Actors.Player;

import Game.Actors.BaseActor;
import Game.Grid.Grid;
import Game.Isometric.Helper;
import Game.Isometric.IsoGrid;
import Game.MovementDir;
import Game.Util;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

/**
 * Used to create our main player
 */
public class Player extends BaseActor {

    private static Picture playerPic;
    private final Controller playerController;
    private double playerSpeed;

    public Player() {
        super(48, 3);
        this.playerController = new Controller();
        this.playerSpeed = 4;
        showPlayer();
    }

    private void showPlayer() {
        int yInitialPosition = 362;
        int xInitialPosition = 250;
        String playerImage = getImagePlayer();
        playerPic = new Picture(xInitialPosition, yInitialPosition, playerImage);
        playerPic.draw();
    }

    public Controller getPlayerController() {
        return playerController;
    }

    public String getImagePlayer() {
        return "src/resources/player.png";
    }

    public static void moveUp() {
        if (Helper.gridLimitsUp(playerPic)) {

            double[] diff = Helper.translateMovement(playerPic, MovementDir.UP, 8);

            playerPic.translate(diff[0], diff[1]);
        }
    }

    public static void moveDown() {
        if (Helper.gridLimitsDown(playerPic)) {


            double[] diff = Helper.translateMovement(playerPic, MovementDir.DOWN,8);

            playerPic.translate(diff[0], diff[1]);
        }
    }

    public static void moveLeft() {
        int[] isoCoords = Helper.toIso(0, 24);

        System.out.println((playerPic.getX() + " : " + playerPic.getY()) + " : Coords " + isoCoords[0] + " : " + isoCoords[1]);

        if(Helper.gridLimitsLeft(playerPic)) // Left limit
        {
            double[] diff = Helper.translateMovement(playerPic, MovementDir.LEFT, 8);

            playerPic.translate(diff[0], diff[1]);
        }
    }

    public static void moveRight() {
        if(Helper.gridLimitsRight(playerPic)){
            double[] diff = Helper.translateMovement(playerPic, MovementDir.RIGHT, 8);
            playerPic.translate(diff[0], diff[1]);
        }
    }

    @Override
    public void move() {

    }
}
