package com.mango.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode {
    public String nodeName;
    public List<GraphNode> adjacentGraphNodes;


    public GraphNode(String nodeName, List<GraphNode> adjacentGraphNodes) {
        this.nodeName = nodeName;
        if(Objects.isNull(adjacentGraphNodes)) {
            adjacentGraphNodes = new ArrayList<>();
        }
        this.adjacentGraphNodes = adjacentGraphNodes;
    }

    public void addAdjacentGraphNode(GraphNode adjacentGraphNode) {
        if (Objects.isNull(adjacentGraphNode)) {
            return;
        }
        this.adjacentGraphNodes.add(adjacentGraphNode);
    }
}
