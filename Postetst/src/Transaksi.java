import java.util.*;
public class Transaksi {
    String namaPembeli;
    String kursi;
    String judulFilm;
    int harga;
    public Transaksi(String judulFilm, String kursi, String namaPemnbeli, int harga){
        this.harga = harga;
        this.judulFilm = judulFilm;
        this.namaPembeli = namaPemnbeli;
        this.kursi = kursi;
    }
}
