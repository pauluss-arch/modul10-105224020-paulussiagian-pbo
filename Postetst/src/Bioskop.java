// Simpan file ini dengan nama: BioskopCLI.java

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bioskop {
    public static void main(String[] args) {

        Map<String, Film> jadwal = new HashMap<>();
        jadwal.put("F01", new Film("Inception",      50000));
        jadwal.put("F02", new Film("Interstellar",   55000));
        jadwal.put("F03", new Film("The Dark Knight", 45000));

        Map<String, Set<String>> kursiTerpesan = new HashMap<>();
        for (String kode : jadwal.keySet()) {
            kursiTerpesan.put(kode, new HashSet<>());
        }

        List<Transaksi> riwayat = new ArrayList<>();

        pesan(riwayat, jadwal, kursiTerpesan, "Iman",  "F01", "A1");
        pesan(riwayat, jadwal, kursiTerpesan, "Naufal;",  "F01", "B3");
        pesan(riwayat, jadwal, kursiTerpesan, "Zaidan", "F02", "A1");
        pesan(riwayat, jadwal, kursiTerpesan, "Ruswan",  "F01", "A1"); 
        pesan(riwayat, jadwal, kursiTerpesan, "Ical;",   "F99", "C2"); 

        System.out.println("\n--RIWAYAT TRANSAKSI--");
        System.out.println("No.\tPemesan\t\tFilm\t\t\tKursi\tHarga");
        System.out.println("______________________________________________________________");
        
        int no = 1;
        for (Transaksi t : riwayat) {
            System.out.println(no + "\t" + t.namaPembeli + "\t\t" + t.judulFilm + "\t\t" + t.kursi + "\tRp " + t.harga);
            no++;
        }
    }

    static void pesan(List<Transaksi> riwayat,
                      Map<String, Film> jadwal,
                      Map<String, Set<String>> kursiTerpesan,
                      String nama, String kodeFilm, String kursi) {

       
        if (!jadwal.containsKey(kodeFilm)) {
            System.out.println("GAGAL [" + nama + "]: Kode film \"" + kodeFilm + "\" tidak ditemukan." );
            return;
        }

        Set<String> kursiFilm = kursiTerpesan.get(kodeFilm);
        if (!kursiFilm.add(kursi)) { 
            System.out.println("GAGAL [" + nama + "]: Kursi " + kursi +
                    " di film \"" + jadwal.get(kodeFilm).judul + "\" sudah dipesan." );
            return;
        }

        Film f = jadwal.get(kodeFilm);
        riwayat.add(new Transaksi(nama, f.judul, kursi, f.harga));
        System.out.println("SUKSES: " + nama + " -> " + f.judul + " kursi " + kursi);
    }
}