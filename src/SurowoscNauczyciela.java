import java.util.ArrayList;
import java.util.List;

public class SurowoscNauczyciela {

    public List<Ocena> liczbaOcen = new ArrayList<>();
    public List<Ocena> liczbaJedynek = new ArrayList<>();
    private double stosunekJedynekDoWszystkichOcen;

    public void obliczStosunek() {
        stosunekJedynekDoWszystkichOcen = (float)(liczbaJedynek.size())/(float)(liczbaOcen.size());
    }

    public double getStosunekJedynekDoWszystkichOcen() {
        return stosunekJedynekDoWszystkichOcen;
    }

    public void setStosunekJedynekDoWszystkichOcen(double stosunekJedynekDoWszystkichOcen) {
        this.stosunekJedynekDoWszystkichOcen = stosunekJedynekDoWszystkichOcen;
    }
}
