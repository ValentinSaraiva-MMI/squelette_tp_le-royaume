package tp9.facade;

import tp9.Book;
import tp9.IBook;
import tp9.adapter.BookStoreAdapter;
import tp9.adapter.IBookStore;
import tp9.adapter.OldBookStore;
import tp9.decorator.LibraryBookDecorator;

// Facade pour simplifier l'accès client
public class LibraryFacade {
    private OldBookStore oldBookStore;
    private IBookStore bookStoreAdapter;
    // autres attributs si nécessaire

    public LibraryFacade(OldBookStore oldBookStore) {
      this.oldBookStore = oldBookStore;
      this.bookStoreAdapter = new BookStoreAdapter(oldBookStore);
    }


    // Méthodes simplifiées pour l'accès client
    public IBook getBook(String title) {
      return bookStoreAdapter.fetchBook(title);
    }

    // Méthode qui renvoie un libraryBookDecorator
    public IBook libraryBook(String title) {
        Book book = oldBookStore.getBook(title);
        return new LibraryBookDecorator(book);
    }
}