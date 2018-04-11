
public class App {
	public static void main(String[] args) {

		int bin1 = 11110;
		int bin2 = 10101;
		int factor = 1;
		int result = 1;
		int digit;

		while (bin2 != 0) {

			digit = bin1 % 10;

			if (digit == 1) {
				bin1 = bin1 * factor;
				// result = bin1 * factor + result;
				result = binaryproduct((int) bin1, (int) result);

			} else {
				bin1 = bin1 * factor;
			}

			factor = 10;
			bin2 = bin2 / 10;
		}
		System.out.println(result);
	}

	static int binaryproduct(int bin1, int bin2) {

		int sum[] = new int[20];
		int i = 0, rest = 0;
		int resultBinPro = 0;

		while (bin1 != 0 || bin2 != 0) {
			sum[i++] = ((bin1 % 10) + (bin2 % 10) + rest) % 2;
			rest = ((bin1 % 10) + (bin2 % 10) + rest) / 2;
			bin1 = bin1 /10;
			bin2 = bin2/10;
		}

		if (rest != 0) {
			sum[i++] = rest;
		}

		--i;

		while (i >= 0) {
			resultBinPro = (resultBinPro * 10 + sum[i--]);
		}

		return resultBinPro;

	}

}
