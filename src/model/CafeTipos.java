package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Iterator; 

/*Banco JSON de tipos de cafe: (usar a biblioteca org.json.simple para manipular o JSON)*/
/*
 * {
	"tipos_cafe": [
	{
		"id": "0",
		"nome": "preto",
		"qtd_cafe": "20", 
		"qtd_leite": "0", 
		"qtd_acucar": "20",
		"qtd_chocolate": "0",
		"valor": "2"
	},
	{
		"id": "1",
		"nome": "com leite", 
		"qtd_cafe": "20", 
		"qtd_leite": "20", 
		"qtd_acucar": "20",
		"qtd_chocolate": "0",
		"valor": "3"
	},
	{
		"id": "2",
		"nome": "capuccino", 
		"qtd_cafe": "20", 
		"qtd_leite": "20", 
		"qtd_acucar": "20",
		"qtd_chocolate": "20",
		"valor": "4"
	},
	{
		"id": "3",
		"nome": "preto amargo", 
		"qtd_cafe": "20", 
		"qtd_leite": "0", 
		"qtd_acucar": "10",
		"qtd_chocolate": "0",
		"valor": "1.5"
	},
	{
		"id": "4",
		"nome": "com leite amargo", 
		"qtd_cafe": "20", 
		"qtd_leite": "20", 
		"qtd_acucar": "10",
		"qtd_chocolate": "0",
		"valor": "2.5"
	},
	{
		"id": "5",
		"nome": "capuccino amargo", 
		"qtd_cafe": "20", 
		"qtd_leite": "20", 
		"qtd_acucar": "10",
		"qtd_chocolate": "20",
		"valor": "3.5"
	}
]
}
 */

public class CafeTipos {
	
	private static JSONObject[] tiposCafe;
	//indices dos tipos de cafe no banco
	public static final int CAFE_PRETO = 0;
	public static final int CAFE_LEITE = 1;
	public static final int CAFE_CAPUCCINO = 2;
	public static final int CAFE_PRETO_AMARGO = 3;
	public static final int CAFE_LEITE_AMARGO = 4;
	public static final int CAFE_CAPUCCINO_AMARGO = 5;
	
	private Insumos insumos;
	
	public CafeTipos(){
		insumos = new Insumos();
		JSONParser parser = new JSONParser();
		try {  
			Object obj = parser.parse(new FileReader("Database/BD_cafe.json"));  
			JSONObject jsonObject = (JSONObject) obj;  
			JSONArray tipos = (JSONArray) jsonObject.get("tipos_cafe");  
			tiposCafe = new JSONObject[Insumos.QTD_TIPO_INSUMO];   
			Iterator<JSONObject> iterator = tipos.iterator(); 
			int i = 0;
			   while (iterator.hasNext()) {  
				   tiposCafe[i] = (JSONObject)iterator.next();
				   i++;
			   }
		}
		 catch (Exception e) {  
			e.printStackTrace();  
		} 
					
	}
	
	/*ACESSANDO OS TIPOS DE CAFE*/
	/*
	 * JSONObject tipos[] = CafeTipos.getTipos();
	 * JSONObject cafe_preto = tipos[CafeTipos.CAFE_PRETO];//retorna um JSONObject com a estrutura: 
	 *  "id": 1,
		"nome": "preto",
		"qtd_cafe": 20, 
		"qtd_leite": 0, 
		"qtd_acucar": 20,
		"qtd_chocolate": 0,
		"valor": 2
		//mostrando os dados:
	 * System.out.println(""+Integer.parseInt((String)cafe_preto.get("id")));
	 * System.out.println(""+(String)cafe_preto.get("nome"));
	 * System.out.println(""+Integer.parseInt((String)cafe_preto.get("qtd_cafe")));
	 * System.out.println(""+Integer.parseInt((String)cafe_preto.get("qtd_leite")));
	 * System.out.println(""+Integer.parseInt((String)cafe_preto.get("qtd_acucar")));
	 * System.out.println(""+Integer.parseInt((String)cafe_preto.get("qtd_chocolate")));
	 * System.out.println(""+Double.parseDouble((String)cafe_preto.get("valor")));
	 */
	//Metodo apenas para mostrar as formulas de cada tipo de café e seus respectivos valores. Para fins de relatório na área administrativa.
	public JSONObject[] getTipos(){ 
		return tiposCafe;
	}
	public JSONObject get(int tipo){ 
		if(tipo>=0 && tipo <=tiposCafe.length){
			return tiposCafe[tipo];
		}
		return null;
	}
	//retorna 1 se disponivel, 0 se nao, -1 se opcao de tipo de cafe invalida
	public int disponibilidade(int cafeTipo){
		
		int qtdsInsumos[] = insumos.getInsumos();
		
		if(cafeTipo>=0 && cafeTipo <=tiposCafe.length){
			if(Integer.parseInt((String)tiposCafe[cafeTipo].get("qtd_cafe")) <= qtdsInsumos[Insumos.CAFE] && Integer.parseInt((String)tiposCafe[cafeTipo].get("qtd_leite")) <= qtdsInsumos[Insumos.LEITE] 
					&& Integer.parseInt((String)tiposCafe[cafeTipo].get("qtd_acucar")) <= qtdsInsumos[Insumos.ACUCAR] && Integer.parseInt((String)tiposCafe[cafeTipo].get("qtd_chocolate")) <= qtdsInsumos[Insumos.CHOCOLATE]){
				return 1;
			}
			else{
				return 0;
			}
		}
		return -1;
	}
	public String relatorio(){
		String rel = "Relatório de cafe\n\n";
		for (int i = 0; i< tiposCafe.length ; i++ ){
			rel+="Cafe "+(String)tiposCafe[i].get("nome")+"\nqtd cafe: "+Integer.parseInt((String)tiposCafe[i].get("qtd_cafe"))+"g\nqtd leite: "+Integer.parseInt((String)tiposCafe[i].get("qtd_leite"))+"g\nqtd chocolate: "+Integer.parseInt((String)tiposCafe[i].get("qtd_chocolate"))+"g\nqtdacucar: "+Integer.parseInt((String)tiposCafe[i].get("qtd_acucar"))+"\ndisponivel: "+((this.disponibilidade(i)==1)?"sim":"não")+"\n\n";	
		}
		return rel;
	}
}
