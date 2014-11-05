package br.com.amil.service;

import br.com.amil.analisador.Analisador;
import br.com.amil.dao.LogDao;
import br.com.amil.dao.impl.LogDaoImpl;

public class LogService {

	LogDao dao = new LogDaoImpl();
	
	public void logService(String file)
	{
		Analisador analisador = new Analisador();
		dao.print(analisador.analisaLog(dao.load(file)));
	}
	
	
}
