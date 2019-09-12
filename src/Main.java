//* UID Generator
// Beware the kraken *//

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.security.SecureRandom;
import java.math.BigInteger;

public class Main {

    public static String masterUid = "";
    public static String masterPass = "";


    public static void main(String[] args) {


        final String VERSION = "0.1.1b";

        JFrame f = new JFrame("Nebletech UID Generator v"+VERSION);
        f.setSize(410,240);

        JLabel input1 = new JLabel("Keyword 1:");
        input1.setBounds(12,20,70,20);
        JLabel input2 = new JLabel("Keyword 2:");
        input2.setBounds(12,58,70,20);
        JLabel input3 = new JLabel("Keyword 3:");
        input3.setBounds(200,20,80,20);
        JLabel input4 = new JLabel("Keynumber:");
        input4.setBounds(200,58,80,20);

        JTextField one = new JTextField("default");
        one.setBounds(100,22,90,20);
        JTextField two = new JTextField("default");
        two.setBounds(100,60,90,20);
        JTextField three = new JTextField("123456");
        three.setBounds(288,22,90,20);
        JTextField four = new JTextField("default");
        four.setBounds(288,60,90,20);

        JLabel uidDisplay = new JLabel("UID:");
        uidDisplay.setBounds(12,150,80,20);
        JLabel passDisplay = new JLabel("Passkey:");
        passDisplay.setBounds(200,150,80,20);
        JLabel uidResult = new JLabel("xxxxxxxxxx");
        uidResult.setBounds(95,150,90,20);
        JLabel passResult = new JLabel("xxxxxxxxxx");
        passResult.setBounds(288,150,85,20);

        JButton button = new JButton("Generate UID");
        button.setBounds(140,110,120,20);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String oneValue = one.getText();
                String twoValue = two.getText();
                String threeValue = three.getText();
                String fourValue = four.getText();
                generateUID(oneValue,twoValue,threeValue,fourValue);
                uidResult.setText("<html><font color=red size=4><b>"+masterUid+"</b></html>");
                passResult.setText("<html><font color=green size=4><b>"+masterPass+"</b></html>");
                uidDisplay.setVisible(true);
                uidResult.setVisible(true);
                passResult.setVisible(true);
                passDisplay.setVisible(true);


            }
        });

        f.add(one);
        f.add(two);
        f.add(three);
        f.add(four);
        f.add(input1);
        f.add(input2);
        f.add(input3);
        f.add(input4);
        f.add(button);
        f.add(uidDisplay);
        f.add(passDisplay);

        uidDisplay.setVisible(false);
        passDisplay.setVisible(false);

        f.add(uidResult);
        f.add(passResult);

        uidResult.setVisible(false);
        passResult.setVisible(false);

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        f.setIconImage(icon);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        f.setLayout(null);
        f.setVisible(true);

        System.out.println("Nebletech Application version "+VERSION);
        System.out.println("UID Generator initialised...");
        System.out.println("\nUSE A VIRTUAL KEYBOARD WHEN RUNNING THIS PROGRAM TO PREVENT KEYLOGGING!");
        requestChoice();

    }





    static void requestChoice() {

        System.out.println("\nPlease select an option:");
        Scanner myScanner = new Scanner(System.in);
        System.out.println("\n1.\t\tGenerate new UID and random passkey");
        System.out.println("2.\t\tHelp");
        System.out.println("3.\t\tQuit\n");


        try {
            Integer answer = myScanner.nextInt();
            if (answer == 1) {
                getInput();
            } else if (answer == 2) {
                viewHelp();
            } else if (answer == 3) {
                System.exit(1);
            }
        } catch (Exception e) {
            System.out.println("Invalid option selected!");
            requestChoice();
        }
    }

    private static void viewHelp() {

        System.out.println("This UID Generator is used to convert various user input data into a " +
                "\nunique code using a cipher algorithm. The program will also generate a random " +
                "\nalphanumeric passkey and store data in a log file.");
        System.out.println("\nIt is important to note that the UID output is dependant on the seed data " +
                "\ninputted by the user, however the passkey is randomised at each iteration. This means " +
                "\nthat users can retrieve their UID by rerunning the program but users will not be able " +
                "\nto retrieve a passkey.");
        System.out.println("\nDue to a deliberate design choice the UID can not be cracked by persons" +
                "\nattempting to reverse engineer the code of this program as some data is cropped during" +
                "\nthe cipher process. However should a user have access to your seed text the UID will" +
                " \nbe reiterated. For these reasons the use of biographical data is strongly discouraged." +
                " \nThe use of memorable keywords as foundation seeds should add sufficient variation to the " +
                "\ninputted data.");
        System.out.println("\nThe log file outputted at the request of the user is stored in the local " +
                "\ndirectory in clear text (uid.log). Users wishing to keep inputted personal data secure " +
                "\nshould ensure that the log file is properly deleted and the data wiped from memory." +
                "\nSeed data is not saved in the log file.");
        System.out.println("\nPress [Enter] to exit Help.");
        try{System.in.read();}
        catch(Exception e){}

        requestChoice();

    }

        private static void getInput() {

            Scanner myVar = new Scanner(System.in);

            System.out.print("Insert keyword 1: ");
            String fn = myVar.nextLine();
            System.out.print("Insert keyword 2: ");
            String ln = myVar.nextLine();
            System.out.print("Insert keyword 3: ");
            String sx = myVar.nextLine();
            System.out.print("Insert 6 digit keynumber: ");
            String d = myVar.nextLine();
            generateUID(fn,ln,sx,d);

        }


        private static void generateUID(String fn, String ln, String d, String sx) {

        //seed generation

        String key = fn + ln + d + sx;

        //Passkey Generation
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
        //System.out.println("------------------------------------------------------");
        //System.out.println("Encryption process: ");
        //System.out.println(" ");
        //System.out.println("1. Unencrypted seed: " + key);
        //System.out.println("2. Encrypted seed: " + Newstr);
        String UID = builder.toString();
        //System.out.println("3. HEX conversion: " + UID);

        // display first four alpha
        String acode = alpha;

        try {
            acode = alpha.substring(0, 5);
            //System.out.println("4. Alpha character extraction: " + acode);
        } catch (Exception e) {
            //System.out.println("*UID Generation Failed due to alpha character < 5!\n" +
            //        "**Appending clone to alpha string and retrying...");
            alpha = alpha + alpha + alpha + alpha + alpha;
            acode = alpha.substring(0, 5);
            //System.out.println("4. Alpha character extraction: " + acode);
        }

        //convert num to int
        String numeric = num.substring(0, 5);
        System.out.println("\n------------------------------------------------------");

        //Warnings

        System.out.println("YOUR UNIQUE IDENTIFICATION CODE");
        System.out.println("------------------------------------------------------");
        System.out.println("######################################################");
        System.out.println("#                                                    #");

        //UID generation
        String result = "";
        for (int i = 0; i < acode.length(); i++) {
            result += acode.charAt(i);
            result += numeric.charAt(i);
        }

        //set main strings

            masterUid = result;
            masterPass = pass;

        //password generation

        System.out.println("#    UID = " + result + "        Passkey = " + pass + "    #");
        System.out.println("#                                                    #");
        System.out.println("######################################################");
        System.out.println("------------------------------------------------------");
        System.out.println("UID and associated passkey generation complete.");
        System.out.println("------------------------------------------------------");
        //printChoice(result,pass,key,Newstr,UID,acode,numeric);


        System.out.println("\n*WARNING: this will generate a clear-text file containing UID and passkey. ");
        System.out.println("Outputting log to file \"uid.log\" in local directory...");

            PrintWriter writer = null;
            try {
                writer = new PrintWriter("uid.log", "UTF-8");
                writer.println("UID generation completed at "+(java.time.LocalDateTime.now()));
                writer.println("\nUID: "+ result);
                writer.println("Passkey: "+ pass);
                writer.close();

                System.out.println("File output complete. \nREMEMBER TO DELETE THIS FILE!");

                writer.println("\nEnd of log.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        System.out.println("Exiting program...");
        System.exit(1);

    }


}
