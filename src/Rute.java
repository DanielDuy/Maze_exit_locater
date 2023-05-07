abstract class Rute {

    private int radNummer;
    private int kolonneNummer;
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
        }
    }
}

/*
        if (fra == naboNord) {
            finn(naboSyd);
            finn(naboVest);
            finn(naboOest);
        } else if (fra == naboSyd) {
            finn(naboNord);

            finn(naboVest);
            finn(naboOest);
        } else if (fra == naboVest) {
            finn(naboNord);
            finn(naboSyd);

            finn(naboOest);
        } else if (fra == naboOest) {
            finn(naboNord);
            finn(naboSyd);
            finn(naboVest);
        }

         */
