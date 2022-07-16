package udemykurs;

import java.util.ArrayList;

public class Kurs {

    private String kursAdi;
    private int toplamKursSüresi;
    private boolean aktifKurs;
    private ArrayList<Egitmen> kursSahipleri;
    private ArrayList<Ders> dersler;

    public Kurs(String kursAdi, ArrayList<Kurs> kursListesi) {
        this.kursAdi = kursAdi;
        this.toplamKursSüresi = 0;
        this.aktifKurs = false;
        kursListesi.add(this);
        kursSahipleri = new ArrayList<>();
        dersler = new ArrayList<>();
    }

    public String getKursAdi() {
        return kursAdi;
    }

    public void setKursAdi(String kursAdi) {
        this.kursAdi = kursAdi;
    }

    public int getToplamKursSüresi() {
        return toplamKursSüresi;
    }

    public boolean isAktifKurs() {
        return aktifKurs;
    }

    public void setAktifKurs(boolean aktifKurs) {
        this.aktifKurs = aktifKurs;
    }

    public ArrayList<Egitmen> getKursSahipleri() {
        return kursSahipleri;
    }

    public void setKursSahibiEkle(Egitmen kursSahibi) {
        if (!kursSahipleri.contains(kursSahibi)) {
            kursSahipleri.add(kursSahibi);
            System.out.println("Kursa eğitmen eklendi");
        } else {
            System.out.println("Zaten bu eğitmen kursa dahil");
        }
    }

    public void setKursSahibiCikar(Egitmen kursSahibi) {
        if (kursSahipleri.indexOf(kursSahibi) == 0) {
            System.out.println("Bu eğitmen bu kursun başeğitmeni çıkarılamaz");
        } else {
            kursSahipleri.remove(kursSahibi);
        }
    }

    public ArrayList<Ders> getDersler() {
        return dersler;
    }

    void dersEkle(Ders ders) {
        if (!dersler.contains(ders)) {
            dersler.add(ders);
            toplamKursSüresi += ders.getUzunluk();
            System.out.println("Ders eklendi");
        } else {
            System.out.println("Bu ders mevcut");
        }
    }

    void dersCikar(Ders ders) {
        dersler.remove(ders);
        toplamKursSüresi -= ders.getUzunluk();
        System.out.println("Ders çıkarlıdı");
    }

    @Override
    public String toString() {
        return "Kurs Adı = " + kursAdi;
    }
}
