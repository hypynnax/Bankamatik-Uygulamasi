package bankamatikuygulamasi;

public class Dugum {

    Musteri musteri = new Musteri();

    Dugum next;
    Dugum prev;

    public Dugum(Musteri musteri) {
        this.musteri = musteri;
        next = null;
        prev = null;
    }
}
