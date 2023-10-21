package Game;

import Game.Isometric.Grid;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {
    private int score;
    private Text scoreText;
    public Score(){
        this.score = 0;
        this.scoreText = new Text(200, 800, "[ SCORE: " + score + " ]");
        scoreText.grow(150,50);
        scoreText.draw();
    }

    public void updateScore(){
        this.score++;
        this.scoreText.delete();
        Text temp = new Text(200, 800, "[ SCORE: " + score + " ]");
        temp.grow(150,50);
        temp.draw();
        this.scoreText = temp;
    }

    public void resetScore(){
        this.score = 0;
        this.scoreText.delete();
        Text temp = new Text(200,800, "[ SCORE: " + score + " ]");
        temp.grow(150,50);
        temp.draw();
        this.scoreText = temp;
    }
}
