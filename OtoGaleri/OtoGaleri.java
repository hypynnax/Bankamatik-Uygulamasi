package otogaleri;

import java.util.ArrayList;
import java.util.Scanner;

public class OtoGaleri {

    private long galeriBakiyesi = 999999999;
    Scanner reader = new Scanner(System.in);
    ArrayList<MotorluTasit> araclar = new ArrayList<>();
    ArrayList<Musteri> musteriler = new ArrayList<>();
    ArrayList<SatisGecmisi> satisGecmisi = new ArrayList<>();

    public long getGaleriBakiyesi() {
        return galeriBakiyesi;
    }

    public void galeriBakiyesineEkle(long galeriBakiyesi) {
        if (galeriBakiyesi > 0) {
            this.galeriBakiyesi += galeriBakiyesi;
        } else {
            System.out.println("Geçerli bir bakiye girin");
        }
    }

    public void galeriBakiyesindenCikar(long galeriBakiyesi) {
        if (this.galeriBakiyesi >= galeriBakiyesi) {
            this.galeriBakiyesi -= galeriBakiyesi;
        }
    }

    MotorluTasit galerideArabaBul(int saseNumarasi) {
        for (MotorluTasit arac : araclar) {
            if (arac.getSaseNumarasi() == saseNumarasi) {
                return arac;
            }
        }
        return null;
    }

    MotorluTasit garajdaArabaBul(Musteri musteri, int saseNumarasi) {
        for (MotorluTasit arac : musteri.getMotorluTasitlarim()) {
            if (arac.getSaseNumarasi() == saseNumarasi) {
                return arac;
            }
        }
        return null;
    }

    void stokArabalar(MotorluTasit motorluTasit) {
        if (!araclar.contains(motorluTasit)) {
            araclar.add(motorluTasit);
        } else {
            System.out.println("Bu araç zaten galeride mevcut");
        }
    }

    void aracEkle() {
        System.out.println("Araba bilgileri...");
        reader.nextLine();
        System.out.print("Markası : ");
        String marka = reader.nextLine();
        System.out.print("Modeli : ");
        String model = reader.nextLine();
        System.out.print("Tür : ");
        String tur = reader.nextLine();
        System.out.print("Şase Numarası : ");
        int saseNumarasi = reader.nextInt();
        System.out.print("Çıkış Yılı : ");
        int cikisYili = reader.nextInt();
        System.out.print("Kilometresi : ");
        int kilometresi = reader.nextInt();
        System.out.print("Fiyatı : ");
        int fiyat = reader.nextInt();
        System.out.print("100 km'de yakılan litre : ");
        int kmBasinaYakilan = reader.nextInt();
        System.out.print("Silindir : ");
        int silindir = reader.nextInt();
        System.out.print("Beygir : ");
        int beygir = reader.nextInt();
        System.out.print("Tekerlek Sayısı : ");
        int tekerlekSayisi = reader.nextInt();
        System.out.print("Kapı Sayısı : ");
        int kapiSayisi = reader.nextInt();
        MotorluTasit motorluTasit = new MotorluTasit(marka, model, tur, saseNumarasi, cikisYili, kilometresi, fiyat, kmBasinaYakilan, silindir, beygir, tekerlekSayisi, kapiSayisi);
        boolean aracVarmi = false;
        for (int i = 0; i < araclar.size(); i++) {
            if (araclar.get(i).getSaseNumarasi() == motorluTasit.getSaseNumarasi()) {
                aracVarmi = true;
            }
        }
        if (!aracVarmi) {
            araclar.add(motorluTasit);
            System.out.println("Araç galeriye eklendi");
        } else {
            System.out.println("Bu araç zaten galeride mevcut");
        }
    }

    void aracCikar() {
        System.out.print("Çıkarmak istediğiniz aracın sase numarasını girin : ");
        int saseNumarasi = reader.nextInt();
        MotorluTasit motorluTasit = galerideArabaBul(saseNumarasi);
        if (motorluTasit != null) {
            araclar.remove(motorluTasit);
            System.out.println("Araç listeden çıkarıldı");
        } else {
            System.out.println("Bu araç zaten galeride mevcut değil");
        }
    }

