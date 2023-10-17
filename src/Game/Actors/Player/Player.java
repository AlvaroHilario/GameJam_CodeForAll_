package Game.Actors.Player;

import Game.Actors.BaseActor;
import Game.Grid.Grid;
import Game.Isometric.Helper;
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
        if (playerPic.getY() > Grid.PADDING) {

            double[] diff = Util.translateMovement(playerPic, MovementDir.UP, 80);

            playerPic.translate(diff[0], diff[1]);
        }
    }

    public static void moveDown() {
        if (playerPic.getY() + playerPic.getHeight() < Grid.getHeight()) {


            double[] diff = Util.translateMovement(playerPic, MovementDir.DOWN,8);

            playerPic.translate(diff[0], diff[1]);
        }
    }

    public static void moveLeft() {
        if (playerPic.getX() > Grid.PADDING) {
            double[] diff = Util.translateMovement(playerPic, MovementDir.LEFT, 8);

            playerPic.translate(diff[0], diff[1]);
        }
    }

    public static void moveRight() {
        int[] isoCoords = Helper.toIso(24, 24);

        int x =  Util.getColX(24);

        int y = Util.getRowY(8);

        if (playerPic.getX() + playerPic.getWidth() < isoCoords[0] && playerPic.getY() < x) {
            double[] diff = Util.translateMovement(playerPic, MovementDir.RIGHT,8);

            playerPic.translate(diff[0], diff[1]);
        }
    }

    @Override
    public void move() {

    }
}
