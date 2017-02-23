//Imports here
import java.text.DecimalFormat;
import java.util.Scanner;

//Method to decode resistors
public class DecodeResistorColors {
    public static String decodeResistorColors(String bands) {
    	int firstBand, secondBand, thirdBand; //declare each of the bands which will be used
    	String tolerance, ohmString; //declare a string which will be manipulated and returned
    	int i = 0; //initalize i for the scanner
    	double ohms; // intialize a double for the ohms
    	 String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "gray", "white"}; //an array of the colors
    	 //black: 0, brown: 1, red: 2, orange: 3, yellow: 4, green: 5, blue: 6, violet: 7, gray: 8, white: 9
    	 DecimalFormat df = new DecimalFormat("###.#"); //A decimal format object which we will use to format a result later
    	 
    	 Scanner sc = new Scanner(bands);//scanner to read set the count to the number of words inputted into function
    	 String[] colorsin = new String[4];//an array of the inputted colors
    	 int[] numbers = new int[3];//an array of the numbers
    	 
    	 while (sc.hasNext()) { //while loop for while there is a next word in the bands input
    		 colorsin[i] = sc.next(); //write these colors that are read into the array of colorsin
    		 i++; //go to the next element of colorsin
    	 }//end the while loop
    	 
    	 for (int j = 0; j < 3; j++)//for loop initiated to check for the first 3 bands
    		 for (int n = 0; n < colors.length; n++) { //loop to check each of the colors
    			 if (colorsin[j].equalsIgnoreCase(colors[n])) {//if the colorin at j matches any color in the colors array
    				 numbers[j] = n;//write the number value of the matched color into an array
    			 }//end colors for loop
    		 }//end first 3 entries for loop
    	 
    	 firstBand = numbers[0] * 10;//the value of the first band = the first number * 10 (I.E 4 would be 40)
    	 
	 //the values of the second and third band would just simply be the number inputted
	 secondBand = numbers[1];
    	 thirdBand = numbers[2];
    	 
    	 if (colorsin[3] == null) { //if the 4th band is empty 
    		 tolerance = "20%"; //the value defaults to 20%
    	 }
         
    	 else if (colorsin[3].equals("gold")) { //if the 4th band is gold
    		 tolerance = "5%"; //the value is defined as 5%
    	 }
    	 else if (colorsin[3].equals("silver")) { //if the 4th band is silver
    		 tolerance = "10%"; //the value is define as 5%
    	 }
    	 else { //else to handle if the band was not defined as either
    		 tolerance = "Undefined input";
    	 }
    	 ohms = (firstBand + secondBand) * Math.pow(10, thirdBand); //Apply the calculation onto the bands
    	 
    	 //Handles if the ohm value is greater than a thousand
	  if (ohms > 999 && ohms < 1000000) {
    		 double value = ohms / 1000;
    		 ohmString = df.format(value) + "k ohms";//applys decimal format
    	 }
	    
	 //Handles if the ohm value is greater than a million
    	 else if (ohms > 999999) {
    		 double value = ohms / 1000000;
    		 ohmString = df.format(value) + "M ohms";//applys decimal format
    	 }
	 
	 //Handles if the ohm value is less than a thousand
    	 else {
    		 ohmString = df.format(ohms) + " ohms";//applys decimal format
    	 }
    	 
    	 return ohmString + ", " + tolerance; //Return the string of the ohm 
    }//ends decode method
    
//Method to encode resistors
    public static String encodeResistorColors(String ohmsString) {
    	
	//declares the bands in both String and integer format  
	String firstBand, secondBand, thirdBand;
    	int firstBand1, secondBand1, thirdBand1;
    	
	//Initiates an empty String which we will write into
	String ohmString = "";
    	
    	int i = 0;//Same value and loop for writing these values into an array
	    
    	String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "gray", "white"};
    	 //black: 0, brown: 1, red: 2, orange: 3, yellow: 4, green: 5, blue: 6, violet: 7, gray: 8, white: 9
    	 
    	 Scanner sc1 = new Scanner(ohmsString);//scanner to read set the count to the number of words
    	 String[] colorsin = new String[2];//an array of the inputted number
    	 
	 //same loop as the encoder method
    	 while (sc1.hasNext()) {
    		 colorsin[i] = sc1.next();
    		 i++;
    	 }
    	 
	 
    	 String numString = colorsin[0].replaceAll("[^0-9]", "");//Regex to replace all the non numeric characters
    	 int num = Integer.parseInt(numString);//Parses the regex applied string for the remainin integers
    	 int length = (int)(Math.log10(num)+1);//Declares the length of the parsed integer
    	 
    	 if (colorsin[0].contains("k")) {//if the inputted value is a thousands
    		 length += 1;//since it is a thousand we will increase the length
    		 
    		 if (colorsin[0].contains(".")) {//reduce the length for the left over periods
    			 length--;
    		 }
    		 
    		 if (num < 9) {//if the number is of length one we multiply it
    			 num = num * 10;
    		 }
    		 
    		 
    	    thirdBand = colors[length]; //the third band is just defined as the length of the integer (the power)
    	    secondBand1 = num % 10; //the second band is just the parsed value mod 10
    	    firstBand1 = (num - secondBand1) / 10; //and the third value is just the parsed intreger minues the second band divided by ten
    	    
            if (firstBand1 > 9) { //handles if the length if only 1 integer
        	    secondBand1 = firstBand1 % 10;
        	    firstBand1 = (firstBand1 - secondBand1) / 10;
    	    }
    		
		//SHOULD CREATE AND APPLY RECURSION METHOD HERE
		firstBand = colors[firstBand1];
    		secondBand = colors[secondBand1];
    		
    		ohmString = firstBand + " " + secondBand + " " + thirdBand + " gold"; //Defines the final ohm string which will be returned on this case
    	 }
    	 
    	 else if (colorsin[0].contains("M")) { //repeats the code for if the input is in millions (M)
    		length += 4;//The length is greater because its a million length
    		
		 //Repeats code for thousands
   		 if (colorsin[0].contains(".")) {
			 length--;
		 }
   		 
    		 if (num < 9) {
    			 num = num * 10;
    		 }
		 
    	    thirdBand = colors[length];
    	    secondBand1 = num % 10;
    	    firstBand1 = (num - secondBand1) / 10;
    	    if (firstBand1 > 9) {
        	    secondBand1 = firstBand1 % 10;
        	    firstBand1 = (firstBand1 - secondBand1) / 10;
    	    }
			firstBand = colors[firstBand1];
			secondBand = colors[secondBand1];
    		
    		ohmString = firstBand + " " + secondBand + " " + thirdBand + " gold";//Defines the string which will be returned
    	 }
    	 
    	 
    	 
    	 else { //Handles for normal numbers below a thousand.
    		 length -= 2;//Subtracts 2 from the length
    		 
    		 
    		 thirdBand = colors[length];
    		 secondBand1 = num % 10;
    		 firstBand1 = (num - secondBand1) / 10;
     	    if (firstBand1 > 9) {
        	    secondBand1 = firstBand1 % 10;
        	    firstBand1 = (firstBand1 - secondBand1) / 10;
    	    }
			 firstBand = colors[firstBand1];
			 secondBand = colors[secondBand1];
			 
			 ohmString = firstBand + " " + secondBand + " " + thirdBand + " gold";//Defines the string which will be returned
	
    	 }
    	return ohmString;
     }
}
