package bankamatikuygulamasi;

public class Musteri {

    private String musteriAdi;
    private double bakiye;
    private int sifre;
    private int hesapNumarasi;
    private boolean hesapDurumu;

    public Musteri(String musteriAdi, double bakiye, int sifre, int hesapNumarasi, boolean hesapDurumu) {
        this.musteriAdi = musteriAdi;
        this.bakiye = bakiye;
        this.sifre = sifre;
        this.hesapNumarasi = hesapNumarasi;
        this.hesapDurumu = hesapDurumu;
    }

    public Musteri() {
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiyeArttir(int tutar) {
        bakiye += tutar;
    }

    public void setBakiyeAzalt(int tutar) {
        bakiye -= tutar;
    }

    public int getSifre() {
        return sifre;
    }

    public void setSifre(int sifre) {
        this.sifre = sifre;
    }

    public int getHesapNumarasi() {
        return hesapNumarasi;
    }

    public boolean getHesapDurumu() {
        return hesapDurumu;
    }

    public void setHesapDurumu(boolean hesapDurumu) {
        this.hesapDurumu = hesapDurumu;
    }
}
