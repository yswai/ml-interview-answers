import com.google.common.collect.Sets;
import com.swyep.model.Edge;
import com.swyep.model.Graph;
import com.swyep.model.Node;
import com.swyep.service.GraphService;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class GraphServiceTest {

    private GraphService graphService;
    private Graph graph;

    @Before
    public void setup() {
        Set<Node> nodes = Sets.newHashSet();
        Set<Edge> edges = Sets.newHashSet();
        graph = new Graph(edges, nodes);
        graphService = new GraphService();
    }

    @Test
    public void testGraphService() {

    }

}
