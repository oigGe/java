
public class Application {
	public static void main(String[] args) {
		// int myInt = 40;
		// if (myInt < 10) {
		//
		// System.out.println("yes");
		// } else if (myInt < 20) {
		// System.out.println("no");
		//
		// } else {
		// System.out.println("none of the above");
		// }
		//

		// This colors the text green

		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_GREEN = "\u001B[32m";

		int loop = 0;
		boolean running = loop < 5;
		while (running = true) {
			System.out.println("looping...................." + loop);

			if (loop == 5) {

			} else if (loop >= 5) {
				System.out.println(ANSI_GREEN + "\n\n..........finished.........." + ANSI_RESET);
				break;
			}
			loop++;
			System.out.println("Running");

		}
	}

}
