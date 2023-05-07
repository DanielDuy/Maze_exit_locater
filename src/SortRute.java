class SortRute extends Rute {

    public SortRute(int radNummer, int kolonneNummer, Labyrint labyrint) {
        super(radNummer, kolonneNummer, labyrint);
    }

    @Override
    public String toString() {
        return "#";
    }

    @Override
    public void finn(Rute fra) {
        return;
    }
}
