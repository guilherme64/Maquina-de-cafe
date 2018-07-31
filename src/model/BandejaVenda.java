package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BandejaVenda {
	String fileName = "database/BD_dinheiro_venda.txt"; // endereço da base de dados do dinheiro recebido nas vendas
	static double dinheiroVenda;
	
	public BandejaVenda(){
		init();
	}
	// metodos
	public void init(){
		int i = 0;
		
		try{
			FileReader arq = new FileReader(fileName);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();
			dinheiroVenda = Double.parseDouble(linha);
			arq.close();
			
		}catch (FileNotFoundException e) {
			System.err.printf("Erro " + e.getMessage());
		}catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}
	}
	
	public void atualizaBD(){
		try {
			FileWriter arq = new FileWriter(this.fileName);
			PrintWriter gravarArq = new PrintWriter(arq);

			gravarArq.println(dinheiroVenda);		
			
			arq.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public double showValorNaBandeja(){
		return dinheiroVenda;
	}
	
	//qtd negativa: retira; qtd positiva: adiciona
	public double descarregarBandeja(){
		double dinheiro = dinheiroVenda;
		dinheiroVenda = 0;
		atualizaBD();
		System.out.println("dinheiro retirado com sucesso ");
		return dinheiro;
	}
	
	public double adicionarDinheiro(double dinheiro){
		dinheiroVenda+= dinheiro;
		atualizaBD();
		return dinheiroVenda;
	}
	
}
