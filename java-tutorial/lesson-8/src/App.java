import java.util.Scanner;

public class App {
	// public static void main(String[] args) {
	// boolean notRightNumber;
	//
	// while (notRightNumber = true) {
	// Scanner input = new Scanner(System.in);
	// System.out.println("Enter Number 5: ");
	// int number = input.nextInt();
	// if(number == 5) {
	// System.out.println("Hello");
	// notRightNumber = false;
	// break;
	//
	//
	// }
	// else {
	// System.out.println("You entered: '" + number + "' Please enter 5." );
	// notRightNumber = true;
	//
	// }
	//
	//
	// }
	//
	// }
	//
	// }
	public static void main(String[] args) {
		int value = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter a number");
			value = scanner.nextInt();
		} while (value != 5);

		System.out.println("Got 5!");

	}

}