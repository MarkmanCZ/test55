import java.time.LocalDate;

public class Navstevnik {

    private String jmeno;
    private String prijmeni;
    private LocalDate datumNavstevy;
    private int pocetKreditu;

    public Navstevnik(String jmeno, String prijmeni, LocalDate datumNavstevy, int pocetKreditu) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNavstevy = datumNavstevy;
        this.pocetKreditu = pocetKreditu;
    }

    public Navstevnik() {

    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public LocalDate getDatumNavstevy() {
        return datumNavstevy;
    }

    public void setDatumNavstevy(LocalDate datumNavstevy) {
        this.datumNavstevy = datumNavstevy;
    }

    public int getPocetKreditu() {
        return pocetKreditu;
    }

    public void setPocetKreditu(int pocetKreditu) {
        this.pocetKreditu = pocetKreditu;
    }
}