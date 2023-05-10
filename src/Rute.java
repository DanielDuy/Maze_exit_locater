abstract class Rute {

    protected int radNummer;
    protected int kolonneNummer;
    private Labyrint labyrint;
    protected Rute naboNord;
    protected Rute naboSyd;
    protected Rute naboVest;
    protected Rute naboOest;

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
        this.naboNord = naboRute;
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

    public void finn(Rute fra) {
        if (naboNord != fra) {
            naboNord.finn(this);
        }
        if (naboSyd != fra) {
            naboSyd.finn(this);
        }
        if (naboVest != fra) {
            naboVest.finn(this);
        }
        if (naboOest != fra) {
            naboOest.finn(this);
        }
    }
}
