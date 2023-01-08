package Project;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Сryptanalyzer {
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
        charArrayToFile(message);
    }


    public static void decoding(int key, String inputFile, String outputFile) {
        char[] chars = fileToCharArray(inputFile);
        System.out.println(Arrays.toString(chars));
        System.out.println("Data successfully encrypted1");
    }

    public static void bruteForce(String inputFile, String outputFile) { //---
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
    }


    public static void charArrayToFile(char[] message) {  //???
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(scanner.nextLine()))) {
            buffer.write(message);
            buffer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static char[] alfpabet() {
        char[] letters = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        return letters;
    }

    public static void enterKey() {
        while (true) {
            if (scanner.hasNextInt()) {
                key = scanner.nextInt();
                break;
            } else {
                System.out.println("-".repeat(120));
                System.out.print("Learn to hit the keys \uD83D\uDCA9 \n" + KEY_TO_ENCODING);
            }
        }
    }

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
    }

    public static void enterInputFile() {
        inputFile = scanner.nextLine();
        inputFile.replace("\\", "\\\\");
    }

    public static void enterOutoutFile() {
        outputFile = scanner.nextLine();
        outputFile.replace("\\", "\\\\");
    }

}

