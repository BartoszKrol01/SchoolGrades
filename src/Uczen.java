import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uczen {

    private int idUcznia;
    private String nazwisko;
    private String imie;
    private String ulica;
    private int dom;
    private String idKlasy;

    public static List<Uczen> uczniowie = new ArrayList<>();

    public Uczen() {

    }

    public Uczen(String linia) {
        super();
        String[] dane = linia.split(";");
        idUcznia = Integer.parseInt(dane[0]);
        nazwisko = dane[1];
        imie = dane[2];
        ulica = dane[3];
        dom = Integer.parseInt(dane[4]);
        idKlasy = dane[5];
        uczniowie.add(this);
    }

    public static void zaladujDane(String nazwaPliku) {
        File file = new File(nazwaPliku);
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                new Uczen(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Student [idUcznia=" + idUcznia + ", nazwisko=" + nazwisko + ", imie=" + imie + ", ulica=" + ulica
                + ", dom=" + dom + ", idKlasy=" + idKlasy + "]";
    }

    public int getIdUcznia() {
        return idUcznia;
    }

    public void setIdUcznia(int idUcznia) {
        this.idUcznia = idUcznia;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getDom() {
        return dom;
    }

    public void setDom(int dom) {
        this.dom = dom;
    }

    public String getIdKlasy() {
        return idKlasy;
    }

    public void setIdKlasy(String idKlasy) {
        this.idKlasy = idKlasy;
    }

    public static List<Uczen> getStudenci() {
        return uczniowie;
    }
}
