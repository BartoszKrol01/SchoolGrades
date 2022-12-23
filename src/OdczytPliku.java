import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OdczytPliku {

    public static void main(String[] args) {

        Uczen.zaladujDane("uczniowie.txt");
//		for(Student student : Student.studenci) {
//			System.out.println(student);
//		}
        Ocena.zaladujDane("oceny.txt");
//		for(Ocena ocena : Ocena.oceny) {
//			System.out.println(ocena);
//		}
        Przedmiot.zaladujDane("przedmioty.txt");
//		for(Przedmiot przedmiot : Przedmiot.przedmioty) {
//			System.out.println(przedmiot);
//		}

//		System.out.println("SREDNIE UCZNIOW");
//		for (Uczen student : Uczen.studenci) {
//			System.out.println(srednieUcznia(student.getIdUcznia()));
//		}

        List<Double> listaSrednich = new ArrayList<>();;
        for(Uczen uczen : Uczen.uczniowie) {
            listaSrednich.add(sredniaSemestralnaUcznia(uczen.getIdUcznia()));
        }

        double sredniaMaks = 0;
        for(Double srednia : listaSrednich) {
//			System.out.println(srednia);
            if(srednia > sredniaMaks) {
                sredniaMaks = srednia;
            }
        }
        System.out.println(sredniaMaks);
    }

    public static double sredniaOcen(int idUcznia, int idPrzedmiotu) {
        long liczbaOcen = 0;
        long sumaOcen = 0;
        List<Integer> oceny = Ocena.oceny
                .stream()
                .filter(ocena -> ocena.getIdPrzedmiotu() == idPrzedmiotu && ocena.getIdUcznia() == idUcznia)
                .map(ocena -> ocena.getOcena())
                .collect(Collectors.toList());
        if(!oceny.isEmpty()) {
            liczbaOcen = oceny.stream().count();
            sumaOcen = oceny.stream().reduce(0, Integer::sum);
        }
        return ((double)sumaOcen)/liczbaOcen;
    }

    public static HashMap<String, Double> srednieUcznia(int idUcznia) {
        double sredniaOcen;
        HashMap<String, Double> index = new HashMap<>();
        for(Przedmiot przedmiot : Przedmiot.przedmioty) {
            sredniaOcen = sredniaOcen(idUcznia, przedmiot.getIdPrzedmiotu());
            if(!(Double.isNaN(sredniaOcen))) {
                index.put(przedmiot.getNazwaPrzedmiotu(), sredniaOcen);
            }
        }
        return index;
    }

    public static double sredniaSemestralnaUcznia(int idUcznia) {
        List<Double> srednie = new ArrayList<>();
        long liczbaSrednich;
        double sumaSrednich;
        double sredniaOcen;
        for(Przedmiot przedmiot : Przedmiot.przedmioty) {
            sredniaOcen = sredniaOcen(idUcznia, przedmiot.getIdPrzedmiotu());
            if(!(Double.isNaN(sredniaOcen))) {
                srednie.add(sredniaOcen(idUcznia, przedmiot.getIdPrzedmiotu()));
            }
        }
        liczbaSrednich = srednie.stream().count();
        sumaSrednich = srednie.stream().reduce(0.0, Double::sum);

        return sumaSrednich/liczbaSrednich;
    }

}


//praca domowa
//253 Barbara Ogoszewska