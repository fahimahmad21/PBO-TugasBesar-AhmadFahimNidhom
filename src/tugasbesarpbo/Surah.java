/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasbesarpbo;

/**
 *
 * @author Fahim Ahmad
 */
public class Surah extends Juz implements Ayat {
    private String namaJuz;
    private String namaSurah;
    private String ayatPertama;
    private String jenisSurah;

    public Surah(String namaJuz, String namaSurah, String ayatPertama) {
        super(namaJuz);
        this.namaJuz = namaJuz;
        this.namaSurah = namaSurah;
        this.ayatPertama = ayatPertama;
        
    }
    
    public String getNamaJuz() {
        return namaJuz;
    }

    public String getNamaSurah() {
        return namaSurah;
    }
    
    public String getAyatPertama() {
        return ayatPertama;
    }
    
     public String getJenisSurah() {
        return jenisSurah;
    }

    public void setJenisSurah(String jenisSurah) {
        this.jenisSurah = jenisSurah;
    }


    @Override
    public void tampilkanAyatPertama() {
        System.out.println("Ayat pertama dari " + getNamaSurah() + " pada " + getNamaJuz() + " adalah: " + ayatPertama);
        
    }
}
