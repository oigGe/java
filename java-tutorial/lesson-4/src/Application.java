
public class Application {
	public static void main(String[] args) {
		int value = 1;

		while (value >= 0) {

			System.out.println(value + "lala " + value + value + value);

			value = (value + 1) ^ 2;
		}

	}
}
