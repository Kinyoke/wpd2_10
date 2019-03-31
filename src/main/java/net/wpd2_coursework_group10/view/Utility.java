package net.wpd2_coursework_group10.view;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faisal Burhan
 */
public class Utility {

    private Scanner reader;

    private String temp;

    public Utility() {
        reader = new Scanner(System.in);
    }

    // READ CHARACTER

    /**
     * @param prompt
     * @return
     */
    public char readCharacter(String prompt) {
        System.out.print(prompt + ": ");
        temp = reader.nextLine();
        char inputText = (!temp.split("",1)[0].equals(""))? temp.toCharArray()[0] : '\t' ;
        return inputText;
    }

    // Read Character - set of valid values

    /**
     *
     * @param prompt
     * @param validCharacters
     * @return
     */
    public char readCharacter(String prompt, String validCharacters) {
        char inputText;
        boolean inputError;
        do {
            inputError = false;
            System.out.print(prompt + ": ");
            temp = reader.nextLine().toUpperCase();
            inputText = (!temp.split("",1)[0].equals(""))? temp.toCharArray()[0] : '\t';
            if (validCharacters.indexOf(temp) == -1) {
                inputError = true;
                System.out.print("Character out of range, please re-enter: ");
            }
        } while (inputError);
        return inputText;
    }

    // Read String

    /**
     *
     * @param prompt
     * @return
     */
    public String readString(String prompt) {

        System.out.print(prompt + ": ");
        String inputText = reader.nextLine();
        return inputText;
    }

    // Read Int

    /**
     *
     * @param prompt
     * @param max
     * @param min
     * @return
     */
    public int readInt(String prompt, int max, int min) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
                if (inputNumber < min || inputNumber > max) {
                    inputError = true;
                    System.out.println("Number out of range: please re-enter\n");
                }
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    // Read Int

    /**
     *
     * @param prompt
     * @return
     */
    public int readInt(String prompt) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.print(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("   Not a valid number, please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    // Read Date

    /**
     *
     * @param prompt
     * @param format
     * @return
     */
    public Calendar readDate(String prompt, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateInString = readString(prompt);
        Date date = null;
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
