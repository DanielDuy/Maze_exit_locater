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
