package udemykurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    Scanner reader = new Scanner(System.in);
    ArrayList<Kurs> kurslarinListesi = new ArrayList<>();
    HashMap<Integer, Kisi> kisilerinListesi = new HashMap<>();
    HashMap<Integer, Integer> parolaListesi = new HashMap<>();
    private static int cikis = 1;
    private Kisi kullanici;

    void acilisPaketi() {
        Egitmen nurullahEgitmen = new Egitmen("Nurullah KARA", 1, 123, parolaListesi);
        Egitmen turkanEgitmen = new Egitmen("Türkan KARA", 2, 234, parolaListesi);
        Egitmen hamzaEgitmen = new Egitmen("Hamza KARA", 3, 345, parolaListesi);
        kisilerinListesi.put(1, nurullahEgitmen);
        kisilerinListesi.put(2, turkanEgitmen);
        kisilerinListesi.put(3, hamzaEgitmen);
        Ogrenci semanurOgrenci = new Ogrenci("Semanur KARA", 4, 456, parolaListesi);
        Ogrenci mehdiyanurOgrenci = new Ogrenci("Mehdiyanur KARA", 5, 567, parolaListesi);
        Ogrenci esmaOgrenci = new Ogrenci("Esma KARA", 6, 678, parolaListesi);
        kisilerinListesi.put(4, semanurOgrenci);
        kisilerinListesi.put(5, mehdiyanurOgrenci);
        kisilerinListesi.put(6, esmaOgrenci);

        Kurs javaKursu = new Kurs("Java Öğreniyorum", kurslarinListesi);
        nurullahEgitmen.kursEkle(javaKursu);
        Kurs derinOgrenmeKursu = new Kurs("Deep Learning ve Mantığı", kurslarinListesi);
        turkanEgitmen.kursEkle(derinOgrenmeKursu);
        Kurs siberGuvenlikKursu = new Kurs("Hacker mı olmak istiyorum?", kurslarinListesi);
        hamzaEgitmen.kursEkle(siberGuvenlikKursu);

        Ders javaDersleri1 = new Ders("Neden Java?", 8);
        Ders javaDersleri2 = new Ders("Java Kullanım Alanları", 10);
        Ders javaDersleri3 = new Ders("Java'nın Avantaj ve Dezavantajları", 6);
        Ders javaDersleri4 = new Ders("Java ile kavramlar", 25);
        Ders javaDersleri5 = new Ders("Java'nın tüm kütüphanesi", 46);
        Ders javaDersleri6 = new Ders("Java Proje Fikirleri", 9);
        Ders javaDersleri7 = new Ders("Diğer Kursların Tanıtımı", 3);
        javaKursu.dersEkle(javaDersleri1);
        javaKursu.dersEkle(javaDersleri2);
        javaKursu.dersEkle(javaDersleri3);
        javaKursu.dersEkle(javaDersleri4);
        javaKursu.dersEkle(javaDersleri5);
        javaKursu.dersEkle(javaDersleri6);
        javaKursu.dersEkle(javaDersleri7);

        Ders derinOgrenmeDersleri1 = new Ders("Derin Öğrenme ve Makine Öğrenmesi Arasındaki farklar", 10);
        Ders derinOgrenmeDersleri2 = new Ders("Derin Öğrenme Mantığı", 30);
        Ders derinOgrenmeDersleri3 = new Ders("Yapay Zeka, İnsan Zekasını Geçebilecek Mi?", 25);
        Ders derinOgrenmeDersleri4 = new Ders("İleri Derin Öğrenme Teknikleri", 43);
        derinOgrenmeKursu.dersEkle(derinOgrenmeDersleri1);
        derinOgrenmeKursu.dersEkle(derinOgrenmeDersleri2);
        derinOgrenmeKursu.dersEkle(derinOgrenmeDersleri3);
        derinOgrenmeKursu.dersEkle(derinOgrenmeDersleri4);

        Ders siberGuvenlikDersleri1 = new Ders("Siber Güvenlik Nedir?", 7);
        Ders siberGuvenlikDersleri2 = new Ders("Siber Güvenlik Alanları", 10);
        Ders siberGuvenlikDersleri3 = new Ders("Bir Siber Güvenlik Uzmanının Hayatı", 60);
        Ders siberGuvenlikDersleri4 = new Ders("Siber Güvenlik Uzmanlarının Türleri", 25);
        siberGuvenlikKursu.dersEkle(siberGuvenlikDersleri1);
        siberGuvenlikKursu.dersEkle(siberGuvenlikDersleri2);
        siberGuvenlikKursu.dersEkle(siberGuvenlikDersleri3);
        siberGuvenlikKursu.dersEkle(siberGuvenlikDersleri4);
    }

    void girisEkrani() {
        while (cikis != 0) {
            System.out.println("Çıkmak için herzaman 0");
            System.out.println("1-> Eğitmen girişi");
            System.out.println("2-> Öğrenci girişi");
            System.out.print("Giriş tipini seçin : ");
            int tercih = reader.nextInt();
            if (tercih == 0) {
                cikis = 0;
            } else if (tercih == 1) {
                System.out.print("Hesap numarasını girin : ");
                int hesapNo = reader.nextInt();
                System.out.print("Parolayı girin : ");
                int parola = reader.nextInt();
                if (parolaListesi.containsKey(parola) == true && parolaListesi.get(parola) == hesapNo) {
                    if (kisilerinListesi.get(hesapNo) instanceof Egitmen) {
                        kullanici = kisilerinListesi.get(hesapNo);
                        egitmenAnaSayfa();
                    } else {
                        System.out.println("Lütfen geçerli giriş ekranına gidiniz");
                    }
                } else {
                    System.out.println("Geçersiz paralo veya hesap numarası");
                }
            } else if (tercih == 2) {
                System.out.print("Hesap numarasını girin : ");
                int hesapNo = reader.nextInt();
                System.out.print("Parolayı girin : ");
                int parola = reader.nextInt();
                if (parolaListesi.containsKey(parola) == true && parolaListesi.get(parola) == hesapNo) {
                    if (kisilerinListesi.get(hesapNo) instanceof Ogrenci) {
                        kullanici = kisilerinListesi.get(hesapNo);
                        ogrenciAnaSayfa();
                    } else {
                        System.out.println("Lütfen geçerli giriş ekranına gidiniz");
                    }
                } else {
                    System.out.println("Geçersiz paralo veya hesap numarası");
                }
            } else {
                System.out.println("Geçersiz giridi");
            }
        }
    }

    void egitmenAnaSayfa() {
        while (cikis != 0) {
            System.out.println("1-> Kurs ekle");
            System.out.println("2-> Kursları görüntüle");
            int tercih = reader.nextInt();
            if (tercih == 0) {
                cikis = 0;
            } else if (tercih == 1) {
                kursEklemeSayfasi();
            } else if (tercih == 2) {
                kullanici.kurslariGoruntule();
            } else {
                System.out.println("Geçersiz giridi");
            }
        }
    }

    void ogrenciAnaSayfa() {
        while (cikis != 0) {
            System.out.println("1-> Kurs Al");
            System.out.println("2-> Kursları görüntüle");
            int tercih = reader.nextInt();
            if (tercih == 0) {
                cikis = 0;
            } else if (tercih == 1) {
                kursAl();
            } else if (tercih == 2) {
                kullanici.kurslariGoruntule();
                if (kullanici.getKurslar().size() > 0) {
                    System.out.print("İzlemek istediğiniz kursun numarasını girin : ");
                    int kursSirasi = reader.nextInt();
                    int dersSirasi = 0;
                    System.out.println("Kursları izlemek için 8(yukarı)/2(aşağı) basın");
                    System.out.println("Dersleri izlemek için 4(geri)/6(ileri) basın");
                    if (kursSirasi > 0 && kursSirasi <= kullanici.getKurslar().size()) {
                        Ogrenci ogrenci = (Ogrenci) kullanici;
                        ogrenci.dersOynat(--kursSirasi, 0);
                        while (cikis != 0) {
                            int hareket = reader.nextInt();
                            if (hareket == 8) {
                                if (kursSirasi == 0) {
                                    System.out.println("Kurslar listesinin başındasın");
                                } else {
                                    ogrenci.dersOynat(--kursSirasi, 0);
                                    dersSirasi = 0;
                                }
                            } else if (hareket == 2) {
                                if (kursSirasi == kullanici.getKurslar().size() - 1) {
                                    System.out.println("Kurslar listesinin sonundasın");
                                } else {
                                    ogrenci.dersOynat(++kursSirasi, 0);
                                    dersSirasi = 0;
                                }
                            } else if (hareket == 4) {
                                if (dersSirasi == 0) {
                                    System.out.println("Dersler listesinin başındasın");
                                } else {
                                    ogrenci.dersOynat(kursSirasi, --dersSirasi);
                                }
                            } else if (hareket == 6) {
                                if (dersSirasi == kullanici.getKurslar().get(kursSirasi).getDersler().size() - 1) {
                                    System.out.println("Dersler listesinin sonundasın");
                                } else {
                                    ogrenci.dersOynat(kursSirasi, ++dersSirasi);
                                }
                            } else if (hareket == 0) {
                                cikis = 0;
                            }
                        }
                    } else {
                        System.out.println("Geçerli bir sayı girin");
                    }
                } else {
                    System.out.println("Kütüphane boş");
                }
            } else {
                System.out.println("Geçersiz giridi");
            }
        }
    }

    void dersEklemeSayfasi(Kurs kurs) {
        reader.nextLine();
        System.out.print("Ders adı : ");
        String dersAdi = reader.nextLine();
        System.out.print("Ders süresi : ");
        int dersSuresi = reader.nextInt();
        Ders ders = new Ders(dersAdi, dersSuresi);
        kurs.dersEkle(ders);
    }

    void kursEklemeSayfasi() {
        reader.nextLine();
        System.out.print("Eklenecek kursun adı : ");
        String kursAdi = reader.nextLine();
        Kurs kurs = new Kurs(kursAdi, kurslarinListesi);
        System.out.print("Kaç derslik bir kurs olduğunu girin : ");
        int dersSayisi = reader.nextInt();
        for (int i = 0; i < dersSayisi; i++) {
            dersEklemeSayfasi(kurs);
        }
        if (kurs.getToplamKursSüresi() / 60 >= 1 && kurs.getDersler().size() >= 5) {
            kurs.setAktifKurs(true);
        }
        if (kurs.isAktifKurs() == true) {
            kullanici.kursEkle(kurs);
        } else {
            System.out.println("Kurs yetersiz video veya süreden dolayı eklenmedi");
        }
    }

    void kursAl() {
        Iterator<Kurs> iterator = kurslarinListesi.iterator();
        int inciKurs = 1;
        while (iterator.hasNext()) {
            System.out.println(inciKurs + ". " + iterator.next());
            inciKurs++;
        }
        System.out.print("Almak istediğiniz kurs numarasını girin : ");
        int kursSirasi = reader.nextInt();
        if (kursSirasi > 0 && kursSirasi <= kurslarinListesi.size()) {
            kullanici.kursEkle(kurslarinListesi.get(kursSirasi - 1));
        } else {
            System.out.println("Geçerli bir sayı girin");
        }
    }

    public static void main(String[] args) {
        Main udemy = new Main();
        udemy.acilisPaketi();
        udemy.girisEkrani();
    }
}
