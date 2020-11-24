package dijkstra;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        Set<Edge> edges = Stream.of(new Edge("A", "D", 14), new Edge("A", "B", 7), new Edge("A", "C", 9),
                new Edge("D", "F", 9), new Edge("D", "C", 2), new Edge("C", "E", 11), new Edge("E", "F", 6),
                new Edge("B", "C", 10), new Edge("B", "E", 15)).collect(Collectors.toSet());
        Graph graph = new Graph(edges);
        Result expected = new Result();
        Result actual = graph.dijkstraAlgorithm("A");
        HashMap<String,Float> actualDistances = new HashMap<String,Float>();
        HashMap<String,String> actualPrevious = new HashMap<String,String>();

        actualDistances.put("A",(float) 0);
        actualDistances.put("B",(float) 7);
        actualDistances.put("C",(float) 9);
        actualDistances.put("D",(float) 11);
        actualDistances.put("E",(float) 20);
        actualDistances.put("F",(float) 20);
        actualPrevious.put("A","");
        actualPrevious.put("B","A");
        actualPrevious.put("C","A");
        actualPrevious.put("D","C");
        actualPrevious.put("E","C");
        actualPrevious.put("F","D");
        expected.setResult(actualDistances, actualPrevious);
        //System.out.println(expected.toString());
        assertEquals(expected, actual);
    }
}
