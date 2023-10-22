package Game;

import Game.Isometric.Road;

import java.util.LinkedList;

public class RoadFactory {

    public static LinkedList<Road> createRoads(){
        LinkedList<Road> temp = new LinkedList<>();

        temp.add(new Road(2));
        temp.add(new Road(6));
        temp.add(new Road(10));
        temp.add(new Road(14));
        temp.add(new Road(18));

        return  temp;
    }

    public static LinkedList<Road> createRoads(Difficulty difficulty ){
        LinkedList<Road> temp = new LinkedList<>();

        switch (difficulty){
            case EASY:
                temp.add(new Road(10));
                temp.add(new Road(14));
                break;
            case MEDIUM:
                temp.add(new Road(6));
                temp.add(new Road(10));
                temp.add(new Road(14));
                break;
            case HARD:
                temp.add(new Road(2));
                temp.add(new Road(6));
                temp.add(new Road(10));
                temp.add(new Road(14));
                temp.add(new Road(18));
                break;
        }

        return  temp;
    }

}
