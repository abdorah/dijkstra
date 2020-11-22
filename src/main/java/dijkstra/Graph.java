package dijkstra;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {

    String source;
    Set<Edge> graph;
    Set<String> vertexes;
    List<Set<String>> listOfLinks;

    public Edge closerVertex(String vertex){
        float distance = Float.MAX_VALUE;
        Edge minDistantEdge = null;
        // Set<String> link;
        // for(Set<String> l : this.graph.listOfLinks){
        //     link.add(vertex);
        //     link.add(this.);
        //     link = null;
        // }
        // this.graph.stream().filter(v->v.equals(vertex)).collect(collector)
        for(Edge e : this.graph){
            if(e.vertexIsInEdge(vertex)){
                if(distance >= e.distance){
                    distance = e.distance;
                    minDistantEdge = e;
                }
            }
        }
        return Optional.ofNullable(minDistantEdge).orElseThrow(GraphNotConnectedException::new);
    }

    String previous;

    public Graph(Set<Edge> graph, String source) {
        this.graph = graph;
        this.source = source;
        this.vertexes.addAll(graph.stream().map(Edge::getVertex1).collect(Collectors.toSet()));
        this.vertexes.addAll(graph.stream().map(Edge::getVertex2).collect(Collectors.toSet()));
        this.listOfLinks.addAll(graph.stream().map(Edge::getLink).collect(Collectors.toList()));
    }
    
    public void dijkstra(Graph graph, String source){
        Set<String> buffer;
        vertexes.stream().forEach(v->{

        });
    }
}    