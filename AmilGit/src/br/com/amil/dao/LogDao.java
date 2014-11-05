package br.com.amil.dao;

import java.util.HashMap;

import br.com.amil.entidade.Relatorio;


public interface LogDao {
	
	public StringBuilder load(String file);
	
	public void print(HashMap<String, Relatorio> saida);

}