    Musteri musteriBul(int kayitNumarasi) {
        for (Musteri musteri : musteriler) {
            if (musteri.getKayitNumarasi() == kayitNumarasi) {
                return musteri;
            }
        }
        return null;
    }

    void stokMusteriler(Musteri musteri) {
        if (!musteriler.contains(musteri)) {
            musteriler.add(musteri);
        } else {
            System.out.println("Bu müşteri zaten galeride kayıtlı");
        }
    }

    void musteriEkle() {
        System.out.println("Müşteri bilgileri...");
        reader.nextLine();
        System.out.print("Ad Soyad : ");
        String adSoyad = reader.nextLine();
        System.out.print("Telefon Numarasi : ");
        String telefon = reader.nextLine();
        System.out.print("Kayit Numarasi : ");
        int kayitNumarasi = reader.nextInt();
        System.out.print("Bakiye : ");
        int bakiye = reader.nextInt();
        Musteri musteri = new Musteri(adSoyad, telefon, kayitNumarasi, bakiye);
        boolean musteriVarmi = false;
        for (int i = 0; i < musteriler.size(); i++) {
            if (musteriler.get(i).getKayitNumarasi() == musteri.getKayitNumarasi()) {
                musteriVarmi = true;
            }
        }
        if (!musteriVarmi) {
            musteriler.add(musteri);
            System.out.println("Müşteri kayıt edildi");
        } else {
            System.out.println("Bu müşteri zaten kayıtlı");
        }
    }

    void musteriCikar() {
        System.out.print("Çıkarmak istediğiniz müşterinin kayıt numarasını girin : ");
        int kayitNumarasi = reader.nextInt();
        Musteri musteri = musteriBul(kayitNumarasi);
        if (musteriler.contains(musteri)) {
            musteriler.remove(musteri);
            System.out.println("Kayıtlı müşteri listeden çıkarıldı");
        } else {
            System.out.println("Bu müşteri zaten galeride kayıtlı değil");
        }
    }

    void arabaSat() {
        System.out.print("Satış yapmak istediğiniz müşterinin kayıt numarasını girin : ");
        int kayitNumarasi = reader.nextInt();
        Musteri musteri = musteriBul(kayitNumarasi);
        System.out.print("Satılacak aracın sase numarasını girin : ");
        int saseNumarasi = reader.nextInt();
        MotorluTasit motorluTasit = galerideArabaBul(saseNumarasi);
        if (motorluTasit != null) {
            if (musteri.satinAl(motorluTasit)) {
                reader.nextLine();
                System.out.print("Tarihi girin : ");
                String tarih = reader.nextLine();
                galeriBakiyesineEkle(motorluTasit.getFiyati());
                araclar.remove(motorluTasit);
                SatisGecmisi satısGecmisi = new SatisGecmisi("Satış", tarih, musteri, motorluTasit);
                satisGecmisi.add(satısGecmisi);
                System.out.println("Satış Gerçekleştirildi");
            }
        } else {
            System.out.println("Galeride bu araç bulunmamaktadır.");
        }

    }

    void arabaIadeAl() {
        System.out.print("İade yapmak isteyen müşterinin kayıt numarasını girin : ");
        int kayitNumarasi = reader.nextInt();
        Musteri musteri = musteriBul(kayitNumarasi);
        System.out.print("İade alınacak aracın sase numarasını girin : ");
        int saseNumarasi = reader.nextInt();
        MotorluTasit motorluTasit = garajdaArabaBul(musteri, saseNumarasi);
        if (motorluTasit != null) {
            if (galeriBakiyesi >= motorluTasit.getFiyati()) {
                if (musteri.satinAlimiIadeEt(motorluTasit)) {
                    reader.nextLine();
                    System.out.print("Tarihi girin : ");
                    String tarih = reader.nextLine();
                    galeriBakiyesindenCikar(motorluTasit.getFiyati());
                    araclar.add(motorluTasit);
                    SatisGecmisi satısGecmisi = new SatisGecmisi("İade", tarih, musteri, motorluTasit);
                    satisGecmisi.add(satısGecmisi);
                    System.out.println("İade işlemi gerçekleşti");
                }
            } else {
                System.out.println("Galeri bakiyesi yetersiz");
            }
        }
    }

