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

    public static final int DEFAULT_MAX_ITERATIONS = 30;

    public int getFixedPathDistance(Graph graph, String expression) {
        String[] paths = expression.split("-");
        Set<Edge> edges = graph.getEdges();
        int total = 0;
        for (int i = 0; i < paths.length - 1; i++) {
            Node src = new Node(paths[i]);
            Node dst = new Node(paths[i + 1]);
            Edge edge = Iterables.find(edges, (e) -> e.getSource().equals(src) && e.getDestination().equals(dst), null);
            if (edge == null) return -1;
            total += edge.getWeight();
        }
        return total;
    }

    public long getNumberOfTripsWithMaxDistance(Graph graph, Node start, Node end, int maxDistance) {
        List<PathResult> routes = getPaths(graph, start, end, GraphService.DEFAULT_MAX_ITERATIONS);
        return routes.stream()
                .map(r -> r.getTotalWeight())
                .filter( d -> d < maxDistance).count();
    }

    public int getShortestPath(Graph graph, Node start, Node end) {
        List<PathResult> routes = getPaths(graph, start, end, GraphService.DEFAULT_MAX_ITERATIONS);
        return routes.stream()
                .map(r -> r.getTotalWeight())
                .min(Integer::compare).get();
    }

    public long getNumberOfTripsWithMaxStops(Graph graph, Node start, Node end, int maxIterations) {
        return getPaths(graph, start, end, maxIterations).size();
    }

    public long getNumberOfTripsWithExactStops(Graph graph, Node start, Node end, int stops) {
        return getPaths(graph, start, end, stops).stream()
                .filter(r -> r.getNodeList().size() - 1 == stops).count();
    }

    private List<PathResult> getPaths(Graph graph, Node start, Node end, int maxIterations) {
        List<PathResult> results = Lists.newArrayList();
        graph.getEdges().stream()
                .filter(e -> e.getSource().equals(start))
                .forEach(edge -> {
                    PathResult r = new PathResult(edge.getSource().toString(), 0, Lists.newArrayList(edge.getSource()));
                    buildAllPathsByStops(graph.getEdges(), r, results, edge, end, maxIterations);
                });
        return results;
    }

    private void buildAllPathsByStops(Set<Edge> edges, PathResult r, List<PathResult> results, Edge currentEdge,
                                      Node end, int maxIterations) {

        r.getNodeList().add(currentEdge.getDestination());
        r.setNodePath(r.getNodePath().concat(currentEdge.getDestination().toString()));
        r.setTotalWeight(r.getTotalWeight() + currentEdge.getWeight());

        if (currentEdge.getDestination().equals(end)) {
            results.add(r);
        }

        if (r.getNodeList().size() - 1 == maxIterations) {
            return;
        }

        edges.stream()
                .filter(e -> e.getSource().equals(currentEdge.getDestination()))
                .forEach(next -> {
                    PathResult r2 = new PathResult(r.getNodePath(), r.getTotalWeight(), Lists.newArrayList(r.getNodeList()));
                    buildAllPathsByStops(edges, r2, results, next, end, maxIterations);
                });
    }

}
