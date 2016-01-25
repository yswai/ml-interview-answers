package com.swyep.service;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.swyep.model.Edge;
import com.swyep.model.Graph;
import com.swyep.model.Node;
import com.swyep.model.PathResult;

import java.util.List;
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

    public int getNumberOfTripsWithMaxStops(Graph graph, Node start, Node end, int maxIterations) {
        return getPaths(graph, start, end, maxIterations).size();
    }

    public int getNumberOfTripsWithExactStops(Graph graph, Node start, Node end, int stops) {
        List<PathResult> results = getPaths(graph, start, end, stops);
        List<PathResult> filtered = Lists.newArrayList(Iterables.filter(results, r -> r.getNodeList().size() == stops));
        return filtered.size();
    }

    private List<PathResult> getPaths(Graph graph, Node start, Node end, int maxIterations) {
        Iterable<Edge> startEdges = Iterables.filter(graph.getEdges(), e -> e.getSource().equals(start));
        List<PathResult> results = Lists.newArrayList();
        for(Edge edge : startEdges) {
            PathResult r = new PathResult(edge.getSource().toString(), edge.getWeight(), Lists.newArrayList(edge.getSource()));
            recursive(graph.getEdges(), r, results, edge, end, maxIterations);
        }
        return results;
    }

    private void recursive(Set<Edge> edges, PathResult r, List<PathResult> results, Edge currentEdge, Node end, int maxIterations) {

        r.getNodeList().add(currentEdge.getDestination());
        r.setNodePath(r.getNodePath().concat(currentEdge.getDestination().toString()));
        r.setTotalWeight(r.getTotalWeight() + currentEdge.getWeight());

        if (currentEdge.getDestination().equals(end)) {
            results.add(r);
            return;
        }

        if (r.getNodeList().size() - 1 == maxIterations) {
            return;
        }

        Iterable<Edge> destEdges = Iterables.filter(edges, e -> e.getSource().equals(currentEdge.getDestination()));
        for(Edge next : destEdges) {
            PathResult r2 = new PathResult(r.getNodePath(), r.getTotalWeight(), r.getNodeList());
            recursive(edges, r2, results, next, end, maxIterations);
        }
    }

    public int getShortestRoute(Node start, Node end, int maxIterations) {
        return 0;
    }

}
