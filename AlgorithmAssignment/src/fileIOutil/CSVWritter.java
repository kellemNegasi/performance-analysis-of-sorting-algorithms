/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileIOutil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Kelly
 */
public class CSVWritter {
     // a Delimiter used in the  file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    //CSV file header
    private static final String FILE_HEADER = "time(nanoSecond),input";
    
     public static void writeCsvFile(String fileName , double[][]ArrayFile){
         FileWriter fileWriter = null;//create file writter and intialize it with null
         File csvFile;//declare csv file;
         int count = 1;
         
         try {
             csvFile = new File(fileName+".csv");
            while(csvFile.exists()){
               csvFile = new File(fileName+" ("+count+").csv");//append an integer if the file name already exists;
               count++;
            }
            fileWriter = new FileWriter(csvFile);
            //Write the CSV file header
            fileWriter.append(FILE_HEADER);
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("CSV file was created successfully !!!");
            
            for(int i = 0; i<ArrayFile[0].length; i++){
                fileWriter.append(ArrayFile[0][i]+"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(ArrayFile[1][i]+"");
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
         }
         catch (Exception e) {

            System.out.println("Error in CsvFileWriter !!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
            }
        }


     }
}
