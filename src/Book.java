
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.FileWriter;
import java.io.PrintWriter;
import static java.lang.System.out;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rhett Fitchett
 */
public class Book {

    private String title;
    private List<String> aLine;
    private URI uri;

    public Book() {
    }

    public Book(String titl, String urii) {
        title = titl;
        try {
            uri = new URI((getClass().getResource("Resources/files/" + urii)).toString());

        } catch (URISyntaxException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void readWithScanner() {

        aLine = new ArrayList<>();
        try {
            //create scanner
            Scanner sc = new Scanner(new File(uri));
            String temp;

            while (sc.hasNext()) {
                //sc.next() --- reads one character at a time 
                temp = sc.nextLine();
                aLine.add(temp);
                //System.out.println(temp);
            }
            //close file
            sc.close();

        } catch (IOException | NullPointerException e) {
            System.out.println("File could not be found!");
        }
    }

    
    public void readFileUsingStreams() throws IOException {
        
        try (Stream<String> thelines = Files.lines(Paths.get(title))) {

            aLine = thelines.collect(Collectors.toList());

        } catch (IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void printTheBook() {
        aLine.forEach(System.out::println);
        /*for (int i = 0; i < aLine.size(); i++){
            System.out.println(aLine.get(i));
        }*/
    }

    public void writeBook() {
        PrintWriter writer = null;
        try {
            File aFile = new File("NewRaven.txt");
            FileWriter fw = new FileWriter(aFile, false);
            PrintWriter pw = new PrintWriter(fw);

            for (int i = 0; i < aLine.size(); i++) {
                pw.println(aLine.get(i));
            }
            //pw.println("Line 1");
            //pw.println("Line 2");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File could not be written....");
        } catch (IOException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*for(int i = 0; i< aLine.size(); i++){
            writer.println("Line " + i);
        } debug */

    }
    public void countCaps(){
       int counter = 0;
       char aChar;
       String str = aLine.toString();
        for (int i = 0; i< str.length(); i++){
            aChar = str.charAt(i);
            if(Character.isUpperCase(aChar)){
                counter++;
            }
        }
        System.out.println("Uppercase letters in " + title + ": " + counter);
    }
    public void countVowels(){
        int counter = 0;
        String str = aLine.toString();
        
        for (int i = 0; i < str.length(); i++){
            
            if((str.charAt(i) == 'a') || 
                (str.charAt(i) == 'e')  ||
                (str.charAt(i) == 'i') || 
                (str.charAt(i) == 'o') ||
                (str.charAt(i) == 'u')){
                counter++;
            }
            
            
        }
        System.out.println("Vowels in " + title + ": " + counter);
    }

}
