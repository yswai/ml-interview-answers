package com.swyep.model;

import java.util.List;

public class PathResult {

    List<Node> nodeList;
    String nodePath;
    int totalWeight;

    public PathResult() {
    }

    public PathResult(String nodePath, int totalWeight, List<Node> nodeList) {
        this.nodePath = nodePath;
        this.totalWeight = totalWeight;
        this.nodeList = nodeList;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public String getNodePath() {
        return nodePath;
    }

    public void setNodePath(String nodePath) {
        this.nodePath = nodePath;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

}
