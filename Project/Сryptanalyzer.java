package Project;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class –°ryptanalyzer {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String CHOISE_TO_ENCODING = "Enter: 1 - coding | 2 - decoding | 3 - bruteForce -> ";
    public static final String KEY_TO_ENCODING = "Enter key for Encoding ";

    public static String getInputFile() {
        return inputFile;
    }

    public static String getOutputFile() {
        return outputFile;
    }

    public static int getKey() {
        return key;
    }

    public static int getMode() {
        return mode;
    }

    private static String inputFile;
    private static String outputFile;
    private static int key;
    private static int mode;

    public static void coding(int key, String inputFile, String outputFile) {
        char[] message = fileToCharArray(inputFile);
        char[] letters = alfpabet();
        int index;
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                if (message[i] == letters[j]) {
                    index = (j + key) % (letters.length - 1);
                    message[i] = letters[index];
                    break;
                }
            }
        }
        charArrayToFile(message, outputFile);
    }//Good


    public static void decoding(int key, String inputFile, String outputFile) {//Bad
        char[] message = fileToCharArray(inputFile);
        char[] letters = alfpabet();
        int index;
        int plusNum;
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                if (message[i] == letters[j]) {
                    plusNum = j - key < 0 ? (j - key) * -1 : j - key;
                    index = plusNum % (letters.length - 1);
                    message[i] = letters[index];
                    break;
                }
            }
        }
        charArrayToFile(message, outputFile);
    }

    public static void bruteForce(String inputFile, String outputFile) { //Bad
        char[] chars = fileToCharArray(inputFile);
        System.out.println(Arrays.toString(chars));
        System.out.println("Data successfully encrypted2");
    }

    public static char[] fileToCharArray(String inputFile) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(inputFile))) {
            StringBuilder str = new StringBuilder();
            while (buffer.ready()) {
                str.append((char) buffer.read());
            }
            return (str.toString()).toCharArray();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//Good


    public static void charArrayToFile(char[] message, String outputFile) {  //???
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(outputFile))) {
            buffer.write(message);
            buffer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//Good

    public static void enterKey() {
        while (true) {
            if (scanner.hasNextInt()) {
                key = scanner.nextInt();
                scanner.nextLine();
                break;
            }else if(scanner.hasNextLine()){
                scanner.nextLine();
                System.out.println("-".repeat(120));
                System.out.print("Learn to hit the keys \uD83D\uDCA9 \n" + KEY_TO_ENCODING);
            }
        }
    }//Good

    public static void enterMode() {
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("1") || s.equals("2") || s.equals("3")) {
                mode = Integer.parseInt(s);
                break;
            } else {
                System.out.println("-".repeat(120));
                System.out.print("Learn to hit the keys \uD83D\uDCA9 \n" + CHOISE_TO_ENCODING);
            }
        }
    }//Good

    public static void enterInputFile() {
            inputFile = scanner.nextLine();
    }//Good

    public static void enterOutFile() {
            outputFile = scanner.nextLine();
    }//Good

    public static char[] alfpabet() {
        char[] letters = {'–į', '–Ī', '–≤', '–≥', '–ī', '–Ķ', '—Ď', '–∂', '–∑', '–ł', '–Ļ', '–ļ', '–Ľ', '–ľ', '–Ĺ', '–ĺ', '–Ņ', '—Ä', '—Ā', '—ā', '—É', '—Ą', '—Ö', '—Ü', '—á', '—ą', '—Č', '—ä', '—č', '—Ć', '—ć', '—é', '—Ź'};
        return letters;
    }
}

