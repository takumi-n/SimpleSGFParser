
package com.github.takumin.simplesgfparser.exception;

/**
 * Exception for SGF parse
 * @author takumi
 */
public class SGFParseError extends Error {
    public SGFParseError(String msg) {
        super(msg);
    }
}