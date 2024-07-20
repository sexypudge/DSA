package Graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Graph {

    private Map<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (adjList.containsKey(vertex)) {
            return false;
        }
        adjList.put(vertex, new ArrayList<>());
        return true;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (!adjList.containsKey(vertex1)) {
            return false;
        }

        if (!adjList.containsKey(vertex2)) {
            return false;
        }

        if (adjList.get(vertex1).contains(vertex2)
                || adjList.get(vertex2).contains(vertex1)) {
            return false;
        } else {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }

//        // Check if both vertices exist in the graph
//        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
//            // If both vertices exist, add an edge between them in both directions
//            adjList.get(vertex1).add(vertex2);
//            adjList.get(vertex2).add(vertex1);
//            // Return true to indicate that the edge was added successfully
//            return true;
//        }
//        // If at least one vertex does not exist, return false to indicate that the edge was not added
//        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (!adjList.containsKey(vertex1)) {
            return false;
        }

        if (!adjList.containsKey(vertex2)) {
            return false;
        }

        adjList.get(vertex1).remove(vertex2);
        adjList.get(vertex2).remove(vertex1);

        return true;
    }

    public boolean removeVertex(String vertex) {
        if (!adjList.containsKey(vertex)) {
            return false;
        }

        adjList.forEach((k, v) -> {
            if (!vertex.equals(k)) {
                v.remove(vertex);
            }
        });

        adjList.remove(vertex);
        return true;
    }



    public static void main(String[] args) {

        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");

        System.out.println("\nGraph:");
        myGraph.printGraph();

        /*
            EXPECTED OUTPUT:
            ----------------
            Graph:
            {A=[], B=[]}

        */

    }

}

