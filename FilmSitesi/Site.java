package filmsitesi;

import java.util.ArrayList;
import java.util.Scanner;

public class Site {

    private double siteBakiyesi = 0;
    private double uyelikUcreti = 34.99;
    Scanner reader = new Scanner(System.in);
    private ArrayList<Kullanici> kullanicilar = new ArrayList<>();
    private ArrayList<Film> filmler = new ArrayList<>();

    public double getUyelikUcreti() {
        return uyelikUcreti;
    }

    public void setUyelikUcreti(double uyelikUcreti) {
        this.uyelikUcreti = uyelikUcreti;
    }

    public double getSiteBakiyesi() {
        return siteBakiyesi;
    }

    public void setSiteBakiyesi(double siteBakiyesi) {
        this.siteBakiyesi = siteBakiyesi;
    }

    void kullaniciEkle(String adSoyad, String email, String sifre, long tel, boolean adminMi, boolean uyeMi) {
        Kullanici kullanici = new Kullanici(adSoyad, email, sifre, tel, adminMi, uyeMi);
        kullanicilar.add(kullanici);
    }

    void kullaniciCikar(String adSoyad, String sifre) {
        for (Kullanici kullanici : kullanicilar) {
            if (adSoyad.equalsIgnoreCase(kullanici.getAdSoyad()) && sifre.equalsIgnoreCase(kullanici.getSifre())) {
                kullanicilar.remove(kullanici);
            }
        }
    }

    void filmEkle(String ad, String tur, String yonetmen, String yapimciSirket, String oyuncu1, String oyuncu2, String oyuncu3, String oyuncu4, String oyuncu5, String kategori, String dil, double imdb, int cikisYili, double fiyat) {
        Film film = new Film(ad, tur, yonetmen, yapimciSirket, kategori, dil, imdb, cikisYili, fiyat);
        film.setOyuncuEkle(oyuncu1);
        film.setOyuncuEkle(oyuncu2);
        film.setOyuncuEkle(oyuncu3);
        film.setOyuncuEkle(oyuncu4);
        film.setOyuncuEkle(oyuncu5);
        filmler.add(film);
    }

    void filmCikar(Film film) {
        filmler.remove(film);
    }

    void anaSayfa() {
        System.out.println("Çıkış için her zaman 0 basın");
        System.out.println("                                            Üye Ol : 1  Üye Girişi : 2"
                + "\n                                            Üye Olmadan Devam Et   : 3");
        for (int i = 0; i < filmler.size(); i++) {
            System.out.println(filmler.get(i).toString());
        }
    }

    void uyeOlEkrani() {
        boolean kontrol = false;
        while (!kontrol) {
            System.out.print("AD : ");
            String ad = reader.nextLine();
            System.out.print("E-mail : ");
            String email = reader.nextLine();
            System.out.print("Telefon Numarası : ");
            long telefonNumarasi = reader.nextLong();
            System.out.println("Önerilen Şifre : " + sifreUretme());
            reader.nextLine();
            System.out.print("Sifre : ");
            String sifre = reader.nextLine();
            if (sifreKontrol(sifre)) {
                if (!kullaniciVarmi(ad, sifre)) {
                    kullaniciEkle(ad, email, sifre, telefonNumarasi, false, true);
                    kontrol = true;
                } else {
                    System.out.println("Alınmış İsim\nYeni bir isim girin");
                }
            } else {
                System.out.println("Kriterlere uygun bir şifre girin");
            }
        }
    }

    boolean kullaniciVarmi(String ad, String sifre) {
        boolean sonuc = false;
        for (Kullanici kullanici : kullanicilar) {
            if (kullanici.getAdSoyad().equalsIgnoreCase(ad) && kullanici.getSifre().equalsIgnoreCase(sifre)) {
                sonuc = true;
                return sonuc;
            }
        }
        return sonuc;
    }

    Kullanici kullaniciBul(String ad, String sifre) {
        Kullanici bulunanKullanici = null;
        for (Kullanici kullanici : kullanicilar) {
            if (kullanici.getAdSoyad().equalsIgnoreCase(ad) && kullanici.getSifre().equalsIgnoreCase(sifre)) {
                bulunanKullanici = kullanici;
                break;
            }
        }
        return bulunanKullanici;
    }

    String sifreUretme() {
        String sifre = "";
        for (int i = 0; i < 6; i++) {
            int rastgele = (int) (Math.random() * 94) + 33;
            sifre += (char) rastgele;
        }
        return sifre;
    }

