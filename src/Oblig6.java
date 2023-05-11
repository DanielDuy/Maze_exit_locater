import java.util.Objects;
import java.util.Scanner;

public class Oblig6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Labyrint labyrint = new Labyrint(args[0]);

        System.out.println("Slik ser labyrinten ut: \n");
        System.out.println(labyrint);

        System.out.println("\nSkriv inn koordinater <rad> <kolonne> ('-1' for å avslutte):");
        String brukerInput = scanner.nextLine();

        while (!Objects.equals(brukerInput, "-1")) {

            String[] brukerInputArray = brukerInput.split(" ");

            int inputRad = Integer.parseInt(brukerInputArray[0]);
            int inputKol = Integer.parseInt(brukerInputArray[1]);

            System.out.println("Aapninger:");

            labyrint.funnUtveiFra(inputRad, inputKol);

            System.out.println("\nSkriv inn koordinater <rad> <kolonne> ('-1' for å avslutte):");
            brukerInput = scanner.nextLine();
        }
    }
}
