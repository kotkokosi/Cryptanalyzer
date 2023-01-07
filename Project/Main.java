package Project;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    static int key;
    static int mode;
    public static final String CHOISE_TO_ENCODING = "Enter: 1 - coding | 2 - decoding | 3 - bruteForce -> ";
    public static final String KEY_TO_ENCODING = "Enter key for Encoding ";

    public static void main(String[] args) {
        System.out.print(CHOISE_TO_ENCODING);
        enterMode();
        System.out.print(KEY_TO_ENCODING);
        enterKey();
        optionEncryption(key, mode);
    }

    public static void optionEncryption(int key, int mode) {
        switch (mode) {
            case 1 -> {
                coding(key);
            }
            case 2 -> {
                decoding(key);
            }
            case 3 -> {
                bruteForce();
            }
        }
    }

    public static void coding(int key) {
        char[] message = fileToCharArray();
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


    public static void decoding(int key) {
        char[] chars = fileToCharArray();
        System.out.println(Arrays.toString(chars));
        System.out.println("Data successfully encrypted1");
    }

    public static void bruteForce() { //---
        char[] chars = fileToCharArray();
        System.out.println(Arrays.toString(chars));
        System.out.println("Data successfully encrypted2");
    }

    public static char[] fileToCharArray() {
        System.out.print("Enter way to file: ");
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader buffer = new BufferedReader(new FileReader(scanner.nextLine()))) {
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
}