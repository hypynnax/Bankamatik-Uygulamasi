package rehber;

public class Kisi {

    private String ad;
    private String soyad;
    private long tel;

    public Kisi() {
    }

    public Kisi(long tel) {
        this.tel = tel;
    }

    public Kisi(String ad, String soyad, long tel) {
        this.ad = ad;
        this.soyad = soyad;
        this.tel = tel;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }
}
