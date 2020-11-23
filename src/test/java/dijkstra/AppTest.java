package dijkstra;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Set<Edge> edges = new HashSet<Edge>();

        Edge a = new Edge("A", "D", 14);
        Edge b = new Edge("A", "B", 7);
        Edge c = new Edge("A", "C", 9);
        Edge d = new Edge("D", "F", 9);
        Edge e = new Edge("D", "C", 2);
        Edge f = new Edge("C", "E", 11);
        Edge g = new Edge("E", "F", 6);
        Edge h = new Edge("B", "C", 10);
        Edge i = new Edge("B", "E", 15);

        edges = Stream.of(a,b,c,d,e,f,g,h,i).collect(Collectors.toSet());
        Graph graph = new Graph(edges, "A");
        HashMap<Float,List<String>> expectation = new HashMap<Float,List<String>>();
        HashMap<Float,List<String>> actual = new HashMap<Float,List<String>>();
        List<String> list = Arrays.asList("A","B","C","D","E");
        expectation.put((float) 20, list);
        actual = graph.dijkstraAlgorithm("A");
        assertEquals(expectation, actual);
        //assertTrue( true );
    }
}
