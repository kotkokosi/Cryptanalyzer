package Project;

import static Project.Сryptanalyzer.*;


public class Main {
    public static final String FILE_TO_READ = "Enter path to file from which to read: ";
    public static final String FILE_TO_RECORD = "Enter path to file for record: ";
    public static void main(String[] args) {
        System.out.print(CHOISE_TO_ENCODING);
        enterMode();
        System.out.print(KEY_TO_ENCODING);
        enterKey();
        System.out.print(FILE_TO_READ);
        enterInputFile();
        System.out.print(FILE_TO_RECORD);
        enterOutFile();
        optionEncryption(getKey(), getMode(), getInputFile(), getOutputFile());
    }

    public static void optionEncryption(int key, int mode, String inputFile, String outputFile) {
        switch (mode) {
            case 1 -> {
                coding(key, inputFile, outputFile);
            }
            case 2 -> {
                decoding(key, inputFile, outputFile);
            }
            case 3 -> {
                bruteForce(inputFile, outputFile);
            }
        }
    }
}
