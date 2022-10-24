import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Sčíta 5 čísiel načítaných z terminálu vo for cykle.
 */
public class SumOfNumbers {

    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new LinkedList<>();
        
        // Do tejto premennej si budeme postupne ukladať hodnotu súčtu všetkých čísel
        int sum = 0;
        
        // For cyklus sa nastavuje troma časťami:
        // 1. inicializácia "int i = 1" vytvorí premennú i, ktorá riadi cyklus
        // 2. podmienka "i <= 5" určuje, či sa cyklus vykoná (ak platí) alebo sa preskočí (ak neplatí)
        // 3. krok na konci cyklu "i++" zvýši hodnotu premennej i o 1
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter number " + i + ":");
            Integer number = Integer.parseInt(reader.readLine(), 10);
            numbers.add(number);
            sum = sum + number;
        }
        System.out.println("Sum of " + numbers + " = " + sum);
    }
}
