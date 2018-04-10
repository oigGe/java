import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = in.nextInt();
		for(double i=10000000000000000.00; i>=0; i = i - 1000) {
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" + num + " x " + i + " = " + (num * i) + ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			
		}
		
	}

}
