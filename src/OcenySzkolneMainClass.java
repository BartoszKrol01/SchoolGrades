import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OcenySzkolneMainClass {

    public static void main(String[] args) {
        NajlepszaSredniaOcen najlepszaSredniaOcen = new NajlepszaSredniaOcen();
        Uczen.zaladujDane("uczniowie.txt");
        Ocena.zaladujDane("oceny.txt");
        Przedmiot.zaladujDane("przedmioty.txt");

        najlepszaSredniaOcen.wypiszNajlepszegoUcznia();
    }
}