
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rhett Fitchett
 */
public class KickOff {
    public static void main(String[] args) throws IOException {
        Book myBook = new Book("Raven", "Raven.txt");
        myBook.readWithScanner(); // makes a String array from the lines of the book
        //myBook.readFileUsingStreams();
        myBook.printTheBook();   //  Prints each value of the array which contains a line each entry
        myBook.writeBook();
        myBook.countVowels();
        myBook.countCaps();
    }
    
}
