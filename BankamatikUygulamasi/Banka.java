package bankamatikuygulamasi;

import java.util.Scanner;

public class Banka {

    Scanner reader = new Scanner(System.in);
    Dugum musteri;

    void paraCekme() {
        System.out.print("Lütfen çekmek istediğiniz tutarı giriniz: ");
        int tutar = reader.nextInt();
        if (musteri.musteri.getBakiye() >= tutar) {
            musteri.musteri.setBakiyeAzalt(tutar);
            System.out.println("Para Çekiliyor....");
            System.out.println("İşlem Başarılı");
        } else {
            System.out.println("Yetersiz Bakiye");
        }
    }

    void paraYatirma() {
        System.out.print("Lütfen yatırmak istediğiniz tutarı giriniz: ");
        int tutar = reader.nextInt();
        musteri.musteri.setBakiyeArttir(tutar);
        System.out.println("Para Yatırılıyor...");
        System.out.println("İşlem Başarılı");
    }

    void paraGonderme(Dugum aliciMusteri) {
        System.out.print("Lütfen göndermek istediğiniz tutarı giriniz: ");
        int tutar = reader.nextInt();
        if (musteri.musteri.getBakiye() >= tutar) {
            musteri.musteri.setBakiyeAzalt(tutar);
            aliciMusteri.musteri.setBakiyeArttir(tutar);
            System.out.println("Para Göderiliyor...");
            System.out.println("İşlem Başarılı");
            System.out.println("Senin bakiyen: " + musteri.musteri.getBakiye() + "\nOnun bakiyesi: " + aliciMusteri.musteri.getBakiye());
        } else {
            System.out.println("Yetersiz Bakiye");
        }
    }

    void bakiyeSorgulama() {
        System.out.println("Bakiyeniz: " + musteri.musteri.getBakiye());
    }

    void dovizDonusumu() {
        System.out.println("Dolar Kuru: 14,77");
        System.out.printf("Dolar kuruna göre bakiyeniz: %5.2f$\n", musteri.musteri.getBakiye() / 14, 77);
        System.out.println("Euro Kuru: 16,12");
        System.out.printf("Euro kuruna göre bakiyeniz: %5.2f£\n", musteri.musteri.getBakiye() / 16, 12);
    }

    void sifreDegistirme() {
        System.out.print("Yeni şifreyi girin: ");
        int yeniSifre = reader.nextInt();
        musteri.musteri.setSifre(yeniSifre);
        System.out.println("Şifre başarılı bir şekilde değiştirildi");
    }

    void hesapDurumu() {
        if (musteri.musteri.getHesapDurumu() == false) {
            System.out.println("Hesap bloke edilmiştir");
            System.out.println("En yakın zamanda şubeye gelmeniz gerekmektedir.");
        }
    }

    boolean sifreKontrol(Liste liste, int hesapNumarasi) {
        boolean devamMiTamamMi = false;
        int kontrol = 0;
        while (kontrol < 3) {
            System.out.print("Şifre girin: ");
            int sifre = reader.nextInt();
            musteri = liste.hesapKontrol(hesapNumarasi);
            if (musteri == null) {
                System.out.println("Böyle bir müşteri bulunamadı");
            } else {
                if (musteri.musteri.getSifre() == sifre) {
                    if (musteri.musteri.getHesapDurumu() == true) {
                        System.out.println("Giriş Başarılı");
                        System.out.println("Hoş Geldin " + musteri.musteri.getMusteriAdi());
                        kontrol = 3;
                        devamMiTamamMi = true;
                    } else {
                        hesapDurumu();
                    }
                } else {
                    kontrol += 1;
                    if (kontrol == 3) {
                        System.err.println("Şifre Bloke Edildi");
                        System.out.println("Kart Yutuldu");
                        System.out.println("En yakın zamanda size en yakın şubeye gidin");
                        musteri.musteri.setHesapDurumu(false);
                    } else {
                        System.out.println("Yanlış Şifre");
                    }
                }
            }
        }
        return devamMiTamamMi;
    }
}
