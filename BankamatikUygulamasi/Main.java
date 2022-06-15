package bankamatikuygulamasi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Musteri musteri1 = new Musteri("Nurullah KARA", 1000000.0, 123456, 1, true);
        Musteri musteri2 = new Musteri("Cengizhan BAYRAK", 1000000.0, 654321, 2, true);
        Musteri musteri3 = new Musteri("Semanur KARA", 1000000.0, 415263, 3, true);
        Dugum dugum1 = new Dugum(musteri1);
        Dugum dugum2 = new Dugum(musteri2);
        Dugum dugum3 = new Dugum(musteri3);
        Liste liste = new Liste();
        Liste kayitliMusteriler = new Liste();
        liste.musteriEkle(dugum1);
        liste.musteriEkle(dugum2);
        liste.musteriEkle(dugum3);
        System.out.print("Hesap numaranızı girin: ");
        int hesapNumarasi = reader.nextInt();
        Banka banka = new Banka();
        if (banka.sifreKontrol(liste, hesapNumarasi) == true) {
            boolean karar = false;
            while (karar != true) {
                System.out.println("1-Para Çekme");
                System.out.println("2-Para Yatırma");
                System.out.println("3-Para Gönderme(EFT-Havale)");
                System.out.println("4-Bakiye Sorgulama");
                System.out.println("5-Döviz Dönüşümü");
                System.out.println("6-Şifre Değiştirme");
                System.out.println("7-Çıkış");
                System.out.print("Lütfen bir seçim yapın: ");
                int secim = reader.nextInt();
                switch (secim) {
                    case 1:
                        banka.paraCekme();
                        break;
                    case 2:
                        banka.paraYatirma();
                        break;
                    case 3:
                        kayitliMusteriler.kayitliMusterileriYazdir();
                        System.out.print("Lütfen göndermek istediğiniz hesap numarasını girin: ");
                        int alicininHesapNumarasi = reader.nextInt();
                        Dugum aliciHesap = liste.aliciHesapBul(alicininHesapNumarasi);
                        Dugum dugum4 = new Dugum(aliciHesap.musteri);
                        kayitliMusteriler.kayitliMusteriEkle(dugum4);
                        banka.paraGonderme(aliciHesap);
                        break;
                    case 4:
                        banka.bakiyeSorgulama();
                        break;
                    case 5:
                        banka.dovizDonusumu();
                        break;
                    case 6:
                        banka.sifreDegistirme();
                        break;
                    case 7:
                        System.out.println("Lütfen kartınızı almayı unutmayın");
                        karar = true;
                        break;
                    default:
                        System.out.println("Lütfen geçerli bir seçim yapın");
                }
            }
        }
    }
}
