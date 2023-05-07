class HvitRute extends Rute {

    public HvitRute(int radNummer, int kolonneNummer, Labyrint labyrint) {
        super(radNummer, kolonneNummer, labyrint);
    }

    @Override
    public String toString() {
        return ".";
    }

    @Override
    public void finn(Rute fra) {
        System.out.println("("+radNummer+", "+kolonneNummer+")");
        if (fra == this.naboNord) {
            naboSyd.finn(this);
            naboVest.finn(this);
            naboOest.finn(this);
        } else if (fra == this.naboSyd) {
            naboNord.finn(this);

            naboVest.finn(this);
            naboOest.finn(this);
        } else if (fra == this.naboVest) {
            naboNord.finn(this);
            naboSyd.finn(this);

            naboOest.finn(this);
        } else if (fra == this.naboOest) {
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
