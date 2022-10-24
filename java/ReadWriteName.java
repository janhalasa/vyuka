import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadWriteName {
    public static void main(String[] args) throws IOException {
        System.out.print("Your name is: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println("Hello " + name + " :-)");
    }
}
