/**
 * Nájde všetky prvočísla menšie alebo rovné ako číslo zadané ako parameter programu.
 * Príklad:
 * java SieveOfEratosthenes 10
 * Prvočísla menšie alebo rovné 10:
 * 1, 2, 3, 5, 7,
 */
public class SieveOfEratosthenes {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Chýba parameter - maximálne číslo");
            System.exit(-1);
        }
        int maxNumber = Integer.parseInt(args[0]);

        boolean[] sieve = createInitialSieve(maxNumber);

        findPrimeNumbers(sieve);

        printResult(sieve);
    }

    private static boolean[] createInitialSieve(int maxIndex) {
        // Sito bude pole príznakov true/false s indexami 0 až maxNumber.
        // True znamená, že jeho index je prvočíslom a false že nie je.
        // Na začiatku budeme uvažovať, že všetky čísla (indexy) sú prvočíslami.
        boolean[] initialSieve = new boolean[maxIndex + 1];
        for (int i = 0; i < initialSieve.length; i++) {
            initialSieve[i] = true;
        }
        return initialSieve;
    }

    private static void findPrimeNumbers(boolean[] sieve) {
        // Nastavíme na false všetky indexy, ktoré sú násobkom nejakého čísla iného ako 1.
        // Musíme začínať od dvojky a od dvojnásobku, lebo nám ide o čísla,
        // ktoré sú deliteľné niečím iným ako 1 samým sebou.
        for (int divider = 2; divider <= Math.sqrt(sieve.length); divider++) {
            int index = 2 * divider;
            while (index < sieve.length) {
                sieve[index] = false;
                index += divider;
            }
        }
    }

    private static void printResult(boolean[] result) {
        System.out.println("Prvočísla menšie alebo rovné " + (result.length - 1) + ":");
        for (int i = 1; i < result.length; i++) {
            if (result[i]) {
                System.out.print(i + ", ");
            }
        }
        System.out.println("");
    }
}
