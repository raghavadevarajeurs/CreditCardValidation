package creditCard;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

@SpringBootApplication
public class creditCardValidation {

    public creditCardValidation() {}

    public static String getFileType(String filename) {
        String fileName = filename;
        final File file = new File(filename);
        try
        {
            Object fileType = Files.probeContentType(file.toPath());
            String extension = "";
            int i = fileName.lastIndexOf('.');
            if (i > 0) {
                extension = fileName.substring(i + 1);
            }
            return extension;
        }catch (FileNotFoundException exception) {
            System.out.println( fileName + "not found " );
        }catch (IOException ioException) {
            System.out.println(
                    "ERROR: Unable to determine file type for " + fileName
                            + " due to exception " + ioException);
        }
        return "";
    }
    public static boolean doesFileExist(String inputFile) {
        return new File(inputFile).isFile();
    }

    public static boolean isSameInOutFileExt(String inFile, String outFile) {
        String inExt = getFileType(inFile);
        System.out.println("Input fileType: " + inExt);
        String outExt = getFileType(outFile);
        System.out.println("Output fileType: " + outExt);

        return inExt.equals(outExt);
    }

    public static void main(String[] args) {
        String inputPath    = "./inputFiles/";
        String outputPath    = "./outputFiles/";

        String inputFile = "";
        String outputFile = "";

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Please enter input file name [Example: Sample.csv/Sample.json/Sample.xml] : ");
            String in = scanner.next(); // get string

            System.out.println("Please enter output file name [Example: Out.csv/Out.json/Out.xml] : ");
            String out = scanner.next(); // get string
            inputFile = inputPath + in;
            outputFile = outputPath + out;
            System.out.format("Input file : %s, Output file : %s", inputFile, outputFile);

            try
            {
                //System.out.println("fileType: " + extension);
                if(doesFileExist(inputFile)) {
                    if(isSameInOutFileExt(inputFile,outputFile) ) {
                        String extension = getFileType(inputFile);
                        Boolean get= fileCategorizer.controller(inputFile,outputFile,extension);
                    }
                    else
                        System.out.println("Input-Output file extensions are not same. Please give same file extension.");
                }
                else
                    System.out.println('\n' +"No such input file exist"+ '\n');

            }
            catch (Exception e) {
                System.out.println("Input-Output file extensions are not same. Please give same file extension.");
                e.printStackTrace();
            }
        }
    }
}