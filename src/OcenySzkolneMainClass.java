public class OcenySzkolneMainClass {

    public static void main(String[] args) {
        NajlepszaSredniaOcen najlepszaSredniaOcen = new NajlepszaSredniaOcen();
        NajsurowszyNauczyciel najsurowszyNauczyciel = new NajsurowszyNauczyciel();
        Uczen.zaladujDane("uczniowie.txt");
        Ocena.zaladujDane("oceny.txt");
        Przedmiot.zaladujDane("przedmioty.txt");

        najlepszaSredniaOcen.wypiszNajlepszegoUcznia();
        najsurowszyNauczyciel.wypiszNajsurowszegoNauczyciela();
    }
}