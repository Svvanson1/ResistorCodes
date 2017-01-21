import java.text.DecimalFormat;
import java.util.Scanner;

public class DecodeResistorColors {
    public static String decodeResistorColors(String bands) {
    	int firstBand, secondBand, thirdBand;
    	String tolerance, ohmString;
    	int i = 0;
    	double ohms;
    	 String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "gray", "white"};
    	 //black: 0, brown: 1, red: 2, orange: 3, yellow: 4, green: 5, blue: 6, violet: 7, gray: 8, white: 9
    	 DecimalFormat df = new DecimalFormat("###.#");
    	 
    	 Scanner sc = new Scanner(bands);//scanner to read set the count to the number of words
    	 String[] colorsin = new String[4];//an array of the inputted colors
    	 int[] numbers = new int[3];//an array of the numbers
    	 
    	 while (sc.hasNext()) {
    		 colorsin[i] = sc.next();
    		 i++;
    	 }
    	 
    	 for (int j = 0; j < 3; j++)
    		 for (int n = 0; n < colors.length; n++) { //loop to check each of the colors
    			 if (colorsin[j].equalsIgnoreCase(colors[n])) {
    				 numbers[j] = n;
    			 }
    		 }
    	 
    	 firstBand = numbers[0] * 10;
    	 secondBand = numbers[1];
    	 thirdBand = numbers[2];
    	 
    	 if (colorsin[3] == null) {
    		 tolerance = "20%";
    	 }
         
    	 else if (colorsin[3].equals("gold")) {
    		 tolerance = "5%";
    	 }
    	 else if (colorsin[3].equals("silver")) {
    		 tolerance = "10%";
    	 }
    	 else {
    		 tolerance = "not working";
    	 }
    	 ohms = (firstBand + secondBand) * Math.pow(10, thirdBand);
    	 
    	 if (ohms > 999 && ohms < 1000000) {
    		 double value = ohms / 1000;
    		 ohmString = df.format(value) + "k ohms";
    	 }
    	 else if (ohms > 999999) {
    		 double value = ohms / 1000000;
    		 ohmString = df.format(value) + "M ohms";
    	 }
    	 else {
    		 ohmString = df.format(ohms) + " ohms";
    	 }
    	 
    	 return ohmString + ", " + tolerance;
    }
}