import java.util.Scanner;

public class Calc {
	public static void main(String[] args) {
		
Scanner input = new Scanner(System.in);
		
		
		System.out.println("Input first number: ");
		long number1 = input.nextLong();
		
		System.out.println("Input second number: ");
		long number2 = input.nextLong();
		
		
		
		
		System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
		System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
		System.out.println(number1 + " x " + number2 + " = " + (number1 * number2));
		System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
		System.out.println(number1 + " mod " + number2 + " = " + (number1 % number2));
		
	}

}
