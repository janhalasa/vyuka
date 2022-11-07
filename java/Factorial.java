import java.math.BigInteger;

/**
 * Vypočíta faktoriál čísla zadaného ako parameter pri spúšťaní programu.
 * Napríklad:
 * $ java Factorial 12
 */
public class Factorial {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Chyba parameter - veľkosť faktoriálu");
            System.exit(-1);
        }
        int factorialNumber = Integer.parseInt(args[0]);
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= factorialNumber; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println("" + factorialNumber + "! = " + result);
    }
}
