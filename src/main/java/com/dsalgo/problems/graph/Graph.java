package com.dsalgo.problems.graph;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    // Each GraphNode maps to a list of all his neighbors
    private Set<GraphNode> adjacencySet;


    public Graph() {
        adjacencySet = new HashSet<>();
    }

    private void printEdges() {

        adjacencySet.forEach( e-> {
            System.out.print("Node "+ e.name +" connects to ");
            e.adjacentNodes.forEach(node -> System.out.println( node.name +" "));
            System.out.println();
        });
    }

    private boolean hasEdge(GraphNode a, GraphNode b) {
       return a.adjacentNodes.contains(b);
    }
    private boolean addNode(GraphNode node){
        return adjacencySet.add(node);
    }

    public void depthFirstSearch(GraphNode node) {
        node.visit();
        System.out.print(node.name + " ");

        List<GraphNode> allNeighbors = node.adjacentNodes;
        if (allNeighbors == null)
            return;

        for (GraphNode neighbor : allNeighbors) {
            if (!neighbor.isVisited())
                depthFirstSearch(neighbor);
        }
    }

    public void depthFirstSearchMain(GraphNode node) {
        depthFirstSearch(node);

        adjacencySet.forEach( n-> {
            if(!n.isVisited()){
                depthFirstSearch(n);
            }
        });

        System.out.println("---");
    }

    public void breadthFirstSearch(GraphNode node){

        if (node == null)
            return;

        LinkedList<GraphNode> queue = new LinkedList<>();

        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode node1 = queue.pop();
            node1.visit();
            System.out.print(node1.name+" ");
            if(node1.adjacentNodes == null){
                continue;
            }
            queue.addAll(node1.adjacentNodes.stream().filter(e -> !e.isVisited()).collect(Collectors.toList()));
        }

    }

    public void breadthFirstSearchMain(GraphNode node) {

        breadthFirstSearch(node);
        adjacencySet.forEach(n -> {
            if (!n.isVisited()) {
                breadthFirstSearch(n);
            }
        });
    }


    public static void main(String[] args) {

        Graph graph = new Graph();

        GraphNode zero = new GraphNode(0, "0");
       GraphNode one = new GraphNode(1, "1");
       GraphNode two = new GraphNode(2, "2");
       GraphNode three = new GraphNode(3, "3");
       GraphNode four = new GraphNode(4, "4");
       GraphNode five = new GraphNode(5, "5");
       GraphNode six = new GraphNode(6, "6");
       GraphNode seven = new GraphNode(7, "7");
       GraphNode eight = new GraphNode(8, "8");

        one.addEdge(zero);
        three.addEdge(one);
        two.addEdge(seven);
        two.addEdge(four);
        five.addEdge(two);
        five.addEdge(zero);
        six.addEdge(five);
        six.addEdge(three);
        six.addEdge(eight);
        seven.addEdge(five);
        seven.addEdge(six);
        seven.addEdge(eight);

        graph.addNode(zero);
        graph.addNode(one);
        graph.addNode(two);
        graph.addNode(three);
        graph.addNode(four);
        graph.addNode(five);
        graph.addNode(six);
        graph.addNode(seven);
        graph.addNode(eight);

//        graph.printEdges();

//        System.out.println(graph.hasEdge(a,b));
//        System.out.println(graph.hasEdge(d,a));

        graph.depthFirstSearchMain(seven);




        Graph graph2 = new Graph();
       GraphNode a = new GraphNode(0, "0");
       GraphNode b = new GraphNode(1, "1");
       GraphNode c = new GraphNode(2, "2");
       GraphNode d = new GraphNode(3, "3");
       GraphNode e = new GraphNode(4, "4");

        a.addEdge(d);
        a.addEdge(b);
        c.addEdge(e);

        graph2.addNode(a);
        graph2.addNode(b);
        graph2.addNode(c);
        graph2.addNode(d);
        graph2.addNode(e);
        graph2.breadthFirstSearchMain(a);

    }




}
