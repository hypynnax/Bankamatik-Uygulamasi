package filmsitesi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Site site = new Site();
        site.filmEkle("The Avengers", "Macera/Aksiyon/Bilim Kurgu", "Joss Whedon", "MARVEL Studios", "Robert Downey Jr.", "Chirs Hemsworth", "Mark Ruffalo", "Scarlett Johansson", "Jeremy Renner", "Yabancı", "Türkçe", 8.0, 2012, 99.90);
        site.filmEkle("The Maze Runner", "Aksiyon/Bilim Kurgu", "Wes Ball", "Fox", "Dylan O'brien", "Thomas Sangster", "Ki Hong Lee", "Kaya Scodelario", "Will Poulter", "Yabancı", "Türkçe", 8.0, 2014, 79.95);
        site.filmEkle("From", "Korku/Bilim Kurgu", "John Griffin", "Epic Studios", "Harold Perrineau", "Avery Konrat", "Hanna Cheramy", "Eion Biley", "David Alpay", "Yabancı", "Türkçe", 7.6, 2022, 86.99);
        site.kullaniciEkle("Nurullah KARA", "", "3dyrAr", 0, true, true);
        site.kullaniciEkle("Semanur KARA", "", "EKuMse", 546879877, false, true);
        site.kullaniciEkle("Turkan KARA", "", "63mHkM", 0, false, false);
        site.kullaniciEkle("1", "", "1", 0, false, false);
        Kullanici kullanici = null;
        site.anaSayfa();
        int tercih = reader.nextInt();
        switch (tercih) {
            case 1 -> {
                site.uyeOlEkrani();
            }
            case 2 -> {
                kullanici = site.kullaniciGirisi();
            }
            case 3 -> {
                kullanici = site.kullaniciGirisi();
            }
            default -> {
                System.out.println("Doğru bir tercih yapın");
            }
        }
        if (tercih == 1) {
            System.out.println("*************************   Giriş Ekranı    *************************");
            kullanici = site.kullaniciGirisi();
            System.out.println("*********************************************************************");
        }
        if (tercih == 3 && kullanici.kullaniciKontrol(kullanici).equalsIgnoreCase("misafir kullanıcı")) {
            boolean cikis = true;
            while (cikis) {
                site.misafirAnaSayfa(kullanici);
                tercih = reader.nextInt();
                switch (tercih) {
                    case 0 -> {
                        cikis = false;
                    }
                    case 1 -> {
                        System.out.println("Üyelik Yükseltme Ücreti 34.99₺");
                        System.out.print("Onaylamak için 3 basın : ");
                        if (reader.nextInt() == 3) {
                            if (kullanici.uyeOlmaUcretiKontrolu(kullanici, site.getUyelikUcreti())) {
                                site.setSiteBakiyesi(site.getSiteBakiyesi() + site.getUyelikUcreti());
                                System.out.println("Tebrikler üyeliğiniz başarılı bir şekilde gerçekleşti");
                                cikis = false;
                            } else {
                                System.out.println("İşlem Yetersiz Bakiye Nedeni İle İptal Edilmiştir");
                            }
                        }
                    }
                    case 2 -> {
                        site.kutuphaneSayfasi(kullanici);
                    }
                    case 3 -> {
                        site.satinAlmaSayfasi(kullanici);
                    }
                    case 4 -> {
                        site.paraYatir(kullanici);
                    }
                    default -> {
                        System.out.println("Doğru bir tercih yapın");
                    }
                }
            }
        }
        if (kullanici.uyeMi()) {
            boolean cikis = true;
            while (cikis) {
                site.uyeAnaSayfa(kullanici);
                tercih = reader.nextInt();
                switch (tercih) {
                    case 0 -> {
                        cikis = false;
                    }
                    case 1 -> {
                        site.profil(kullanici);
                    }
                    case 2 -> {
                        site.kutuphaneSayfasi(kullanici);
                    }
                    case 3 -> {
                        site.satinAlmaSayfasi(kullanici);
                    }
                    case 4 -> {
                        site.paraYatir(kullanici);
                    }
                    default -> {
                        System.out.println("Doğru bir tercih yapın");
                    }
                }
            }
        }
    }
}
