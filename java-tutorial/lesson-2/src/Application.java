
public class Application {

	public static void main(String[] args) {
		int myNumber;
		boolean myBoolean;
		
		myNumber = 88;
		myBoolean = true;

		long myLong = 8989898;
		float myFloat = 22.33f;
		myLong = myLong - 1;
		char myChar = 'z';
		byte myByte = 14;


		System.out.println(" My Number: " + myNumber);
		System.out.println(" My Long: " + myLong);

		myLong = myLong + 999999;

		System.out.println(" My new Long: " + myLong);
		System.out.println(" My Float: " + myFloat);
		System.out.println(" My Char: " + myChar);
		System.out.println(" My Bool: " + myBoolean);
		System.out.println(" My Bite: " + myByte);
	}

}