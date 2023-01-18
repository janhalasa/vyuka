/**
 * Zreťazený zoznam - štruktúra pre ukladanie dát. Podporuje len celočíselné
 * hodnoty typu int.
 *
 * Skladá sa z položiek typu ListItem. Udržuje si informáciu o prvom a poslednom prvku zoznamu a svojej dĺžke.
 * Podporuje operáciu pre pridanie hodnoty na koniec. Ďalšie operácie sa dajú dorobiť.
 */
public class LinkedList {

    private ListItem first = null;
    private ListItem last = null;
    private int length = 0;

    /**
     * Pridá danú hodnotu na koniec zoznamu.
     */
    public void addLast(int value) {
        ListItem newItem = new ListItem(value, last, null);
        if (first == null) {
            first = newItem;
            last = newItem;
        } else {
            last.nextItem = newItem;
            last = newItem;
        }
        length++;
    }

    /**
     * Vytvorí textovú reprezentáciu zoznamu - aby sa dal ľahko vypísať na terminál.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        ListItem item = first;
        while (item != null) {
            result.append(item.value).append(" ");
            item = item.nextItem;
        }
        result.append("] length: ").append(length);
        return result.toString();
    }

    /**
     * Reprezentuje položku zoznamu - pozná svoju hodnotu a prvky, ktoré sú pred ňou a za ňou.
     */
    private static class ListItem {
        private int value;
        private ListItem previousItem;
        private ListItem nextItem;

        public ListItem(int value, ListItem previous, ListItem next) {
            this.value = value;
            this.previousItem = previous;
            this.nextItem = next;
        }
    }

    public static void main(String[] args) {
        // Pre overenie funkčnosti, vytvorí zoznam, vloží do neho 3 hodnoty a vypíše zoznam.
        LinkedList linkedList = new LinkedList();
        System.out.println("Initial list:     " + linkedList);
        linkedList.addLast(12);
        linkedList.addLast(34);
        linkedList.addLast(56);
        System.out.println("List with values: " + linkedList);
    }
}
