package com.dsalgo.problems.graph;

import java.util.LinkedList;

public class GraphNode {

    int n;
    String name;
    LinkedList<GraphNode> adjacentNodes;
    private boolean visited; // New attribute

    GraphNode(int n, String name) {
        this.n = n;
        this.name = name;
        visited = false;
//        adjacentNodes = new PriorityQueue<>(Comparator.comparingInt(a -> a.n));
        adjacentNodes =  new LinkedList<>();
    }

    // Two new methods we'll need in our traversal algorithms
    void visit() {
        visited = true;
    }

    void unvisit() {
        visited = false;
    }

    public void addEdge(GraphNode node) {
        if (!adjacentNodes.contains(node))
            adjacentNodes.add(node);
    }

    public boolean isVisited() {
        return visited;
    }
}
