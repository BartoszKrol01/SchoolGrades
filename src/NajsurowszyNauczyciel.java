import java.util.Arrays;

public class NajsurowszyNauczyciel {

    public double obliczStosunekWystawionychJedynekDoWystawionychOcen(Przedmiot przedmiot) {
        SurowoscNauczyciela surowoscNauczyciela = new SurowoscNauczyciela();

        for(Ocena ocena : Ocena.oceny) {
            if (ocena.getIdPrzedmiotu() == przedmiot.getIdPrzedmiotu()) {
                surowoscNauczyciela.liczbaOcen.add(ocena);
                if(ocena.getOcena() == 1) {
                    surowoscNauczyciela.liczbaJedynek.add(ocena);
                }
            }
            surowoscNauczyciela.obliczStosunek();
        }
        return surowoscNauczyciela.getStosunekJedynekDoWszystkichOcen();
    }

    public void wypiszNajsurowszegoNauczyciela() {
        String[] najsurowszyNauczyciel = new String[2];
        double najwyzszyStosunek = 0;
        double stosunek;
        for(Przedmiot przedmiot : Przedmiot.przedmioty) {
            stosunek = obliczStosunekWystawionychJedynekDoWystawionychOcen(przedmiot);
            if(najwyzszyStosunek < stosunek) {
                najwyzszyStosunek = stosunek;
                najsurowszyNauczyciel[0] = przedmiot.getImieNauczyciela();
                najsurowszyNauczyciel[1] = przedmiot.getNazwiskoNauczyciela();
            }
        }
        System.out.println(Arrays.toString(najsurowszyNauczyciel) + " " + najwyzszyStosunek);

    }
}
