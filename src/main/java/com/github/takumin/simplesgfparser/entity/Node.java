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

    public void addProperty(String propIdent, String propValue) {
        properties.put(propIdent, propValue);
    }

    public Object get(String propIdent) {
        return properties.get(propIdent);
    }
}
