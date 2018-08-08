package br.com.senai.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesUtils {
	private static String baseDir = Paths.get(System.getProperty("user.dir")).getParent().toString();
	private static String baseWebInf = "/standalone/deployments/facebook-servlet.war/WEB-INF";
	public static Path webInfDir = Paths.get(baseDir.concat(baseWebInf));
	
}
