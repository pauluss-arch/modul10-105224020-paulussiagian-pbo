public class Buku {
    String isbn;
    String judul;

    public Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
    }

    public void info() {
        System.out.println("-" + judul + " (ISBN: " + isbn + ")");
    }
}