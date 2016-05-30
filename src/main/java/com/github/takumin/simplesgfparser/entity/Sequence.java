package com.github.takumin.simplesgfparser.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * EBNF:
 *  Sequence = Node { Node }
 * @author takumi
 */
public class Sequence {
    @Getter
    private List<Node> nodes;

    public Sequence() {
        nodes = new ArrayList<>();
    }

    /**
     * Appends the specified GameTree to this sequence.
     * 
     * @param node node to be appended to this sequence
     */
    public void addNode(Node node) {
        nodes.add(node);
    }
}
