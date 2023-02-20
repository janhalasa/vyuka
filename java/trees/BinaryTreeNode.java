package trees;

public class BinaryTreeNode {
    
    String value;
    BinaryTreeNode previous;
    BinaryTreeNode next;

    public BinaryTreeNode(
            String value, 
            BinaryTreeNode previous,
            BinaryTreeNode next) {
        
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public void printMe(String indentation) {
        System.out.println(indentation + this.value);
        if (this.previous != null) {
            this.previous.printMe("  " + indentation);
        }
        if (this.next != null) {
            this.next.printMe("  " + indentation);
        }
    }
}
