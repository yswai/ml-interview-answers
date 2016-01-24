package com.swyep.service;

import com.google.common.collect.Iterables;
import com.swyep.model.Edge;
import com.swyep.model.Graph;
import com.swyep.model.Node;

import java.util.Set;

public class GraphService {

    public int getFixedPathDistance(Graph graph, String expression) {
        String[] paths = expression.split("-");
        Set<Edge> edges = graph.getEdges();
        int total = 0;
        for (int i = 0 ; i < paths.length - 1  ; i++) {
            Node src = new Node(paths[i]);
            Node dst = new Node(paths[i + 1]);
            Edge edge = Iterables.find(edges, (e) ->
                    e.getSource().equals(src) && e.getDestination().equals(dst), null);
            if ( edge == null) return -1;
            total += edge.getWeight();
        }
        return total;
    }

    public int getNumberOfTrips(Node start, Node end, int maxIterations) {
        return 0;
    }

    public int getShortestRoute(Node start, Node end, int maxIterations) {
        return 0;
    }

}
