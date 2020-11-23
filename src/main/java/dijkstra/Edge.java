package dijkstra;

import java.util.Collections;
import java.util.Set;

public class Edge {
    
    String vertex1;
    String vertex2;
    Set<String> link;
    float distance;

    public Edge(String vertex1, String vertex2, float distance) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.link = (Set<String>) Collections.EMPTY_SET;
        this.link.add(vertex1);
        this.link.add(vertex2);
        this.distance = distance;
    }

    public String getVertex1() {
        return vertex1;
    }

    public String getVertex2() {
        return vertex2;
    }

    public Set<String> getLink() {
        return link;
    }

    public boolean vertexIsInEdge(String vertex){
        boolean result = false;
        if(vertex.equals(this.vertex1) || vertex.equals(this.vertex2)){
            result = true;
        }
        return result;
    }
}