    boolean sifreKontrol(String sifre) {
        boolean sonuc = true;
        {
            if (sifre.length() < 6) {
                System.out.println("Lütfen en az 6 karekter uzunluğunda bir şifre girin");
                sonuc = false;
            }
        }
        {
            byte kontrol = 0;
            for (int i = 0; i < sifre.length(); i++) {
                for (int j = 48; j < 58; j++) {
                    if ((int) sifre.charAt(i) == j) {
                        kontrol += 1;
                    }
                }
            }
            for (int i = 0; i < sifre.length(); i++) {
                for (int j = 65; j < 91; j++) {
                    if ((int) sifre.charAt(i) == j) {
                        kontrol += 1;
                    }
                }
            }
            for (int i = 0; i < sifre.length(); i++) {
                for (int j = 97; j < 123; j++) {
                    if ((int) sifre.charAt(i) == j) {
                        kontrol += 1;
                    }
                }
            }
            if (kontrol != sifre.length()) {
                System.out.println("Lütfen yanlızca sayı veya harflerden oluşan bir şifre girin");
                sonuc = false;
            }
        }
        {
            byte kontrol = 0;
            for (int i = 0; i < sifre.length(); i++) {
                for (int j = 48; j < 58; j++) {
                    if ((int) sifre.charAt(i) == j) {
                        kontrol += 1;
                    }
                }
            }
            if (kontrol < 2) {
                System.out.println("Lütfen en az iki sayı içeren bir şifre giriniz");
                sonuc = false;
            }
        }
        return sonuc;
    }

    Kullanici kullaniciGirisi() {
        boolean kontrol = true;
        while (kontrol) {
            System.out.print("Ad : ");
            String ad = reader.nextLine();
            System.out.print("Sifre : ");
            String sifre = reader.nextLine();
            if (kullaniciVarmi(ad, sifre)) {
                kontrol = false;
                return kullaniciBul(ad, sifre);
            } else {
                System.out.println("Yanlış Giriş Bilgileri");
            }
        }
        return null;
    }

    void kutuphaneSayfasi(Kullanici kullanici) {
        System.out.println("****************************    KÜTÜPHANE    ****************************");
        System.out.println(kullanici.getSahipOlduguFilmler());
    }

    void misafirAnaSayfa(Kullanici kullanici) {
        System.out.print("                                              Üyeliğini Yükselt : 1"
                + "\n                                              Kütüphanem        : 2"
                + "\n                                              Film Satın Al     : 3"
                + "\n                                              Para Yatır        : 4"
                + "\n                                              Bakiye            : ");
        System.out.printf("%.2f₺", kullanici.getBakiye());
        for (int i = 0; i < filmler.size(); i++) {
            System.out.println(filmler.get(i).toString());
        }
    }

    void uyeAnaSayfa(Kullanici kullanici) {
        System.out.print("                                              Profil            : 1"
                + "\n                                              Kütüphanem        : 2"
                + "\n                                              Film Satın Al     : 3"
                + "\n                                              Para Yatır        : 4"
                + "\n                                              Bakiye            : ");
        System.out.printf("%.2f₺", kullanici.getBakiye());
        for (int i = 0; i < filmler.size(); i++) {
            System.out.println(filmler.get(i).toString());
        }
    }

    void profil(Kullanici kullanici) {
        System.out.println(kullanici);
    }

    void paraYatir(Kullanici kullanici) {
        System.out.print("Yatırmak istediğiniz tutarı girin : ");
        int tutar = reader.nextInt();
        System.out.println("İşlem Başarılı");
        kullanici.setBakiye(kullanici.getBakiye() + tutar);
    }

    void satinAlmaSayfasi(Kullanici kullanici) {
        for (int i = 0; i < filmler.size(); i++) {
            String tab = "";
            for (int j = 0; j < 61 - filmler.get(i).getAd().length(); j++) {
                tab += " ";
            }
            System.out.print(i + 1 + "-> " + filmler.get(i).getAd() + tab);
            System.out.printf("%.2f₺\n", filmler.get(i).getFiyat());
        }
        System.out.print("Almak istediğiniz film numarasını girin : ");
        int filmNumarasi = reader.nextInt();
        kullanici.filmSatinAl(filmler.get(filmNumarasi - 1));
    }

    void iadeEtmeSayfasi(Kullanici kullanici) {
        for (int i = 0; i < filmler.size(); i++) {
            System.out.printf("%d-> %s", i + 1, filmler.get(i).getAd());
        }
        System.out.print("İade etmek istediğiniz film numarasını girin : ");
        int filmNumarasi = reader.nextInt();
        kullanici.filmIadeEt(filmler.get(filmNumarasi - 1));
    }
}
