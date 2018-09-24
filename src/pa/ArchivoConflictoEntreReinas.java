package pa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoConflictoEntreReinas {

	public static Tablero leerArchivo(String path) throws FileNotFoundException {
		File archivo = new File(path);
		Scanner entrada = new Scanner(archivo);
		int dimTablero = entrada.nextInt();
		int cantidadDeReinas = entrada.nextInt();
		List<Reina> reinas = new ArrayList<>();

		for (int i = 1; i <= cantidadDeReinas; i++) {
			reinas.add(new Reina(entrada.nextInt(), entrada.nextInt(), i));
		}
		entrada.close();

		return new Tablero(dimTablero, reinas);
	}

	public static void escribirArchivo(String path, List<Conflicto> conflictos) throws IOException {
		File archivo = new File(path);
		PrintWriter salida = new PrintWriter(archivo);
		for (int i = 0; i < conflictos.size(); i++) {
			if (conflictos.get(i).getReinasEnConflicto().size() > 0) {
				conflictos.get(i).ordenaReinas();
				salida.print(conflictos.get(i).getReinasEnConflicto().size() + " ");
				for (Reina x : conflictos.get(i).getReinasEnConflicto()) {
					salida.print(x.getNumeroDeReina() + " ");
				}
			} else
				salida.print(0);
			salida.println();
		}
		salida.close();
	}
}