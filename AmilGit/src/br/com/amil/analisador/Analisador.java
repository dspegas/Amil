package br.com.amil.analisador;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.amil.dao.LogDao;
import br.com.amil.dao.impl.LogDaoImpl;
import br.com.amil.entidade.Relatorio;
import br.com.amil.util.Constants;

public class Analisador {
	
	HashMap<String, Relatorio> partida = new HashMap<String, Relatorio>();
	
	String partidaIniciada = "";
	
	public HashMap<String, Relatorio> analisaLog (StringBuilder log)
	{
				
		// varre todas as linhas do log
		Scanner scan = new Scanner(log.toString()); 
		while (scan.hasNextLine() ){
		 String oneLine = scan.nextLine();
		 analisaLinha(oneLine);
		}
		
		return partida;
	}
	
	private void analisaLinha(String linha)
	{
		// vrifica inicio de partida
		if (retornaPartida(linha,Constants.START) != null)
		{
			partidaIniciada = retornaPartida(linha,Constants.START);
			partida.put(partidaIniciada, new Relatorio());
		}
		
		// verifica assassinato
		if (retornaJogador(linha,Constants.KILLED) != null && !linha.contains(Constants.World))
		{
			String jogador = retornaJogador(linha,Constants.KILLED);
			Relatorio rel = partida.get(partidaIniciada);
			if (rel.getMortes().containsKey(jogador))
			{
				int mortes = rel.getMortes().get(jogador);
				rel.getMortes().put(jogador, mortes+1);
			}
			else
			{
				rel.getMortes().put(jogador, 1);
			}
			
			rel.setQtdeAssasinatos(rel.getQtdeAssasinatos()+1);
			
			partida.put(partidaIniciada, rel);
		}
		
		// verifica fim de partida
		if (retornaPartida(linha,Constants.END) != null)
		{
			partidaIniciada = "";
		}
		
		
	}
	
	// metodo que retorna a partida de acordo com o pattern
	public String retornaPartida(String texto, Pattern pattern) {
		Matcher matcher = pattern.matcher(texto);
		if (matcher.matches() && matcher.groupCount() == 1) {
			return matcher.group(1);
		} else {
			return null;
		}
	}
	
	// metodo que retorna o jogador de acordo com o pattern
	public String retornaJogador(String texto, Pattern pattern) {
		Matcher matcher = pattern.matcher(texto);
		if (matcher.matches() && matcher.groupCount() == 2) {
			return matcher.group(2);
		} else {
			return null;
		}
	}

}
