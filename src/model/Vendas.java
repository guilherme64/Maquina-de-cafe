package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Date;
import java.util.Iterator; 

/*Banco JSON de vendas: (usar a biblioteca org.json.simple para manipular o JSON)*/
/*
 * {
	"vendas": [
	{
		"id": "0",
		"tipo_cafe": "1",
		"valor": "2", 
		"valor_pago": "5", 
		"troco": "3",
		"data_hora": "2016-12-08 17-43-00"
	},
	{
		"id": "1",
		"tipo_cafe": "3",
		"valor": "2.5", 
		"valor_pago": "5", 
		"troco": "2.5",
		"data_hora": "2016-12-08 17-43-00"
	}
  ]
}
 */

public class Vendas {
	
	private static JSONObject[] vendas;
	private static JSONArray asVendas;
	private CafeTipos cafeTipos = new CafeTipos();
	
	public Vendas(){
		init();
					
	}
	
	public void init(){
		JSONParser parser = new JSONParser();
		try {  
			Object obj = parser.parse(new FileReader("Database/BD_vendas.json"));  
			JSONObject jsonObject = (JSONObject) obj;  
			asVendas = (JSONArray) jsonObject.get("vendas");  
			vendas = new JSONObject[asVendas.size()];   
			Iterator<JSONObject> iterator = asVendas.iterator(); 
			int i = 0;
			   while (iterator.hasNext()) {  
				   vendas[i] = (JSONObject)iterator.next();
				   i++;
			   }
		}
		 catch (Exception e) {  
			e.printStackTrace();  
		} 
	}
	
	public JSONObject[] getVendas(){ 
		return vendas;
	}
	
	public void registrarVenda(int tipo_cafe, double valor, double valor_pago, double troco){
		JSONObject venda = new JSONObject();
		venda.put("id", ""+vendas.length);
		venda.put("tipo_cafe", ""+tipo_cafe);
		venda.put("valor", ""+valor);
		venda.put("valor_pago", ""+valor_pago);
		venda.put("troco", ""+troco);
		venda.put("data_hora", ""+new Date().toString());
		asVendas.add(venda);
		JSONObject dbVendas = new JSONObject();
		dbVendas.put("vendas", asVendas);
		
		try {

			 FileWriter file = new FileWriter("database/BD_vendas.json");
			 file.write(dbVendas.toJSONString());
			 file.flush();
			 file.close();

			 } catch (IOException e) {
			 e.printStackTrace();
			 }
	}

	public String relatorio(){
		String rel = "Relatório de vendas\n\n";
		for (int i = 0; i< vendas.length ; i++ ){
			String valor = (String)vendas[i].get("valor");
			String valorPago = (String)vendas[i].get("valor_pago");
			String troco = (String)vendas[i].get("troco");
			int tipoCafe = Integer.parseInt((String)vendas[i].get("tipo_cafe"));
			String produto = (String)cafeTipos.get(tipoCafe).get("nome");
			String idVenda = (String)vendas[i].get("id");
			rel+="Cod: "+idVenda+"\nProduto: café "+produto+"\nvalor: R$ "+valor+"\nvalor pago: R$ "+valorPago+"\ntroco: R$ "+troco+"\ndata/hora: "+(String)vendas[i].get("data_hora")+"\n\n";	
		}
		return rel;
	}
}

