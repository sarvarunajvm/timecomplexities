package org.studies.dsalgo.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonTest {


    public static int connectedSum(int n, List<String> edges) {
        System.out.println(n);
        System.out.println(edges.toString());

        Graph graph = new Graph(n);

        for (int i = 0; i < edges.size(); i++) {
            Integer src = Integer.parseInt(edges.get(i).split(" ")[0]);
            Integer dest = Integer.parseInt(edges.get(i).split(" ")[1]);
            graph.addEdge(src, dest);
        }

        List<List<Integer>> connectionList = graph.getAllConnections();

        int totalGroups = 0;
        int result = 0;

        for (List<Integer> list : connectionList) {
            totalGroups = totalGroups + list.size();
            result = result + (int) Math.ceil(Math.sqrt(list.size()));
        }
        result = result + (n - totalGroups);
        // Set<Integer> allNodes = new HashSet<>();

        // List<Set<Integer>> listedNodes = new CopyOnWriteArrayList<>();


        // for (int i=0; i<edges.size(); i++) {
        //     Integer pairL = Integer.parseInt(edges.get(i).split(" ")[0]);
        //     Integer pairR = Integer.parseInt(edges.get(i).split(" ")[1]);
        //     allNodes.add(pairL);
        //     allNodes.add(pairR);

        //     if(i == 0){
        //         listedNodes.add(new HashSet<>(Arrays.asList(pairL,pairR)));
        //     }else{
        //         for (Set<Integer> indiSet : listedNodes) {
        //             if(indiSet.contains(pairL) || indiSet.contains(pairR)){
        //                 indiSet.add(pairL);
        //                 indiSet.add(pairR);
        //             }else{
        //                 listedNodes.add(new HashSet<>(Arrays.asList(pairL,pairR)));
        //             }
        //             System.out.println(listedNodes);
        //         }
        //     }

        //     if(i == edges.size()-1){
        //         result = allNodes.size() == n ? 0 : n-allNodes.size();
        //         for (Set<Integer> indiSet : listedNodes) {
        //             result+=Math.ceil(Math.sqrt(Double.valueOf(indiSet.size())));
        //         }
        //     }
        // }
        return result;

    }

    public static void main(String[] args) {
        int n = 8;
        List<String> strings = Arrays.asList("8 1","5 8", "7 3", "8 6");
        System.out.println(connectedSum(n,strings));
    }
}

class Graph {
    int vertices;
    List<List<Integer>> adjancencyList;

    Graph(int vertices) {
        this.vertices = vertices+1;
        this.adjancencyList = new ArrayList<>();
        for (int i = 0; i < this.vertices; i++) {
            this.adjancencyList.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        this.adjancencyList.get(src).add(dest);
        this.adjancencyList.get(dest).add(src);
    }

    public List<List<Integer>> getAllConnections() {
        // create an array to track the visited nodes
        boolean[] isVisited = new boolean[this.vertices];

        List<List<Integer>> connectionList = new ArrayList<>();

        //dfs logic to visit all the nodes
        for (int i = 0; i < this.vertices; i++) {
            if (!isVisited[i]) {
                List<Integer> tempList = dfsList(i, isVisited, new ArrayList<>());
                connectionList.add(tempList);
            }
        }
        return connectionList;
    }

    private List<Integer> dfsList(int i, boolean[] isVisited, List<Integer> tempList) {
        isVisited[i] = true;
        tempList.add(i);
        for (int vertex : this.adjancencyList.get(i)) {
            if (!isVisited[vertex]) {
                dfsList(vertex, isVisited, tempList);
            }
        }
        return tempList;
    }
}