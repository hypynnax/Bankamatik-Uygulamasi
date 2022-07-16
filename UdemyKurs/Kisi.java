package udemykurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

abstract class Kisi {

    private String ad;
    private ArrayList<Kurs> kurslar;

    public Kisi(String ad, int hesapNo, int parola, HashMap<Integer, Integer> hesapNoParola) {
        this.ad = ad;
        hesapNoParola.put(parola, hesapNo);
        this.kurslar = new ArrayList<>();
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public ArrayList<Kurs> getKurslar() {
        return kurslar;
    }

    void kursEkle(Kurs kurs) {
        kurslar.add(kurs);
        System.out.println("Kurs kütüphaneye eklendi");
    }

    void kursCikar(Kurs kurs) {
        kurslar.remove(kurs);
        System.out.println("Kurs kütüphaneden çıkarlıdı");
    }

    void kurslariGoruntule() {
        int kursSayisi = 1;
        Iterator<Kurs> iterator = getKurslar().iterator();
        while (iterator.hasNext()) {
            System.out.println(kursSayisi + ". " + iterator.next());
            kursSayisi++;
        }
    }
}
