import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		
		Scanner num = new Scanner(System.in);
		
		System.out.println("Please eneter radius: ");
		
		double r = num.nextDouble();
		
		double perimeter = 2 * Math.PI * r;
		
		double area = Math.PI * Math.pow(r, 2);

		System.out.println("Perimeter is: " + perimeter + "\nArfaewqhtdbea is: " + area);
	}

}
