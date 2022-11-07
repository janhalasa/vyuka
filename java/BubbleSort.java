import java.util.Arrays;
import java.util.Random;

/**
 * Vygeneruje pole náhodných čísel fixnej dĺžky a usporiada ich od najmenšieho po najväčšie.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int numbers[] = new int[6];

        // Najprv potrebujeme vygenerovať náhodné čísla, ktoré budeme chcieť usporiadať
        for (int i = 0; i < numbers.length; i++) {
            // Index v poli začína od nuly, takže pole veľkosti 6 má hodnoty na indexoch 0-5
            numbers[i] = new Random().nextInt(100);
        }
        System.out.println("Numbers to sort: " + Arrays.toString(numbers));

        // Usporiadame jednotlivé čísla prehadzovaním susediacich čísel tak, aby menšie išlo na nižší index v poli
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tempNumber = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = tempNumber;
                }
            }
        }
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));
    }
}
