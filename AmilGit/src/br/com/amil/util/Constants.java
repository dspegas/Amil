package br.com.amil.util;

import java.util.regex.Pattern;

public class Constants {
	
	public static final Pattern START = Pattern.compile(".*New match ([0-9\\-]+) has started.*");
	
	public static final Pattern END = Pattern.compile(".*Match ([0-9\\-]+) has ended.*");
	
	public static final Pattern KILLED = Pattern.compile(".* - ([a-zA-Z0-9\\-]+) killed ([a-zA-Z0-9\\-]+).*");
	
	public static final String World = "<WORLD>";
	

}
