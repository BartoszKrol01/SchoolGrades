import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class NajlepszaSredniaOcen {

    public static  HashMap<Uczen,Double> srednieWszystkichUczniow = new HashMap<>();

    public void wypiszNajlepszegoUcznia() {
        for(Uczen uczen : Uczen.uczniowie) {
            wyliczSredniaUcznia(uczen);
        }
        Uczen najlepszyUczen = null;
        double sredniaMaks = 0;
        for(Uczen uczen : Uczen.uczniowie) {
            if(sredniaMaks < srednieWszystkichUczniow.get(uczen)) {
                sredniaMaks = srednieWszystkichUczniow.get(uczen);
                najlepszyUczen = uczen;
            }
        }
        System.out.println(najlepszyUczen + " Średnia: " + sredniaMaks);
    }

    public void wyliczSredniaUcznia(Uczen uczen) {
        List<Double> srednie = new ArrayList<>();
        long liczbaSrednich;
        double sumaSrednich;
        double sredniaOcen;
        for(Przedmiot przedmiot : Przedmiot.przedmioty) {
            sredniaOcen = obliczSredniaOcen(uczen.getIdUcznia(), przedmiot.getIdPrzedmiotu());
            if(!(Double.isNaN(sredniaOcen))) {
                srednie.add(sredniaOcen);
            }
        }
        liczbaSrednich = srednie.size();
        sumaSrednich = srednie.stream().reduce(0.0, Double::sum);
        srednieWszystkichUczniow.put(uczen, sumaSrednich/liczbaSrednich);
    }

    public double obliczSredniaOcen(int idUcznia, int idPrzedmiotu) {
        long liczbaOcen = 0;
        long sumaOcen = 0;
        List<Integer> oceny = Ocena.oceny
                .stream()
                .filter(ocena -> ocena.getIdPrzedmiotu() == idPrzedmiotu && ocena.getIdUcznia() == idUcznia)
                .map(Ocena::getOcena)
                .collect(Collectors.toList());
        if(!oceny.isEmpty()) {
            liczbaOcen = oceny.size();
            sumaOcen = oceny.stream().reduce(0, Integer::sum);
        }
        return ((double)sumaOcen)/liczbaOcen;
    }
}
