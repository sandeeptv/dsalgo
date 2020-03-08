package com.dsalgo.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.
 *
 * graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.
 *
 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 *
 * Example 2:
 *
 * Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * Output: 4
 * Explanation: One possible path is [0,1,4,2,3]
 *
 *
 * Note:
 *
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 */
public class ShortestPathNodes {

    public static void main(String[] args) {

        ShortestPathNodes nodes = new ShortestPathNodes();
        nodes.shortestPathLength(new int[][] {{1,2,3},{0},{0},{0}});
    }


    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;

        Set<String> visited = new HashSet<>();
        Queue<Node> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i, 1<<i);
            que.offer(node);
            visited.add(node.toString());
        }

        int level = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                if (node.mask == fullMask) return level;
                for (int next : graph[node.id]) {
                    Node nextNode = new Node(next, node.mask | (1 << next));
                    if (visited.contains(nextNode.toString())) continue;
                    que.offer(nextNode);
                    visited.add(nextNode.toString());
                }
            }
            level++;
        }

        return level;
    }

    class Node {
        int id;
        int mask;

        Node(int id, int mask){
            this.id = id; this.mask = mask;
        }

        public String toString() {
            return id + " " + mask;
        }
    }
}
