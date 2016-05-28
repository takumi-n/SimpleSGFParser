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

    public Node getMetadata() {
        return sequence.getNodes().get(0);
    }

    public void addGameTree(GameTree tree) {
        trees.add(tree);
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }
}
