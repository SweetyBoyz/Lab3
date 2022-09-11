package org.example;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class files {
    public final static String emptyFileName="file1.txt";
    public final static String textFileName="file2.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


/******************* Reading from a text file *************************/
// using FileReader
        System.out.println(String.format("Reading file [%s] using FileReader",textFileName));
                StringBuilder sb= new StringBuilder();
        try {
            FileReader myReader = new FileReader(textFileName);
            try(Scanner sc = new Scanner(new FileInputStream(textFileName))) {
                int count = 0;
                while (sc.hasNext()) {
                    sc.next();
                    count++;
                }
                System.out.println("Number of words: " + count);
            }
            FileReader fr = new FileReader("file2.txt");
            BufferedReader br = new BufferedReader(fr);
            br.lines()
                    .map(Letters::stringToLettersCount)
                    .reduce(Letters::sum)
                    .ifPresent(l -> System.out.println(l.toString()));
            br.close();


            int character=myReader.read();
            while(character!=-1)
            {   System.out.print((char) character);
                sb.append((char) character);
                character=myReader.read();

            }

            myReader.close();

        } catch (Exception e) {
            System.out.println("Text reading failed.");
            e.printStackTrace();
        }

        System.out.println(sb.toString());
// using Scanner
        System.out.println(String.format("Reading file[%s] using Scanner",textFileName));
        try {
            File myFile = new File(textFileName);
            Scanner myReader = new Scanner(myFile);


            while (myReader.hasNextLine()) {

                String line = myReader.nextLine();
                System.out.println(line);
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Text reading failed.");
            e.printStackTrace();
        }






    }
}
