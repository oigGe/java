import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Pleas enter a Command: ");
		String text = input.nextLine();

		switch (text) {
		case "start":
			System.out.println("Machine started");
			break;
		case "stop":
			System.out.println("Machine stopped");
			break;

		default:
			System.out.println("W0T????");
		}
		
		
	}
}
