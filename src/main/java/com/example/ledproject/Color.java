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
            if(hexVal[0] =='a' || hexVal[0] == 'F'){temp = 10;}
            else if (hexVal[0] == 'b' || hexVal[0] == 'B' ) {temp = 11;}
            else if (hexVal[0] == 'c' || hexVal[0] == 'C') {temp = 12;}
            else if (hexVal[0] == 'd' || hexVal[0] == 'D') {temp = 13;}
            else if (hexVal[0] == 'e' || hexVal[0] == 'E') {temp = 14;}
            else if (hexVal[0] == 'f' || hexVal[0] == 'F') {temp = 15;}
            else {
                //Otherwise temp will be equal to the numeric value.
                temp = Character.getNumericValue(hexVal[0]);;
            }
        //Check if the second digit is a char. If it is, num will equal the corresponding value.
        if(hexVal[1] =='a' || hexVal[1] == 'A'){num = 10;}
            else if (hexVal[1] == 'b' || hexVal[1] == 'B') {num = 11;}
            else if (hexVal[1] == 'c' || hexVal[1] == 'C') {num = 12;}
            else if (hexVal[1] == 'd' || hexVal[1] == 'D') {num = 13;}
            else if (hexVal[1] == 'e' || hexVal[1] == 'E') {num = 14;}
            else if (hexVal[1] == 'f' || hexVal[1] == 'F') {num = 15;}
            else {
                num = Character.getNumericValue(hexVal[1]);;
            }
        //Otherwise num will be equal to the numeric value.
        /*
        Convert hex to decimal by multiplying the first digit by 16 (temp).
        Then add that value to the second digit (num).
         */

        int decValue = (temp*16) + num;

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
       char[] hexChars = Hex.toLowerCase().toCharArray();
       //Instantiates a size 2 char array for temp use.
       char[] temp = new char[2];

       //Gets Blue digits of the string and puts them in the array.
       temp[0] = hexChars[1];
       temp[1] = hexChars[2];
       //Assigns the red value to the proper decimal value.
       Red = fromHex(temp);

        //Gets Green digits of the string and puts them in the array.
       temp[0] = hexChars[3];
       temp[1] = hexChars[4];
        //Assigns the Green value to the proper decimal value.
        Green = fromHex(temp);

        //Gets Blue digits of the string and puts them in the array.
       temp[0] = hexChars[5];
       temp[1] = hexChars[6];
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
          Hex = hexVal.toLowerCase();
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
          System.out.println("Printing...");
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


    /**
     * Changes Red value of a color by some integer n.
     * @param n - The integer value to change red by.
     */
    public void addRedBy(int n){
        //Checks if the integer value is larger than what a color will allow or less than 0.
        //If either of these are true, throws an IllegalArgumentException.
        if(n > 255 || n < 0) {throw new IllegalArgumentException();}
        //Checks if adding n to Red will be more than a Color can handle.
        //If it is, throws an IndexOutofBoundsException.
        if(Red + n > 255) {throw new IndexOutOfBoundsException();}
        //Adds n to Red.
        Red += n;
        //Sets Hex Value.
        RGBtoHex();

    }

    /**
     * Changes Green value of a color by some integer n.
     * @param n - The integer value to change Green by.
     */
    public void addGreenBy(int n){
        //Checks if the integer value is larger than what a color will allow or less than 0.
        //If either of these are true, throws an IllegalArgumentException.
        if(n > 255 || n < 0) {throw new IllegalArgumentException();}
        //Checks if adding n to Green will be more than a Color can handle.
        //If it is, throws an IndexOutofBoundsException.
        if(Green + n > 255) {throw new IndexOutOfBoundsException();}
        //Adds n to Green.
        Green += n;
        //Sets Hex Value.
        RGBtoHex();

    }

    /**
     * Changes Blue value of a color by some integer n.
     * @param n- The integer value to change Blue by.
     */
    public void addBlueBy(int n){
        //Checks if the integer value is larger than what a color will allow or less than 0.
        //If either of these are true, throws an IllegalArgumentException.
        if(n > 255 || n < 0) {throw new IllegalArgumentException();}
        //Checks if adding n to Blue will be more than a Color can handle.
        //If it is, throws an IndexOutofBoundsException.
        if(Blue + n > 255) {throw new IndexOutOfBoundsException();}
        //Adds n to Blue.
        Blue += n;
        //Sets Hex Value.
        RGBtoHex();


    }

    /**
     * Changes Color by some Value n - additive.
     * @param n - integer value that changes color.
     */
    public void addColorBy(int n){
        //Runs add methods with parameter n.
        addRedBy(n);
        addGreenBy(n);
        addBlueBy(n);
    }

    /**
     * Adds some Red, Green, and Blue values to a Color.
     * @param r - Red Integer Value.
     * @param g - Green Integer Value.
     * @param b - Blue Integer Value.
     */
    public void addColorBy(int r, int g, int b){
        addRedBy(r);
        addGreenBy(g);
        addBlueBy(b);

    }

    /**
     * Changes Red value of a color by some integer n.
     * @param n- The integer value to change Red by.
     */
    public void subtractRedBy(int n){
        if (n > 255 || n < 0){throw new IllegalArgumentException();}
        //Checks if the integer value is larger than what a color will allow or less than 0.
        //If either of these are true, throws an IllegalArgumentException.
        if(Red - n < 0) {throw new IndexOutOfBoundsException();}
        //Checks if adding n to Red will be more than a Color can handle.
        //If it is, throws an IndexOutofBoundsException.
        //Subtracts n from Red.
        Red -=n;
        RGBtoHex();
    }
    /**
     * Changes Green value of a color by some integer n.
     * @param n- The integer value to change Green by.
     */
    public void subtractGreenBy(int n){
        if (n > 255 || n < 0){throw new IllegalArgumentException();}
        //Checks if the integer value is larger than what a color will allow or less than 0.
        //If either of these are true, throws an IllegalArgumentException.
        if(Green - n < 0) {throw new IndexOutOfBoundsException();}
        //Checks if adding n to Green will be more than a Color can handle.
        //If it is, throws an IndexOutofBoundsException.
        //Subtracts n from Green.
        Green -=n;
        RGBtoHex();
    }
    /**
     * Changes Blue value of a color by some integer n.
     * @param n- The integer value to change Blue by.
     */
    public void subtractBlueBy(int n){
        if (n > 255 || n < 0){throw new IllegalArgumentException();}
        //Checks if the integer value is larger than what a color will allow or less than 0.
        //If either of these are true, throws an IllegalArgumentException.
        if(Blue - n < 0) {throw new IndexOutOfBoundsException();}
        //Checks if adding n to Green will be more than a Color can handle.
        //If it is, throws an IndexOutofBoundsException.
        //Subtracts n from Blue.
        Blue -=n;
        RGBtoHex();
    }

    /**
     * Changes a Color by n - Subtracting.
     * @param n - integer value to subtract.
     */
    public void subtractColorBy(int n){
        subtractRedBy(n);
        subtractGreenBy(n);
        subtractBlueBy(n);
    }
    /**
     * Subtracts some Red, Green, and Blue values to a Color.
     * @param r - Red Integer Value.
     * @param g - Green Integer Value.
     * @param b - Blue Integer Value.
     */
    public void subtractColorBy(int r, int g, int b){
        subtractBlueBy(b);
        subtractGreenBy(g);
        subtractRedBy(r);
    }

    /**
     * Changes Red value of a color by factor n.
     * @param n- The integer value to change Red by.
     */
    public void multiplyRedBy(int n){
        if (n > 255 || n < 0){throw new IllegalArgumentException();}
        //Checks if the integer value is larger than what a color will allow or less than 0.
        //If either of these are true, throws an IllegalArgumentException.
        if(Red * n > 255) {throw new IndexOutOfBoundsException();}
        //Checks if adding n to Red will be more than a Color can handle.
        //If it is, throws an IndexOutofBoundsException.
        //Multiplies Red by n.
        Red *=n;
        RGBtoHex();
    }
    /**
     * Changes Green value of a color by factor n.
     * @param n- The integer value to change Green by.
     */
    public void multiplyGreenBy(int n){
        if (n > 255 || n < 0){throw new IllegalArgumentException();}
        //Checks if the integer value is larger than what a color will allow or less than 0.
        //If either of these are true, throws an IllegalArgumentException.
        if(Green * n > 255) {throw new IndexOutOfBoundsException();}
        //Checks if adding n to Green will be more than a Color can handle.
        //If it is, throws an IndexOutofBoundsException.
        //Multiplies Green by n.
        Green *=n;
        RGBtoHex();
    }
    /**
     * Changes Blue value of a color by factor n.
     * @param n- The integer value to change Blue by.
     */
    public void multiplyBlueBy(int n){
        if (n > 255 || n < 0){throw new IllegalArgumentException();}
        //Checks if the integer value is larger than what a color will allow or less than 0.
        //If either of these are true, throws an IllegalArgumentException.
        if(Blue * n > 255) {throw new IndexOutOfBoundsException();}
        //Checks if adding n to Green will be more than a Color can handle.
        //If it is, throws an IndexOutofBoundsException.
        //Multiplies Blue by n.
        Blue *=n;
        RGBtoHex();
    }

    /**
     * Changes a Color by n - Multiplicitive.
     * @param n - integer value to multiply.
     */
    public void multiplyColorBy(int n){
        multiplyRedBy(n);
        multiplyGreenBy(n);
        multiplyBlueBy(n);
    }
    /**
     * Multiplies some Red, Green, and Blue values to a Color.
     * @param r - Red Integer Value.
     * @param g - Green Integer Value.
     * @param b - Blue Integer Value.
     */
    public void multiplyColorBy(int r, int g, int b){
        multiplyBlueBy(b);
        multiplyGreenBy(g);
        multiplyRedBy(r);
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
          System.out.println("c1" + separateSmall);
          c1.printColors();
        System.out.println("c2" + separateSmall);
          c2.printColors();
        System.out.println("c3" + separateSmall);
          c3.printColors();
        System.out.println("c4" + separateSmall);
          c4.printColors();
        System.out.println(separateBig);
        c1.setColor("#aabbcc");
        c3.setColor("#ffffff");
        c4.setColor("#affb4c");
        System.out.println("c1" + separateSmall);
        c1.printColors();
        System.out.println("c2" + separateSmall);
        c2.printColors();
        System.out.println("c3" + separateSmall);
        c3.printColors();
        System.out.println("c4" + separateSmall);
        c4.printColors();
        System.out.println(separateBig);
        c1.addRedBy(10);
        c1.addGreenBy(1);
        c1.addBlueBy(20);
        c2.addRedBy(45);
        c2.addGreenBy(1);
        c2.addBlueBy(10);
        c4.addRedBy(1);
        c4.addGreenBy(1);
        c4.addBlueBy(50);
        System.out.println("c1" + separateSmall);
        c1.printColors();
        System.out.println("c2" + separateSmall);
        c2.printColors();
        System.out.println("c4" + separateSmall);
        c4.printColors();
        System.out.println(separateBig);

        c1.subtractRedBy(10);
        c1.subtractGreenBy(1);
        c1.subtractBlueBy(20);
        c2.subtractColorBy(45,1,10);
        c3.subtractColorBy(255);

        System.out.println("c1" + separateSmall);
        c1.printColors();
        System.out.println("c2" + separateSmall);
        c2.printColors();
        System.out.println("c3" + separateSmall);
        c3.printColors();
        System.out.println("c4" + separateSmall);
        c4.printColors();
        System.out.println(separateBig);


        c2.addColorBy(20);
        c2.multiplyColorBy(2);
        System.out.println("c2" + separateSmall);
        c2.printColors();
        c2.multiplyColorBy(2,3,1);
        System.out.println("c2" + separateSmall);
        c2.printColors();

        System.out.println(separateBig);
        System.out.println("Done.");
        System.out.println(separateBig);
    }


}
