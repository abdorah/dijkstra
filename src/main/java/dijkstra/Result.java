package dijkstra;

import java.util.HashMap;

public class Result {
    HashMap<String,Float> distances;
    HashMap<String,String> previous;
    
    public void setResult(HashMap<String, Float> distances, HashMap<String, String> previous) {
        this.distances = distances;
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Result [distances=" + distances + ", previous=" + previous + "]";
    }
}
