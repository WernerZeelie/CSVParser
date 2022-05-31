/*
 * Author: Werner Zeelie
 * Last modified: 31 May 2022
 * Vas-X Technical Test
 */

package csvparser;

import java.util.Scanner;

public class CSVParser {

    public static void main(String[] args) {
        //Create a scanner to get user input
        Scanner sc = new Scanner(System.in);
        String filepath = sc.next();
        //Creation of the CSVHandler Object
        CSVHandler handler1 = new CSVHandler();
        //Pass the filepath to start summarizing the CSV file
        handler1.summarizeCSV(filepath);
    }
    
}
