import org.junit.Assert;
import org.junit.Test;
import controller.VendaController;
import model.CafeTipos;

public class VendaTest {

	@Test
	public void cafePodeSerVendido() {
		VendaController venda = new VendaController();
		Assert.assertTrue(venda.selectTipo(CafeTipos.CAFE_PRETO));
	}
	
	@Test
	public void dinheiroInseridoSuficiente(){
		VendaController venda = new VendaController();
		venda.selectTipo(CafeTipos.CAFE_CAPUCCINO);//valor: R$ 4,00
		venda.addDinheiro(0);//R$ 0,50
		venda.addDinheiro(1);//R$ 1,00
		venda.addDinheiro(1);//R$ 1,00
		Assert.assertTrue(venda.addDinheiro(2));//R$ 2,00
	}
}
