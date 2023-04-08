import java.util.LinkedList;
import java.util.List;

/**
 * Dijkstrov algoritmus pre nájdenie najkratšej cesty v grafe.
 * Graf použitý v tomto príklade je rovnaký z grafom v animácii na Wikipedii.
 * Je tam aj podrobný popis algoritmu:
 * https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 */
public class ShortestPathInGraph {

    private static class Graph {
        final GraphNode root;

        Graph(GraphNode root) {
            this.root = root;
            this.root.shortestPathLength = 0;
            this.calculatePaths();
        }

        private void calculatePaths() {
            System.out.println("Calculating paths from root node " + root.id);
            LinkedList<GraphNode> nodeQueue = new LinkedList<>();
            nodeQueue.addLast(root);
            while (!nodeQueue.isEmpty()) {
                GraphNode node = nodeQueue.removeFirst();
                System.out.print(node.id + " ");

                for (GraphEdge edge : node.edges) {
                    int pathLength = node.shortestPathLength + edge.length;
                    if (edge.remoteNode.shortestPathLength == null || pathLength < edge.remoteNode.shortestPathLength) {
                        edge.remoteNode.setShortestStepTowardsRoot(node, pathLength);

                        nodeQueue.remove(edge.remoteNode);
                        nodeQueue.addLast(edge.remoteNode);
                    }
                }
            }
            System.out.println();
        }

        void printShortestPathFromRootToNode(GraphNode targetNode) {
            System.out.println("Printing path to node " + targetNode.id);
            LinkedList<GraphEdge> path = new LinkedList<>();
            GraphNode pathNode = targetNode;
            while (pathNode != root) {
                path.addFirst(pathNode.shortestEdgeTowardsRoot);
                pathNode = pathNode.shortestEdgeTowardsRoot.remoteNode;
            }
            for (GraphEdge edge : path) {
                System.out.print(edge.remoteNode.id + " --(" + edge.length + ")--> ");
            }
            System.out.println(targetNode.id);
            System.out.println("Path length is: " + targetNode.shortestPathLength);
        }
    }

    /**
     * Reprezentuje jeden uzol v grafe.
     */
    private static class GraphNode {

        // Identifikátor uzlu - aby sme mohli odlíšiť jednotlivé uzly od seba
        final int id;

        // Hrany grafu - cesty, kam sa z tohto uzlu vieme dostať
        List<GraphEdge> edges = new LinkedList<>();

        // Dĺžka nájdenej najkratšej cesty v grafe z koreňa do tohto uzlu.
        // Musí korešpondovať s atribútom shortestEdgeTowardsRoot.
        Integer shortestPathLength = null;

        // Hrana, ktorou sa vydať v grafe, aby sme šli najkratšou cestou ku koreňu.
        GraphEdge shortestEdgeTowardsRoot = null;

        GraphNode(int id) {
            this.id = id;
        }

        void setShortestStepTowardsRoot(GraphNode remoteNode, int pathLength) {
            for (GraphEdge edge : edges) {
                if (edge.remoteNode == remoteNode) {
                    this.shortestEdgeTowardsRoot = edge;
                    this.shortestPathLength = pathLength;
                    return;
                }
            }
            throw new IllegalArgumentException("There is no edge from node " + id + " to node " + remoteNode.id);
        }

        @Override
        public String toString() {
            return "" + id;
        }
    }

    /**
     * Hrana v grafe - z uzla, ktorý ju vlastní (v GraphNode::edges) do remoteNode s dĺžkou length.
     */
    private static class GraphEdge {
        int length;
        GraphNode remoteNode;
        GraphEdge(GraphNode remoteNode, int length) {
            this.length = length;
            this.remoteNode = remoteNode;
        }

        @Override
        public String toString() {
            return "[to: " + remoteNode.id + ", length: " + length + "]";
        }
    }

    public static void main(String[] args) {
        // Vytvorenie grafu - najprv uzly a potom hrany medzi nimi.
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);

        createEdges(node1, node2, 7);
        createEdges(node1, node3, 9);
        createEdges(node1, node6, 14);
        createEdges(node2, node3, 10);
        createEdges(node2, node4, 15);
        createEdges(node3, node6, 2);
        createEdges(node3, node4, 11);
        createEdges(node4, node5, 6);
        createEdges(node5, node6, 9);

        Graph graph = new Graph(node1);
        graph.printShortestPathFromRootToNode(node5);
    }

    /**
     * Vytvorí cestu medzi dvoma uzlami tak, že pre každý uzol vytvorí hranu do opačného.
     */
    private static void createEdges(GraphNode firstNode, GraphNode secondNode, int length) {
        firstNode.edges.add(new GraphEdge(secondNode, length));
        secondNode.edges.add(new GraphEdge(firstNode, length));
    }
}
