package controller;

import model.*;

public class VendaController {
	
	public CafeTipos tiposCafe = new CafeTipos();
	public int tipoSelected = 0;
	public String mensagem = "";//mensagem ao cliente
	public Insumos insumos = new Insumos();
	public int[] dinheiroVenda;//recebe as cedulas e moedas: 0 = 50cent; 1 = 1real; 2 = 2 reais; 3 = 5reais; 4 = 10reais
	public double[] dinheiros = {0.5, 1, 2, 5, 10};
	public double somaDinheiros;
	
	public VendaController(){
		dinheiroVenda = new int[5];
	}
	
	public boolean selectTipo(int tipo){//a view a primeira vez que abre deve chamar este metodo selecionando o primeiro cafe
		this.tipoSelected = tipo;
		if(!insumos.temAgua()){
			mensagem = "não tem água";
			return false;//a view deve bloquear o input de dinehiro e realizar venda e mostrar msg
		}
		if(insumos.getQtdInsumo(Insumos.COPOS)==0){
			mensagem = "não tem copo";
			return false;//a view deve bloquear o input de dinehiro e realizar venda e mostrar msg
		}
		
		if(tiposCafe.disponibilidade(tipo)==0){
			mensagem = "café indisponivel";
			return false;//a view deve bloquear o input de dinehiro e realizar venda e mostrar msg
		}
		mensagem = "ok";
		newVenda();
		return true;
	}
	
	public String getNomeCafe(){
		return (String)tiposCafe.getTipos()[tipoSelected].get("nome");
	}
	
	public double getValorCafe(){
		return Double.parseDouble((String)tiposCafe.getTipos()[tipoSelected].get("valor"));
	}
	
	public String getMensagem(){
		return this.mensagem;
	}
	
	public void newVenda(){
		clearDinheiros();
	}
	
	public boolean addDinheiro(int opDinheiro){//retorna true se dinheiro é suficiente para concretizar venda, e só entao a view deve liberar o botao de comprar
		dinheiroVenda[opDinheiro]+= 1;
		somaDinheiros = 0;
		for(int i=0;i<5;i++){
			somaDinheiros+= dinheiroVenda[i] * dinheiros[i];
		}
		if(somaDinheiros >= Double.parseDouble((String)tiposCafe.getTipos()[tipoSelected].get("valor"))){
			return true;//a view deve liberar o botao de comprar
		}
		return false;
	}
	public void clearDinheiros(){
		
		for(int i=0;i<5;i++){
			dinheiroVenda[i] = 0;
		}
		somaDinheiros = 0;
	}
	public boolean processarCompra(){
		BandejaTroco bandeja = new BandejaTroco();
		
		double troco, recebido, conta;
		
		bandeja.init(); // inicia metodo principal
//		mostraTrocos(bandeja.vetorUnidades);
		
		// inializa os valores p/ teste
		recebido = somaDinheiros;
		conta = Double.parseDouble((String)tiposCafe.getTipos()[tipoSelected].get("valor"));
		
		troco = recebido - conta;	
		
		if(!bandeja.calcTroco(troco)){//se nao for possivel dar o troco
			mensagem = "Não é possível processar o troco para o dinheiro adicionado";
			clearDinheiros();//devolve o dinheiro
			return false;
		}
		//se foi possivel dar o troco, o troco foi debitado. processar compra.
		
		//debitar insumos
		
		insumos.adiciona(0, -Integer.parseInt((String)tiposCafe.get(tipoSelected).get("qtd_cafe")));
		insumos.adiciona(1, -Integer.parseInt((String)tiposCafe.get(tipoSelected).get("qtd_leite")));
		insumos.adiciona(2, -Integer.parseInt((String)tiposCafe.get(tipoSelected).get("qtd_acucar")));
		insumos.adiciona(3, -Integer.parseInt((String)tiposCafe.get(tipoSelected).get("qtd_chocolate")));
		insumos.adiciona(4, -1);//copo
		
		String dindinsRec = "";
		for(int i=0;i<dinheiros.length;i++){
			if(dinheiroVenda[i]==0) continue;
			
			dindinsRec+=dinheiroVenda[i]+"x"+dinheiros[i]+" ";
			
		}
		String dindinsTroco = "";
		int[] vTroco = bandeja.getTrocoCalculado();
		for(int i=0;i<vTroco.length;i++){
			if(vTroco[i]==0) continue;
			
			dindinsTroco+=vTroco[i]+"x"+dinheiros[i]+" ";
			
		}
		
		Vendas venda = new Vendas();
		venda.registrarVenda(tipoSelected, conta, recebido, troco);
		BandejaVenda bandejaVenda = new BandejaVenda();
		bandejaVenda.adicionarDinheiro(recebido);
		mensagem = "Compra realizada. Recebido: R$ "+recebido+" ("+dindinsRec+"). Troco: R$ "+troco+" ("+dindinsTroco+"). Saboreie seu delicioso café "+getNomeCafe()+"!";
		return true;
	}

}
