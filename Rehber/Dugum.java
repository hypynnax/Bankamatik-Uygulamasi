package rehber;

public class Dugum {

    Kisi kisi = new Kisi();
    Dugum next;
    Dugum prev;

    public Dugum(Kisi kisi) {
        this.kisi = kisi;
        next = null;
        prev = null;
    }
}
