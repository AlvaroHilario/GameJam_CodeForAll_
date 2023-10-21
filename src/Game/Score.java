package Game;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {
    private int score;
    private Text scoreText;
    public Score(){
        this.score = 0;
        this.scoreText = new Text(30,30, "SCORE: " + score);
        scoreText.grow(20,20);
        scoreText.draw();
    }

    public void updateScore(){
        this.score++;
        this.scoreText.delete();
        this.scoreText = new Text(30,30, "SCORE: " + score);
        scoreText.grow(20,20);
        scoreText.draw();

    }

    public void resetScore(){
        this.score = 0;
        this.scoreText.delete();
        this.scoreText = new Text(30,30, "SCORE: " + score);
        scoreText.grow(20,20);
        scoreText.draw();

    }
}
