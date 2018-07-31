package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Insumos {
	
	private String fileName = "Database/BD_insumos.txt"; // endereço da base de dados dos insumos
	public static final int QTD_TIPO_INSUMO = 6;
	private static int insumosBD[] = new int[QTD_TIPO_INSUMO]; // 0 = café (1000g), 1 = leite (1000g), 2 = açucar (1000g), 3 = chocolate (1000g), 4 = copos (100und), 5 = agua (0 = faltou; 1 = tem agua na torneira)
	private final int MAX_INSUMOS = 1000;//em gramas
	private final int MAX_COPOS = 100;//em unidades
	
	//constantes globais em toda a app que representam os indices dos insumos no bd. Ex uso: Insumos.CAFE
	public static final int CAFE = 0;
	public static final int LEITE = 1;
	public static final int ACUCAR = 2;
	public static final int CHOCOLATE = 3;
	public static final int COPOS = 4;
	public static final int AGUA = 5;
	public static final String[] nomes = {"Café", "Leite", "Açúcar", "Chocolate", "Copos", "Água"};
	
	public Insumos(){
		init();
	}

	public void init(){
		try{
			FileReader arq = new FileReader(fileName);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();
			int i = 0;
			
			while(linha != null){
				insumosBD[i] = Integer.parseInt(linha);
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

	/*Adiciona ou retira (passando qtd negativo) insumos ou copos
	 *retorno: o resultado da soma ou subtração se ok 
	 *		   -1 se erro
	 *		   -2 se opção invalida ou quantidade inválida de insumo a adicionar/subtrair
	 *		   */
	public int adiciona(int opcao, int qtd){
		int soma = qtd + insumosBD[opcao];
		//para ingredientes e copos
		if((opcao < 4 && opcao >=0 && (soma <= MAX_INSUMOS && soma >=0)) || (opcao == 4 && (soma <= MAX_COPOS && soma >= 0))) {
			insumosBD[opcao] = soma;
			String insumosBDWrite = "";
			for(int i=0; i<insumosBD.length; i++){
				insumosBDWrite+= insumosBD[i]+"\n";
			}
			try {

				File file = new File(this.fileName);

				if (!file.exists()) {
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(insumosBDWrite);
				bw.close();

				System.out.println("Done");
				return insumosBD[opcao];

			} catch (IOException e) {
				System.err.printf("Erro ao ler ou gravar o bd");
				this.init();//faz um rollback da adicao/subtracao na memoria
				return -1;
			}
			
		}
		
		System.err.printf("Quantidade de insumo excedida ou opcao invalida");
		return -2;//codigo de erro
	}
		
	/*Retorna um array com as quantidades de cada insumo*/
	public int[] getInsumos(){
		return insumosBD;
	}
	
	//retorna a quantidade atual do insumo ou -1 em caso de opção inválida de insumo
	public int getQtdInsumo(int insumo){
		return (insumo < 5 && insumo >=0)?insumosBD[insumo]:-1;
	}
	
	public boolean temAgua(){
		init();
		if(insumosBD[Insumos.AGUA]==0){
			return false;
		}
		return true;
	}

	public String relatorio(){
		String rel = "Relatório de insumos\n\n";
		for (int i = 0; i< QTD_TIPO_INSUMO ; i++ ){
			rel+= nomes[i]+": "+insumosBD[i]+"\n";
		}
		return rel;
	}
}
