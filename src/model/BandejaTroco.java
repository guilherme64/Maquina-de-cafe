package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// baseado nos codigos dessa fonta: http://www.devmedia.com.br/calculando-o-troco-em-uma-aplicacao-java/23617

public class BandejaTroco {
	// atriutos
	String fileName = "database/BD_troco.txt"; // endere√ßo da base de dados do troco
	static int vetorUnidades[] = new int[5]; // [.50],[1],[2],[5],[10]
	int reais[] = {10,5,2,1};
	int centavos[] = {50};
	int vetorTrocoCalculado[];
	
	public BandejaTroco(){
		init();
	}
	// metodos
	public void init(){
		int i = 0;
		
		try{
			FileReader arq = new FileReader(fileName);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();
			
			while(linha != null){
				this.vetorUnidades[i] = Integer.parseInt(linha);
				System.out.println("\nvetorUnidades[i] "+vetorUnidades[i]+" linha "+Integer.parseInt(linha));
				linha = lerArq.readLine();
				i++;
			}
			
			arq.close();
			
		}catch (FileNotFoundException e) {
			System.err.printf("Erro " + e.getMessage());
		}catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}
	}
	
	public void atualizaBD(int vetor[]){
		try {
			FileWriter arq = new FileWriter(this.fileName);
			PrintWriter gravarArq = new PrintWriter(arq);
			
			for(int i = 0;i<5;i++){
				gravarArq.println(vetor[i]);		
			}
			arq.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String relatorioTrocos(){
		String rel = "Bandeja de troco:\n";
		rel+= vetorUnidades[0]+" moedas de 50 centavos\n";
		rel+= vetorUnidades[1]+" moedas de 1 real\n";
		rel+= vetorUnidades[2]+" cedulas de 2 reais\n";
		rel+= vetorUnidades[3]+" cedulas de 5 reais\n";
		rel+= vetorUnidades[4]+" cedulas de 10 reais\n";
		return rel;
	}

	public boolean calcTroco(double troco){
		int valor, i = 0, ct;
		double trocoAux = troco;
		int vetorResult[] = new int[5]; // para calcular quanto sai da bandeja de troco 
		for(int j=0;j<5;j++){
			vetorResult[j] = 0;
		}
		
		valor = (int) troco; // definindo notas do troco (parte inteira)
		
		// moeda de 1 real fica classificado como cedula por ser um valor n√£o fracioando
		// e √© mais facil de calcular assim
		
		while (valor != 0){
			int ctTemp = valor / this.reais[i];
			if(ctTemp != 0){
				if(ctTemp <= vetorUnidades[4-i]){
					ct = ctTemp; // calculando a quantidade de notas
					System.out.println(ct + " unidade(s) de R$ " + this.reais[i]);
			        vetorResult[4-i] = ct;
			        trocoAux = trocoAux - this.reais[i] * ctTemp;
			        //System.out.println("reais: trocoAux="+trocoAux);
			        valor = valor % this.reais[i]; // sobra
				}
				else{
					System.out.println("N„o h· notas de R$ " + this.reais[i]+" suficientes para o troco.");
				}
			}
			
			i++; //proxima nota 
			if(i>=reais.length) break;
		}
		
		// definindo os centavos do troco (parte fracion√°ria)
		valor = (int)Math.round((troco - (int)troco) * 100);
	    i = 0;
	    
	    while (valor != 0) { // n√£o √© necessaria
	    	int ctTemp = valor / this.centavos[i]; // calculando a qtde de moedas
	    	if(ctTemp != 0) {
	    		if(ctTemp <= vetorUnidades[i]){
	    			ct = ctTemp;
		    		System.out.println(ct +" unidade(s) de "+ this.centavos[i] + " centavo(s)");
		        	vetorResult[i] = ct;
		        	//System.out.println("trocoAux("+trocoAux+") = trocoAux("+trocoAux+") - this.centavos[i]("+this.centavos[i]+") * ctTemp("+ctTemp+")/100)");
		        	trocoAux = trocoAux - ((double)(this.centavos[i] * ctTemp))/100;
		        	//System.out.println("centavos: trocoAux="+trocoAux);
		        	valor = valor % this.centavos[i]; // sobra
	    		}
	    		else{
	    			System.out.println("N„o h· moedas de R$ 0," + this.centavos[i]+" suficientes para o troco.");
	    		}
	        }
	        i++; // pr√≥ximo centavo
	        if(i>=centavos.length) break;
	    }
	    
	    if(trocoAux>0){//se n„o h· disponibilidade
	    	System.out.println("N„o h· disponibilidade de troco");
	    	return false;
	    }
	    
	    debitarTroco(vetorResult);
	    return true;  
	    
	}

	private void debitarTroco(int[] vResult){
		int i;
		
		System.out.println("\nTroco debitado. Bandeja atual: ");
		for(i=0;i<5;i++){
			this.vetorUnidades[i] -= vResult[i];
			System.out.println("\n"+this.vetorUnidades[i]);
		}
		atualizaBD(this.vetorUnidades);
		vetorTrocoCalculado = vResult;
	}
	
	public int[] getTrocoCalculado(){
		return vetorTrocoCalculado;
	}
	
	//qtd negativa: retira; qtd positiva: adiciona
	//retorno: o resultado da soma/subtraÁ„o se opÁao valida ou subtraÁ„o > 0; -1 se opÁ„o invalida; -2 se subtraÁ„o < 0; -3 se qtd>1000
	public int carregarBandeja(int opcao, int qtd){
		int soma = qtd + vetorUnidades[opcao];
		System.out.println("\nsomando "+qtd+" + "+vetorUnidades[opcao]);
		//para ingredientes e copos
		if(opcao < 5 && opcao >=0 && soma >=0 && soma <=1000) {
			vetorUnidades[opcao] = soma;
			atualizaBD(this.vetorUnidades);
			System.out.println("\nTroco adicionado/retirado com sucesso ");
			return vetorUnidades[opcao];
		}
		else if(!(opcao < 5 && opcao >=0)) return -1;
		else if(soma < 0) return -2;
		else if(soma > 1000) return -3;
		return -3;
	}
}
