package Game.Actors.Player;

import Game.Actors.BaseActor;
import Game.Grid.Grid;
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

    public Player() {
        super(48, 3);
        this.playerController = new Controller();
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
            playerPic.translate(0, -16);
        }
    }

    public static void moveDown() {
        if (playerPic.getY() + playerPic.getHeight() < Grid.getHeight()) {
            playerPic.translate(0, 16);
        }
    }

    public static void moveLeft() {
        if (playerPic.getX() > Grid.PADDING) {
            playerPic.translate(-16, 0);
        }
    }

    public static void moveRight() {
        if (playerPic.getX() + playerPic.getWidth() < Grid.getWidth()) {
            playerPic.translate(16, 0);
        }
    }
}
