import java.util.Scanner;

public class Application {
	public static void main(String[] args) {

		//// Create scanner object
		// Scanner input = new Scanner(System.in);
		//
		//// Output prompt
		// System.out.println("Enter Password: ");
		//
		//// Wait for the user to enter Password
		// String line = input.nextLine();
		//
		//// Tell them what they entered
		// if(line == "1234") {
		// System.out.println("Password Correct");
		// }
		// else {
		// System.out.println("You enteres: " + line +"\n Password is incorrect" );
		//
		//
		// }
		//
		//
		// }
		// }
		Scanner input = new Scanner(System.in);
		// int Code = 1234;
		String Password = "hallo";
		
		System.out.println("Enter Name: ");
		String name = input.nextLine();

		boolean noValidInput = true;
		while (noValidInput = true) {
			System.out.println("Enter Password: ");

			String line = input.nextLine();
			noValidInput = false;
			if (line.equals(Password)) {
				for(int i = 0; i < 100; i++) {
					System.out.printf(".");
				}
				System.out.println("\n Password is correct");
				System.out.println("Herzlich Willkommen " + name);
				break;
			} else {
				System.out.println("Password '" + line + "' is incorrect. Please try again. ");
				noValidInput = true;

			}
		}

	}
}