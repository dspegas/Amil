package br.com.amil.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.amil.dao.LogDao;
import br.com.amil.dao.impl.LogDaoImpl;

public class ArquivoTest {

		
	@Test
	public void testLeitura() {
		LogDao dao = new LogDaoImpl();
		StringBuilder st = dao.load("C:\\Users\\Daniel\\Desktop\\exemplo.txt");
		boolean n = false;
		if (st == null) n= true;
		assertEquals(n, false);
	}
	
}
