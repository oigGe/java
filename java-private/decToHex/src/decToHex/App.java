package decToHex;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		// dec is input value
		int dec = 0;
		int a, numSys;
		String transNum = "";
		boolean stop = false;
		Scanner in = new Scanner(System.in);

		String numSystem[] = { "Binary", "Ternary", "Quarternary", "Quinary", "Senary", "Septenary", "Octal", "Nonary",
				"Decimal", "Undecimal", "Duodecimal", "Tridecimal", "Tetradecimal", "Pentadecimal", "Hecadecimal",
				"Heptadecimal", "Octadecimal", "Nonadecimal", "Vigesimal" };

		char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q' };
		while(!stop) {
		System.out.println("Which decimal NUMBER do you want to transform?: ");
		dec = in.nextInt();

		System.out.println("And to which BASE?");
		numSys = in.nextInt();

		a = dec;

		while (a > 0) {
			int mod = a % numSys;
			transNum = hex[mod] + transNum;
			a = a / numSys;
		}
		System.out.println(numSystem[numSys - 2] + " number is: " + transNum);
//		clear transNum for the next loop
		transNum = "";
		
		System.out.println("Would you like to continue? (y/n)");
	    String s = in.next();
	    if(s.equals("n")) {
	        stop = true;
	    }

		
		}
	}

}

// String numSystem[] = {
// 'Binary','Ternary','Quarternary','Quinary','Senary','Septenary','Octal','Nonary','Decimal','Undecimal','Duodecimal','Tridecimal','Tetradecimal','Pentadecimal','Hecadecimal','Heptadecimal','Octadecimal','Nonadecimal','Vigesimal'};

// a = a/numSys;
// int aMod = a%numSys;
//
//// a = 48 aMod = 7
//
// System.out.println(a + " " + aMod);
//
// int bMod = a%numSys;
// a = a/numSys;
//
//// b = 3 bMod = 0
//
// System.out.println(a + " " + bMod);
//
// int cMod = a%numSys;
// a = a/numSys;
//
//// c = 0 ---> stop, cMod = 3;
//
// System.out.println(a + " " + cMod);
//
// System.out.println(dec + " in num = " + cMod + "." + bMod + "." + aMod +
// ".");