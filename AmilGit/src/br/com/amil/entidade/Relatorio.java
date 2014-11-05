package br.com.amil.entidade;

import java.util.HashMap;

public class Relatorio {
	
	// quantidade de assassinatos na partida
	private int qtdeAssasinatos;
	
	// hash de jogador e suas mortes na partida
	private HashMap<String, Integer> mortes = new HashMap<String, Integer>();
	
	public int getQtdeAssasinatos() {
		return qtdeAssasinatos;
	}

	public void setQtdeAssasinatos(int qtdeAssasinatos) {
		this.qtdeAssasinatos = qtdeAssasinatos;
	}

	public HashMap<String, Integer> getMortes() {
		return mortes;
	}

	public void setMortes(HashMap<String, Integer> mortes) {
		this.mortes = mortes;
	}

}
