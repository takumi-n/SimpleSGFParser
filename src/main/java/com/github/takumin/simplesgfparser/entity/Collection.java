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

    public void addGameTree(GameTree tree) {
        trees.add(tree);
    }
}
