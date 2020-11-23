package dijkstra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    //static final Edge a = new Edge("A", "D", 14);
    // static final Edge b = new Edge("A", "B", 7);
    // static final Edge c = new Edge("A", "C", 9);
    // static final Edge d = new Edge("D", "F", 9);
    // static final Edge e = new Edge("D", "C", 2);
    // static final Edge f = new Edge("C", "E", 11);
    // static final Edge g = new Edge("E", "F", 6);
    // static final Edge h = new Edge("B", "C", 10);
    // static final Edge i = new Edge("B", "E", 15);
    public static void main( String[] args )
    {
        Set<Edge> edges = Stream.of(new Edge("A", "D", 14), new Edge("A", "B", 7), 
        new Edge("A", "C", 9), new Edge("D", "F", 9), new Edge("D", "C", 2), new Edge("C", "E", 11), 
        new Edge("E", "F", 6), new Edge("B", "C", 10), new Edge("B", "E", 15)).collect(Collectors.toSet());
        Graph graph = new Graph(edges);
        HashMap<Float,List<String>> expectation = new HashMap<Float,List<String>>();
        HashMap<Float,List<String>> actual = new HashMap<Float,List<String>>();
        List<String> list = Arrays.asList("A","B","C","D","E");
         //asList("A","B","C","D","E");
        expectation.put((float) 20, list);
        actual = graph.dijkstraAlgorithm("A");
        if(actual.equals(expectation))
        System.out.println( "Hello World!" );
    }
}
