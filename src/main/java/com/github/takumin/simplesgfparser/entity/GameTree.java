package com.github.takumin.simplesgfparser.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * EBNF: GameTree = "(" Sequence { GameTree } ")"
 *
 * @author takumi
 */
public class GameTree {
    @Getter
    private Sequence sequence;
    @Getter
    private List<GameTree> trees;

    public GameTree() {
        trees = new ArrayList<>();
    }

    /**
     * Returns the metadata Node of this tree.
     * This method is equals to #getSequence.getNodes.get(0).
     * 
     * @return Metadata Node
     */
    public Node getMetadata() {
        return sequence.getNodes().get(0);
    }

    /**
     * Appends the specified GameTree to this collection.
     * 
     * @param tree GameTree to be appended to this collection
     */
    public void addGameTree(GameTree tree) {
        trees.add(tree);
    }

    /**
     * Sets the specified Sequence to this tree.
     * 
     * @param sequence sequence to be set to this tree
     */
    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }
}
