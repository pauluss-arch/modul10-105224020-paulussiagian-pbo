public class Main {
    public static void main(String[] args) {
        SistemGudang gudang = new SistemGudang();

        gudang.tambahBarangBaru("B01", "Laptop ASUS", "Elektronik", 10);
        gudang.tambahBarangBaru("B02", "Meja Kerja", "Furnitur", 5);
        gudang.tambahBarangBaru("B03", "Mouse Logitech", "Elektronik", 15);

        gudang.tambahStok("B01", 5);
        gudang.kurangiStokSimulasi("B02", 3, true); 
        gudang.kurangiStokSimulasi("B02", 10, false); 
        gudang.cetakLaporan();
    }
}