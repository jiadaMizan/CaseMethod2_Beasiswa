import java.util.Scanner;

public class CM_Beasiswa {
    static Scanner sc = new Scanner(System.in);

    static int pilihan;

    
    static void menu() {
        System.out.println("=== Sistem Pendaftaran Beasiswa ===");
        System.out.println("1. Tambah Data Pendaftar Beasiswa");
        System.out.println("2. Tampilkan Semua Pendaftar Beasiswa");
        System.out.println("4. Cari Pendaftar Beasiswa berdasarkan Jenis Beasiswa");
        System.out.println("3. Hitung Rata-rata IPK per Jenis Beasiswa");
        System.out.println("5. Exit");
        System.out.println("==============================================================");
        System.out.print("Masukkan pilihan Anda: (1-5)");
        pilihan = sc.nextInt();
    }
    public static void main(String[] args) {
        do {
            menu();
            switch (pilihan) {
                case 1:
                    System.out.println("Menambahkan Data Pendaftar Beasiswa");
                    break;
                case 2:
                    System.out.println("Menampilkan Semua Pendaftar Beasiswa");
                    break;
                case 3:
                    System.out.println("Menghitung Rata-rata IPK per Jenis Beasiswa");
                    break;
                case 4:
                    System.out.println("Mencari Pendaftar Beasiswa berdasarkan Jenis Beasiswa");
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }
}
