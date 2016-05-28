package com.github.takumin.simplesgfparser.parser;

import com.github.takumin.simplesgfparser.entity.Node;
import com.github.takumin.simplesgfparser.entity.Sequence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author takumi
 */
public class SGFParserTest {

    public SGFParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testParseCollection() {
        SGFParser p1 = new SGFParser("(;AP[SAMPLE1]FF[4];B[ai];W[ci])(;AP[SAMPLE2]FF[4]KM[7];B[jd];W[ab])");
        assert (2 == p1.getGameTreeCount());

        SGFParser p2 = new SGFParser("(;AP[SAMPLE1]FF[4];B[ai];W[ci])(;AP[SAMPLE1]FF[4];B[ai];W[ci])(;AP[SAMPLE1]FF[4];B[ai];W[ci])(;AP[SAMPLE2]FF[4]KM[7];B[jd];W[ab])");
        assert (4 == p2.getGameTreeCount());
    }

    @Test
    public void testParseMetadata() {
        SGFParser p = new SGFParser("(;AP[SAMPLE1]FF[4];B[ai];W[ci])(;AP[SAMPLE2]FF[4]KM[7];B[jd];W[ab])");
        Node n1 = p.getGameTree(0).getMetadata();
        assertEquals("SAMPLE1", n1.get("AP"));

        Node n2 = p.getGameTree(1).getMetadata();
        assertEquals("SAMPLE2", n2.get("AP"));
        assertEquals("7", n2.get("KM"));
    }

    @Test
    public void testParseSequence() {
        SGFParser p = new SGFParser("(;AP[SAMPLE1]FF[4];B[ai];W[ci])(;AP[SAMPLE2]FF[4]KM[7];B[jd];W[ab])");
        Sequence seq1 = p.getGameTree(0).getSequence();
        Node n1 = seq1.getNodes().get(0);
        assertEquals("4", n1.get("FF"));
        Node n2 = seq1.getNodes().get(1);
        assertEquals("ai", n2.get("B"));
        Node n3 = seq1.getNodes().get(2);
        assertEquals("ci", n3.get("W"));
    }
}
