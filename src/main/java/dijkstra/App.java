package dijkstra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main( String[] args )
    {
        Set<Edge> edges = Stream.of(new Edge("A", "D", 14), new Edge("A", "B", 7),
                new Edge("A", "C", 9), new Edge("D", "F", 9), new Edge("D", "C", 2), new Edge("C", "E", 11),
                new Edge("E", "F", 6), new Edge("B", "C", 10), new Edge("B", "E", 15)).collect(Collectors.toSet());
        Graph graph = new Graph(edges);
        HashMap<Float,List<String>> expectation = new HashMap<Float,List<String>>();
        HashMap<String, Float> actual = new HashMap<String, Float>();
        List<String> list = Arrays.asList("A","B","C","D","E");
        expectation.put((float) 20, list);
        actual = graph.dijkstraAlgorithm("A");
        System.out.println(actual.toString());
        // if(actual.equals(expectation)){
        //     System.out.println( "Hello World!" );
        // }
    }
}