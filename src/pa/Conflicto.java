package pa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conflicto {
	private int numeroDeReina;
	List<Reina> reinasEnConflicto = new ArrayList<>();

	public Conflicto(int nroDeReina, List<Reina> reinas) {
		this.numeroDeReina = nroDeReina;
		this.reinasEnConflicto.addAll(reinas);
	}

	public int getNumeroDeReina() {
		return numeroDeReina;
	}

	public List<Reina> getReinasEnConflicto() {
		return reinasEnConflicto;
	}

	public void ordenaReinas() {
		Collections.sort(this.reinasEnConflicto);
	}

}