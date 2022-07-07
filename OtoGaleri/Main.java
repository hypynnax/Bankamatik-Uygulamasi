package otogaleri;

public class Main {

    public static void main(String[] args) {
        OtoGaleri otoGaleri = new OtoGaleri();
        Musteri nurullah = new Musteri("Nurullah KARA", "05467963034", 1, 987654321);
        Musteri semanur = new Musteri("Semanur KARA", "05776269064", 2, 1234567890);
        Musteri turkan = new Musteri("Türkan KARA", "05815733445", 3, 315791486);
        Musteri hamza = new Musteri("Hamza KARA", "05480220748", 4, 1510122324);
        Musteri fatma = new Musteri("Fatma KARA", "05849805948", 5, 856412578);
        otoGaleri.stokMusteriler(nurullah);
        otoGaleri.stokMusteriler(semanur);
        otoGaleri.stokMusteriler(turkan);
        otoGaleri.stokMusteriler(hamza);
        otoGaleri.stokMusteriler(fatma);
        MotorluTasit mercedes = new MotorluTasit("Mercedes", "AMG One", "Spor", 123, 2023, 0, 3000000, 10, 6, 556, 4, 5);
        MotorluTasit bmw = new MotorluTasit("BMW", "M5 f90", "Spor", 234, 2017, 0, 2500000, 10, 8, 600, 4, 5);
        MotorluTasit audi = new MotorluTasit("Audi", "RS 8", "Spor", 345, 2022, 0, 2300000, 11, 10, 540, 4, 5);
        MotorluTasit volvo = new MotorluTasit("Volvo", "S90", "Sedan", 456, 2021, 0, 1800000, 6, 4, 235, 4, 5);
        MotorluTasit lamborghini = new MotorluTasit("Lamborghini", "Aventador", "Süper Spor", 567, 2020, 0, 4500000, 26, 12, 700, 4, 2);
        MotorluTasit bugatti = new MotorluTasit("Bugatti", "Chiron", "Süper Spor", 678, 2020, 0, 4580000, 32, 16, 1595, 4, 2);
        MotorluTasit ferrari = new MotorluTasit("Ferrari", "488 Pista", "Süper Spor", 789, 2022, 0, 5000000, 21, 8, 711, 4, 2);
        MotorluTasit yamaha = new MotorluTasit("Yamaha", "R25", "Motor", 890, 2019, 0, 300000, 5, 2, 36, 2, 0);
        MotorluTasit suzuki = new MotorluTasit("Suzuki", "GSX-R 600", "Motor", 901, 2018, 0, 150000, 6, 2, 125, 2, 0);
        MotorluTasit kawasaki = new MotorluTasit("Kawasaki", "Ninja H2R", "Motor", 912, 2021, 0, 250000, 9, 4, 310, 2, 0);
        MotorluTasit honda = new MotorluTasit("Honda", "CBR 1000 RR", "Motor", 823, 2022, 0, 230000, 9, 4, 218, 2, 0);
        otoGaleri.stokArabalar(mercedes);
        otoGaleri.stokArabalar(bmw);
        otoGaleri.stokArabalar(audi);
        otoGaleri.stokArabalar(volvo);
        otoGaleri.stokArabalar(lamborghini);
        otoGaleri.stokArabalar(bugatti);
        otoGaleri.stokArabalar(ferrari);
        otoGaleri.stokArabalar(yamaha);
        otoGaleri.stokArabalar(suzuki);
        otoGaleri.stokArabalar(kawasaki);
        otoGaleri.stokArabalar(honda);
        boolean kontrol = true;
        while (kontrol) {
            switch (otoGaleri.menuGoster()) {
                case 0 -> {
                    kontrol = false;
                }
                case 1 -> {
                    otoGaleri.aracEkle();
                }
                case 2 -> {
                    otoGaleri.aracCikar();
                }
                case 3 -> {
                    otoGaleri.musteriEkle();
                }
                case 4 -> {
                    otoGaleri.musteriCikar();
                }
                case 5 -> {
                    otoGaleri.arabaSat();
                }
                case 6 -> {
                    otoGaleri.arabaIadeAl();
                }
                case 7 -> {
                    otoGaleri.arabaKiralama();
                }
                case 8 -> {
                    otoGaleri.kiralamayiSonlandir();
                }
                case 9 -> {
                    System.out.println("Galeri Bakiyesi : " + otoGaleri.getGaleriBakiyesi() + " ₺");
                }
                case 10 -> {
                    otoGaleri.araclariGoruntule();
                }
                case 11 -> {
                    otoGaleri.musterileriGoruntule();
                }
                case 12 -> {
                    otoGaleri.satisGecmisiGoruntule();
                }
            }
        }
    }
}
