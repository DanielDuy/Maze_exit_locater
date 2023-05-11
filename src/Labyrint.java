import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

class Labyrint {

    private Rute[][] labyrint;
    private int antallRader;
    private int antallKolonner;

    public Labyrint(String filnavn) {
        try {
            File fil = new File(filnavn);
            Scanner scanner = new Scanner(fil);

            String[] forsteLinje = scanner.nextLine().split(" ");
            antallRader = Integer.parseInt(forsteLinje[0]);
            antallKolonner = Integer.parseInt(forsteLinje[1]);

            labyrint = new Rute[antallRader][antallKolonner];

            int radTeller = 0;

            while (scanner.hasNextLine()) {
                String[] radAvRuter = scanner.nextLine().split("");

                if (radAvRuter.length != antallKolonner) {
                    throw new Exception("Antall kolonner oppgitt, er ikke lik antall kolonner i labyrinten.");
                }

                for (int i = 0; i < radAvRuter.length; i++) {
                    if (Objects.equals(radAvRuter[i], "#")) {
                        SortRute nySortRute = new SortRute(radTeller, i, this);
                        settInnRute(radTeller, i, nySortRute);

                    } else if (Objects.equals(radAvRuter[i], ".")) {
                        if (i == 0 || i == (radAvRuter.length-1) || radTeller == 0 || radTeller == (antallRader-1)) {
                            Aapning nyAapning = new Aapning(radTeller, i, this);
                            settInnRute(radTeller, i, nyAapning);
                        } else {
                            HvitRute nyHvitRute = new HvitRute(radTeller, i, this);
                            settInnRute(radTeller, i, nyHvitRute);
                        }

                    } else {
                        throw new Exception("Ugyldig tegn i labyrinten.");
                    }
                }

                radTeller += 1;
            }

            if (radTeller != antallRader) {
                throw new Exception("Antall rader oppgitt, er ikke lik antall rader i labyrinten.");
            }

            scanner.close();

            settNaboer();

        } catch (FileNotFoundException e) {
            System.out.println("Noe gikk galt med lesing av filen.");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void settInnRute(int radRute, int kolRute, Rute ruteObjekt) {
        labyrint[radRute][kolRute] = ruteObjekt;
    }

    private Rute hentRute(int rad, int kolonne) {
        return labyrint[rad][kolonne];
    }

    private void settNaboer() {

        // Hjørnene.
        hentRute(0, 0).settNaboSyd(hentRute(1, 0));
        hentRute(0, 0).settNaboOest(hentRute(0, 1));

        hentRute(0, antallKolonner-1).settNaboVest(hentRute(0, antallKolonner-2));
        hentRute(0, antallKolonner-1).settNaboSyd(hentRute(1, antallKolonner-1));

        hentRute(antallRader-1, 0).settNaboNord(hentRute(antallRader-2, 0));
        hentRute(antallRader-1, 0).settNaboOest(hentRute(antallRader-1, 1));

        hentRute(antallRader-1, antallKolonner-1).settNaboNord(hentRute(antallRader-2, antallKolonner-1));
        hentRute(antallRader-1, antallKolonner-1).settNaboVest(hentRute(antallRader-1, antallKolonner-2));

        // Øvre siden.
        for (int i = 1; i < antallKolonner-1; i++) {
            hentRute(0, i).settNaboSyd(hentRute(1, i));
            hentRute(0, i).settNaboVest(hentRute(0, i-1));
            hentRute(0, i).settNaboOest(hentRute(0, i+1));
        }

        // Nedre siden.
        for (int i = 1; i < antallKolonner-1; i++) {
            hentRute(antallRader-1, i).settNaboNord(hentRute(antallRader-2, i));
            hentRute(antallRader-1, i).settNaboVest(hentRute(antallRader-1, i-1));
            hentRute(antallRader-1, i).settNaboOest(hentRute(antallRader-1, i+1));
        }

        // Venste siden.
        for (int i = 1; i < antallRader-1; i++) {
            hentRute(i, 0).settNaboNord(hentRute(i-1, 0));
            hentRute(i, 0).settNaboSyd(hentRute(i+1, 0));
            hentRute(i, 0).settNaboOest(hentRute(i, 1));
        }

        // Høyre siden.
        for (int i = 1; i < antallRader-1; i++) {
            hentRute(i, antallKolonner-1).settNaboNord(hentRute(i-1, antallKolonner-1));
            hentRute(i, antallKolonner-1).settNaboSyd(hentRute(i+1, antallKolonner-1));
            hentRute(i, antallKolonner-1).settNaboVest(hentRute(i, antallKolonner-2));
        }

        // Resten.
        for (int rad = 1; rad < antallRader-1; rad++) {
            for (int kolonne = 1; kolonne < antallKolonner-1; kolonne++) {
                hentRute(rad, kolonne).settNaboNord(hentRute(rad-1, kolonne));
                hentRute(rad, kolonne).settNaboSyd(hentRute(rad+1, kolonne));
                hentRute(rad, kolonne).settNaboVest(hentRute(rad, kolonne-1));
                hentRute(rad, kolonne).settNaboOest(hentRute(rad, kolonne+1));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        for (Rute[] rutes : labyrint) {
            for (Rute rute : rutes) {
                outputString.append(rute.toString()).append(" ");
            }
            outputString.append("\n");
        }
        return outputString.toString();
    }

    protected void funnUtveiFra(int rad, int kol) {
        if (labyrint[rad][kol] instanceof SortRute) {
            System.out.println("Kan ikke starte i sort rute.");
        } else {
            hentRute(rad, kol).finn(null);
            for (Rute[] rutes : labyrint) {
                for (Rute rute : rutes) {
                    rute.settGaatGjennomFalse();
                }
            }
        }
    }
}
