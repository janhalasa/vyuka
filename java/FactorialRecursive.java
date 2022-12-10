public class FactorialRecursive {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Chýba parameter - veľkosť faktoriálu");
            System.exit(-1);
        }
        int factorialParameter = Integer.parseInt(args[0]);
        long result = factorial(factorialParameter);
        System.out.println(factorialParameter + "! = " + result);
    }

    private static long factorial(int number) {
        if (number == 1) {
            return 1;
        }
        return factorial(number - 1) * number;
    }
}
