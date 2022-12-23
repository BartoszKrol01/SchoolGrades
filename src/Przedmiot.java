import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Przedmiot {

    private int idPrzedmiotu;
    private String nazwaPrzedmiotu;
    private String nazwiskoNauczyciela;
    private String imieNauczyciela;

    public static List<Przedmiot> przedmioty = new ArrayList<>();

    public Przedmiot() {

    }

    public Przedmiot(String linia) {
        super();
        String[] dane = linia.split(";");
        idPrzedmiotu = Integer.parseInt(dane[0]);
        nazwaPrzedmiotu = dane[1];
        nazwiskoNauczyciela = dane[2];
        imieNauczyciela = dane[3];
        przedmioty.add(this);
    }

    public static void zaladujDane(String nazwaPliku) {
        File file = new File(nazwaPliku);
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                new Przedmiot(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Przedmiot [idPrzedmiotu=" + idPrzedmiotu + ", nazwaPrzedmiotu=" + nazwaPrzedmiotu
                + ", nazwiskoNauczyciela=" + nazwiskoNauczyciela + ", imieNauczyciela=" + imieNauczyciela + "]";
    }

    public int getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    public void setIdPrzedmiotu(int idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public String getNazwaPrzedmiotu() {
        return nazwaPrzedmiotu;
    }

    public void setNazwaPrzedmiotu(String nazwaPrzedmiotu) {
        this.nazwaPrzedmiotu = nazwaPrzedmiotu;
    }

    public String getNazwiskoNauczyciela() {
        return nazwiskoNauczyciela;
    }

    public void setNazwiskoNauczyciela(String nazwiskoNauczyciela) {
        this.nazwiskoNauczyciela = nazwiskoNauczyciela;
    }

    public String getImieNauczyciela() {
        return imieNauczyciela;
    }

    public void setImieNauczyciela(String imieNauczyciela) {
        this.imieNauczyciela = imieNauczyciela;
    }

    public static List<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }
}
