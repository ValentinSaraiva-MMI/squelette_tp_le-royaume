package tp9;

// Classe Book
public class Book implements IBook {
    private String title;
    private double price;

    public Book (String title, double price)
    {
        this.title = title;
        this.price = price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }


    // getters, setters, etc.


    //TODO à compléter

    public String preview() {
        // Simule l'affichage d'un aperçu du livre (indiquez par exemple "Preview of Clean Code: [First few lines of the book...]")
        return null;
    }
}