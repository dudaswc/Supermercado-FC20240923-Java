package ClassesAtualizadas;

import java.util.Scanner;

public class Console {
	    private static Scanner reader = new Scanner(System.in);

	    public static int readNumber(String message) {
	        System.out.print(message);
	        return Integer.parseInt(reader.next());
	    }

	    public static String readText(String message) {
	        System.out.print(message);
	        return reader.next();
	    }

	    public static int readNumber() {
	        return Integer.parseInt(reader.next());
	    }

	    public static String readText() {
	        return reader.next();
	    }
	}

