package filmsitesi;

import java.util.ArrayList;

class Film {

    private String ad;
    private String tur;
    private String yonetmen;
    private String yapimciSirket;
    private ArrayList<String> oyuncular;
    private String kategori;
    private String dil;
    private double imdb;
    private int cikisYili;
    private double fiyat;

    public Film(String ad, String tur, String yonetmen, String yapimciSirket, String kategori, String dil, double imdb, int cikisYili, double fiyat) {
        this.ad = ad;
        this.tur = tur;
        this.yonetmen = yonetmen;
        this.yapimciSirket = yapimciSirket;
        oyuncular = new ArrayList<>();
        this.kategori = kategori;
        this.dil = dil;
        this.imdb = imdb;
        this.cikisYili = cikisYili;
        this.fiyat = fiyat;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(String yonetmen) {
        this.yonetmen = yonetmen;
    }

    public String getYapimciSirket() {
        return yapimciSirket;
    }

    public void setYapimciSirket(String yapimciSirket) {
        this.yapimciSirket = yapimciSirket;
    }

    public String getOyuncular() {
        String oyuncuListesi = "";
        for (int i = 0; i < oyuncular.size(); i++) {
            oyuncuListesi += oyuncular.get(i);
            if (i != oyuncular.size() - 1) {
                oyuncuListesi += ",";
            }
        }
        return oyuncuListesi;
    }

    public void setOyuncuEkle(String oyuncu) {
        oyuncular.add(oyuncu);
    }

    public void setOyuncuCikar(String oyuncu) {
        oyuncular.remove(oyuncu);
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDil() {
        return dil;
    }

    public void setDil(String dil) {
        this.dil = dil;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public int getCikisYili() {
        return cikisYili;
    }

    public void setCikisYili(int cikisYili) {
        this.cikisYili = cikisYili;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        String tab = "";
        for (int i = 0; i < 54 - getAd().length(); i++) {
            tab += " ";
        }
        return "\n*************************    FİLM BİLGİLERİ  *************************\n"
                + getAd() + tab + "İMDB PUANI : " + getImdb()
                + "\nYönetmen : " + getYonetmen()
                + "\nOyuncular : " + getOyuncular()
                + "\nTür : " + getTur()
                + "\nKategori : " + getKategori()
                + "\nDil : " + getDil()
                + "\nÇıkış Tarihi : " + getCikisYili()
                + "\nYapımcı Şirket : " + getYapimciSirket()
                + "\nFiyatı :                                                         " + getFiyat() + "₺";
    }
}
