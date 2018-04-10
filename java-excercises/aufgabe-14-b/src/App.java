public class App {
	public static void main(String[] args) {

		String string1 = "* * * * * * ============================================ ";
		String string2 = " * * * * *  ============================================ ";
		String string3 = "======================================================== ";

		for (int i = 0; i < 15; i++) {

			if (i < 9) {

				if (i != 0 & i % 2 == 0) {
					System.out.println(string1);
				}

				else {
					System.out.println(string2);
				}

			} else {
				System.out.println(string3);
			}
		}

	}
}
