package com.github.takumin.simplesgfparser.entity;

import java.util.HashMap;
import lombok.Getter;

/**
 * EBNF:
 *  Node = ";" { Property }
 * @author takumi
 */
public class Node {
    @Getter
    private HashMap<String, String> properties;

    public Node() {
        properties = new HashMap<>();
    }

    /**
     * Appends the specified Property to this node.
     * 
     * @param propIdent id to represent value to be appended to this node
     * @param propValue value to be appended to this node
     */
    public void addProperty(String propIdent, String propValue) {
        properties.put(propIdent, propValue);
    }

    /**
     * Returns the propValue represented by propIdent.
     * 
     * @param propIdent propIdent to represent propValue
     * @return propValue to correspond to propIdent
     */
    public String get(String propIdent) {
        return properties.get(propIdent);
    }
}