    void arabaKiralama() {
        System.out.print("Kiralama yapmak istediğiniz müşterinin kayıt numarasını girin : ");
        int kayitNumarasi = reader.nextInt();
        Musteri musteri = musteriBul(kayitNumarasi);
        System.out.print("Kiralanacak aracın sase numarasını girin : ");
        int saseNumarasi = reader.nextInt();
        MotorluTasit motorluTasit = galerideArabaBul(saseNumarasi);
        if (motorluTasit != null) {
            reader.nextLine();
            System.out.print("Tarihi girin : ");
            String tarih = reader.nextLine();
            System.out.print("Kiralanacak zamanı girin : ");
            int sure = reader.nextInt();
            int fiyat = motorluTasit.getFiyati() / 500 * sure;
            if (musteri.kiralamayaBasla(motorluTasit, fiyat)) {
                araclar.remove(motorluTasit);
                galeriBakiyesineEkle(fiyat);
                SatisGecmisi satisGecmisi = new SatisGecmisi("Kiralama", tarih, musteri, motorluTasit);
                this.satisGecmisi.add(satisGecmisi);
                System.out.println(motorluTasit.getKilometresi() + " km V" + motorluTasit.getSilindir() + " motor " + motorluTasit.getBeygir() + " hp " + motorluTasit.getCikisYili() + " model " + motorluTasit.getMarka() + " " + motorluTasit.getModel() + ", " + musteri.getAdSoyad() + " adına kiralandı");
            }
        } else {
            System.out.println("Galeride bu araç bulunmamaktadır.");
        }
    }

    void kiralamayiSonlandir() {
        System.out.print("Aracı teslim alacağınız müşterinin kayıt numarasını girin : ");
        int kayitNumarasi = reader.nextInt();
        Musteri musteri = musteriBul(kayitNumarasi);
        System.out.print("Teslim alınacak aracın sase numarasını girin : ");
        int saseNumarasi = reader.nextInt();
        MotorluTasit motorluTasit = garajdaArabaBul(musteri, saseNumarasi);
        musteri.kiralamayiBitir(motorluTasit);
        reader.nextLine();
        System.out.print("Tarihi girin : ");
        String tarih = reader.nextLine();
        SatisGecmisi satisGecmisi = new SatisGecmisi("Kiralama Teslim", tarih, musteri, motorluTasit);
        this.satisGecmisi.add(satisGecmisi);
        araclar.add(motorluTasit);
        System.out.println(musteri.getAdSoyad() + " adına kiralanan, " + motorluTasit.getKilometresi() + " km V" + motorluTasit.getSilindir() + " motor " + motorluTasit.getBeygir() + " hp " + motorluTasit.getCikisYili() + " model " + motorluTasit.getMarka() + " " + motorluTasit.getModel() + " araç teslim alındı");
    }

    void araclariGoruntule() {
        for (int i = 0; i < araclar.size(); i++) {
            System.out.println((i + 1) + " -> " + araclar.get(i));
        }
    }

    void musterileriGoruntule() {
        for (int i = 0; i < musteriler.size(); i++) {
            System.out.println((i + 1) + " -> " + musteriler.get(i));
        }
    }

    void satisGecmisiGoruntule() {
        if (satisGecmisi.size() == 0) {
            System.out.println("***********************    BOŞ    ***********************");
        } else {
            for (int i = 0; i < satisGecmisi.size(); i++) {
                System.out.println((i + 1) + " -> " + satisGecmisi.get(i));
            }
        }
    }

    int menuGoster() {
        System.out.println("***********************    MENÜ   ***********************");
        System.out.println("1  -> Araba ekle");
        System.out.println("2  -> Araba çıkar");
        System.out.println("3  -> Müşteri ekle");
        System.out.println("4  -> Müşteri çıkar");
        System.out.println("5  -> Araba sat");
        System.out.println("6  -> Araba iadesi al");
        System.out.println("7  -> Araba kirala");
        System.out.println("8  -> Kiralanan aracı teslim al");
        System.out.println("9  -> Galeri bakiyesini görüntüle");
        System.out.println("10 -> Galerideki tüm araçların listesini görüntüle");
        System.out.println("11 -> Galerideki kayıtlı müşterilerin listesini görüntüle");
        System.out.println("12 -> Galeri satış geçmişini görüntüle");
        System.out.println("0  -> Çıkış");
        return reader.nextInt();
    }
}
