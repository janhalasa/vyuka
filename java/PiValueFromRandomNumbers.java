import java.util.Random;

/**
 * Vypočíta hodnotu Pi pomocou generovania náhodných súradníc v štvorci 1x1.
 * Pre každú súradnicu zistí, či sa nachádza v kruhu s polomerom 1 a stredom v bode [0, 0]. Použije sa k tomu pytagorova veta.
 * Hodnota Pi sa vypočíta trojčlenkov zo vzorca pre obsah kruhu a pomeru všetkých vygenerovaných bodov k tým, čo spadli do kruhu.
 */
public class PiValueFromRandomNumbers {

    public static void main(String[] args) {
        int withinCircle = 0;
        int totalCount = 1000000;
        for (int counter = 0; counter < totalCount; counter++) {
            double x = new Random().nextDouble();
            double y = new Random().nextDouble();

            if (Math.sqrt(x*x + y*y) <= 1) {
                withinCircle++;
            }
        }

        double pi = 4 * (double) withinCircle / totalCount;

        System.out.println("PI value: " + pi);
    }
}
