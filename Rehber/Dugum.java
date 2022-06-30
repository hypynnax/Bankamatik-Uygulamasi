package rehber;

public class Dugum {

    Kisi kisi = new Kisi();
    Dugum next;
    Dugum prive;

    public Dugum(Kisi kisi) {
        this.kisi = kisi;
        next = null;
        prive = null;
    }
}
