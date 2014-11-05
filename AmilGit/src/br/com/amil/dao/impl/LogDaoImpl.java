package br.com.amil.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.amil.dao.LogDao;
import br.com.amil.entidade.Relatorio;

public class LogDaoImpl implements LogDao {

	@Override
	public StringBuilder load(String file) {
		
		 //local do arquivo
        File arquivo = new File(file);
        StringBuilder conteudo = new StringBuilder();
        BufferedReader reader;
 
        try {
 
            reader = new BufferedReader(new FileReader(arquivo));
            String text;
 
            // repete enquanto existir linhas
            while ((text = reader.readLine()) != null) {
                conteudo.append(text).append(System.getProperty("line.separator"));
            }
 
            reader.close();
 
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Falha ao tentar ler arquivo! "+e.getMessage());
        }
        
        return conteudo;
	}

	// sys out do relatorio
	public void print(HashMap<String, Relatorio> saida)
	{
		for (Map.Entry<String,Relatorio> pair : saida.entrySet()) {
		    System.out.println("Partida :" + pair.getKey());
		    System.out.println("Assassinatos :" + pair.getValue().getQtdeAssasinatos());
		    
		    for (Map.Entry<String,Integer> jogadores : pair.getValue().getMortes().entrySet()) {
		    	System.out.println("Jogador :" + jogadores.getKey());
		    	System.out.println("No Mortes :" + jogadores.getValue());
		    	
		    }
   
		}
	}
}
