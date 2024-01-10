/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasbesarpbo;

/**
 *
 * @author Fahim Ahmad
 */
import java.util.Scanner;
public class TadarrusAlQuran {
    private static final String MENU_UTAMA = "==== Tadarrus Al-Quran ====\n1. (10 Juz pertama)\n2. (10 Juz kedua)\n3. (10 Juz ketiga)\n0. Keluar\n";
    private static final String MENU_JUZ = "==== %s ====\n1. (Surah Makkiyah)\n2. (Surah Madaniyah)\n0. Kembali\n\n";
    private static final String MENU_SURAH = "\n==== %s ====\n%s\n0. Kembali\n\n";

    private static DatabaseSurahPertama databaseSurah;
    
    
    

    public static void main(String[] args) {
        databaseSurah = new DatabaseSurahPertama();
        jalankanProgram();
    }

    public static void jalankanProgram() {
        Scanner scanner = new Scanner(System.in);
        int pilihanJuz;

        do {
            
            System.out.println(MENU_UTAMA);
            System.out.print("Pilih Juz (0 untuk keluar): ");
            pilihanJuz = scanner.nextInt();

            switch (pilihanJuz) {
                case 1:
                    menuJuz("10 Juz pertama");
                    break;
                case 2:
                    menuJuz("10 Juz kedua");
                    break;
                case 3:
                    menuJuz("10 Juz ketiga");
                    break;
                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        } while (pilihanJuz != 0);
    }

    public static void menuJuz(String namaJuz) {
        Scanner scanner = new Scanner(System.in);
        int pilihanSurah;

        do {
            System.out.printf(MENU_JUZ, namaJuz);
            System.out.print("Pilih Surah (0 untuk kembali): ");
            pilihanSurah = scanner.nextInt();

            switch (pilihanSurah) {
                case 1:
                    menuSurah("Surah Makkiyah", namaJuz);
                    break;
                case 2:
                    menuSurah("Surah Madaniyah", namaJuz);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        } while (pilihanSurah != 0);
    }

    public static void menuSurah(String jenisSurah, String namaJuz) {
        Scanner scanner = new Scanner(System.in);
        Surah[] surahList = null;

        if (jenisSurah.equalsIgnoreCase("Surah Makkiyah")) {
            surahList = databaseSurah.getMakkiyahSurahListbyJuz(namaJuz);
        }
        
        if (jenisSurah.equalsIgnoreCase("Surah Madaniyah")) {
            surahList = databaseSurah.getMadaniyahSurahListbyJuz(namaJuz);
        }

        if (surahList != null) {
            int pilihanSurah;
            do {
                System.out.printf(MENU_SURAH, jenisSurah, daftarSurah(surahList));
                System.out.print("Pilih nomor surah (0 untuk kembali): ");
                pilihanSurah = scanner.nextInt();

                if (pilihanSurah > 0 && pilihanSurah <= surahList.length) {
                    surahList[pilihanSurah - 1].tampilkanAyatPertama();
                } else if (pilihanSurah != 0) {
                    System.out.println("Nomor surah tidak valid");
                }
            } while (pilihanSurah != 0);
            
            
        }
    }
    
    


    private static String daftarSurah(Surah[] surahList) {
        StringBuilder daftar = new StringBuilder();
        for (int i = 0; i < surahList.length; i++) {
            daftar.append((i + 1)).append(". ").append(surahList[i].getNamaSurah()).append("\n");
        }
        return daftar.toString();
    }
    
    
}
