import java.util.Scanner;

public class App {
	public static void main(String[] args) {

	
	Scanner sc = new Scanner(System.in);
	System.out.println("Input width: ");
	double width = sc.nextDouble();

	System.out.println("Input height: ");
	double height = sc.nextDouble();
	
	double perimeter = 2*(width + height);
	double area = width*height;
	
	System.out.println("Area is: " + width + " * " + height + " = " + area + "\nPerimeter is: " + "2 x (" + width + " + " + height + ")" + " = " + perimeter );
	}
}
