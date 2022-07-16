package udemykurs;

public class Ders {

    private String dersAdi;
    private int uzunluk;

    public Ders(String dersAdi, int uzunluk) {
        this.dersAdi = dersAdi;
        this.uzunluk = uzunluk;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public int getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(int uzunluk) {
        this.uzunluk = uzunluk;
    }

    @Override
    public String toString() {
        String saat = ((uzunluk / 60 < 10) ? "0" + uzunluk / 60 : "" + uzunluk / 60);
        String dakka = ((uzunluk % 60 < 10) ? "0" + uzunluk % 60 : "" + uzunluk % 60);
        return "Ders = " + dersAdi + "       Süre = " + saat + ":" + dakka + ":00";
    }
}
