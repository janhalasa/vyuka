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
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter number " + i + ":");
            Integer number = Integer.parseInt(reader.readLine(), 10);
            numbers.add(number);
            sum = sum + number;
        }
        System.out.println("Sum of " + numbers + " = " + sum);
    }
}
