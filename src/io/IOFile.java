package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import domain.Planeta;
import domain.Planeta2;
import domain.Planeta3;

import java.awt.*;

public class IOFile {
    public static ArrayList<Planeta> readFichero() throws IOException, NumberFormatException{
        ArrayList<Planeta> planetas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("resources/juego.txt")));

        HashMap<String, Color> colores = new HashMap<>();
        colores.put("azul", Color.BLUE);
        colores.put("rojo", Color.RED);
        colores.put("verde", Color.GREEN);
        colores.put("amarillo", Color.yellow);

        // Inicializo variables
        int x = 0; 
        int y = 0; 
        int animacion = 0; 
        Color color = Color.RED;
      

        String linea = br.readLine();
        while (linea != null){
            String[] campos = linea.split("true");
            boolean relleno = true; 

            if (linea.contains("false")){
                campos = linea.split("false"); 
                relleno = false; 
            }

            x = Integer.parseInt(campos[0]);

            System.out.println(linea + "\nCampo 0: " + campos[0] + " Campo1: " + campos[1]);

            // Colores
            for (String c : colores.keySet()){
                if (campos[1].contains(c)){
                    color = colores.get(c);
                    String[] campos2 = campos[1].split(c);
                    y = Integer.parseInt(campos2[0]);
                    animacion = Integer.parseInt(campos2[1]);
                }
            }

            System.out.println("x: " + x + " relleno: " + relleno +
            ", y: " + y + " ,color: " + color + ", animacion: " + animacion);

            Planeta planeta; 
            if (animacion == 1){
                planeta = new Planeta(x, relleno, y, color);
            } else if (animacion == 2){
                planeta = new Planeta2(x, relleno, y, color);
            } else {
                planeta = new Planeta3(x, relleno, y, color);
            }

            planetas.add(planeta);
            
            linea = br.readLine();
        }
        br.close();
        return planetas; 
    }
}
