package dijkstra;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    String source;
    Set<Edge> graph;
    Set<String> vertexes;
    //List<Set<String>> listOfLinks;

    public String closestVertex(String vertex) {
        float distance = Float.MAX_VALUE;
        String minDistantVertex = null;
        // Set<String> link;
        // for(Set<String> l : this.graph.listOfLinks){
        // link.add(vertex);
        // link.add(this.);
        // link = null;
        // }
        // this.graph.stream().filter(v->v.equals(vertex)).collect(collector)
        for (Edge e : this.graph) {
            if (e.vertexIsInEdge(vertex)) {
                if (distance >= e.distance) {
                    distance = e.distance;
                    minDistantVertex = vertex.equals(e.vertex1) ? e.vertex2 : e.vertex1;
                }
            }
        }
        return Optional.ofNullable(minDistantVertex).orElseThrow(GraphNotConnectedException::new);
    }
/*
    public Edge closestEdge(String vertex) {
        float distance = Float.MAX_VALUE;
        Edge minDistantEdge = null;
        // Set<String> link;
        // for(Set<String> l : this.graph.listOfLinks){
        // link.add(vertex);
        // link.add(this.);
        // link = null;
        // }
        // this.graph.stream().filter(v->v.equals(vertex)).collect(collector)
        for (Edge e : this.graph) {
            if (e.vertexIsInEdge(vertex)) {
                if (distance >= e.distance) {
                    distance = e.distance;
                    minDistantEdge = e;
                }
            }
        }
        return Optional.ofNullable(minDistantEdge).orElseThrow(GraphNotConnectedException::new);
    }

 */

    public Graph(Set<Edge> graph, String source) {
        this.graph = graph;
        this.source = source;
        this.vertexes = new HashSet<>();
        this.vertexes.addAll(graph.stream().map(Edge::getVertex1).collect(Collectors.toSet()));
        this.vertexes.addAll(graph.stream().map(Edge::getVertex2).collect(Collectors.toSet()));
        //this.listOfLinks.addAll(graph.stream().map(Edge::getLink).collect(Collectors.toList()));
    }

    public HashMap<Float,List<String>> dijkstraAlgorithm(String source) {
        Set<String> bufferes = this.vertexes;
        String buffer = source;
        // String bufferToRemove = null;
        List<String> previous = new ArrayList<>();
        float distance = 0;
        HashMap<Float,List<String>> result = new HashMap<Float,List<String>>();
        // float distance = Float.MAX_VALUE;
        // float sourceDistance = 0;
        // this.graph.stream().forEach(e->{

        // });
        while(!(bufferes.isEmpty())){
            buffer = this.closestVertex(buffer);
            bufferes.remove(buffer);
            for(Edge e : this.graph){
                if(e.vertexIsInEdge(buffer)){
                    //bufferToRemove = buffer == e.vertex1 ? e.vertex2:e.vertex1;
                    distance = distance + e.distance;
                    previous.add(buffer);
                } 
            }
        }
        result.put(distance, previous);
        return Optional.ofNullable(result).orElseThrow(GraphNotConnectedException::new);
    }
}    
