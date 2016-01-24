import com.google.common.collect.Sets;
import com.swyep.model.Edge;
import com.swyep.model.Graph;
import com.swyep.model.Node;
import com.swyep.service.GraphService;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;

import static org.junit.Assert.*;

public class GraphServiceTest {

    private GraphService graphService;
    private Graph graph;
    private Set<Node> nodes = Sets.newHashSet();
    private Set<Edge> edges = Sets.newHashSet();

    @Before
    public void setup() {
        graph = new Graph(edges, nodes);
        addLane("A", "B", 5);
        addLane("B", "C", 4);
        addLane("C", "D", 8);
        addLane("D", "C", 8);
        addLane("D", "E", 6);
        addLane("A", "D", 5);
        addLane("C", "E", 2);
        addLane("E", "B", 3);
        addLane("A", "E", 7);
        graphService = new GraphService();
    }

    @Test
    public void testGraphService() {
        assertEquals(9, graphService.getFixedPathDistance(graph, "A-B-C"));
        assertEquals(5, graphService.getFixedPathDistance(graph, "A-D"));
        assertEquals(13, graphService.getFixedPathDistance(graph, "A-D-C"));
        assertEquals(22, graphService.getFixedPathDistance(graph, "A-E-B-C-D"));
        assertEquals(-1, graphService.getFixedPathDistance(graph, "A-E-D"));
    }

    private void addLane(String src, String dest, int weight) {
        Node srcNode = new Node(src);
        Node destNode = new Node(dest);
        if (!nodes.contains(new Node(src))) nodes.add(srcNode);
        if (!nodes.contains(new Node(dest))) nodes.add(destNode);
        Edge newEdge = new Edge(srcNode, destNode, weight);
        edges.add(newEdge);
    }

}
