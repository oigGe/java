import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		long bin1, bin2;
		int rest = 0;
		int i = 0;
		int sum[] = new int[20];
		Scanner in = new Scanner(System.in);

		System.out.println("input binary 1: ");
		bin1 = in.nextLong();

		System.out.println("input binary 2: ");
		bin2 = in.nextLong();

		while (bin1 != 0 || bin2 != 0) {

			sum[i++] = (int) ((bin1 % 10 + bin2 % 10 + rest) % 2);
			rest = (int) ((bin1 % 10 + bin2 % 10 + rest) / 2);
			bin1 = bin1 / 10;
			bin2 = bin2 / 10;
		}
		// System.out.println("zwischenschritt: " + bin1 +" " + bin2 + " " + rest + " "
		// + "i= "+ i );
		if (rest != 0) {
			sum[i++] = rest;
		}
		// System.out.println("i= " + i);
		// weil i++ immer erst in i schreibt und dann i hinterher um 1 erhoeht.
		--i;
		// System.out.println("i= " + i);
		while (i >= 0) {
			System.out.print(sum[i--]);
		}
	}

}
