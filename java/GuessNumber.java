import java.util.Random;
import java.util.Scanner;

/**
 * Hra, ktorá vygeneruje celé číslo od 0 do 99 a chce po hráčovi,
 * aby si tipol, ktoré číslo bolo vygenerované. Po každom tipe mu vypíše,
 * či je číslo väčšie, menšie. Hra skončí, keď hráč uhádne číslo.
 */
public class GuessNumber {

    public static void main(String[] args) {
        int secretNumber = new Random().nextInt(100);
        Scanner scanner = new Scanner(System.in);

        int numberOfTries = 0;
        int guessedNumber;
        System.out.println("Guess the number in range 0-99:");

        while (true) {
            numberOfTries ++;
            guessedNumber = scanner.nextInt();
            if (guessedNumber == secretNumber) {
                // Tento break ukončí celý cyklus while
                break;
            }
            if (guessedNumber < secretNumber) {
                System.out.println("Try something bigger");
                // Toto continue spustí ďalšie opakovanie cyklu while
                continue;
            }
            if (guessedNumber > secretNumber) {
                System.out.println("That was too much");
            }
        }
        System.out.println("Great, it took you just " + numberOfTries + " guesses :-)");
    }
}
