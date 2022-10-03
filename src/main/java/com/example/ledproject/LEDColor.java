package com.example.ledproject;

public class LEDColor {

    /*Instantiate variables to define colors.
    Colors will consist of RGB values or Hex Values.
    These are essentially the same, we could get away with just using RGB,
    but passing colors to other things will be much easier if we can easily switch between
    hex and rgb.
     */
    public short Red;
    public short Green;
    public short Blue;
    public String Hex;


    /**
     * The constructor for our color will initialize the RGB value to (0,0,0) and the Hex value to #000000.
     * All colors will start out as black.
     */
      public LEDColor(){

          Red = 0;
          Green = 0;
          Blue = 0;
          Hex = "#000000";
      }

    /**
     * Takes a short value between 0 and 255 and returns a hex value between 00 and ff as a string.
     * @param val - short value to be made into hex.
     * @return returnString - a string consisting of two hex digits.
     */
    private String toHex(short val){
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
     * Takes a two digit hex value as an array of chars and returns a corresponding short value.
     * @param hexVal - Character array representing a hex value.
     * @return decValue - a decimal value representing a hex value.
     */
    private short fromHex(char[] hexVal) throws IllegalArgumentException{
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

        short decValue = (short)((temp*16) + num);

        //return the result.
        return decValue;
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
    public short getRed(){
        return this.Red;
    }
    /**
     * Getter method for Green Value.
     * @return Green Value
     */
    public short getGreen(){
        return this.Green;
    }
    /**
     * Getter method for Blue Value.
     * @return Blue Value.
     */
    public short getBlue(){
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
     * sets Red value to a short n.
     * @param n - value to set Red to.
     */
    public void setRed(short n){
        if(n>255 || n <0){throw new IllegalArgumentException();}
        Red = n;
        RGBtoHex();

    }
    /**
     * setRed for int type values.
     * @param n - integer
     */
    public void setRed(int n){
        short m = (short)n;
        setRed(m);
    }
    /**
     * setRed for long type values.
     * @param n - long value
     */
    public void setRed(long n){
        short m = (short)n;
        setRed(m);
    }
    /**
     * setRed for double type values.
     * @param n - double value
     */
    public void setRed(double n){
        short m = (short)n;
        setRed(m);
    }
    /**
     * setRed for float type values.
     * @param n - integer
     */
    public void setRed(float n){
        short m = (short)n;
        setRed(m);
    }
    /**
     * setRed for 2 digit hex values.
     * @param hex - 2 digit hex value.
     */
    public void setRed(String hex){
        if(hex.length() != 2 || hex.charAt(0) =='#'){ throw new IllegalArgumentException();}
        char [] hexArray = hex.toCharArray();
        short decVal = (short)fromHex(hexArray);
        setRed(decVal);
    }
    /**
     * sets Red value to a short n.
     * @param n - value to set Green to.
     */
    public void setGreen(short n){
        if(n>255 || n <0){throw new IllegalArgumentException();}
        Green = n;
        RGBtoHex();

    }
    /**
     * setGreen for int type values.
     * @param n - integer
     */
    public void setGreen(int n){
        short m = (short)n;
        setGreen(m);
    }
    /**
     * setGreen for long type values.
     * @param n - long value
     */
    public void setGreen(long n){
        short m = (short)n;
        setGreen(m);
    }
    /**
     * setGreen for double type values.
     * @param n - double value
     */
    public void setGreen(double n){
        short m = (short)n;
        setGreen(m);
    }
    /**
     * setGreen for float type values.
     * @param n - integer
     */
    public void setGreen(float n){
        short m = (short)n;
        setGreen(m);
    }
    /**
     * setGreen for 2 digit hex values.
     * @param hex - 2 digit hex value.
     */
    public void setGreen(String hex){
        if(hex.length() != 2 || hex.charAt(0) =='#'){ throw new IllegalArgumentException();}
        char [] hexArray = hex.toCharArray();
        short decVal = (short)fromHex(hexArray);
        setGreen(decVal);
    }
    /**
     * sets Red value to a short n.
     * @param n - value to set Blue to.
     */
    public void setBlue(short n){
        if(n>255 || n <0){throw new IllegalArgumentException();}
        Blue = n;
        RGBtoHex();
    }
    /**
     * setBlue for int type values.
     * @param n - integer
     */
    public void setBlue(int n){
        short m = (short)n;
        setBlue(m);
    }
    /**
     * setBlue for long type values.
     * @param n - long value
     */
    public void setBlue(long n){
        short m = (short)n;
        setBlue(m);
    }
    /**
     * setBlue for double type values.
     * @param n - double value
     */
    public void setBlue(double n){
        short m = (short)n;
        setBlue(m);
    }
    /**
     * setBlue for float type values.
     * @param n - integer
     */
    public void setBlue(float n){
        short m = (short)n;
        setBlue(m);
    }
    /**
     * setBlue for 2 digit hex values.
     * @param hex - 2 digit hex value.
     */
    public void setBlue(String hex){
        if(hex.length() != 2 || hex.charAt(0) =='#'){ throw new IllegalArgumentException();}
        char [] hexArray = hex.toCharArray();
        short decVal = (short)fromHex(hexArray);
        setBlue(decVal);
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
        short tempVal;
        //Initializes an array of characters from the hex string.
        char[] hexChars = Hex.toLowerCase().toCharArray();
        //Instantiates a size 2 char array for temp use.
        char[] temp = new char[2];

        //Gets Blue digits of the string and puts them in the array.
        temp[0] = hexChars[1];
        temp[1] = hexChars[2];
        tempVal = fromHex(temp);
        //Assigns the red value to the proper decimal value.
        setRed(tempVal);

        //Gets Green digits of the string and puts them in the array.
        temp[0] = hexChars[3];
        temp[1] = hexChars[4];
        //Assigns the Green value to the proper decimal value.
        tempVal = fromHex(temp);
        setGreen(tempVal);

        //Gets Blue digits of the string and puts them in the array.
        temp[0] = hexChars[5];
        temp[1] = hexChars[6];
        //Assigns the Blue value to the proper decimal value.
        tempVal = fromHex(temp);
        setBlue(tempVal);
    }
    /**
     * Sets color, both hex and rgb, from three separate rgb color values.
     * @param red - Red RGB value to be set.
     * @param green - Green RGB value to be set.
     * @param blue - Blue RGB value to be set.
     */
    public void setColor(short red, short green, short blue){
        //sets Red, Green, and Blue to desired color.
        setRed(red);
        setGreen(green);
        setBlue(blue);
        //sets hex value to that same color.
        RGBtoHex();
    }
    /**
     * Private helper method for checking format of hex String.
     * @param hexVal - String to be checked.
     * @return - True if properly formatted, false otherwise.
     */
    private boolean isFormattedProperly(String hexVal){
        boolean isProper = true;
        hexVal = hexVal.toLowerCase();
        if (hexVal.length() != 7){
            isProper = false;
        }
        if(hexVal.charAt(0) != '#'){
            isProper = false;
        }
        else if (hexVal.charAt(0) == '0' && hexVal.charAt(1) == 'x' || (hexVal.charAt(0) == '0' && hexVal.charAt(1) == '#')){
            isProper = false;
        }
        return isProper;
    }
    /**
     * Private helper method to reformat hex String.
     * @param hexVal - String to be reformatted.
     */
    private void reformatHex(String hexVal){
        if(!isFormattedProperly(hexVal)) {
            hexVal = hexVal.toLowerCase();

            if(hexVal.charAt(1) == 'x' ||hexVal.charAt(1) == '#'){
            String temp = "#" + Integer.toString(hexVal.charAt(2)) + Integer.toString(hexVal.charAt(3))
                    +  Integer.toString(hexVal.charAt(4)) + Integer.toString(hexVal.charAt(5)) +
                    Integer.toString(hexVal.charAt(6)) + Integer.toString(hexVal.charAt(7));

            }
            if (hexVal.charAt(0) != '#') {
                //if it isn't reformat it.
                String temp = "#" + hexVal;
                hexVal = temp;
            }
        }
        hexVal = hexVal.toLowerCase();

        }
    /**
     * Sets the color, both RGB and Hex, for the color at a given Hex Value.
     * @param hexVal - Desired hex value to set color to.
     */
    public void setColor(String hexVal){
        hexVal = hexVal.toLowerCase();
        //Checks if hex value is formatted properly.
        if(!isFormattedProperly(hexVal)){
            reformatHex(hexVal);
        }
        //Otherwise, set the Hex of the color to hexVal and run hexToRGB() to set RGB to proper values.
        Hex = hexVal.toLowerCase();
        hexToRGB();

    }
    /**
     * Adds Red value to by a short n.
     * If the value is less than 0 it subtracts from Red.
     * If the sum is greater than 255 it overflows to 0.
     * @param n - amount added.
     */
    public void addRed(short n){
        if(n + Red > 255){
            setRed((n % 255));
        } else if (n < 0) {
            if(Red - n*-1 < 0) {
                setRed((n*-1) % 255);
            }
            else{setRed(Red - (n * (-1)));}
        } else {setRed(Red + n);}
    }
    /**
     * addRed for Int Types.
     * @param n - integer to add.
     */
    public void addRed(int n){
        short m = (short)n;
        addRed(m);
    }
    /**
     * addRed for Double Types.
     * @param n - number to add.
     */
    public void addRed(double n){
        short m = (short)n;
        addRed(m);
    }
    /**
     * addRed for Float Types.
     * @param n - number to add.
     */
    public void addRed(float n){
        short m = (short)n;
        addRed(m);
    }
    /**
     * addRed for long Types.
     * @param n - number to add.
     */
    public void addRed(long n){
        short m = (short)n;
        addRed(m);
    }
    /**
     * addRed for hex.
     * @param hexVal - hex to add.
     */
    public void addRed(String hexVal){
        short decVal = fromHex(hexVal.toCharArray());
        addRed(decVal);
    }
    /**
     * Adds Green value to by a short n.
     * If the value is less than 0 it subtracts from Red.
     * If the sum is greater than 255 it overflows to 0.
     * @param n - amount added.
     */
    public void addGreen(short n){
        if(n + Green > 255){
            setGreen((n % 255));
        } else if (n < 0) {
            if(Green - n*-1 < 0) {
                setGreen((n*-1) % 255);
            }
            else{setGreen(Green - (n * (-1)));}
        } else {setGreen(Green + n);}
    }
    /**
     * addGreen for Int Types.
     * @param n - integer to add.
     */
    public void addGreen(int n){
        short m = (short)n;
        addGreen(m);
    }
    /**
     * addGreen for Double Types.
     * @param n - number to add.
     */
    public void addGreen(double n){
        short m = (short)n;
        addGreen(m);
    }
    /**
     * addGreen for Float Types.
     * @param n - number to add.
     */
    public void addGreen(float n){
        short m = (short)n;
        addGreen(m);
    }
    /**
     * addGreen for long Types.
     * @param n - number to add.
     */
    public void addGreen(long n){
        short m = (short)n;
        addGreen(m);
    }
    /**
     * addGreen for hex.
     * @param hexVal - hex to add.
     */
    public void addGreen(String hexVal){
        short decVal = fromHex(hexVal.toCharArray());
        addGreen(decVal);
    }
    /**
     * Adds Blue value to by a short n.
     * If the value is less than 0 it subtracts from Red.
     * If the sum is greater than 255 it overflows to 0.
     * @param n - amount added.
     */
    public void addBlue(short n){
        if(n + Blue > 255){
            setBlue((n % 255));
        } else if (n < 0) {
            if(Blue - n*-1 < 0) {
                setBlue((n*-1) % 255);
            }
            else{setBlue(Blue - (n * (-1)));}
        } else {setBlue(Blue + n);}
    }
    /**
     * addBlue for Int Types.
     * @param n - integer to add.
     */
    public void addBlue(int n){
        short m = (short)n;
        addBlue(m);
    }
    /**
     * addBlue for Double Types.
     * @param n - number to add.
     */
    public void addBlue(double n){
        short m = (short)n;
        addBlue(m);
    }
    /**
     * addBlue for Float Types.
     * @param n - number to add.
     */
    public void addBlue(float n){
        short m = (short)n;
        addBlue(m);
    }
    /**
     * addBlue for long Types.
     * @param n - number to add.
     */
    public void addBlue(long n){
        short m = (short)n;
        addBlue(m);
    }
    /**
     * addBlue for hex.
     * @param hexVal - hex to add.
     */
    public void addBlue(String hexVal){
        short decVal = fromHex(hexVal.toCharArray());
        addBlue(decVal);
    }
    /**
     * Subtracts a short number from Red.
     * @param n - short to be subtracted
     */
    public void subtractRed(short n){
        addRed(n*-1);
    }
    /**
     * subtractRed for integers.
     * @param n - number to be subtracted
     */
    public void subtractRed(int n){
        short m = (short)n;
        addRed(m*-1);
    }
    /**
     * subtractRed for longs.
     * @param n - number to be subtracted
     */
    public void subtractRed(long n){
        short m = (short)n;
        addRed(m*-1);
    }
    /**
     * subtractRed for doubles.
     * @param n - number to be subtracted
     */
    public void subtractRed(double n){
        short m = (short)n;
        addRed(m*-1);
    }
    /**
     * subtractRed for floats.
     * @param n - number to be subtracted
     */
    public void subtractRed(float n){
        short m = (short)n;
        addRed(m*-1);
    }
    /**
     * subtractRed for hexString.
     * @param hexString - hexString to be subtracted
     */
    public void subtractRed(String hexString){
        short decVal = fromHex(hexString.toCharArray());
        addRed(decVal * -1);
    }
    /**
     * Subtracts a short number from Green.
     * @param n - short to be subtracted
     */
    public void subtractGreen(short n){
        addGreen(n*-1);
    }
    /**
     * subtractGreen for integers.
     * @param n - number to be subtracted
     */
    public void subtractGreen(int n){
        short m = (short)n;
        addGreen(m*-1);
    }
    /**
     * subtractGreen for longs.
     * @param n - number to be subtracted
     */
    public void subtractGreen(long n){
        short m = (short)n;
        addGreen(m*-1);
    }
    /**
     * subtractGreen for doubles.
     * @param n - number to be subtracted
     */
    public void subtractGreen(double n){
        short m = (short)n;
        addGreen(m*-1);
    }
    /**
     * subtractGreen for floats.
     * @param n - number to be subtracted
     */
    public void subtractGreen(float n){
        short m = (short)n;
        addGreen(m*-1);
    }
    /**
     * subtractGreen for hexString.
     * @param hexString - hexString to be subtracted
     */
    public void subtractGreen(String hexString){
        short decVal = fromHex(hexString.toCharArray());
        addGreen(decVal * -1);
    }
    /**
     * Subtracts a short number from Blue.
     * @param n - short to be subtracted
     */
    public void subtractBlue(short n){
        addBlue(n*-1);
    }
    /**
     * subtractBlue for integers.
     * @param n - number to be subtracted
     */
    public void subtractBlue(int n){
        short m = (short)n;
        addBlue(m*-1);
    }
    /**
     * subtractBlue for longs.
     * @param n - number to be subtracted
     */
    public void subtractBlue(long n){
        short m = (short)n;
        addBlue(m*-1);
    }
    /**
     * subtractBlue for doubles.
     * @param n - number to be subtracted
     */
    public void subtractBlue(double n){
        short m = (short)n;
        addBlue(m*-1);
    }
    /**
     * subtractBlue for floats.
     * @param n - number to be subtracted
     */
    public void subtractBlue(float n){
        short m = (short)n;
        addBlue(m*-1);
    }
    /**
     * subtractBlue for hexString.
     * @param hexString - hexString to be subtracted
     */
    public void subtractBlue(String hexString){
        short decVal = fromHex(hexString.toCharArray());
        addBlue(decVal * -1);
    }
    /**
     * multiplies Red by some double value.
     * @param n - amount to be multiplied by.
     */
    public void multiplyRed(double n){
        double num = (double)Red * n;
        if(num < 0){

            num *= -1;
        }
        if (num > 255){
            num = (num) % 255;
        }
        setRed((short)num);
    }
    /**
     * multiplyRed for float values.
     * @param n - amount to be multiplied by.
     */
    public void multiplyRed(float n){
        float num = (float)Red * n;
        if(num < 0){

            num *= -1;
        }
        if (num > 255){
            num = (num) % 255;
        }
        setRed((short)num);
    }
    /**
     * multiplyRed for int values.
     * @param n - amount to be multiplied by.
     */
    public void multiplyRed(int n){
        double m = (double)n;
        multiplyRed(m);
    }
    /**
     * multiplyRed for long values.
     * @param n - amount to be multiplied by.
     */
    public void multiplyRed(long n){
        double m = (double)n;
        multiplyRed(m);
    }
    /**
     * multiplyRed for hex values.
     * @param hexValue - amount to be multiplied by.
     */
    public void multiplyRed(String hexValue){
        double decVal = fromHex(hexValue.toCharArray()); 
        multiplyRed(decVal);
    }
    /**
     * multiplies Green by some double value.
     * @param n - amount to be multiplied by.
     */
    public void multiplyGreen(double n){
        double num = (double)Green * n;
        if(num < 0){

            num *= -1;
        }
        if (num > 255){
            num = (num) % 255;
        }
        setGreen((short)num);
    }
    /**
     * multiplyGreen for float values.
     * @param n - amount to be multiplied by.
     */
    public void multiplyGreen(float n){
        float num = (float)Green * n;
        if(num < 0){

            num *= -1;
        }
        if (num > 255){
            num = (num) % 255;
        }
        setGreen((short)num);
    }

    /**
     * multiplyGreen for int values.
     * @param n - amount to be multiplied by.
     */
    public void multiplyGreen(int n){
        double m = (double)n;
        multiplyGreen(m);
    }

    /**
     * multiplyGreen for long values.
     * @param n - amount to be multiplied by.
     */
    public void multiplyGreen(long n){
        double m = (double)n;
        multiplyGreen(m);
    }

    /**
     * multiplyGreen for hex values.
     * @param hexValue - amount to be multiplied by.
     */
    public void multiplyGreen(String hexValue){
        double decVal = fromHex(hexValue.toCharArray());
        multiplyGreen(decVal);
    }
    /**
     * multiplies Blue by some double value.
     * @param n - amount to be multiplied by.
     */
    public void multiplyBlue(double n){
        double num = (double)Blue * n;
        if(num < 0){

            num *= -1;
        }
        if (num > 255){
            num = (num) % 255;
        }
        setBlue((short)num);
    }

    /**
     * multiplyBlue for float values.
     * @param n - amount to be multiplied by.
     */
    public void multiplyBlue(float n){
        float num = (float)Red * n;
        if(num < 0){

            num *= -1;
        }
        if (num > 255){
            num = (num) % 255;
        }
        setBlue((short)num);
    }

    /**
     * multiplyBlue for int values.
     * @param n - amount to be multiplied by.
     */
    public void multiplyBlue(int n){
        double m = (double)n;
        multiplyBlue(m);
    }

    /**
     * multiplyBlue for long values.
     * @param n - amount to be multiplied by.
     */
    public void multiplyBlue(long n){
        double m = (double)n;
        multiplyBlue(m);
    }

    /**
     * multiplyBlue for hex values.
     * @param hexValue - amount to be multiplied by.
     */
    public void multiplyBlue(String hexValue){
        double decVal = fromHex(hexValue.toCharArray());
        multiplyBlue(decVal);
    }

    /**
     * Adds n to Red, Green, and Blue values of color.
     * @param n num to be added.
     */
    public void addColor(short n){
        addRed(n);
        addGreen(n);
        addBlue(n);
    }
    /**
     * addColor for Integer Type.
     * @param n num to be added.
     */
    public void addColor(int n){
        addRed(n);
        addGreen(n);
        addBlue(n);
    }

    /**
     * addColor for Double Type.
     * @param n num to be added.
     */
    public void addColor(Double n){
        addRed(n);
        addGreen(n);
        addBlue(n);
    }

    /**
     * addColor for Float Type.
     * @param n num to be added.
     */
    public void addColor(float n){
        addRed(n);
        addGreen(n);
        addBlue(n);
    }

    /**
     * addColor for Long Type.
     * @param n num to be added.
     */
    public void addColor(long n){
        addRed(n);
        addGreen(n);
        addBlue(n);
    }


    /**
     * Adds Red, Green, Or Blue to Colors.
     * @param r - num of red to be added.
     * @param g - num of green to be added.
     * @param b - num of blue to be added.
     */
    public void addColor(short r, short g, short b){
        addRed(r);
        addGreen(g);
        addBlue(b);
    }

    /**
     * addColor(rgb) for Integer Type.
     * @param r - num of red to be added.
     * @param g - num of green to be added.
     * @param b - num of blue to be added.
     */
    public void addColor(int r, int g, int b){
        addRed(r);
        addGreen(g);
        addBlue(b);
    }

    /**
     * addColor(rgb) for Double Type.
     * @param r - num of red to be added.
     * @param g - num of green to be added.
     * @param b - num of blue to be added.
     */
    public void addColor(double r, double g, double b){
        addRed(r);
        addGreen(g);
        addBlue(b);
    }


    /**
     * addColor(rgb) for float Type.
     * @param r - num of red to be added.
     * @param g - num of green to be added.
     * @param b - num of blue to be added.
     */
    public void addColor(float r, float g, float b){
        addRed(r);
        addGreen(g);
        addBlue(b);
    }

    /**
     * addColor(rgb) for Long Type.
     * @param r - num of red to be added.
     * @param g - num of green to be added.
     * @param b - num of blue to be added.
     */
    public void addColor(long r, long g, long b){
        addRed(r);
        addGreen(g);
        addBlue(b);
    }

    /**
     * addColor for hexValue.
     * @param hexValue - Hex value to be added.
     */
    public void addColor(String hexValue){
        hexValue = hexValue.toLowerCase();
        if(!isFormattedProperly(hexValue)){
            reformatHex(hexValue);
        }
        char[] hexArray = hexValue.toCharArray();

        char[] temp = new char[2];
        temp[0] = hexArray[1];
        temp[1] = hexArray[2];
        addRed(fromHex(temp));
        temp[0] = hexArray[3];
        temp[1] = hexArray[4];
        addGreen(fromHex(temp));
        temp[0] = hexArray[5];
        temp[1] = hexArray[6];
        addBlue(fromHex(temp));

    }
    /**
     * subtracts a value from a color.
     * @param n - num to subtract.
     */
    public void subtractColor(short n){
        subtractRed(n);
        subtractGreen(n);
        subtractBlue(n);
    }
    /**
     * subtracts a value from a color.
     * @param n - num to subtract.
     */
    public void subtractColor(int n){
        subtractRed(n);
        subtractGreen(n);
        subtractBlue(n);
    }
    /**
     * subtracts a value from a color.
     * @param n - num to subtract.
     */
    public void subtractColor(long n){
        subtractRed(n);
        subtractGreen(n);
        subtractBlue(n);
    }
    /**
     * subtracts a value from a color.
     * @param n - num to subtract.
     */
    public void subtractColor(float n){
        subtractRed(n);
        subtractGreen(n);
        subtractBlue(n);
    }
    /**
     * subtracts a value from a color.
     * @param n - num to subtract.
     */
    public void subtractColor(double n){
        subtractRed(n);
        subtractGreen(n);
        subtractBlue(n);
    }

    /**
     * subtractColor for an RGB set.
     * @param r - red to be subtracted
     * @param g - green to be subtracted
     * @param b - blue to be subtracted
     */
    public void subtractColor(short r, short g, short b){
        subtractRed(r);
        subtractGreen(g);
        subtractBlue(b);
    }

    /**
     * subtractColor for an RGB set.
     * @param r - red to be subtracted
     * @param g - green to be subtracted
     * @param b - blue to be subtracted
     */
    public void subtractColor(int r, int g, int b){
        subtractRed(r);
        subtractGreen(g);
        subtractBlue(b);
    }
    /**
     * subtractColor for an RGB set.
     * @param r - red to be subtracted
     * @param g - green to be subtracted
     * @param b - blue to be subtracted
     */
    public void subtractColor(long r, long g, long b){
        subtractRed(r);
        subtractGreen(g);
        subtractBlue(b);
    }
    /**
     * subtractColor for an RGB set.
     * @param r - red to be subtracted
     * @param g - green to be subtracted
     * @param b - blue to be subtracted
     */
    public void subtractColor(float r, float g, float b){
        subtractRed(r);
        subtractGreen(g);
        subtractBlue(b);
    }
    /**
     * subtractColor for an RGB set.
     * @param r - red to be subtracted
     * @param g - green to be subtracted
     * @param b - blue to be subtracted
     */
    public void subtractColor(double r, double g, double b){
        subtractRed(r);
        subtractGreen(g);
        subtractBlue(b);
    }

    /**
     * subtracts a Hex value from a color.
     * @param hexValue
     */
    public void subtractColor(String hexValue){
        hexValue = hexValue.toLowerCase();
        if(!isFormattedProperly(hexValue)){
            reformatHex(hexValue);
        }
        char[] hexArray = hexValue.toCharArray();

        char[] temp = new char[2];
        temp[0] = hexArray[1];
        temp[1] = hexArray[2];
        subtractRed(fromHex(temp));
        temp[0] = hexArray[3];
        temp[1] = hexArray[4];
        subtractGreen(fromHex(temp));
        temp[0] = hexArray[5];
        temp[1] = hexArray[6];
        subtractBlue(fromHex(temp));

    }
    /**
     * Multiplies color by a factor of n.
     * @param n factor to be multiplied by.
     */
    public void multiplyColor(double n){
        multiplyRed(n);
        multiplyGreen(n);
        multiplyBlue(n);
    }
    /**
     * Multiplies color by a factor of n.
     * @param n factor to be multiplied by.
     */
    public void multiplyColor(float n){
        multiplyRed(n);
        multiplyGreen(n);
        multiplyBlue(n);
    }
    /**
     * Multiplies color by a factor of n.
     * @param n factor to be multiplied by.
     */
    public void multiplyColor(int n){
        multiplyRed(n);
        multiplyGreen(n);
        multiplyBlue(n);
    }
    /**
     * Multiplies color by a factor of n.
     * @param n factor to be multiplied by.
     */
    public void multiplyColor(long n){
        multiplyRed(n);
        multiplyGreen(n);
        multiplyBlue(n);
    }
    /**
     * Multiplies color by a factor of n.
     * @param n factor to be multiplied by.
     */
    public void multiplyColor(short n){
        multiplyRed(n);
        multiplyGreen(n);
        multiplyBlue(n);
    }

    /**
     * multiplyColor for rgb.
     * @param r - factor to multiply red by.
     * @param g - factor to multiply green by.
     * @param b - factor to multiply blue by
     */
    public void multiplyColor(float r, float g, float b){
        multiplyRed(r);
        multiplyGreen(g);
        multiplyBlue(b);
    }

    /**
     * multiplyColor for rgb.
     * @param r - factor to multiply red by.
     * @param g - factor to multiply green by.
     * @param b - factor to multiply blue by
     */
    public void multiplyColor(double r, double g, double b){
        multiplyRed(r);
        multiplyGreen(g);
        multiplyBlue(b);
    }
    /**
     * multiplyColor for rgb.
     * @param r - factor to multiply red by.
     * @param g - factor to multiply green by.
     * @param b - factor to multiply blue by
     */
    public void multiplyColor(short r, short g, short b){
        multiplyRed(r);
        multiplyGreen(g);
        multiplyBlue(b);
    }
    /**
     * multiplyColor for rgb.
     * @param r - factor to multiply red by.
     * @param g - factor to multiply green by.
     * @param b - factor to multiply blue by
     */
    public void multiplyColor(int r, int g, int b){
        multiplyRed(r);
        multiplyGreen(g);
        multiplyBlue(b);
    }
    /**
     * multiplyColor for rgb.
     * @param r - factor to multiply red by.
     * @param g - factor to multiply green by.
     * @param b - factor to multiply blue by
     */
    public void multiplyColor(long r, long g, long b){
        multiplyRed(r);
        multiplyGreen(g);
        multiplyBlue(b);
    }
    /**
     * multiplyColor for hexValue.
     * @param hexValue - Hex value to be added.
     */
    public void multiplyColor(String hexValue){
        hexValue = hexValue.toLowerCase();
        if(!isFormattedProperly(hexValue)){
            reformatHex(hexValue);
        }
        char[] hexArray = hexValue.toCharArray();

        char[] temp = new char[2];
        temp[0] = hexArray[1];
        temp[1] = hexArray[2];
        multiplyRed(fromHex(temp));
        temp[0] = hexArray[3];
        temp[1] = hexArray[4];
        multiplyGreen(fromHex(temp));
        temp[0] = hexArray[5];
        temp[1] = hexArray[6];
        multiplyBlue(fromHex(temp));

    }
}
