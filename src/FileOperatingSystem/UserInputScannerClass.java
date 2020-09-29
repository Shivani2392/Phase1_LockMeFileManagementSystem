package FileOperatingSystem;

import java.util.Scanner;

public class UserInputScannerClass {
	
	public static String askuserforinput() {
		Scanner scanner=new Scanner(System.in);
	    String  input=scanner.nextLine();
		return input;
	}

}
