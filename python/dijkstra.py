#
# Dijkstrov algoritmus pre nájdenie najkratšej cesty v grafe.
# Graf použitý v tomto príklade je rovnaký z grafom v animácii na Wikipedii.
# Je tam aj podrobný popis algoritmu:
# https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
#

from typing import Optional

class GraphEdge:
    def __init__(self, remoteNodeIndex: int, weight: int) -> None:
        self.remoteNodeIndex: int = remoteNodeIndex
        self.weight: int = weight;


class GraphNode:
    """Graph node class"""

    def __init__(self, index: int, edges: list[GraphEdge]) -> None:
        self.index = index
        self.processed: bool = False
        self.lengthFromRoot: Optional[int] = None
        self.edgeToRoot: Optional[GraphEdge] = None
        self.edges: list[GraphEdge] = edges

class Graph:
    """ Implements graph from https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm """
    def __init__(self) -> None:
        self.nodes = [
            GraphNode(
                0,
                [GraphEdge(5, 14),
                GraphEdge(2, 9),
                GraphEdge(1, 7)]
            ),
            GraphNode(
                1,
                [GraphEdge(0, 7),
                GraphEdge(2, 10),
                GraphEdge(3, 15)]
            ),
            GraphNode(
                2,
                [GraphEdge(0, 9),
                GraphEdge(1, 10),
                GraphEdge(3, 11),
                GraphEdge(5, 2)]
            ),
            GraphNode(
                3,
                [GraphEdge(1, 15),
                GraphEdge(2, 11),
                GraphEdge(4, 6)]
            ),
            GraphNode(
                4,
                [GraphEdge(3, 6),
                GraphEdge(5, 9)]
            ),
            GraphNode(
                5,
                [GraphEdge(0, 14),
                GraphEdge(2, 2),
                GraphEdge(4, 9)]
            )
        ]
        self.nodes[0].lengthFromRoot = 0

    def findShortestPaths(self):
        stack = []
        stack.append(self.nodes[0])
        while len(stack) > 0:
            node: GraphNode = stack.pop()
            node.processed = True
            for edge in node.edges:
                remoteNode = self.nodes[edge.remoteNodeIndex]
                if not remoteNode.processed:
                    stack.append(remoteNode)
                
                assert node.lengthFromRoot is not None
                lengthUsingThisEdge = node.lengthFromRoot + edge.weight
                if remoteNode.lengthFromRoot is None or remoteNode.lengthFromRoot > lengthUsingThisEdge:
                    remoteNode.lengthFromRoot = lengthUsingThisEdge
                    remoteNode.edgeToRoot = GraphEdge(node.index, edge.weight)

    def printShortestRouteFromNode(self, nodeIndex: int):
        node = self.nodes[nodeIndex]
        while node.index != 0:
            print(f"{node.index}-({node.edgeToRoot.weight})", end='-')
            node = self.nodes[node.edgeToRoot.remoteNodeIndex]
        print("0")



graph = Graph()
graph.findShortestPaths()
graph.printShortestRouteFromNode(4)
