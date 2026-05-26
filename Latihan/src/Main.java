import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        
        Map<String, Buku> katalogBuku = new HashMap<>(); 
        katalogBuku.put("978111", new Buku("978111", "Laskar Pelangi"));
        katalogBuku.put("978222", new Buku("978222", "Bumi Manusia"));
        katalogBuku.put("978332", new Buku("978332", "Struktur Data Java"));

        Set<Anggota> setAnggota = new HashSet<>(); 
        setAnggota.add(new Anggota("A01", "Pak Ruswan", "Dosen"));
        setAnggota.add(new Anggota("A02", "Aldo", "Mahasiswa"));
        setAnggota.add(new Anggota("A03", "Naufal", "Mahasiswa"));

        LinkedList<String> antrean = new LinkedList<>(); 
        antrean.addLast("A02#978111"); 
        antrean.addFirst("A01#978222"); 
        antrean.addLast("A03#978332"); 
        antrean.addFirst("A04#978111"); 
        
        antrean.addLast("A03#978111"); 

        System.out.println("Kondisi Awal Antrean: " + antrean);
        System.out.println();

        System.out.println("===PROSES PEMINJAMAN BUKU===");
        
        Set<String> bukuSedangDipinjam = new HashSet<>();

        while (!antrean.isEmpty()) {
            String dataAntrean = antrean.removeFirst();
            
            String[] part = dataAntrean.split("#");
            String idCari = part[0];
            String isbnCari = part[1];

            System.out.println("Memproses antrean: ID Anggota (" + idCari + ") - ISBN Buku (" + isbnCari + ")");

            boolean idTerdaftar = false;
            String namaAnggota = "";
            for (Anggota ang : setAnggota) {
                if (ang.idAnggota.equals(idCari)) {
                    idTerdaftar = true;
                    namaAnggota = ang.nama;
                    break;
                }
            }

            boolean isbnTerdaftar = katalogBuku.containsKey(isbnCari);

            boolean sedangDipinjam = bukuSedangDipinjam.contains(isbnCari);

            if (!idTerdaftar) {
                System.out.println("   - REJECT: idAnggota " + idCari + " tidak terdaftar di sistem!");
            } 
            else if (!isbnTerdaftar) {
                System.out.println("   - REJECT: ISBN " + isbnCari + " tidak ditemukan di katalog!");
            } 
            else if (sedangDipinjam) {
                System.out.println("   - REJECT: Buku '" + katalogBuku.get(isbnCari).judul + "' SEDANG DIPINJAM orang lain!");
            } 
            else {
                bukuSedangDipinjam.add(isbnCari); 
                System.out.print("   - SUCCESS: " + namaAnggota + " berhasil meminjam ");
                katalogBuku.get(isbnCari).info(); 
            }
            System.out.println("_________________________________________________");
        }
        
        System.out.println("\nRekap Akhir ISBN Buku yang Sedang Dipinjam: " + bukuSedangDipinjam);
    }
}