package pa;

import java.io.IOException;

public class App {

	public static void main(String[] args) {
		try {
			Tablero tablero = ArchivoConflictoEntreReinas.leerArchivo("resource\\entrada\\reinas.in");
			ArchivoConflictoEntreReinas.escribirArchivo("resource\\salida\\reinas.out", tablero.resolver());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
