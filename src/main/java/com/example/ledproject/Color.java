package com.example.ledproject;

public class Color {

    /*Instantiate variables to define colors.
    Colors will consist of RGB values or Hex Values.
    These are essentially the same, we could get away with just using RGB,
    but passing colors to other things will be much easier if we can easily switch between
    hex and rgb.
     */
    public int Red;
    public int Green;
    public int Blue;
    public String Hex;


    /**
     * The constructor for our color will initialize the RGB value to (0,0,0) and the Hex value to #000000.
     * All colors will start out as black.
     */
      public Color(){

          Red = 0;
          Green = 0;
          Blue = 0;
          Hex = "#000000";
      }

    /**
     * Takes an integer value between 0 and 255 and returns a hex value between 00 and ff as a string.
     * @param val - integer value to be made into hex.
     * @return returnString - a string consisting of two hex digits.
     */
    private String toHex(int val){
        //Instantiate the return string as a string.
        String returnString;
        //Check if the value is below 15 - this means we need to add another redundant digit to our return string.
        if(val <= 15){
            //If the value is in fact less than 15, add the redundant digit first then add the hex value of the int.
            returnString = Integer.toHexString(0) + Integer.toHexString(val);
        }
        else{
            //Otherwise just return the hex value of the string.
            returnString = Integer.toHexString(val);
        }
        //return the string
        return returnString;
    }

    /**
     * Takes a two digit hex value as an array of chars and returns a corresponding integer value.
     * @param hexVal - Character array representing a hex value.
     * @return decValue - a decimal value representing a hex value.
     */
    private int fromHex(char[] hexVal) throws IllegalArgumentException{
        /*Check if the length of the array is the proper size.
        or if the array is not formatted properly.
        If these checks fail throw an IllegalArgumentException.
         */
        if((hexVal.length != 2) || hexVal[0] == '#'){
            throw new IllegalArgumentException();
        }

        //Instantiate a temporary variable for multiplying.
        //Initialize a number variable at 0.
        int temp;
        int num =0;
        //Check if the first digit is a char. If it is, temp will equal the corresponding value.
            if(hexVal[0] =='a'){temp = 10;}
            else if (hexVal[0] == 'b') {temp = 11;}
            else if (hexVal[0] == 'c') {temp = 12;}
            else if (hexVal[0] == 'd') {temp = 13;}
            else if (hexVal[0] == 'e') {temp = 14;}
            else if (hexVal[0] == 'f') {temp = 15;}
            else {
                //Otherwise temp will be equal to the numeric value.
                temp = Character.getNumericValue(hexVal[0]);;
            }
        //Check if the second digit is a char. If it is, num will equal the corresponding value.
        if(hexVal[1] =='a'){num = 10;}
            else if (hexVal[1] == 'b') {num = 11;}
            else if (hexVal[1] == 'c') {num = 12;}
            else if (hexVal[1] == 'd') {num = 13;}
            else if (hexVal[1] == 'e') {num = 14;}
            else if (hexVal[1] == 'f') {num = 15;}
            else {
                num = Character.getNumericValue(hexVal[1]);;
            }
        //Otherwise num will be equal to the numeric value.
        /*
        Convert hex to decimal by multiplying the first digit by 16 (temp).
        Then add that value to the second digit (num).
         */
        int decValue = temp*16 + num;
        //return the result.
        return decValue;
    }

    /**
     * Changes an RGB value to Hex Values.
     */
    public void RGBtoHex(){
        //Initialize 3 new strings to the hex values of their corresponding color values.
       String hexRed = toHex(Red);
       String hexGreen = toHex(Green);
       String hexBlue = toHex(Blue);
       //Set the Hex value to a pound sign plus the three strings in the order red green blue.
       Hex = "#" +hexRed + hexGreen + hexBlue;
    }

    /**
     * Changes a Hex value to an RGB value.
     */
    public void hexToRGB(){
        //Initializes an array of characters from the hex string.
       char[] hexChars = Hex.toCharArray();
       //Instantiates a size 2 char array for temp use.
       char[] temp = new char[2];

       //Gets Blue digits of the string and puts them in the array.
       temp[0] = hexChars[2];
       temp[1] = hexChars[1];
       //Assigns the red value to the proper decimal value.
       Red = fromHex(temp);

        //Gets Green digits of the string and puts them in the array.
       temp[0] = hexChars[4];
       temp[1] = hexChars[3];
        //Assigns the Green value to the proper decimal value.
        Green = fromHex(temp);

        //Gets Blue digits of the string and puts them in the array.
       temp[0] = hexChars[6];
       temp[1] = hexChars[5];
        //Assigns the Blue value to the proper decimal value.
        Blue = fromHex(temp);
    }

