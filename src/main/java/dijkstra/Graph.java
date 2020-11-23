package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {

    // String source;
    Set<Edge> graph;
    Set<String> vertexes;
    // List<Set<String>> listOfLinks;

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

    public Set<String> getLinks(String vertex) {
        Set<String> link = new HashSet<String>();
        link = graph.stream().filter(e -> e.getLink().contains(vertex))
                .map(e -> vertex == e.vertex1 ? e.vertex2 : e.vertex1).collect(Collectors.toSet());
        return Optional.ofNullable(link).orElseThrow(GraphNotConnectedException::new);
    }

    public boolean isEdge(String v1, String v2){
        boolean result = false;
        for (Edge e : graph) {
            if(e.vertexIsInEdge(v1)&&e.vertexIsInEdge(v2)){
                result = true;
            }
        }
        return result;
    }

    public Edge getEdge(String v1, String v2){
        Edge result = null;
        for (Edge e : graph) {
            if(e.vertexIsInEdge(v1)&&e.vertexIsInEdge(v2)){
                result = e;
            }
        }
        return Optional.ofNullable(result).orElseThrow(NullPointerException::new);
    }

    /*
     * public Edge closestEdge(String vertex) { float distance = Float.MAX_VALUE;
     * Edge minDistantEdge = null; // Set<String> link; // for(Set<String> l :
     * this.graph.listOfLinks){ // link.add(vertex); // link.add(this.); // link =
     * null; // } //
     * this.graph.stream().filter(v->v.equals(vertex)).collect(collector) for (Edge
     * e : this.graph) { if (e.vertexIsInEdge(vertex)) { if (distance >= e.distance)
     * { distance = e.distance; minDistantEdge = e; } } } return
     * Optional.ofNullable(minDistantEdge).orElseThrow(GraphNotConnectedException::
     * new); }
     * 
     */

    public Graph(Set<Edge> graph/* , String source */) {
        this.graph = graph;
        // this.source = source;
        this.vertexes = new HashSet<>();
        this.vertexes.addAll(graph.stream().map(Edge::getVertex1).collect(Collectors.toSet()));
        this.vertexes.addAll(graph.stream().map(Edge::getVertex2).collect(Collectors.toSet()));
        // this.listOfLinks.addAll(graph.stream().map(Edge::getLink).collect(Collectors.toList()));
    }

//     public HashMap<Float, List<String>> dijkstraAlgorithm(String source) {
//         Set<String> bufferes = this.vertexes;
//         String buffer = source;
//         // String bufferToRemove = null;
//         List<String> previous = new ArrayList<>();
//         float distance = 0;
//         HashMap<Float, List<String>> result = new HashMap<Float, List<String>>();
//         // float distance = Float.MAX_VALUE;
//         // float sourceDistance = 0;
//         // this.graph.stream().forEach(e->{

//         // });
//         while (!(bufferes.isEmpty())) {
//             buffer = this.closestVertex(buffer);
//             bufferes.remove(buffer);
//             for (Edge e : this.graph) {
//                 if (e.vertexIsInEdge(buffer)) {
//                     // buffer = ;
//                     distance = distance + e.distance;
//                     previous.add(buffer == e.vertex1 ? e.vertex2 : e.vertex1);
//                 }
//             }
//         }
//         result.put(distance, previous);
//         return Optional.ofNullable(result).orElseThrow(GraphNotConnectedException::new);
//     }
    public HashMap<Float, List<String>> dijkstraAlgorithm(String source) {
        HashMap<String,Float> distances = new HashMap<String,Float>();
        HashMap<String,List<String>> previous = new HashMap<String,List<String>>();
        List<String> points = new ArrayList<String>();
        Set<String> bufferes = this.vertexes;
        String buffer = source;
        float alt;
        for(String v : this.vertexes){
            distances.put(v, Float.MAX_VALUE);
            previous.put(v, points);
            if(source.equals(v)){
                distances.put(v, (float)0);
            }
        }
        while (!(bufferes.isEmpty())){
            if(bufferes.contains(this.closestVertex(buffer))){
                buffer = this.closestVertex(buffer);
                bufferes.remove(buffer);
            }
            for (String v : this.getLinks(buffer)) {
                if(bufferes.contains(v)){
                    alt = distances.get(buffer) + this.getEdge(v, buffer).distance;
                    if(alt<distances.get(v)){
                        distances.replace(v, alt);
                        points.add(buffer);
                        previous.replace(v, points);
                    }
                }
            }
        }
        HashMap<Float, List<String>> result = new HashMap<Float, List<String>>(); 
        for (String v : bufferes) {
            result.put(distances.get(v), previous.get(v));
        }
        return Optional.ofNullable(result).orElseThrow(GraphNotConnectedException::new);
    }
}