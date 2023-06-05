package ui;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import domain.GestionPlanetas;
import domain.Planeta;
import io.IOFile;

public class Juego extends JFrame {
    public static int ALTO = 1000; 
    public static int ANCHO = 1000; 

    public Juego(){
        super("Planetas"); 

        GestionPlanetas gestion = new GestionPlanetas(this);
        
        gestion.initJuego();

        setVisible(true);
        setResizable(false);
        //setLocationRelativeTo(null);
        setSize(ANCHO, ALTO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new Juego();
    } 
}
