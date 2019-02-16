package com.mango.ds;

import java.util.ArrayList;
import java.util.List;

public class NArrayTreeNode {
    public int weight;
    public List<NArrayTreeNode> childes;

    public NArrayTreeNode(int weight) {
        this.weight = weight;
        this.childes = new ArrayList<>();
    }

    public NArrayTreeNode(int weight, List<NArrayTreeNode> childes) {
        this.weight = weight;
        this.childes = childes;
    }

    @Override
    public String toString() {
        return String.valueOf(weight);
    }
}
