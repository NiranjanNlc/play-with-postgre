package controllers;

import model.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.books.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class BooksController extends Controller {


  @Inject
    FormFactory formFactory;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        /**
        Set <Book> books = Book.allBooks();
         */
        List<Book> books = Book.find.all();
        return ok(index.render(books));


    }
    public Result create() {
        Form<Book> bookForm = formFactory.form(Book.class);

        return  ok(create.render(bookForm));

    }
    public Result save(){
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
       /*
        Book.add(book); */
       book.save();
        return redirect(routes.BooksController.index());
    }
    public Result update() {
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
       /** Book oldbook = Book.findById(book.id); */
       Book oldbook = Book.find.byId(book.id);
        if(oldbook==null) {

        }
        else
        {
            oldbook.title = book.title;
            oldbook.author = book.author;
            oldbook.price = book.price;
            oldbook.update();
        }
        return redirect(routes.BooksController.index());

    }
    public Result edit(Integer id) {

        /**  Book book = Book.findById(id);*/
        Book book = Book.find.byId(id);
        if(book==null)
        {
            return TODO;
        }
        else
        {
            Form<Book> bookForm = formFactory.form(Book.class).fill(book);
            return ok(edit.render(bookForm));
        }

    }

    public Result destroy(Integer id) {
        /** Book book = Book.findById(id); */
        Book book = Book.find.byId(id);
         if(book == null)
         {
             return notFound("not found");
         }
         else
         {
           /**   Book.remove(book);  */
           book.delete();
             return redirect(routes.BooksController.index());
         }
    }

    public Result show(Integer id) {
        /** Book book = Book.findById(id); */
        Book book = Book.find.byId(id);
        if(book==null)
        {
            return TODO;
        }
        else
        {

            return ok(show.render(book));
        }
    }




}