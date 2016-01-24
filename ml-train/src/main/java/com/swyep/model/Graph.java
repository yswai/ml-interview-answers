package com.swyep.model;

import java.util.Set;

public class Graph {

    private Set<Node> nodes;
    private Set<Edge> edges;

    public Graph(Set<Edge> edges, Set<Node> nodes) {
        this.edges = edges;
        this.nodes = nodes;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }
}
