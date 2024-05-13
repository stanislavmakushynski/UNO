package main;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class Log {
	
	private static final String PATH = "log.txt";
	public static Formatter output;
	
	public static void writeConsole(String message) {
		System.out.println(message);
	}
	
	public static void write(String message) {
		if(output == null) {
			try {
				output = new Formatter(PATH);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		output.format("[%s] %s\n", java.time.LocalDateTime.now().toLocalTime().toString().substring(0, 8), message);
	}
	
	public static void close() {
		output.close();
	}
}
