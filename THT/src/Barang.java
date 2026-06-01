class Barang {
    private String idBarang;
    private String namaBarang;
    private String kategori;
    private int stok;

    public Barang(String idBarang, String namaBarang, String kategori, int stok) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.kategori = kategori;
        this.stok = stok;
    }

    public void tambahStokEkstra(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStokEkstra(int jumlah) {
        this.stok -= jumlah;
    }

    public void infoBarang() {
        System.out.println("ID: " + this.idBarang + " | Nama: " + this.namaBarang + " | Kategori: " + this.kategori + " | Stok: " + this.stok);
    }
}