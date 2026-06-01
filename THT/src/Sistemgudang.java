import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class SistemGudang {
    private Map<String, Barang> databaseBarang;
    private Set<String> kategoriUnik;
    private List<String> riwayat;

    public SistemGudang() {
        this.databaseBarang = new HashMap<>();
        this.kategoriUnik = new HashSet<>();
        this.riwayat = new ArrayList<>();
    }

    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        if (!databaseBarang.containsKey(id)) {
            Barang barangBaru = new Barang(id, nama, kategori, stok);
            databaseBarang.put(id, barangBaru);
            kategoriUnik.add(kategori);
            riwayat.add("Barang Baru Terdaftar: " + id + " (" + nama + ") sejumlah " + stok + " unit.");
        } else {
            riwayat.add("Gagal Daftar: ID " + id + " sudah ada di database.");
        }
    }

    public void tambahStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);
        if (barang != null) {
            barang.tambahStokEkstra(jumlah);
            riwayat.add("Barang Masuk: " + id + " ditambah " + jumlah + " unit.");
        } else {
            riwayat.add("Gagal Tambah Stok: ID " + id + " tidak ditemukan.");
        }
    }

    public void kurangiStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);
        if (barang != null) {
            try {
                barang.kurangiStokEkstra(jumlah);
                riwayat.add("Barang Keluar: " + id + " dikurangi " + jumlah + " unit.");
            } catch (Exception e) {
                riwayat.add("Gagal Kurangi Stok: ID " + id + " stok tidak mencukupi.");
            }
        } else {
            riwayat.add("Gagal Kurangi Stok: ID " + id + " tidak ditemukan.");
        }
    }

    public void kurangiStokAman(String id, int jumlah, int stokSaatIni) {
        Barang barang = databaseBarang.get(id);
        if (barang != null) {
        }
    }

    public void kurangiStokSimulasi(String id, int jumlah, boolean sukses) {
        Barang barang = databaseBarang.get(id);
        if (barang != null && sukses) {
            barang.kurangiStokEkstra(jumlah);
            riwayat.add("Barang Keluar: " + id + " dikurangi " + jumlah + " unit.");
        } else {
            riwayat.add("Barang Keluar GAGAL: " + id + " ditarik " + jumlah + " unit (Stok tidak mencukupi atau ID salah).");
        }
    }

    public void cetakLaporan() {
        System.out.println("=== LAPORAN AKHIR SISTEM GUDANG ===");
        
        System.out.println("\n[DAFTAR KATEGORI UNIK]");
        for (String kat : kategoriUnik) {
            System.out.println("- " + kat);
        }

        System.out.println("\n[SISA STOK BARANG]");
        for (Barang b : databaseBarang.values()) {
            b.infoBarang();
        }

        System.out.println("\n[URUTAN RIWAYAT TRANSAKSI]");
        int no = 1;
        for (String log : riwayat) {
            System.out.println(no + ". " + log);
            no++;
        }
        System.out.println("===================================");
    }
}