package Game.Actors;

public abstract class BaseActor {
    protected Position pos;

    BaseActor(int col, int row){
        this.pos = new Position(col , row);
    }
}
