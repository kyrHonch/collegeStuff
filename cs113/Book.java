package cs113;

import java.util.Objects;

public class Book {
    private int pages;
    String publisher;
    public Book(int p, String publ){
        pages = p;
        publisher = publ;
    }

    public int getPages() {
        return pages;
    }

    public String getPublisher(){
        return publisher;
    }

    public String toString(){
        return "The publisher of the book is " + publisher + ". The book has " + pages + " pages.";
    }

    public boolean equals(Book book){
        return book.getPages() == pages && Objects.equals(book.getPublisher(), this.publisher);
    }

    public int compareTo(Book b1){
        return Integer.compare(b1.getPages(), pages);
    }

}
