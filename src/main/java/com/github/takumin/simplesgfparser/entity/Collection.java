package com.github.takumin.simplesgfparser.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * EBNF: Collection = GameTree { GameTree }
 *
 * @author takumi
 */
public class Collection {

    @Getter
    private List<GameTree> trees;

    public Collection() {
        trees = new ArrayList<>();
    }

    /**
     * Appends the specified GameTree to this collection.
     * 
     * @param tree GameTree to be appended to this collection
     */
    public void addGameTree(GameTree tree) {
        trees.add(tree);
    }
}
