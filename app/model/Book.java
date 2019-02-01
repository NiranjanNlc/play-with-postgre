package model;
import java.util.HashSet;
import java.util.Set;
import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;

@Entity
public class Book extends Model {
    @Id
    public Integer id;
    public String title;
    public Integer price;
    public String author;

    public static final Finder<Integer,Book> find = new Finder<>(Book.class);
    /**
    public Book()
    {

    }

    public Book(Integer id, String title, Integer price, String author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }
    private static Set<Book> books;
    static{
        books = new HashSet<>();

        books.add(new Book(1,"palpasa cafe",234,"Naryan wagle"));
        books.add(new Book(2,"yogmaya",234,"nilam"));
        books.add(new Book(3,"hajar mile",234,"Naryan dhakal"));
        books.add(new Book(4,"softwre engineering",234, "ashwin dhakal"));
        books.add(new Book(5,"yena",234,"ramlal yadav"));

    }

    public static Set<Book> allBooks()
    {
        return books;
    }
    public static Book findById(Integer id)
    {
        for (Book book : books)
        {
            if(id.equals(book.id))
            {
                return book;
            }
        }
        return  null;
    }
    public  static  void add (Book book)
    {
        books.add(book);
    }
    public  static  boolean remove (Book  book)
    {

        return  books.remove(book);
    }
     */
}
