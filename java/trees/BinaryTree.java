package trees;

import java.util.LinkedList;

public class BinaryTree {
    
    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     * Vypíše uzly stromu postupne podľa úrovní (do šírky) - skôr svojho súrodenca ako potomkov.
     */
    public void printBreadthFirst() {

        System.out.println("===== Breadth-first =====");

        LinkedList<NodeWithIndentation> nodeQueue = new LinkedList<>();
        nodeQueue.push(new NodeWithIndentation(root, "- "));

        while (!nodeQueue.isEmpty()) {
            NodeWithIndentation nodeWithIndentation = nodeQueue.getFirst();
            BinaryTreeNode node = nodeWithIndentation.node;
            nodeQueue.removeFirst();
            System.out.println(nodeWithIndentation.indentation + node.value);
            String biggerIndetation = "  " + nodeWithIndentation.indentation;
            if (node.previous != null) {
                nodeQueue.addLast(new NodeWithIndentation(node.previous, biggerIndetation));
            }
            if (node.next != null) {
                nodeQueue.addLast(new NodeWithIndentation(node.next, biggerIndetation));
            }
        }
        System.out.println();
    }

    /**
     * Vypíše uzly do hĺbky stromu tak - najskôr svojich potomkov, až potom súrodencov.
     */
    public void printDepthFirst() {
        System.out.println("===== Depth-first =====");
        this.root.printMe("- ");
        System.out.println();
    }

    public void printDepthFirstRecursively() {
        System.out.println("===== Depth-first Recursive =====");
        printDepthFirstRecursively(root, "- ");
        System.out.println();
    }

    private static void printDepthFirstRecursively(BinaryTreeNode node, String indentation) {
        System.out.println(indentation + node.value);
        if (node.previous != null) {
            printDepthFirstRecursively(node.previous, "  " + indentation);
        }
        if (node.next != null) {
            printDepthFirstRecursively(node.next, "  " + indentation);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(
            new BinaryTreeNode(
                "Katarína", 
                new BinaryTreeNode(
                    "Daniel", 
                    new BinaryTreeNode("Božena", null, null), 
                    new BinaryTreeNode("Félix", null, null)), 
                new BinaryTreeNode(
                    "Ondrej", 
                    new BinaryTreeNode("Michal", null, null), 
                    new BinaryTreeNode(
                        "Silvia", 
                        null, 
                        new BinaryTreeNode(
                            "Zuzana", 
                            null, 
                            null)))));

        tree.printBreadthFirst();
        tree.printDepthFirst();
        tree.printDepthFirstRecursively();
    }
}
