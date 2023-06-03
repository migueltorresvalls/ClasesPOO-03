import java.awt.Color;

public abstract class Planeta {
    protected int x; 
    protected int y; 

    protected boolean relleno; 
    protected Color color; 

    protected int animacion; 

    public Planeta(int x, int y, boolean relleno, Color color, int animacion){
        this.x = x; 
        this.y = y; 
        this.relleno = relleno; 
        this.color = color; 
        this.animacion = animacion; 
    }
}
