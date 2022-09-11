package org.example;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class files {
    public final static String emptyFileName="file1.txt";
    public final static String textFileName="file2.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

/************* File creation and Deletion **************/
        System.out.println(String.format("Creating an empty file [%s]....",emptyFileName));
        File file = new File(emptyFileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File creation successful!");

            } else {
                System.out.println("File creation failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Deleting file [%s]....",emptyFileName));
        System.out.println("Do you want to delete the file (Y or y for Yes)?");
        Scanner in=new Scanner(System.in);
        char choice=in.nextLine().charAt(0);
        if(choice=='Y' || choice=='y')
        {
            try {
                if (file.delete()) {
                    System.out.println("File deletion successful!");
                } else {
                    System.out.println("File deletion failed!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
/******************* Writing to a text file ********************/
        System.out.println(String.format("Writing to file [%s]",textFileName));
        try {
            FileWriter myWriter = new FileWriter(textFileName);
            String sentence = scanner.nextLine();
            myWriter.write(sentence + '\n');
            myWriter.close();
            System.out.println("Text saved successfully.");
        } catch (Exception e) {
            System.out.println("Text saving failed.");
            e.printStackTrace();
        }
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
