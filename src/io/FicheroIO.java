import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FicheroIO {
    private String file; 

	public FicheroIO(String file){
		this.file = file; 
	}

	public ArrayList<Planeta> readFichero() throws IOException, NumberFormatException{
        ArrayList<Planeta> planetas = new ArrayList<>();
		String[] colores = {"rojo", "azul", "verde"};

		BufferedReader br = new BufferedReader(new FileReader(new File(file))); 

		String linea = br.readLine();
		while(linea != null){
			System.out.println(linea);

			boolean relleno = false; 
			int salto = 3;

			// x, relleno
			String[] campos; 
			if (linea.contains("true")){
				campos = linea.split("t");
				relleno = true; 
			} else {
				campos = linea.split("f");
				salto = 4;
			}
			int x = Integer.parseInt(campos[0]);
			String campo = campos[1].substring(salto);

			// Color, y, animacion
			Color color = Color.RED;
			int index = 3; // Longitud de color

			for (String c : colores){
				if (campo.contains(c.substring(0, 1))){
					if (c.equals("azul")){
						color = Color.BLUE;
					} else if (c.equals("verde")){
						color = Color.GREEN;
						index = 4;
					}
				}
			}
			int y = Integer.parseInt(campo.substring(0, campo.length()-index-2));
			int animacion = Integer.parseInt(campo.substring(campo.length()-1));

			System.out.println("x: " + x + " relleno: " + relleno +
					", y: " + y + " ,color: " + color + ", animacion: " + animacion);

			// Creamos planeta
			Planeta planeta; 
			if (animacion == 1){
				planeta = new Planeta1(index, y, relleno, color);
			} else if (animacion == 2){
				planeta = new Planeta2(index, y, relleno, color); 
			} else {
				planeta = new Planeta3(index, y, relleno, color);
			}

            planetas.add(planeta);
			linea = br.readLine(); 
		}
		br.close(); 
        return planetas; 
	}
}
