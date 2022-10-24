import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Addition {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first number:");
        Integer first = Integer.parseInt(reader.readLine(), 10);
        System.out.println("Enter second number:");
        Integer second = Integer.parseInt(reader.readLine(), 10);
        System.out.println(first + " + " + second + " = " + (first + second));
    }
}
