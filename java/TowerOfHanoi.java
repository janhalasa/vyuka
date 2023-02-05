import java.util.LinkedList;

/**
 * Implementácia známeho problému presunu veže, zloženej z krúžkov rôznej veľkosti, z jedného miesta na druhé.
 * 
 * https://en.wikipedia.org/wiki/Tower_of_Hanoi
 */
public class TowerOfHanoi {
    
    private final int size;

    private LinkedList<Integer> firstStick = new LinkedList<>();
    private LinkedList<Integer> secondStick = new LinkedList<>();
    private LinkedList<Integer> thirdStick = new LinkedList<>();

    private int stepCount = 0;

    public TowerOfHanoi(int size) {
        this.size = size;
        for (int i = 1; i <= size; i++) {
            firstStick.addFirst(i);
        }
    }

    public void solve() {
        System.out.println("Starting ...");
        prinntSticks();
        while (thirdStick.size() < this.size) {
            // Algoritmus sa líši poradím krokov podľa toho, či máme párny alebo nepárny počet krúžkov.
            if (this.size % 2 == 1) {
                if (makeOneMove(firstStick, secondStick, 1, 2)) {
                    break;
                }
                if (makeOneMove(firstStick, thirdStick, 1, 3)) {
                    break;
                }
            } else {
                if (makeOneMove(firstStick, thirdStick, 1, 3)) {
                    break;
                }
                if (makeOneMove(firstStick, secondStick, 1, 2)) {
                    break;
                }
            }
            if (makeOneMove(secondStick, thirdStick, 2, 3)) {
                break;
            }
        }
        System.out.println("Finished in " + this.stepCount + " steps");
        prinntSticks();
    }

    private void prinntSticks() {
        System.out.println("Stick 1: " + this.firstStick);
        System.out.println("Stick 2: " + this.secondStick);
        System.out.println("Stick 3: " + this.thirdStick);
    }

    /**
     * Skúsi presunúť vrchnú položku z veže A na vežu B alebo opačne.
     * Vráti true, ak sú po tomto kroku všetky krúžky presunuté na tretiu vežu, inak false.
     */
    private boolean makeOneMove(
            LinkedList<Integer> stickA, 
            LinkedList<Integer> stickB, 
            int stickNumberA, 
            int stickNumberB) {

        if (moveIfPossible(stickA, stickB)) {
            this.stepCount ++;
            System.out.println(stickNumberA + " -> " + stickNumberB);
        } else if (moveIfPossible(stickB, stickA)) {
            this.stepCount ++;
            System.out.println(stickNumberB + " -> " + stickNumberA);
        }
        if (thirdStick.size() == this.size) {
            return true;
        } 
        return false;
    }

    private boolean moveIfPossible(LinkedList<Integer> from, LinkedList<Integer> to) {
        if (!from.isEmpty() && (to.isEmpty() || to.getLast() > from.getLast())) {
            to.addLast(from.removeLast());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java TowerOfHanoi size");
            System.exit(1);
        }
        int size = Integer.parseInt(args[0], 10);
        TowerOfHanoi toverOfHanoi = new TowerOfHanoi(size);
        toverOfHanoi.solve();
    }
}
