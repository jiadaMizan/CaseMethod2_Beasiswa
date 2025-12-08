import java.util.Scanner;

public class CM_Beasiswa {
    static Scanner sc = new Scanner(System.in);

    static String[][] data = new String[0][5];
    static int pilihan;

    static void menu() {
        System.out.println("=== Sistem Pendaftaran Beasiswa ===");
        System.out.println("1. Tambah Data Pendaftar Beasiswa");
        System.out.println("2. Tampilkan Semua Pendaftar Beasiswa");
        System.out.println("4. Cari Pendaftar Beasiswa berdasarkan Jenis Beasiswa");
        System.out.println("3. Hitung Rata-rata IPK per Jenis Beasiswa");
        System.out.println("5. Exit");
        System.out.println("==============================================================");
        System.out.print("Masukkan pilihan Anda (1-5): ");
        pilihan = sc.nextInt();
        sc.nextLine(); // Clear newline
    }

    static void tambahDataPendaftar() {
        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine();

        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        System.out.print("Masukkan IPK: ");
        String ipk = sc.nextLine();

        System.out.print("Masukkan Jenis Beasiswa: ");
        String jenisBeasiswa = sc.nextLine();

        System.out.print("Masukkan Penghasilan Orang Tua: ");
        String penghasilan = sc.nextLine();

        String[][] newData = new String[data.length + 1][5];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < 5; j++) {
                newData[i][j] = data[i][j];
            }
        }

        newData[data.length][0] = nama;
        newData[data.length][1] = nim;
        newData[data.length][2] = ipk;
        newData[data.length][3] = jenisBeasiswa;
        newData[data.length][4] = penghasilan;

        data = newData;

        System.out.println("Data berhasil ditambahkan!\n");
    }

    public static void main(String[] args) {
        do {
            menu();
            switch (pilihan) {
                case 1:
                    tambahDataPendaftar();
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
