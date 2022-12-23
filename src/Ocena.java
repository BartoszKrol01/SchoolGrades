import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ocena {

    private int idUcznia;
    private int ocena;
    private String data;
    private int idPrzedmiotu;

    public static List<Ocena> oceny = new ArrayList<>();

    public Ocena(String linia) {
        super();
        String[] dane = linia.split(";");
        idUcznia = Integer.parseInt(dane[0]);
        ocena = Integer.parseInt(dane[1]);
        data = dane[2];
        idPrzedmiotu = Integer.parseInt(dane[3]);
        oceny.add(this);
    }

    public static void zaladujDane(String nazwaPliku) {
        File file = new File(nazwaPliku);
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                new Ocena(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Ocena [idUcznia=" + idUcznia + ", ocena=" + ocena + ", data=" + data + ", idPrzedmiotu=" + idPrzedmiotu
                + "]";
    }

    public int getIdUcznia() {
        return idUcznia;
    }

    public void setIdUcznia(int idUcznia) {
        this.idUcznia = idUcznia;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    public void setIdPrzedmiotu(int idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public static List<Ocena> getOceny() {
        return oceny;
    }
}
