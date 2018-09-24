package pa;

import java.util.List;

public class Reina implements Comparable<Reina> {
	private int x;
	private int y;
	private int numeroDeReina;

	public Reina(int x, int y, int numeroDeReina) {
		this.x = x;
		this.y = y;
		this.numeroDeReina = numeroDeReina;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getNumeroDeReina() {
		return this.numeroDeReina;
	}

	public boolean dentroDeRango(Reina otra, int dimTablero) {
		boolean rangoDiagonal = false;
		for (int i = 1; i < dimTablero; i++) {
			if ((otra.x == this.x - i && otra.y == this.y + i) || (otra.x == this.x + i && otra.y == this.y - i)
					|| (otra.x == this.x + i && otra.y == this.y + i) || (otra.x == this.x - i && otra.y == this.y - i))
				rangoDiagonal = true;
		}
		return this.x == otra.x || this.y == otra.y || rangoDiagonal;
	}

	public void eliminaNoConflictos(List<Reina> reinasConConflictos) {

		Reina[] reinasConConflictosFinal = new Reina[8];
		for (Reina reina1 : reinasConConflictos) {
			int ret = this.identificaPosicionRelativa(reina1);
			if (reinasConConflictosFinal[ret] == null)
				reinasConConflictosFinal[ret] = reina1;
			else {
				Reina reina2 = reinasConConflictosFinal[ret];
				double dist1 = this.distanciaEntreReinas(reina1);
				double dist2 = this.distanciaEntreReinas(reina2);
				if (dist1 < dist2)
					reinasConConflictosFinal[ret] = reina1;
				else
					reinasConConflictosFinal[ret] = reina2;
			}
		}
		reinasConConflictos.clear();
		for (int i = 0; i < reinasConConflictosFinal.length; i++)
			if (reinasConConflictosFinal[i] != null)
				reinasConConflictos.add(reinasConConflictosFinal[i]);
	}

	public int identificaPosicionRelativa(Reina otra) {
		if (this.x == otra.x && this.y > otra.y)
			return 0; // A la izquierda de la Reina
		else if (this.x == otra.x && this.y < otra.y)
			return 1; // A la derecha de la Reina
		else if (this.y == otra.y && this.x > otra.x)
			return 2; // Arriba de la Reina
		else if (this.y == otra.y && this.x < otra.x)
			return 3; // Abajo de la Reina
		else if (this.x > otra.x && this.y < otra.y)
			return 4; // Diagonal derecha arriba de la Reina
		else if (this.x < otra.x && this.y > otra.y)
			return 5; // Diagonal izquierda abajo de la Reina
		else if (this.x > otra.x && this.y > otra.y)
			return 6; // Diagonal izquierda arriba de la Reina
		else
			return 7; // Diagonal derecha abajo de la Reina

	}

	public int distanciaEntreReinas(Reina otra) {
		return (int) Math.sqrt((Math.pow(this.x - otra.x, 2)) + Math.pow(this.y - otra.y, 2));
	}

	@Override
	public int compareTo(Reina otra) {
		return this.numeroDeReina - otra.numeroDeReina;
	}
}
