package dijkstra;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

public class Edge {
    
    String vertex1;
    String vertex2;
    //Set<String> link;
    float distance;

    public Edge(String vertex1, String vertex2, float distance) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        //this.link = new Set<String>();
        //Consumer<String> adder = v-> this.link.add(v);
        //Optional.ofNullable(this.link).ifPresent(adder.accept(vertex1));//add(vertex1);
        // Collections.addAll(Optional.ofNullable(this.link).get(),vertex1,vertex2);
        // this.link.add(vertex2);
        this.distance = distance;
    }

    public String getVertex1() {
        return vertex1;
    }

    public String getVertex2() {
        return vertex2;
    }

    public Set<String> getLink() {
        Set<String> link = new HashSet<String>();
        link.add(this.vertex1);
        link.add(this.vertex2);
        return Optional.ofNullable(link).orElseThrow(GraphNotConnectedException::new);
    }

    public boolean vertexIsInEdge(String vertex){
        boolean result = false;
        if(vertex.equals(this.vertex1) || vertex.equals(this.vertex2)){
            result = true;
        }
        return result;
    }
}
