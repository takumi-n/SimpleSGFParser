package com.github.takumin.simplesgfparser.parser;

import com.github.takumin.simplesgfparser.entity.Collection;
import com.github.takumin.simplesgfparser.entity.GameTree;
import com.github.takumin.simplesgfparser.entity.Node;
import com.github.takumin.simplesgfparser.entity.Sequence;
import com.github.takumin.simplesgfparser.exception.SGFParseError;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse SGF string
 *
 * @author takumi
 */
public class SGFParser {

    private String sgf;
    private Collection collection;

    public SGFParser(String sgf) {
        this.sgf = sgf;
        collection = new Collection();
        parse();
    }

    public GameTree getSingleGameTree() {
        return getGameTree(0);
    }

    public GameTree getGameTree(int index) {
        return collection.getTrees().get(index);
    }

    public int getGameTreeCount() {
        return collection.getTrees().size();
    }

    private void parse() {
        List<String> rawTrees = getRawTrees(sgf);
        for (String rawTree : rawTrees) {
            GameTree gt = parseTree(rawTree);
            collection.addGameTree(gt);
        }
    }

    private List<String> getRawTrees(String sgf) {
        List<String> result = new ArrayList<>();
        int rbCount = 0;
        int lbCount = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < sgf.length(); i++) {
            char c = sgf.charAt(i);
            if (c == '(') {
                // If found right bracket is first, set i to start index
                if (rbCount == 0) {
                    start = i;
                }
                rbCount += 1;
            } else if (c == ')') {
                lbCount += 1;
                if (rbCount == lbCount) {
                    end = i;
                    result.add(sgf.substring(start, end + 1));
                    rbCount = 0;
                    lbCount = 0;
                }
            }
        }
        return result;
    }

    private GameTree parseTree(String rawTree) {
        GameTree result = new GameTree();
        String regex = "^\\((;[^\\(]+)(\\(.+\\))?\\)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(rawTree);
        if (m.find()) {
            if (m.groupCount() == 3) {
                // (Sequence {GameTree})
                result.setSequence(parseSequence(m.group(1)));
                result.addGameTree(parseTree(m.group(2)));
            } else if (m.groupCount() == 2) {
                // (Sequence)
                String rawSequence = m.group(1);
                result.setSequence(parseSequence(rawSequence));
            } else {
                throw new SGFParseError("Illegal format");
            }
        } else {
            throw new SGFParseError("Illegal format");
        }
        return result;
    }

    private Sequence parseSequence(String rawSequence) {
        Sequence result = new Sequence();
        char firstChar = rawSequence.charAt(0);
        if (firstChar != ';') {
            throw new SGFParseError("Illegal format");
        }
        rawSequence = rawSequence.substring(1);
        String[] rawNodes = rawSequence.split(";");

        for (String rawNode : rawNodes) {
            result.addNode(parseNode(rawNode));
        }
        return result;
    }

    //AP[1]KM[4]TM[40]
    private Node parseNode(String rawNode) {
        Node result = new Node();
        String regex1 = "[A-Z]+?\\[.+?\\]";
        Pattern p1 = Pattern.compile(regex1);
        Matcher m1 = p1.matcher(rawNode);
        while (m1.find()) {
            String regex2 = "([A-Z]+?)\\[(.+?)\\]";
            Pattern p2 = Pattern.compile(regex2);
            String k = m1.group();
            Matcher m2 = p2.matcher(k);
            if (m2.find()) {
                if (m2.groupCount() < 2) {
                    throw new SGFParseError("Illegal format Node found");
                }
                result.addProperty(m2.group(1), m2.group(2));
            } else {
                throw new SGFParseError("Illegal format Node found");
            }
        }
        return result;
    }
}
