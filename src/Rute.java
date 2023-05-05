abstract class Rute {

    private int radNummer;
    private int kolonneNummer;
    private Labyrint labyrint;
    private Rute naboNord;
    private Rute naboSyd;
    private Rute naboVest;
    private Rute naboOest;

    public Rute(int radNummer, int kolonneNummer, Labyrint labyrint) {
        this.radNummer = radNummer;
        this.kolonneNummer = kolonneNummer;
        this.labyrint = labyrint;
        naboNord = null;
        naboSyd = null;
        naboVest = null;
        naboOest = null;
    }

    protected void settNaboNord(Rute naboRute) {
        this.naboOest = naboRute;
    }

    protected void settNaboSyd(Rute naboRute) {
        this.naboSyd = naboRute;
    }

    protected void settNaboVest(Rute naboRute) {
        this.naboVest = naboRute;
    }

    protected void settNaboOest(Rute naboRute) {
        this.naboOest = naboRute;
    }
}
