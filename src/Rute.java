abstract class Rute {

    protected int radNummer;
    protected int kolonneNummer;
    protected Labyrint labyrint;
    protected Rute naboNord;
    protected Rute naboSyd;
    protected Rute naboVest;
    protected Rute naboOest;
    protected boolean gaatGjennom;

    public Rute(int radNummer, int kolonneNummer, Labyrint labyrint) {
        this.radNummer = radNummer;
        this.kolonneNummer = kolonneNummer;
        this.labyrint = labyrint;
        naboNord = null;
        naboSyd = null;
        naboVest = null;
        naboOest = null;
        gaatGjennom = false;
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

    protected void settGaatGjennomTrue() {
        gaatGjennom = true;
    }

    protected void settGaatGjennomFalse() {
        gaatGjennom = false;
    }

    public void finn(Rute fra) {
        if (!gaatGjennom) {
            settGaatGjennomTrue();
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
}
