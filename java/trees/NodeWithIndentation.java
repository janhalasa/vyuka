package trees;

public class NodeWithIndentation {

    public final BinaryTreeNode node;
    public final String indentation;

    public NodeWithIndentation(BinaryTreeNode node, String indentation) {
        this.node = node;
        this.indentation = indentation;
    }
}
