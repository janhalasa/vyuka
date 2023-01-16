public class PiValueFromTriangles {

    /**
     * Vypočíta hodnotu Pi použitím aproximácie cez plochu vpísaných a opísaných
     * n-uholníkov.
     *
     * Video o tom, koľko času sa strávilo takýmto počítaním v minulosti a ako sa Pi
     * počíta od čias Newtona, sa dá pozrieť na
     * https://www.youtube.com/watch?v=gMlf1ELvRzc
     */
    public static void main(String[] args) {
        int triangleCount = 360;

        double angleInRadians = Math.toRadians(360.0 / triangleCount);

        double minTriangleArea = Math.sin(angleInRadians / 2) * Math.cos(angleInRadians / 2);
        double maxTriangleArea = Math.sin(angleInRadians / 2) / Math.cos(angleInRadians / 2);

        double piMin = minTriangleArea * triangleCount;
        double piMax = maxTriangleArea * triangleCount;

        System.out.println("PI value is between \n" + piMin + "\n" + piMax);
    }
}
