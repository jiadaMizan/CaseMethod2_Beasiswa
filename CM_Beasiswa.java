import java.util.InputMismatchException;
import java.util.Scanner;

public class CM_Beasiswa {
    static Scanner sc = new Scanner(System.in);

    static String[][] data = new String[0][5];

    static void menu() {
        System.out.println("\n=== SISTEM PENDAFTARAN BEASISWA AKADEMIK ===");
        System.out.println("1. Tambah data pendaftar");
        System.out.println("2. Tampilkan seluruh data pendaftar");
        System.out.println("3. Cari pendaftar berdasarkan jenis beasiswa");
        System.out.println("4. Hitung rata-rata IPK per jenis beasiswa");
        System.out.println("5. Keluar");
        System.out.println("=============================================");
        System.out.print("Pilih menu [1-5]: ");
    }

    static void tambahDataPendaftar() {
        System.out.println("\n=== Tambah Data Pendaftar Beasiswa ===");

        System.out.print("Nama mahasiswa        : ");
        String nama = sc.nextLine().trim();
        while (nama.isEmpty()) {
            System.out.print("Nama tidak boleh kosong. Masukkan lagi: ");
            nama = sc.nextLine().trim();
        }

        long nim = 0;
        boolean validNIM = false;
        while (!validNIM) {
            try {
                System.out.print("NIM mahasiswa         : ");
                nim = sc.nextLong();
                sc.nextLine(); // Clear newline
                if (String.valueOf(nim).length() == 12) {
                    validNIM = true;
                } else {
                    System.out.println("NIM harus 12 digit!");
                }
            } catch (InputMismatchException e) {
                System.out.println("NIM harus berupa angka!");
                sc.nextLine(); // Clear invalid input
            }
        }

        double ipk = 0;
        boolean validIPK = false;
        while (!validIPK) {
            try {
                System.out.print("IPK Terakhir          : ");
                ipk = sc.nextDouble();
                sc.nextLine(); // Clear newline

                if (ipk >= 0 && ipk <= 4.0) {
                    validIPK = true;
                } else {
                    System.out.println("IPK harus antara 0.00 - 4.00!");
                }

            } catch (InputMismatchException e) {
                System.out.println("IPK harus berupa angka desimal!");
                sc.nextLine(); // Clear invalid input
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
            try {
                System.out.print("Penghasilan orang tua  (Rp): ");
                penghasilan = sc.nextLong();
                sc.nextLine();

                if (penghasilan >= 0 && penghasilan <= 2000000) {
                    validPenghasilan = true;
                } else {
                    System.out.println("Penghasilan orang tua maksimal Rp 2.000.000!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Penghasilan harus berupa angka!");
                sc.nextLine(); // Clear invalid input
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
            return;
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

        static void cariPendaftarBeasiswa() {
            System.out.print("\nMasukkan jenis beasiswa yang dicari (Reguler/Unggulan/Riset): ");
            String jenis = sc.nextLine().trim();

            jenis = jenis.substring(0,1).toUpperCase() + jenis.substring(1).toLowerCase();

            System.out.println("\n=== Hasil Pencarian Pendaftar Beasiswa ===");
            System.out.printf("%-3s %-20s %-12s %-6s %-12s %-15s\n", "No","Nama","NIM", "IPK", "Beasiswa", "Penghasilan" );

            int nomor = 1;
            boolean ditemukan = false;

            for (int i = 0; i < data.length; i++){
                if (data[i][3].equalsIgnoreCase(jenis)){
                    ditemukan = true;
                    System.out.printf("%-3d ", nomor++);

                    for (int j = 0; j < 5; j++){
                        if (j == 0){
                            System.out.printf("%-20s ", data[i][j]);
                        }else if (j == 1) {
                            System.out.printf("%-12s ", data[i][j]);
                        }else if (j == 2) {
                            System.out.printf("%-6s ", data[i][j]);
                        }else if (j == 3) {
                            System.out.printf("%-12s ", data[i][j]);
                        }else if (j == 4) {
                            System.out.printf("%-15s ", data[i][j]);
                        }
                    }
                    System.out.println();
                }
            }
            if (!ditemukan){
                System.out.println("Tidak ada pendaftar dengan beasiswa " + jenis);
            }
        }

        static void hitungRataIPK() {
            if (data.length == 0) {
                System.out.println("\nBelum ada pendaftar!");
            }

            double totalReguler =0, totalUnggulan = 0, totalRiset = 0;
            int countReguler = 0, countUnggulan = 0, countRiset = 0;

            for (int i=0; i < data.length; i++){
                String jenis = data[i][3];
                double ipk = Double.parseDouble(data[i][2]);

                if (jenis.equalsIgnoreCase("Reguler")){
                    totalReguler += ipk;
                    countReguler++;
                }else if (jenis.equalsIgnoreCase("Unggulan")){
                    totalUnggulan += ipk;
                    countUnggulan++;
                }else if (jenis.equalsIgnoreCase("Riset")){
                    totalRiset += ipk;
                    countRiset++;
                }
            }

            System.out.println("\n=== Rata-rata IPK per Jenis Beasiswa ===");

            if (countReguler > 0){
                double rataReguler = totalReguler/countReguler;
                System.out.printf("Reguler  : rata-rata IPK = %.2f\n", rataReguler);
            }else {
                System.out.println("Reguler  : tidak ada pendaftar");
            }

            if (countUnggulan > 0) {
                double rataUnggulan = totalUnggulan/countUnggulan;
                System.out.printf("Unggulan : rata-rata IPK = %.2f\n", rataUnggulan);
            }else {
                System.out.println("Unggulan : tidak ada pendaftar");
            }

            if (countRiset > 0) {
                double rataRiset = totalRiset/countRiset;
                System.out.printf("Riset    : rata-rata IPK = %.2f\n", rataRiset);
            }else {
                System.out.println("Riset    : tidak ada pendaftar");
            }
            System.out.println();
        }
    public static void main(String[] args) {
        int pilihan;

        do {
            menu();
            pilihan = sc.nextInt();
            sc.nextLine(); // Clear newline
            switch (pilihan) {
                case 1:
                    tambahDataPendaftar();
                    break;
                case 2:
                    tampilkanDataPendaftaran();
                    break;
                case 3:
                    cariPendaftarBeasiswa();
                    break;
                case 4:
                    hitungRataIPK();
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
