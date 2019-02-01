package model;

import java.util.HashSet;
import java.util.Set;

public class Books {
    public Integer id;
    public String title;
    public Integer price;
    public String author;

    public Books(Integer id, String title, Integer price, String author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }
    private  static Set<Books> books;
    static{
        books = new HashSet<>();

        books.add(new Books(1,"palpasa cafe",234,"Naryan wagle"));
        books.add(new Books(2,"yogmaya",234,"nilam"));
        books.add(new Books(3,"hajar mile",234,"Naryan dhakal"));
        books.add(new Books(4,"softwre engineering",234, "ashwin dhakal"));
        books.add(new Books(5,"yena",234,"ramlal yadav"));

    }

    public static Set<Books> allBooks() {
        return books;
    }
    public static Books findById(Integer id)
    {
        for (Books book:books)
        {
            if(id.equals(book.id))
            {
                return book;
            }
        }
        return  null;
    }
    public  static  void add (Books book)
    {
        books.add(book);
    }
    public  static  boolean remove (Books book)
    {
        return  books.remove(book);
    }
}
