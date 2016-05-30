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
     * Gets the metadata of GameTree.
     * Equals to get the first node.
     * 
     * @return Metadata Node
     */
    public Node getMetadata() {
        return sequence.getNodes().get(0);
    }

    /**
     * Adds GameTree to GameTree
     * 
     * @param tree 
     */
    public void addGameTree(GameTree tree) {
        trees.add(tree);
    }

    /**
     * Sets Sequence to GameTree.
     * 
     * @param sequence 
     */
    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }
}
