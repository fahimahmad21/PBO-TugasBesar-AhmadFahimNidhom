/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasbesarpbo;

/**
 *
 * @author Fahim Ahmad
 */
import java.util.Arrays;
import java.util.Scanner;
public class DatabaseSurahPertama {
    private Surah[] surahList;

    public DatabaseSurahPertama() {
        // Inisialisasi surah pada 10 Juz pertama
        surahList = new Surah[]{
                new Makkiyah("10 Juz pertama", "Al-Fatihah", "Bismillaahir-Rohmanir-Rohiim"),
                new Makkiyah("10 Juz pertama", "Al-A'raf", "Alif Laam-Miim Shaad"),
                new Madaniyah("10 Juz pertama", "Al-Baqarah", "Alif-Lam-Mim. dzaalikal-kitaabu laa roiba fiihi hudan-lil-muttaqiin"),
                new Madaniyah("10 Juz pertama", "Ali 'Imran", "Alif-Lam-Mim. Allou laa ilaaha illaa huwal-hayyul-qoyyum"),
                new Makkiyah("10 Juz kedua", "Yunus", "Alif-Lam-Raa. tilka aayaatul-kitaabil-khakiim"),
                new Makkiyah("10 Juz kedua", "Hud", "Alif-Lam-Raa. Kitaabun ukhkimat aayaatuhuu tsumma fusshilat min-ladun khakiimin 'khobiir"),
                new Madaniyah("10 Juz kedua", "Ar-Hajj", "Yaa ayyuhan-naasut-taquu robbakum. inna zalzalatas-saaAti syaiun 'Adhiim"),
                new Madaniyah("10 Juz kedua", "An-Nur", "Suurotun anzalnaahaa wa farodznaahaa wa anzalnaa fiihaaa aayaatin-bayyinaatin-la'allakum tadzakkaruun"),
                new Makkiyah("10 Juz ketiga", "Ar-Rum", "Alif-Lam-Mim. Ghulibatir-ruum"),
                new Makkiyah("10 Juz ketiga", "Luqman", "Alif-Lam-Mim. Tilka aayaatul kitaabil-hakiim"),
                new Madaniyah("10 Juz ketiga", "Muhammad", "Alladziina kafaruu wa shodduu 'an-sabiilillaahi adholla a'maalahum"),
                new Madaniyah("10 Juz ketiga", "Al-Fath", "Inna fatahnaa laka fathan-mubiinaa"),
                

                // Tambahkan surah lainnya
        };
    }

    public Surah[] getSurahList() {
        return surahList;
    }
    
    

    public Surah[] getMakkiyahSurahListbyJuz(String namaJuz) {
        return filterSurahListByJenisAndJuz("Makkiyah", namaJuz);
    }
    
    public Surah[] getMadaniyahSurahListbyJuz(String namaJuz) {
        return filterSurahListByJenisAndJuz("Madaniyah", namaJuz);
    }
    
    private Surah[] filterSurahListByJenis(String jenisSurah) {
        return Arrays.stream(surahList)
                .filter(surah -> surah.getJenisSurah().equalsIgnoreCase(jenisSurah))
                .toArray(Surah[]::new);
    }
    
    
    
    public Surah[] getSurahListByJenis(String jenisSurah) {
        // Mengembalikan array surah berdasarkan jenisSurah (Makkiyah atau Madaniyah)
        return Arrays.stream(surahList)
                .filter(surah -> surah.getJenisSurah().equalsIgnoreCase(jenisSurah))
                .toArray(Surah[]::new);
    }
    
    private Surah[] filterSurahListByJenisAndJuz(String jenisSurah, String namaJuz) {
         // Mengembalikan array surah berdasarkan jenisSurah (Makkiyah atau Madaniyah) dan namaJuz
        return Arrays.stream(surahList)
                .filter(surah -> surah.getJenisSurah().equalsIgnoreCase(jenisSurah) && surah.getNamaJuz().equalsIgnoreCase(namaJuz))
                .toArray(Surah[]::new);
    }
    public void tampilkanDaftarSurah(String jenisSurah, String namaJuz) {
        Surah[] surahListByJenisAndJuz = filterSurahListByJenisAndJuz(jenisSurah, namaJuz);

        System.out.println("==== Surah " + jenisSurah + " ====");
        for (int i = 0; i < surahListByJenisAndJuz.length; i++) {
            System.out.println((i + 1) + ". " + surahListByJenisAndJuz[i].getNamaSurah());
        }
        System.out.println("0. Kembali");
    }

}
