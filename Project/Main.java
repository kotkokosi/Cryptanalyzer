package Project;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static Project.Сryptanalyzer.*;


public class Main {
    public static void main(String[] args) {
        System.out.print(CHOISE_TO_ENCODING);
        enterMode();
        System.out.print(KEY_TO_ENCODING);
        enterKey();
        System.out.println(FILE_TO_READ);
        enterInputFile();
        System.out.println(FILE_TO_READ);
        enterOutoutFile()
        optionEncryption(getKey(), getMode(), getInputFile(), getOutputFile());
    }

    public static void optionEncryption(int key, int mode, String inputFile, String outputFile) {
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
}
