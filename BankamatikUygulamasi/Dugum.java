package bankamatikuygulamasi;

public class Dugum {

    Musteri musteri = new Musteri();

    Dugum next;
    Dugum prive;

    public Dugum(Musteri musteri) {
        this.musteri = musteri;
        next = null;
        prive = null;
    }
}
