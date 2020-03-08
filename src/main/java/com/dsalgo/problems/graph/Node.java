package com.dsalgo.problems.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Node {


    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", visited=" + visited +
                '}';
    }

    int weight;
    String name;
    PriorityQueue<Node> adjacentNodes;
    Map<Node, Integer> nodeWeightMap;
    private boolean visited; // New attribute

    Node(String name) {
        this.name = name;
        visited = false;
        adjacentNodes = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        nodeWeightMap = new HashMap<>();
    }

    // Two new methods we'll need in our traversal algorithms
    void visit() {
        visited = true;
    }

    public void addEdge(Node node, Integer weight) {
        node.setWeight(weight);
        if (!adjacentNodes.contains(node)) {
            adjacentNodes.add(node);
        }
        nodeWeightMap.putIfAbsent(node, weight);
    }

    public boolean isVisited() {
        return visited;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {

        return name.hashCode();
    }


    @Override
    public boolean equals(Object o) {

        // null check
        if (o == null) {
            return false;
        }

        // this instance check
        if (this == o) {
            return true;
        }

        if ((o instanceof Node) && ((Node) o).name.equals(this.name)) {
            return true;
        } else {
            return false;
        }
    }
}
