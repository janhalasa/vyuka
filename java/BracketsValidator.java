import java.util.LinkedList;

/**
 * Program skontroluje, či zátvorky obsiahnuté vo vstupnom texte, zadanom ako
 * parameter, sú správne usporiadané.
 * Napríklad:
 * vstup "{([](){})}" je korektný
 * vstup "{[(])}" nie je korektný, lebo zátvorky sú prepletené
 * vstup "{]" nie je korektný, lebo zložená zátvorka nie je uzatvorená a hranatá nemá otváraciu
 */
public class BracketsValidator {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("Error: Input text parameter is required");
            System.exit(1);
        }

        String inputText = args[0];
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < inputText.length(); i++) {
            char character = inputText.charAt(i);
            if (character == '{' || character == '[' || character == '(') {
                stack.push(character);
            } else if (character == '}' || character == ']' || character == ')') {
                if (stack.isEmpty()) {
                    System.out.println("Brackets are incorrect - closing bracket without opening one at position " + i);
                    return;
                }
                char lastOpenBracket = stack.pop();
                if (character == '{' && lastOpenBracket != '}'
                        || character == '[' && lastOpenBracket != ']'
                        || character == '(' && lastOpenBracket != ')') {
                    System.out.println("Brackets are incorrect - wrong closing bracket at position " + i + ": " + lastOpenBracket + "..." + character);
                    return;
                }
            } else {
                // Non-bracket character - just skip it
            }
        }
        if (! stack.isEmpty()) {
            System.out.println("Brackets are incorrect - some brackets don't have closing ones: " + stack);
            return;
        }
        System.out.println("Brackets correct :-)");
    }
}
