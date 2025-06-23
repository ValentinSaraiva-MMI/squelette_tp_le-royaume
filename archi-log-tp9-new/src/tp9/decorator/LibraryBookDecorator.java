package tp9.decorator;
import tp9.Book;

import java.time.LocalDate;

// Décorateur pour ajouter des fonctionnalités de bibliothèque
public class LibraryBookDecorator implements BookDecorator {
    private Book book;
    private boolean isLoaned; // prêt en cours ou non
    private LocalDate dueDate; // date de prêt

    public LibraryBookDecorator(Book book) {
        this.book = book;
        this.isLoaned = false;
    }

    // définit un prêt. isLoaned devient vrai, et on fournit la date du prêt
    public void loanOut(LocalDate dueDate) {
        this.isLoaned = true;
        this.dueDate = dueDate;
    }

    // Le livre a été ramené, fin du prêt
    public void returnBook() {
        this.isLoaned = false;
        this.dueDate = null;    }

    public boolean isLoanedOut() {
        return isLoaned;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    // Méthodes de l'interface IBook déléguées à l'objet décoré
    @Override
    public String getTitle() {
        return book.getTitle() + " (Library book)";
    }

    @Override
    public void setTitle(String title) {
        book.setTitle(title);
    }

    @Override
    public double getPrice() {
        return book.getPrice();
    }

    @Override
    public void setPrice(double price) {
        book.setPrice(price);
    }

    @Override
    public String preview() {
        return book.preview();
    }

    @Override
    public String toString() {
        if (isLoanedOut()) {
            return getTitle() + " has been loaned out. Due date: " + getDueDate();
        } else {
            return getTitle() + " is available for a loan.";
        }
    }
}