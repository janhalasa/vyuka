import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Načíta meno z terminálu a vypíše ho.
 */
public class ReadWriteName {
    public static void main(String[] args) throws IOException {
        System.out.print("Your name is: ");
        // Premenná reader je schopná čítať vstupné riadky z terminálu (do stlačenia klávesy Enter)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println("Hello " + name + " :-)");
    }
}
