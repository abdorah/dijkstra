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
        HashMap<String, Float> expected = new HashMap<String, Float>();
        HashMap<String, Float> actual = graph.dijkstraAlgorithm("A");
        expected.put("A",(float) 0);
        expected.put("B",(float) 7);
        expected.put("C",(float) 9);
        expected.put("D",(float) 11);
        expected.put("E",(float) 20);
        expected.put("F",(float) 20);
        assertEquals(expected, actual);
    }
}
