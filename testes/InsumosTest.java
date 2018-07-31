import org.junit.Assert;
import org.junit.Test;
import model.Insumos;

public class InsumosTest {
	
	@Test
	public void addInsumoAlemdaCapacidade() {
		Insumos insumos = new Insumos();
		Assert.assertEquals(-2, insumos.adiciona(Insumos.CAFE, 1001));
	}
}
