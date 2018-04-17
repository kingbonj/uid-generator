//* UPC Generator
// This is my code to test
// Beware the kraken *//

import java.util.Scanner;
import java.security.SecureRandom;
import java.math.BigInteger;

public class MyClass {

    public static void main(String[] args) {
        Scanner myVar = new Scanner(System.in);

        System.out.print("Insert first name: ");
        String fn = myVar.nextLine();
        System.out.print("Insert last name: ");
        String ln = myVar.nextLine();
        System.out.print("Insert sex (M/F/O): ");
        String sx = myVar.nextLine();
        System.out.print("DOB (format: DDMMYYYY): ");
        String d = myVar.nextLine();

        //Format DOB

        System.out.println("DOB: " + d);


        // Display the input back to the user

        System.out.println(" ");
        System.out.println("------------------------------------------------------");
        System.out.println(" ");
        System.out.println("Data summary: ");
        System.out.println(" ");
        System.out.println("Name: " + fn + " " + ln);
        System.out.println("DOB: " + d);
        System.out.println("Sex: " + sx);

        //seed generation

        String key = fn + ln + d + sx;
        System.out.println(" ");

        //Random String generation
        SecureRandom random = new SecureRandom();
        String rstr = new BigInteger(130, random).toString(32);
        String rcode = rstr.substring(0, 5);

        //Password Generation
        SecureRandom random2 = new SecureRandom();
        String pw = new BigInteger(130, random2).toString(32);
        String pass = pw.substring(0, 10);

        //Converting seed to UID

        String Newstr = " ";

        try {

            Scanner in = new Scanner(System.in);
            for (int i = 0; i < key.length(); i++) {
                char ch = Character.toLowerCase(key.charAt(i));
                switch (ch) {
                    case 'a':
                        Newstr = Newstr + "G";
                        break;
                    case 'b':
                        Newstr = Newstr + "W";
                        break;
                    case 'c':
                        Newstr = Newstr + "L";
                        break;
                    case 'd':
                        Newstr = Newstr + "x";
                        break;
                    case 'e':
                        Newstr = Newstr + "4";
                        break;
                    case 'f':
                        Newstr = Newstr + "L";
                        break;
                    case 'g':
                        Newstr = Newstr + "J";
                        break;
                    case 'h':
                        Newstr = Newstr + "e";
                        break;
                    case 'i':
                        Newstr = Newstr + "m";
                        break;
                    case 'j':
                        Newstr = Newstr + "8";
                        break;
                    case 'k':
                        Newstr = Newstr + "u";
                        break;
                    case 'l':
                        Newstr = Newstr + "a";
                        break;
                    case 'm':
                        Newstr = Newstr + "o";
                        break;
                    case 'n':
                        Newstr = Newstr + "c";
                        break;
                    case 'o':
                        Newstr = Newstr + "v";
                        break;
                    case 'p':
                        Newstr = Newstr + "f";
                        break;
                    case 'q':
                        Newstr = Newstr + "p";
                        break;
                    case 'r':
                        Newstr = Newstr + "q";
                        break;
                    case 's':
                        Newstr = Newstr + "h";
                        break;
                    case 't':
                        Newstr = Newstr + "K";
                        break;
                    case 'u':
                        Newstr = Newstr + "k";
                        break;
                    case 'v':
                        Newstr = Newstr + "L";
                        break;
                    case 'w':
                        Newstr = Newstr + "3";
                        break;
                    case 'x':
                        Newstr = Newstr + "7";
                        break;
                    case 'y':
                        Newstr = Newstr + "6";
                        break;
                    case 'z':
                        Newstr = Newstr + "D";
                        break;
                    case ' ':
                        Newstr = Newstr + "1";
                        break;
                    case '.':
                        Newstr = Newstr + '3';
                        break;
                    case ',':
                        Newstr = Newstr + "1";
                        break;
                    case '(':
                        Newstr = Newstr + '4';
                        break;
                    case '\"':
                        Newstr = Newstr + '5';
                        break;
                    case ')':
                        Newstr = Newstr + "7";
                        break;
                    case '?':
                        Newstr = Newstr + "2";
                        break;
                    case '!':
                        Newstr = Newstr + "8";
                        break;
                    case '-':
                        Newstr = Newstr + "6";
                        break;
                    case '%':
                        Newstr = Newstr + "9";
                        break;
                    case '1':
                        Newstr = Newstr + "r";
                        break;
                    case '2':
                        Newstr = Newstr + "k";
                        break;
                    case '3':
                        Newstr = Newstr + "b";
                        break;
                    case '4':
                        Newstr = Newstr + "e";
                        break;
                    case '5':
                        Newstr = Newstr + "q";
                        break;
                    case '6':
                        Newstr = Newstr + "h";
                        break;
                    case '7':
                        Newstr = Newstr + "u";
                        break;
                    case '8':
                        Newstr = Newstr + "y";
                        break;
                    case '9':
                        Newstr = Newstr + "w";
                        break;
                    case '0':
                        Newstr = Newstr + "z";
                        break;
                    default:
                        Newstr = Newstr + "0";
                        break;
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }


        //Generating HEX from ASCII
        String ascii = Newstr;
        char[] ch = ascii.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : ch) {
            int i = (int) c;
            builder.append(Integer.toHexString(i).toUpperCase());
        }
        //removing alpha and numeric characters
        String num = (builder.toString().replaceAll("[^0-9]", ""));
        String alpha = (builder.toString().replaceAll("[^A-Z]", ""));
        System.out.println("------------------------------------------------------");
        System.out.println("Encryption process: ");
        System.out.println(" ");
        System.out.println("1. Unencrypted seed: " + key);
        System.out.println("2. Encrypted seed: " + Newstr);
        String UID = builder.toString();
        System.out.println("3. HEX conversion: " + UID);

        // display first four alpha
        String acode = alpha.substring(0, 5);
        System.out.println("4. Alpha character extraction: " + acode);

        //convert num to int
        String numeric = num.substring(0, 5);
        System.out.println("5. Numeric character extraction: " + numeric);

        //random string recall

        System.out.println("6. Random String generation: " + rcode);
        System.out.println(" ");
        System.out.println("------------------------------------------------------");

        //Warnings

        System.out.println("YOUR UNIQUE IDENTIFICATION CODE");
        System.out.println("------------------------------------------------------");
        System.out.println("######################################################");
        System.out.println("#                                                    #");

        //UID generation
        String result = "";
        for(int i=0; i<acode.length();i++){
            result += acode.charAt(i);
            result += numeric.charAt(i);
        }

        //password generation



        System.out.println("#    UID = " + result + "       Password = " + pass + "    #");
        System.out.println("#                                                    #");
        System.out.println("######################################################");
        System.out.println("------------------------------------------------------");
        System.out.println("Unique user identification generation complete.");
        System.out.println("------------------------------------------------------");


        //Reboot

    }

}
