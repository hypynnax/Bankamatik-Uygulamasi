package otogaleri;

import java.util.ArrayList;

public class Musteri {

    private String adSoyad;
    private String telefonNumarasi;
    private int bakiye;
    private int kayitNumarasi;
    private ArrayList<MotorluTasit> motorluTasitlarim;

    public Musteri(String adSoyad, String telefonNumarasi, int kayitNumarasi, int bakiye) {
        this.adSoyad = adSoyad;
        this.telefonNumarasi = telefonNumarasi;
        this.bakiye = bakiye;
        this.kayitNumarasi = kayitNumarasi;
        this.motorluTasitlarim = new ArrayList<>();
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(String telefonNumarasi) {
        if (telefonNumarasi.length() == 11) {
            this.telefonNumarasi = telefonNumarasi;
        } else {
            System.out.println("Yanlış telefon numarası\nLütfen başında 0 olacak şekilde tuşlayınız");
        }
    }

    public int getBakiye() {
        return bakiye;
    }

    public void bakiyeEkle(int bakiye) {
        if (bakiye > 0) {
            this.bakiye += bakiye;
        } else {
            System.out.println("Geçerli bir bakiye girin");
        }
    }

    public void bakiyeCikar(int bakiye) {
        if (this.bakiye >= bakiye) {
            this.bakiye -= bakiye;
        }
    }

    public int getKayitNumarasi() {
        return kayitNumarasi;
    }

    public void setKayitNumarasi(int kayitNumarasi) {
        this.kayitNumarasi = kayitNumarasi;
    }

    public ArrayList<MotorluTasit> getMotorluTasitlarim() {
        return motorluTasitlarim;
    }

    public void motorluTasitlarimaEkle(MotorluTasit motorluTasit) {
        motorluTasitlarim.add(motorluTasit);
    }

    public void motorluTasitlarimdanCikar(MotorluTasit motorluTasit) {
        motorluTasitlarim.remove(motorluTasit);
    }

    boolean satinAl(MotorluTasit motorluTasit) {
        if (bakiye >= motorluTasit.getFiyati()) {
            if (!motorluTasitlarim.contains(motorluTasit)) {
                bakiyeCikar(motorluTasit.getFiyati());
                motorluTasitlarimaEkle(motorluTasit);
                return true;
            } else {
                System.out.println("Bu araç zaten garajda mevcut");
                return false;
            }
        } else {
            System.out.println("Yetersiz bakiye nedeni ile işlem iptal edildi");
            return false;
        }
    }

    boolean satinAlimiIadeEt(MotorluTasit motorluTasit) {
        if (motorluTasitlarim.contains(motorluTasit)) {
            bakiyeEkle(motorluTasit.getFiyati());
            motorluTasitlarim.remove(motorluTasit);
            return true;
        } else {
            System.out.println("Böyle bir araç garajda mevcut değil");
            return false;
        }
    }

    boolean kiralamayaBasla(MotorluTasit motorluTasit, int fiyat) {
        if (bakiye >= motorluTasit.getFiyati()) {
            bakiyeCikar(fiyat);
            motorluTasitlarimaEkle(motorluTasit);
            return true;
        } else {
            System.out.println("Yetersiz bakiye");
            return false;
        }
    }

    void kiralamayiBitir(MotorluTasit motorluTasit) {
        motorluTasitlarim.remove(motorluTasit);
    }

    @Override
    public String toString() {
        return "Ad Soyad = " + adSoyad
                + "\n     Telefon Numarası = " + telefonNumarasi
                + "\n     Bakiye = " + bakiye + "₺"
                + "\n     Sahip olduğu araçlar ;\n" + motorluTasitlarim;
    }
}
