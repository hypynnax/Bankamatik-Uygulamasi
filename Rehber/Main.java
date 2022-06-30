package rehber;

public class Main {

    public static void main(String[] args) {
        Rehber rehber = new Rehber();
        Rehber aramaGecmisi = new Rehber();
        boolean control = false;
        while (control != true) {
            switch (rehber.anaSayfa()) {
                case 1 -> {
                    rehber.ekle(rehber.kayitBilgileri());
                }
                case 2 -> {
                    rehber.kayitSil();
                }
                case 3 -> {
                    rehber.kayitDuzenle();
                }
                case 4 -> {
                    rehber.kayitYazdir();
                }
                case 5 -> {
                    rehber.yazdir();
                }
                case 6 -> {
                    rehber.yazdir();
                    aramaGecmisi.aramaYap();
                }
                case 7 -> {
                    aramaGecmisi.yazdir();
                }
                case 8 -> {
                    control = true;
                }
                default ->
                    System.out.println("Lütfen geçerli bir sayı girin");
            }
        }
    }
}
