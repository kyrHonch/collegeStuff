package cs113;

import cs113.Book;

import java.util.Scanner;
import java.util.Random;

public class TestBooks {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int numOfBooks;
        Book b1, largestBook;

        System.out.println("How many books would you like to review?");
        numOfBooks = s.nextInt();

        System.out.println("Enter the name of the publisher: ");
        largestBook = b1 = new Book(r.nextInt(100)+1, s.next());


        for(int i=1;i<numOfBooks;i++){
            System.out.println("Enter the name of the publisher: ");
            b1 = new Book(r.nextInt(100)+1, s.next());
            if(largestBook.compareTo(b1) == 1) {

                largestBook = b1;
            }
        }
        System.out.println(largestBook);
    }
}
