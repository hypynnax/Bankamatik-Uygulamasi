package otogaleri;

public class SatisGecmisi {

    private final String islemNedeni;
    private final String islemTarihi;
    private final Musteri musteri;
    private final MotorluTasit motorluTasit;

    public SatisGecmisi(String islemNedeni, String islemTarihi, Musteri musteri, MotorluTasit motorluTasit) {
        this.islemNedeni = islemNedeni;
        this.islemTarihi = islemTarihi;
        this.musteri = musteri;
        this.motorluTasit = motorluTasit;
    }

    @Override
    public String toString() {
        return "İşlem Nedeni = " + islemNedeni
                + "\n     İşlem Tarihi = " + islemTarihi
                + "\n     Müşteri = " + musteri.getAdSoyad()
                + "\n     Motorlu Taşıt = " + motorluTasit.getKilometresi() + " km V" + motorluTasit.getSilindir() + " motor " + motorluTasit.getBeygir() + " hp " + motorluTasit.getCikisYili() + " model " + motorluTasit.getMarka() + " " + motorluTasit.getModel();
    }
}
