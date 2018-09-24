package pa;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
	private int dimension;
	List<Reina> reinas;

	public Tablero(int dim, List<Reina> reinas) {
		this.dimension = dim;
		this.reinas = reinas;
	}

	public List<Conflicto> resolver() {
		List<Reina> reinasEnConflictos = new ArrayList<>();
		List<Conflicto> conflictos = new ArrayList<>();
		for (int i = 0; i < reinas.size(); i++) {
			Reina reinaActual = reinas.get(i);
			for (int j = 0; j < reinas.size(); j++) {
				if ((reinaActual.dentroDeRango(reinas.get(j), this.dimension)) && reinaActual != reinas.get(j)) {
					reinasEnConflictos.add(this.reinas.get(j));
				}
			}
			if (reinasEnConflictos.size() > 1)
				reinaActual.eliminaNoConflictos(reinasEnConflictos);
			conflictos.add(new Conflicto(reinaActual.getNumeroDeReina(), reinasEnConflictos));
			reinasEnConflictos.clear();
		}

		return conflictos;
	}
}
