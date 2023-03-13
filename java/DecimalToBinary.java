import java.util.LinkedList;

/**
 * Converts an unsigned decimal number to its binary form.
 */
public class DecimalToBinary {

    public static void main(String[] args) {
        
        if (args.length != 1) {
            System.err.println("Required parameter: decimal-number");
        }

        int decimal = Integer.parseUnsignedInt(args[0], 10);

        LinkedList<Integer> binaryDigits = new LinkedList<>();
        int remainder = decimal;
        int powerOfTwo = 1;

        // Find the largest power of two which is smaller than the given decimal number
        while (powerOfTwo <= decimal) {
            powerOfTwo *= 2;
        }
        powerOfTwo /= 2;

        // Compose binary digits from left to right
        while (true) {
            if (remainder >= powerOfTwo) {
                remainder -= powerOfTwo;
                binaryDigits.addLast(1);
            } else {
                binaryDigits.addLast(0);
            }
            if (powerOfTwo == 1) {
                break;
            }
            powerOfTwo /= 2;
        }

        System.out.print("Decimal " + decimal + " = ");
        binaryDigits.forEach(digit -> System.out.print(digit));
        System.out.println(" binary");
    }
}