import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeResistorColors h = new DecodeResistorColors();
		boolean keepGoing = true;
		//System.out.println(h.decodeResistorColors("brown black black"));
		System.out.println("The basic resistor color codes are: black: 0, brown: 1, red: 2, orange: 3, yellow: 4, green: 5, blue: 6, violet: 7, gray: 8, white: 9");
		System.out.println("Each resistor will have at least three bands, with the first and second bands indicating the first two digits of the ohms value, and the third indicating the power of ten to multiply them by, for example a resistor with the three bands 'yellow violet black' would be 47 * 10^0 ohms, or 47 ohms.");
		System.out.println("Most resistors will also have a fourth band that is either gold or silver, with gold indicating plus or minus 5% tolerance, and silver indicating 10% tolerance. Resistors that do not have a fourth band are rated at 20% tolerance. NOTE: Encoding only works with gold band resistors");
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to 'Encode' or 'Decode', please type your answer or type 'exit'");
		System.out.println("NOTE: This program will only handle resistors less than 999Million Ohms");
		String inputString = input.next();
		
		while (keepGoing) {
		if (inputString.equalsIgnoreCase("encode")) {
			Scanner input1 = new Scanner(System.in);
			System.out.println("Enter encode string:");
			String inputString1 = input1.next();
			System.out.println(h.encodeResistorColors(inputString1));
		}
		if (inputString.equalsIgnoreCase("decode")) {
			Scanner input2 = new Scanner(System.in);
			System.out.println("Enter decode string:");
			String inputString2 = input2.next();
			System.out.println(h.decodeResistorColors(inputString2));
		}
		if (inputString.equalsIgnoreCase("exit")) {
			keepGoing = false;
			break;
		}
		else {
			System.out.println("Invalid Entry");
			}
		}
	}
}
