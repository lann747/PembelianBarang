import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Barang {
    private String nama;
    private int hargaSatuan;
    private int jumlah;

    // Constructor
    public Barang(String nama, int hargaSatuan, int jumlah) {
        this.nama = nama;
        this.hargaSatuan = hargaSatuan;
        this.jumlah = jumlah;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    // Menghitung total harga barang
    public int hitungTotalHarga() {
        return hargaSatuan * jumlah;
    }
}

class Pembeli {
    private String nama;
    private List<Barang> daftarBarang;

    // Constructor
    public Pembeli(String nama) {
        this.nama = nama;
        this.daftarBarang = new ArrayList<>();
    }

    // Menambahkan barang ke daftar
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    // Menghitung total harga pembelian
    public int hitungTotalHarga() {
        int totalHarga = 0;
        for (Barang barang : daftarBarang) {
            totalHarga += barang.hitungTotalHarga();
        }
        return totalHarga;
    }

    // Menampilkan informasi pembelian
    public void tampilkanInformasiPembelian() {
        System.out.println("");
        System.out.println("Nama Pembeli: " + nama);
        System.out.println("Jumlah barang yang akan dibeli: " + daftarBarang.size());

        for (Barang barang : daftarBarang) {
            System.out.println("Nama Barang: " + barang.getNama());
            System.out.println("Harga Satuan: " + barang.getHargaSatuan());
            System.out.println("Jumlah Barang: " + barang.getJumlah());
            System.out.println();
        }

        System.out.println("Informasi Pembelian:");
        System.out.println("Nama Pembeli: " + nama);
        System.out.println("Daftar Barang:");
        for (Barang barang : daftarBarang) {
            System.out.println(
                    "- " + barang.getNama() + " (" + barang.getJumlah() + ") Harga Satuan: " + barang.getHargaSatuan());
        }
        System.out.println("Total Harga: " + hitungTotalHarga());
    }
}

public class AplikasiPembelianBarang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Program Pembelian Barang");
        System.out.println("========================");

        System.out.println("");

        // Input nama pembeli
        System.out.print("Nama pembeli: ");
        String namaPembeli = scanner.nextLine();

        // Membuat objek Pembeli
        Pembeli pembeli = new Pembeli(namaPembeli);

        // Input jumlah barang
        System.out.print("Jumlah barang yang akan dibeli: ");
        int jumlahBarang = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        // Loop untuk input barang
        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println("");
            System.out.print("Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Harga Satuan: ");
            int hargaSatuan = scanner.nextInt();

            System.out.print("Jumlah Barang: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            // Tambahkan barang ke pembeli
            Barang barang = new Barang(namaBarang, hargaSatuan, jumlah);
            pembeli.tambahBarang(barang);
        }

        // Tampilkan informasi pembelian
        pembeli.tampilkanInformasiPembelian();

        scanner.close();
    }
}
