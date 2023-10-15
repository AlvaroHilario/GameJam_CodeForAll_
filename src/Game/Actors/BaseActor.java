package Game.Actors;

public abstract class BaseActor {
    protected Position pos;

    public BaseActor(int col, int row){
        this.pos = new Position(col , row);
    }
}
