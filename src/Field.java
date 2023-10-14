import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
    private Rectangle field;

    public Field () {
        this.field = new Rectangle(10,10, 1000, 800);
        this.field.setColor(Color.BLACK);
        this.field.fill();
    }


    public int getWidth() {
        return field.getWidth();
    }

    public int getHeight() {
        return field.getHeight();
    }
}