    /**
     * Sets the color, both RGB and Hex, for the color at a given Hex Value.
     * @param hexVal - Desired hex value to set color to.
     */
    public void setColor(String hexVal){
        //Checks if hex value is formatted properly.
        if ((hexVal.charAt(0) != '#')){
            //if it isn't reformat it.
            String temp ="#" + hexVal;
            hexVal = temp;
        }
        //Otherwise, set the Hex of the color to hexVal and run hexToRGB() to set RGB to proper values.
          Hex = hexVal;
          hexToRGB();

    }

    /**
     * Sets color, both hex and rgb, from three separate rgb color values.
     * @param red - Red RGB value to be set.
     * @param green - Green RGB value to be set.
     * @param blue - Blue RGB value to be set.
     */
    public void setColor(int red, int green, int blue){
        //sets Red, Green, and Blue to desired color.
          Red = red;
          Green = green;
          Blue = blue;
          //sets hex value to that same color.
          RGBtoHex();
    }

    /**
     * Prints the Red, Green, Blue, and Hex value for a given color.
     */
    public void printColors(){
          System.out.println("Red Value: " + Red + ".");
          System.out.println("Green Value: " + Green + ".");
          System.out.println("Blue Value: " + Blue + ".");
          System.out.println("Hex Value: " + Hex + ".");
    }

    /**
     * Getter method for Red Value.
     * @return Red value.
     */
    public int getRed(){
        return this.Red;
    }

    /**
     * Getter method for Green Value.
     * @return Green Value
     */
    public int getGreen(){
        return this.Green;
    }

    /**
     * Getter method for Blue Value.
     * @return Blue Value.
     */
    public int getBlue(){
        return this.Blue;
    }

    /**
     * Getter method for Hex Value.
     * @return Hex Value
     */
    public String getHex(){
        return this.Hex;
    }


    public static void main(String[] args){

        String separateBig = "======================================================================================\n" +
                             "======================================================================================";
        String separateSmall = "------------------------------------------------------------------------------------\n";

        System.out.println(separateBig);
        System.out.println("New Colors:");
          Color c1 = new Color();
          Color c2 = new Color();
          Color c3 = new Color();
          Color c4 = new Color();
        System.out.println("c1");
        System.out.println("c2");
        System.out.println("c3");
        System.out.println("c4");
        System.out.println(separateBig);

        System.out.println("Printing New colors...");
        System.out.println("c1 " + separateSmall);
        c1.printColors();
        System.out.println("c2 " + separateSmall);
        c2.printColors();
        System.out.println("c3 " + separateSmall);
        c3.printColors();
        System.out.println("c4 " + separateSmall);
        c4.printColors();

        System.out.println(separateBig);

          String hex1 = "#34A562";
          String hex2 = "#233F66";
          String hex3 = "#512366";
          String hex4 = "#C83E68";

          c1.setColor(hex1);
          c2.setColor(hex2);
          c3.setColor(hex3);
          c4.setColor(hex4);
          System.out.println("Setting color of c1 to " + hex1 +".");
          System.out.println("Setting color of c2 to " + hex2 +".");
          System.out.println("Setting color of c3 to " + hex3 +".");
          System.out.println("Setting color of c4 to " + hex4 +".");
        System.out.println("Printing colors...");
        System.out.println("c1 " + separateSmall);
        c1.printColors();
        System.out.println("c2 " + separateSmall);
        c2.printColors();
        System.out.println("c3 " + separateSmall);
        c3.printColors();
        System.out.println("c4 " + separateSmall);
        c4.printColors();
        System.out.println(separateBig);

        System.out.println("Setting color of c1 to " + "RGB(255,0,0)" +".");
        System.out.println("Setting color of c2 to " + "RGB(0,255,0)" +".");
        System.out.println("Setting color of c3 to " + "RGB(0,0,255)" +".");
        System.out.println("Setting color of c4 to " + "RGB(255,231,20)" +".");
            c1.setColor(255,0,0);
            c2.setColor(0,255,0);
            c3.setColor(0,0,255);
            c4.setColor(255,231,20);

        System.out.println("Printing colors...");
        System.out.println("c1 " + separateSmall);
        c1.printColors();
        System.out.println("c2 " + separateSmall);
        c2.printColors();
        System.out.println("c3 " + separateSmall);
        c3.printColors();
        System.out.println("c4 " + separateSmall);
        c4.printColors();
        System.out.println(separateBig);

        System.out.println("Done.");
        System.out.println(separateBig);
    }


}
