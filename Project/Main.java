package Project;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static final String CHOISE_TO_ENCODING = "Enter: 1 - coding | 2 - decoding | 3 - bruteForce -> ";
    public static final String KEY_FOR_ENCODING = "Enter key for Encoding";

    public static void main(String[] args) {
        System.out.print(CHOISE_TO_ENCODING);
        optionEncryption();
    }

    public static String optionEncryption() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                switch (scanner.nextLine()) {
                    case "1" -> {
                        System.out.print(KEY_FOR_ENCODING + " ");
                        coding(scanner.nextInt());
                    }
                    case "2" -> {
                        System.out.print(KEY_FOR_ENCODING + " ");
                        return decoding(scanner.nextInt());
                    }
                    case "3" -> {
                        return bruteForce();
                    }
                }
                System.out.println("-".repeat(120));
                System.out.print("Learn to hit the keys \uD83D\uDCA9 \n" + CHOISE_TO_ENCODING);
            }
        }
    }

    public static void coding(int key) {
        char[] message = fileToCharArray();
        char[] letters = alfpabet();
        int index;
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                if (message[i] == letters[j]){
                    index = (j + key) % (letters.length - 1);
                    message[i] = letters[index];
                    break;
                }
            }
        }
        charArrayToFile(message);
    }


    public static String decoding(int key) {
        char[] chars = fileToCharArray();
        System.out.println(Arrays.toString(chars));
        return "Data successfully encrypted1";
    }

    public static String bruteForce() {
        char[] chars = fileToCharArray();
        System.out.println(Arrays.toString(chars));
        return "Data successfully encrypted2";
    }

    public static char[] fileToCharArray() {
        System.out.print("Enter way to file: ");
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader buffer = new BufferedReader (new FileReader(scanner.nextLine()))) {
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

    public static void charArrayToFile(char[] message) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter buffer = new BufferedWriter (new FileWriter(scanner.nextLine()))) {
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

}