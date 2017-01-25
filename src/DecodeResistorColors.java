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
    
    public static String encodeResistorColors(String ohmsString) {
    	String firstBand, secondBand, thirdBand;
    	int firstBand1, secondBand1, thirdBand1;
    	String ohmString = "";
    	
    	int i = 0;
    	int ohms;
    	 String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "gray", "white"};
    	 //black: 0, brown: 1, red: 2, orange: 3, yellow: 4, green: 5, blue: 6, violet: 7, gray: 8, white: 9
    	 
    	 Scanner sc1 = new Scanner(ohmsString);//scanner to read set the count to the number of words
    	 String[] colorsin = new String[2];//an array of the inputted number
    	 int[] numbers = new int[3];//an array of the numbers
    	 
    	 while (sc1.hasNext()) {
    		 colorsin[i] = sc1.next();
    		 i++;
    	 }
    	 
    	 String numString = colorsin[0].replaceAll("[^0-9.]", "");
    	 int num = Integer.parseInt(numString);
    	 
    	 if (colorsin[0].contains("k")) {
    		 
    		 
    		 int zeroes = 0;
    				 while(num%10 == 0 && num != 0) {
    				   zeroes++;
    				   num /= 10;
    				 }
    	    		 if (zeroes > 0) {
    	    			 thirdBand = colors[zeroes + 2];
    	        		 }
    	        		 else {
    	        			 thirdBand = colors[zeroes];
    	        		 }
    	    secondBand1 = num % 10;
    	    firstBand1 = (num - secondBand1) / 10;
    		firstBand = colors[firstBand1];
    		secondBand = colors[secondBand1];
    		
    		ohmString = firstBand + " " + secondBand + " " + thirdBand + " gold";
    	 }
    	 
    	 else if (colorsin[0].contains("M")) {
    		 
    		 int zeroes = 0;
    				 while(num%10 == 0 && num != 0) {
    				   zeroes++;
    				   num /= 10;
    				 }
    	    		 if (zeroes > 0) {
    	    			 thirdBand = colors[zeroes + 5];
    	        		 }
    	        		 else {
    	        			 thirdBand = colors[zeroes];
    	        		 }
    	    secondBand1 = num % 10;
    	    firstBand1 = (num - secondBand1) / 10;
			 firstBand = colors[firstBand1];
			 secondBand = colors[secondBand1];
    		
    		ohmString = firstBand + " " + secondBand + " " + thirdBand + " gold";
    	 }
    	 
    	 else {
    		 	int zeroes = 0;
    		 	while(num%10 == 0 && num != 0) {
    		 		zeroes++;
    		 		num /= 10;
    		 	}
    		 if (zeroes > 0) {
			 thirdBand = colors[zeroes - 1];
    		 }
    		 else {
    			 thirdBand = colors[zeroes];
    		 }
    		 secondBand1 = num % 10;
    		 firstBand1 = (num - secondBand1) / 10;
			 firstBand = colors[firstBand1];
			 secondBand = colors[secondBand1];
			 
			 ohmString = firstBand + " " + secondBand + " " + thirdBand + " gold";
	
    	 }
    	return ohmString;
     }
}
