package ui;

import javax.swing.JPanel;

import domain.GestionPlanetas;
import io.IOFile;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Tablero extends JPanel{
    private GestionPlanetas gestion; 
    private static final int FPS = 60;

    private HashMap<Color, Boolean> colores = new HashMap<>();

    public Tablero(GestionPlanetas gestion){
        colores.put(Color.RED, true);
        colores.put(Color.BLUE, true);
        colores.put(Color.GREEN, true);

        this.gestion = gestion;

        setBackground(Color.BLACK);
    }

    public HashMap<Color, Boolean> getColores(){
        return colores; 
    }

    public void setColores(HashMap<Color, Boolean> colores){
        this.colores = colores;
    }

    public void initMov(){
        new Thread(() -> {
            while (true){
                //gestion.recalcularPosiciones();
                //System.out.println("Planetas: " + gestion.getPlanetas());
                repaint();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }).start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);


        gestion.getPlanetas().forEach(planeta -> {
            if (colores.get(planeta.getColor())){
                planeta.paint(g);
            }
        });
    }
}
