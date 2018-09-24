package pa;

import org.junit.Assert;
import org.junit.Test;

public class ReinaTests {
	@Test
	public void enRangoLineal() {
		Reina r1 = new Reina(5, 4,1);
		Reina r2 = new Reina(5, 1,2);
		Reina r3 = new Reina(8, 4,3);
		Assert.assertEquals(true, r1.dentroDeRango(r2, 8));
		Assert.assertEquals(true, r1.dentroDeRango(r3, 8));
	}

	@Test
	public void enRangoDiagonal() {
		Reina r1 = new Reina(5, 4,1);
		Reina r2 = new Reina(1, 8,2);
		Reina r3 = new Reina(6, 3,3);
		Reina r4 = new Reina(8, 7,4);
		Reina r5 = new Reina(2, 1,5);

		Assert.assertEquals(true, r1.dentroDeRango(r2, 8));
		Assert.assertEquals(true, r1.dentroDeRango(r3, 8));
		Assert.assertEquals(true, r1.dentroDeRango(r4, 8));
		Assert.assertEquals(true, r1.dentroDeRango(r5, 8));
	}

	@Test
	public void fueraDeRango() {
		Reina r1 = new Reina(5, 4,1);
		Reina r2 = new Reina(4, 6,2);
		Reina r3 = new Reina(7, 1,3);
		Reina r4 = new Reina(1, 3,4);
		Reina r5 = new Reina(6, 8,5);

		Assert.assertEquals(false, r1.dentroDeRango(r2, 8));
		Assert.assertEquals(false, r1.dentroDeRango(r3, 8));
		Assert.assertEquals(false, r1.dentroDeRango(r4, 8));
		Assert.assertEquals(false, r1.dentroDeRango(r5, 8));
	}
	
	@Test
	public void enRangoExtremo() {
		Reina r1 = new Reina(1, 1,1);
		Reina r2 = new Reina(8, 8,2);
		Assert.assertEquals(true, r1.dentroDeRango(r2, 8));
	
	}

}
