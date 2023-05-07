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
        System.out.println("("+radNummer+", "+kolonneNummer+")");
        if (fra == naboNord) {
            naboSyd.finn(this);
            naboVest.finn(this);
            naboOest.finn(this);
        } else if (fra == naboSyd) {
            naboNord.finn(this);

            naboVest.finn(this);
            naboOest.finn(this);
        } else if (fra == naboVest) {
            naboNord.finn(this);
            naboSyd.finn(this);

            naboOest.finn(this);
        } else if (fra == naboOest) {
            naboNord.finn(this);
            naboSyd.finn(this);
            naboVest.finn(this);
        } else {
            naboNord.finn(this);
            naboSyd.finn(this);
            naboVest.finn(this);
            naboOest.finn(this);
        }
    }
}
