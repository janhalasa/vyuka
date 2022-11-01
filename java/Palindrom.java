/**
 * Program otestuje, či je zadané slovo palindrómom - či je rovnaké zľava aj zprava.
 */
public class Palindrom {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Zadajte slovo ako parameter");
            System.exit(1);
        }
        String wordToTest = args[0];
        for (int i = 0; i < wordToTest.length(); i++) {
            if (wordToTest.charAt(i) != wordToTest.charAt(wordToTest.length() - i - 1)) {
                System.out.println("Zadané slovo nie je palindróm :-(");
                System.exit(0);
            }
        }
        System.out.println("Hurá, zadané slovo je palindróm :-)");
    }
}
