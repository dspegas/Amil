package br.com.amil.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.amil.analisador.Analisador;
import br.com.amil.util.Constants;

public class ExpressaoRegularTest {

	@Test
	public void testStart() {
		Analisador analisador = new Analisador();
		String partida = analisador.retornaPartida("23/04/2013 15:34:22 - New match 11348965 has started", Constants.START);
		assertEquals(partida, "11348965");
	}
	
	@Test
	public void testEnd() {
		Analisador analisador = new Analisador();
		String partida = analisador.retornaPartida("23/04/2013 15:39:22 - Match 11348965 has ended", Constants.END);
		assertEquals(partida, "11348965");
	}
	
	@Test
	public void testKilled() {
		Analisador analisador = new Analisador();
		String jogador = analisador.retornaJogador("23/04/2013 15:36:04 - Roman killed Nick using M16", Constants.KILLED);
		assertEquals(jogador, "Nick");
	}

}
