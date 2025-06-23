package tp9.proxy;

import tp9.Book;

// Classe proxy
public class ProxyBookAccess implements BookAccess {
    private RealBookAccess realBookAccess;
    private boolean hasPurchased;
    // Logic for controlling access based on hasPurchased

    public ProxyBookAccess(Book book) {
       this.realBookAccess = new RealBookAccess(book);
       this.hasPurchased = false;
    }

    public void purchase() {
        this.hasPurchased = true;
    }

    @Override
    public String read() {
        // Dans un Proxy, si le livre a été acheté, on autorise la lecture, sinon on indique à l'utilisateur qu'il doit acheter le livre

        if (hasPurchased) {
            return realBookAccess.read();
        }

        else {
            return "You must purchase the book to read it.";
        }

    }

    @Override
    public String preview() {
       return realBookAccess.preview();
    }

}