package domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import ui.Juego;

public class Planeta {
    protected int alto = 100; 
    protected int ancho = 100; 

    protected int x; 
    protected int y; 

    protected Color color; 
    protected boolean relleno;

    protected Random random = new Random(); 

    public Planeta(int x, boolean relleno, int y, Color color){
        
        if (x == -1 || y == -1){
            this.x = random.nextInt(Juego.ANCHO);
            this.y = random.nextInt(Juego.ALTO);
        } else {
            this.x = x; 
            this.y = y; 
        }
        
        this.relleno = relleno; 
        this.color = color; 
    }

    public Color getColor(){
        return color;
    }

    public void paint(Graphics g){
        g.setColor(color);
        if (relleno){
            g.fillOval(x, y, ancho, alto);
        } else {
            g.drawOval(x, y, ancho, alto);
        }
    }

    @Override
    public String toString(){
        return "x: " + x + " y: " + y 
        + " relleno: " + relleno + " color: " + color; 
    }
}
