package rehber;

import java.util.Scanner;

public class Rehber {

    Scanner reader = new Scanner(System.in);
    Dugum head = null;
    Dugum tail = null;

    void ekle(Dugum dugum) {
        if (head == null) {
            head = dugum;
            tail = dugum;
        } else {
            tail.next = dugum;
            dugum.prive = tail;
            tail = dugum;
        }
    }

    Dugum kayitBilgileri() {
        System.out.println("Eklenecek kaydın bilgilerini girin");
        System.out.print("Kaydın adı: ");
        String ad = reader.next();
        System.out.print("Kaydın soyadı: ");
        String soyad = reader.next();
        System.out.print("Kaydın telefon numarası: ");
        long telefon = reader.nextLong();
        Kisi kisi = new Kisi(ad, soyad, telefon);
        Dugum dugum = new Dugum(kisi);
        return dugum;
    }

    void kayitSil() {
        Dugum temp = head;
        if (temp == null) {
            System.out.println("Rehberde kayıt yok");
        } else if (temp.next == null) {
            head = null;
            System.out.println("Son kayıt silindi");
        } else {
            System.out.print("Telefon girin : ");
            long tel = reader.nextLong();
            while (temp.kisi.getTel() != tel) {
                temp = temp.next;
            }
            temp.prive.next = temp.next;
        }
    }

    void kayitDuzenle() {
        Dugum temp = head;
        if (temp == null) {
            System.out.println("Düzenlenecek kayıt yok");
        } else {
            System.out.print("Düzenlenecek kaydın telefon numarasını girin : ");
            long tel = reader.nextLong();
            while (temp.kisi.getTel() != tel) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Rehberde eşleşen kayıt yok");
            } else {
                System.out.println("Kaydın bilgilerini güncelleyin");
                reader.nextLine();
                System.out.print("Ad : ");
                String ad = reader.nextLine();
                System.out.print("Soyad : ");
                String soyad = reader.nextLine();
                System.out.print("Telefon : ");
                tel = reader.nextLong();
                temp.kisi.setAd(ad);
                temp.kisi.setSoyad(soyad);
                temp.kisi.setTel(tel);
            }
        }
    }

    void kayitYazdir() {
        Dugum temp = head;
        if (temp == null) {
            System.out.println("Rehberde kayıt yok");
        } else {
            System.out.print("Telefon girin : ");
            long tel = reader.nextLong();
            while (temp.kisi.getTel() != tel) {
                temp = temp.next;
            }
            bilgileriGoster(temp);
        }
    }

    void yazdir() {
        Dugum temp = head;
        while (temp != null) {
            bilgileriGoster(temp);
            temp = temp.next;
        }
    }

    void bilgileriGoster(Dugum temp) {
        if (temp.kisi.getAd() != null) {
            System.out.println("*********************************");
            System.out.println(temp.kisi.getAd() + " " + temp.kisi.getSoyad() + "\n0" + temp.kisi.getTel());
            System.out.println("*********************************");
        } else {
            System.out.println("*********************************");
            System.out.println("0" + temp.kisi.getTel());
            System.out.println("*********************************");

        }
    }

    void aramaYap() {
        System.out.print("Arama yapmak istediğiniz numarayı tuşlayın : ");
        long tel = reader.nextLong();
        System.out.println("0" + tel);
        System.out.println("Aranıyor......");
        Kisi kisi = new Kisi(tel);
        Dugum dugum = new Dugum(kisi);
        ekle(dugum);
    }

    int anaSayfa() {
        System.out.println("1- Kayıt ekle");
        System.out.println("2- Kayıt sil");
        System.out.println("3- Kayıt düzenle");
        System.out.println("4- Kayıt ara");
        System.out.println("5- Tüm kayıtları listele");
        System.out.println("6- Arama yap");
        System.out.println("7- Arama geçmişini görüntüle");
        System.out.println("8- Çıkış");
        System.out.print("Lütfen bir seçim yapın: ");
        int secim = reader.nextInt();
        return secim;
    }
}
