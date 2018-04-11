import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		long bin1,bin2;
		int product[] = new int[20];
		int i = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Intput first binary: ");
		bin1 = in.nextLong();

		System.out.println("Intput second binary: ");
		bin2 = in.nextLong();
		
		
		
		while ( bin1 != 0 || bin2 !=0) {
			product[i++] = ((int)((bin1 % 10) * (bin2 % 10)));
			bin1 = bin1 /10;
			bin2 = bin2 / 10;
			
		}
//		--i;
		while(i>=0) {
			System.out.print(product[i--]);
		}
		
		
		
	}
}
