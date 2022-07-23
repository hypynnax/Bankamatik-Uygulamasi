package bankamatikuygulamasi;

public class Liste {

    Dugum head = null;
    Dugum tail = null;

    public Liste() {

    }

    void kayitliMusteriEkle(Dugum dugum) {
        Dugum temp = head;
        if (head == null) {
            head = dugum;
            tail = dugum;
        } else {
            while (temp.musteri.getHesapNumarasi() != dugum.musteri.getHesapNumarasi() && temp.next != null) {
                temp = temp.next;
            }
            if (temp.musteri.getHesapNumarasi() != dugum.musteri.getHesapNumarasi()) {
                tail.next = dugum;
                dugum.prev = tail;
                tail = dugum;
            }
        }
    }

    void musteriEkle(Dugum dugum) {
        if (head == null) {
            head = dugum;
            tail = dugum;
        } else {
            tail.next = dugum;
            dugum.prev = tail;
            tail = dugum;
        }
    }

    void musteriSil(int hesapNumarasi) {
        Dugum temp = head;
        Dugum tempSonrasi = head;
        while (tempSonrasi.musteri.getHesapNumarasi() != hesapNumarasi) {
            temp = tempSonrasi;
            tempSonrasi = tempSonrasi.next;
        }
        temp.next = tempSonrasi.next;
        tempSonrasi.next.prev = temp;
    }

    Dugum hesapKontrol(int hesapNumarasi) {
        Dugum temp = head;
        while (temp.musteri.getHesapNumarasi() != hesapNumarasi) {
            temp = temp.next;
        }
        return temp;
    }

    Dugum aliciHesapBul(int hesapNumarasi) {
        Dugum temp = head;
        while (temp.musteri.getHesapNumarasi() != hesapNumarasi) {
            temp = temp.next;
        }
        return temp;
    }

    void kayitliMusterileriYazdir() {
        Dugum temp = head;
        int i = 1;
        while (temp != null) {
            System.out.println("********************************\n" + i + "  Müşteri adı: " + temp.musteri.getMusteriAdi() + "\n" + "-> Müşteri hesap numarası: " + temp.musteri.getHesapNumarasi());
            temp = temp.next;
            i++;
        }
        System.out.println("********************************");
    }
}
