package com.dsalgo.problems.graph;

import java.util.LinkedList;

public class GraphDijkstra {

    // Each GraphNode maps to a list of all his neighbors
//    private Set<Node> adjacencySet;

    public GraphDijkstra() {
//        adjacencySet = new HashSet<>();
    }
    public void dijkstra(Node source, Node dest){

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(source);

        int weight = 0 ;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.isVisited()){
                continue;
            }
            node.visit();

            if(node.name.equals(dest.name)){
                System.out.println(weight);
            }

            if(node.adjacentNodes == null){
                continue;
            }
            weight+=node.weight;
            queue.addAll(node.adjacentNodes);
        }

    }

//    private boolean addNode(Node... node){
//        return adjacencySet.addAll(Arrays.asList(node));
//    }

    public static void main(String[] args) {

        GraphDijkstra gd = new GraphDijkstra();

        Node zero = new Node("0");
        Node one = new Node("1");
        Node two = new Node("2");
        Node three = new Node("3");
        Node four = new Node("4");
        Node five = new Node("5");
        Node six = new Node("6");

        zero.addEdge( one, 8);
        zero.addEdge( two, 11);
        one.addEdge( three, 3);
        one.addEdge( four, 8);
        one.addEdge( two, 7);
        two.addEdge( four, 9);
        three.addEdge( four, 5);
        three.addEdge( five, 2);
        four.addEdge(six, 6);
        five.addEdge(four, 1);
        five.addEdge(six, 8);

//        gd.addNode(zero, one, two, three, four,five,six);

        gd.dijkstra(zero,six);
        //0 1 3 5 4 6

    }
}
