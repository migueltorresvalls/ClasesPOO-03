package domain;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import io.IOFile;
import ui.Juego;
import ui.Tablero;


public class GestionPlanetas {
    ArrayList<Planeta> planetasFichero = new ArrayList<>();
    ArrayList<Planeta> planetas = new ArrayList<>();
    private Juego juego; 
    private Tablero tablero; 

    private int contSpace = 0; 

    public GestionPlanetas(Juego juego){
        this.juego = juego; 
        
        try {
            planetasFichero = IOFile.readFichero();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void initJuego(){
        tablero = new Tablero(this);

        juego.add(tablero);
        tablero.initMov();
        addEventos();
    }

    public void addEventos(){
        HashMap<Color, Boolean> colores = tablero.getColores();
        
        juego.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE: 
                        // Agregamos un planeta
                        if (contSpace < 7){
                            Planeta planeta = planetasFichero.get(contSpace);
                            planetas.add(planeta);
                            
                            contSpace ++;
                        }
                        break;
                    case KeyEvent.VK_ENTER:
                        // Empieza animacion
                        break; 
                    case KeyEvent.VK_R:
                        colores.put(Color.RED, true);
                        colores.put(Color.BLUE, false);
                        colores.put(Color.GREEN, false);
                        break; 
                    case KeyEvent.VK_G:
                        colores.put(Color.GREEN, true);
                        colores.put(Color.RED, false);
                        colores.put(Color.BLUE, false);
                        break; 
                    case KeyEvent.VK_B:
                        colores.put(Color.BLUE, true);
                        colores.put(Color.RED, false);
                        colores.put(Color.GREEN, false);
                        break; 
                    case KeyEvent.VK_A:
                        colores.put(Color.GREEN, true);
                        colores.put(Color.RED, true);
                        colores.put(Color.BLUE, true);
                    default:
                        break;
                }
            }
        });
        tablero.setColores(colores);
    }

    public void recalcularPosiciones(){
        planetas.forEach(planeta -> {
            if (planeta instanceof Planeta2 planeta2){
                // Movimiento cuadratico
            } else if (planeta instanceof Planeta3 planeta3){
                // Movimiento cuadratico + zoom 
            }
        });
    }

    public ArrayList<Planeta> getPlanetas(){
        return planetas; 
    }
}
