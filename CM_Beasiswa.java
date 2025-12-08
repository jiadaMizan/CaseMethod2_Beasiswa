import java.util.Scanner;

public class CM_Beasiswa {
    static Scanner sc = new Scanner(System.in);

    static String[][] data = new String[0][5];
    static int pilihan;


    static void menu() {
        System.out.println("\n=== SISTEM PENDAFTARAN BEASISWA AKADEMIK ===");
        System.out.println("1. Tambah data pendaftar");
        System.out.println("2. Tampilkan seluruh data pendaftar");
        System.out.println("3. Cari pendaftar berdasarkan jenis beasiswa");
        System.out.println("4. Hitung rata-rata IPK per jenis beasiswa");
        System.out.println("5. Keluar");
        System.out.println("=============================================");
        System.out.print("Pilih menu [1-5]: ");
        pilihan = sc.nextInt();
        sc.nextLine(); // Clear newline
    }
    
    static void tambahDataPendaftar() {
        System.out.println("\n=== Tambah Data Pendaftar Beasiswa ===");

        System.out.print("Nama mahasiswa        : ");
        String nama = sc.nextLine().trim();
        while (nama.isEmpty()) {
            System.out.print("Nama tidak boleh kosong. Masukkan lagi: ");
            nama = sc.nextLine().trim();
        }

        System.out.print("NIM mahasiswa         : ");
        long nim = sc.nextLong();
        sc.nextLine(); // Clear newline

        double ipk = 0;
        boolean validIPK = false;
        while (!validIPK) {
            System.out.print("IPK Terakhir          : ");
            ipk = sc.nextDouble();
            sc.nextLine(); // Clear newline
            if (ipk >= 0 && ipk <= 4.0) {
                validIPK = true;
            } else {
                System.out.println("IPK harus antara 0.00 - 4.00!");
            }
        }

        String jenisBeasiswa = "";
        boolean validJenis = false;
        while (!validJenis) {
            System.out.print("Jenis Beasiswa (Reguler/Unggulan/Riset): ");
            jenisBeasiswa = sc.nextLine().trim();

            if (jenisBeasiswa.equalsIgnoreCase("Reguler") ||
                jenisBeasiswa.equalsIgnoreCase("Unggulan") ||
                jenisBeasiswa.equalsIgnoreCase("Riset")) {
                jenisBeasiswa = jenisBeasiswa.substring(0, 1).toUpperCase() +
                                jenisBeasiswa.substring(1).toLowerCase();
                validJenis = true;
            } else {
                System.out.println("Jenis beasiswa hanya boleh: Reguler, Unggulan, atau Riset!");
            }
        }

        long penghasilan = 0;
        boolean validPenghasilan = false;
        while (!validPenghasilan) {
            System.out.print("Penghasilan orang tua  (Rp): ");
            penghasilan = sc.nextLong();
            sc.nextLine(); // Clear newline
            if (penghasilan >= 0 && penghasilan <= 2000000) {
                validPenghasilan = true;
            } else {
                System.out.println("Penghasilan orang tua maksimal Rp 2.000.000!");
            }
        }

        String[][] newData = new String[data.length + 1][5];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < 5; j++) {
                newData[i][j] = data[i][j];
            }
        }
        newData[data.length][0] = nama;
        newData[data.length][1] = String.valueOf(nim);
        newData[data.length][2] = String.valueOf(ipk);
        newData[data.length][3] = jenisBeasiswa;
        newData[data.length][4] = String.valueOf(penghasilan);

        data = newData;
        System.out.println("\nData berhasil ditambahkan!\n");
    }

    static void tampilkanDataPendaftaran() {

        System.out.println("\n===DAFTAR SELURUH DATA PENDAFTAR===");

        if (data.length==0) {
            System.out.println("Belum ada pendaftar");

        }

        System.out.printf("%-3s %-20s %-12s %-6s %-12s %-15s\n",
        "No", "Nama", "NIM", "IPK", "Beasiswa", "Penghasilan");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-3d %-20s %-12s %-6s %-12s %-15s\n",
            (i + 1),
            data[i][0],
            data[i][1],
            data[i][2],
            data[i][3],
            data[i][4]);
        }

        System.out.println();
    }

    public static void main(String[] args) {

        do {
            menu();
            switch (pilihan) {
                case 1:
                    tambahDataPendaftar();
                    break;
                case 2:
                    System.out.println("Menampilkan seluruh data pendaftar");
                    break;
                case 3:
                    System.out.println("Menghitung Rata-rata IPK per Jenis Beasiswa");
                    break;
                case 4:
                    System.out.println("Mencari Pendaftar Beasiswa berdasarkan Jenis Beasiswa");
                    break;
                case 5:
                    System.out.println("Terimakasih telah menggunakan program");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }
}
