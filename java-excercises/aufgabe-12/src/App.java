import java.util.Scanner;

public class App {
	public static void main(String[] args) {
//		Scanner num = new Scanner(System.in);
//		System.out.println("Enter number 1: ");
//		double num1 = num.nextDouble();
//
//		System.out.println("Enter number 2: ");
//		double num2 = num.nextDouble();
//
//		System.out.println("Enter number 3: ");
//		double num3 = num.nextDouble();
//		// double result = (num1 + num2 + num3)/3;
//
//		System.out.println((num1 + num2 + num3) / 3);

		
		double num = 0;
		int x = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("input the quantity of numbers (n) you want to calculate the average of: ");
		int n = sc.nextInt();
		while (x <= n) {
			System.out.println("Input number" + "(" + x + ")" + ":");
			num += sc.nextInt();
			x += 1;
		}
		double avgn = (num / n);
		System.out.println("Average: " + avgn);
		
		
	}
}
