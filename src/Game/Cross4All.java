package Game;

import Game.Actors.Player.Player;
import Game.Isometric.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

/** Main game logic */
public class Cross4All implements Game, KeyboardHandler {
    private Player player;
    private LinkedList<IsoCar> isoCars;
    private LinkedList<Road> roads;
    private Hill hills;
    private Keyboard keyboard;
    private boolean clicked = false;
    private Grid currentGrid;
    private boolean endGame;
    private int scoreCounter;



    //Level options
    private boolean newLevel;
    private Difficulty difficulty;

    public Cross4All(){
        Menu menu = new Menu(this);
        while (!clicked) {
            try {
                Thread.sleep(25);
            } catch (Exception e) {
                System.out.println("Add exception");
            }
        }
        init();

        this.endGame = false;
        this.newLevel = false;
        this.difficulty = Difficulty.EASY;

        this.currentGrid = new Grid(difficulty);
        this.roads = RoadFactory.createRoads(difficulty);
        this.hills = new Hill(difficulty);
        this.isoCars = new LinkedList<IsoCar>();
        this.player = new Player(isoCars);
        this.player.getPlayerController().keyboardInit();
    }

    public void run() {
        while (!endGame) {

                //Todo Level creation or deletion
                if(newLevel){
                    //Testing deleting and loading levels

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

                for(IsoCar c : isoCars){
                    if( c.checkCollision(player) || !player.isAlive()) {

                        player.getPlayerPic().delete();
                        player = new Player(isoCars);
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

                try {
                    Thread.sleep(25);
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

        newLevel = true;
        //System.exit(1);
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
            isoCars.getFirst().deleteCar();
            isoCars.removeFirst();
        }

        player.setAlive(false);
        player.getPlayerPic().delete();
    }


    public void createLevel(){
        this.currentGrid = new Grid(difficulty);
        this.roads = RoadFactory.createRoads();
        this.hills = new Hill(difficulty);
        this.isoCars = new LinkedList<IsoCar>();
        this.player = new Player(isoCars);
        this.player.getPlayerController().keyboardInit();
    }
}
