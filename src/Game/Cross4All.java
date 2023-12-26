package Game;

import Game.Actors.Player.Controller;
import Game.Actors.Player.Player;
import Game.Isometric.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.applet.AudioClip;
import java.util.*;
import java.util.LinkedList;

/** Main game logic */
public class Cross4All implements Game, KeyboardHandler {
    private Player player;
    private Controller playerController;
    private List<IsoCar> isoCars;
    private LinkedList<Road> roads;
    private Hill hills;
    private Keyboard keyboard;
    private boolean clicked = false;
    private Grid currentGrid;
    private boolean endGame;
    private Score scoreboard;

    private Sound sound = new Sound();

    //Level options
    private boolean newLevel;
    private Difficulty difficulty;

    public Cross4All(){
        Menu menu = new Menu(this);
        while (!clicked) {
            try {
                Thread.sleep(25);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        init();

        this.endGame = false;
        this.newLevel = false;
        this.difficulty = Difficulty.EASY;
        this.currentGrid = new Grid(difficulty);
        this.roads = RoadFactory.createRoads(difficulty);
        this.hills = new Hill(difficulty);
        this.isoCars = Collections.synchronizedList(new LinkedList<IsoCar>());
        this.player = new Player(isoCars);
        this.playerController = Controller.getInstance();
        this.playerController.setPlayerOwner(player, true);
        this.scoreboard = new Score();
        //this.player.getPlayerController().keyboardInit();
    }

    public void run() {
        while (!endGame) {
                if(newLevel){
                    //Deleting and loading levels
                    try{
                        deleteLevel();
                        Thread.sleep(1000);
                    }catch (Exception e){
                        System.out.println(e);
                    }

                    try{
                        createLevel();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    newLevel = false;
                    continue;
                }

                if (isoCars.size() < difficulty.getMaxCars()) {
                    CarFactory.generateIsoCar(isoCars, difficulty);
                }

                reDrawPlayer();

                for(IsoCar c : isoCars){
                    if( c.checkCollision(player) || !player.isAlive()) {

                        if(difficulty.equals(Difficulty.EASY)) {
                            playerController.setPlayerOwner(null, false);
                            player.getPlayerPic().delete();
                            player = new Player(isoCars);
                            playerController.setPlayerOwner(this.player, false);

                        }else{
                            difficulty = Difficulty.EASY;
                            newLevel = true;

                        }

                        scoreboard.resetScore();
                    }
                }

                for (int i = 0; i < isoCars.size(); i++) {

                    if (isoCars.get(i).getMoveDir().equals(MovementDir.RIGHT) && !Helper.gridLimitsRight(isoCars.get(i).getCarPic())) {
                        isoCars.get(i).deleteCar();
                        isoCars.remove(i);
                    }
                    else if (isoCars.get(i).getMoveDir().equals(MovementDir.LEFT) && !Helper.gridLimitsLeft(isoCars.get(i).getCarPic())) {
                        isoCars.get(i).deleteCar();
                        isoCars.remove(i);
                    }
                }

                for (int i = 0; i < isoCars.size(); i++) {
                    isoCars.get(i).move();
                }

                //Check if player has won this round
                if(  checkPlayerWinCondition()  )  {

                    //Increasing difficulty if the player wins
                    if(difficulty.ordinal() < Difficulty.values().length-1)
                        difficulty = Difficulty.values()[difficulty.ordinal() + 1];

                    scoreboard.updateScore();
                    newLevel = true;
                }

                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    System.out.println("Add exception");
                }
        }
    }

    private void init(){
        keyboard = new Keyboard(this);
        KeyboardEvent quitGame = new KeyboardEvent();
        quitGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        quitGame.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(quitGame);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        System.exit(1);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    //Level functionalities
    public void deleteLevel() throws Exception{

        //Deletes grid tiles
        Picture[][] tiles =  currentGrid.isoGrid;
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                tiles[i][j].delete();
            }
        }

        //Deletes the roads
        while(!this.roads.isEmpty()){

            Picture[] roadTilesLeft = this.roads.getFirst().getLeftRoadGrid();
            for(int i = 0; i < roadTilesLeft.length; i++){
                roadTilesLeft[i].delete();
            }

            Picture[] roadTilesRight = this.roads.getFirst().getRightRoadGrid();
            for(int i = 0; i < roadTilesRight.length; i++){
                roadTilesRight[i].delete();
            }

            this.roads.removeFirst();
        }

        //Deletes hills
        LinkedList<Picture> hillsList = this.hills.getHills();
        while(!hillsList.isEmpty()){
            hillsList.getFirst().delete();
            hillsList.removeFirst();
        }

        //Deletes Cars
        while(!this.isoCars.isEmpty()){
            isoCars.get(0).deleteCar();
            isoCars.remove(0);
        }

        playerController.setPlayerOwner(null, true);
        player.setAlive(false);
        player.getPlayerPic().delete();
    }


    public void createLevel(){
        this.currentGrid = new Grid(difficulty);
        this.roads = RoadFactory.createRoads(difficulty);
        this.hills = new Hill(difficulty);
        this.isoCars = Collections.synchronizedList(new LinkedList<IsoCar>());
        this.player = new Player(isoCars);
        playerController.setPlayerOwner(this.player, true);
        //this.player.getPlayerController().keyboardInit();
    }

    public boolean checkPlayerWinCondition(){
        double playerWidth = player.getPlayerPic().getWidth();
        double playerHeight = player.getPlayerPic().getHeight();
        double playerMiddleX = player.getPlayerPic().getX() + playerWidth / 2;
        double playerMiddleY = player.getPlayerPic().getY() + playerHeight / 1.25;

        int[] gridPosPlayer = Helper.toGrid(playerMiddleX, playerMiddleY);

        return gridPosPlayer[1] < 2;
    }

    public synchronized void reDrawPlayer(){
            player.getPlayerPic().delete();
            player.getPlayerPic().draw();
    }

    public void playMusic(int i){
            sound.setFile(i);
            sound.play();
            sound.loop();
    }

    public void stopMusic(){
            sound.stop();
    }

}
