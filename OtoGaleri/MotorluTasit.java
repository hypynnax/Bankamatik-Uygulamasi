package otogaleri;

public class MotorluTasit {

    private String marka;
    private String model;
    private String tur;
    private Musteri sahip;
    private int saseNumarasi;
    private int cikisYili;
    private int kilometresi;
    private int fiyati;
    private int kmBasinaYakit;
    private int silindir;
    private int beygir;
    private int tekerSayisi;
    private int kapiSayisi;

    public MotorluTasit(String marka, String model, String tur, int saseNumarasi, int cikisYili, int kilometresi, int fiyati, int kmBasinaYakit, int silindir, int beygir, int tekerSayisi, int kapiSayisi) {
        this.marka = marka;
        this.model = model;
        this.tur = tur;
        this.sahip = null;
        this.saseNumarasi = saseNumarasi;
        this.cikisYili = cikisYili;
        this.kilometresi = kilometresi;
        this.fiyati = fiyati;
        this.kmBasinaYakit = kmBasinaYakit;
        this.silindir = silindir;
        this.beygir = beygir;
        this.tekerSayisi = tekerSayisi;
        this.kapiSayisi = kapiSayisi;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public Musteri getSahip() {
        return sahip;
    }

    public void setSahip(Musteri sahip) {
        this.sahip = sahip;
    }

    public int getSaseNumarasi() {
        return saseNumarasi;
    }

    public void setSaseNumarasi(int saseNumarasi) {
        this.saseNumarasi = saseNumarasi;
    }

    public int getCikisYili() {
        return cikisYili;
    }

    public void setCikisYili(int cikisYili) {
        this.cikisYili = cikisYili;
    }

    public int getKilometresi() {
        return kilometresi;
    }

    public void setKilometresi(int kilometresi) {
        if (kilometresi > this.kilometresi) {
            this.kilometresi = kilometresi;
        }
    }

    public int getFiyati() {
        return fiyati;
    }

    public void setFiyati(int fiyati) {
        this.fiyati = fiyati;
    }

    public int getKmBasinaYakit() {
        return kmBasinaYakit;
    }

    public void setKmBasinaYakit(int kmBasinaYakit) {
        this.kmBasinaYakit = kmBasinaYakit;
    }

    public int getSilindir() {
        return silindir;
    }

    public void setSilindir(int silindir) {
        this.silindir = silindir;
    }

    public int getBeygir() {
        return beygir;
    }

    public void setBeygir(int beygir) {
        this.beygir = beygir;
    }

    public int getTekerSayisi() {
        return tekerSayisi;
    }

    public void setTekerSayisi(int tekerSayisi) {
        this.tekerSayisi = tekerSayisi;
    }

    public int getKapiSayisi() {
        return kapiSayisi;
    }

    public void setKapiSayisi(int kapiSayisi) {
        this.kapiSayisi = kapiSayisi;
    }

    @Override
    public String toString() {
        return kilometresi + " km V" + silindir + " motor " + beygir + " hp " + cikisYili + " model " + marka + " " + model
                + "\n      " + fiyati + " ₺"
                + "\n      100 km'de " + kmBasinaYakit + " litre\n";
    }
}
