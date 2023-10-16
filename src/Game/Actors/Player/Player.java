package Game.Actors.Player;

import Game.Actors.BaseActor;
import Game.Grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

/** Used to create our main player */
public class Player extends BaseActor {

    private Rectangle playerPic;

    public Player(){
        super(48, 3);
        // rectangle for now
        this.playerPic = new Rectangle(10,10,50, 50);
        this.playerPic.setColor(Color.RED);
        this.playerPic.fill();


    }
    private Controller playerController;

    @Override
    public void move() {

    }
}
