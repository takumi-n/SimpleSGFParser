
package com.github.takumin.simplesgfparser.exception;

/**
 * Thrown to indicate that it fails to parse
 * @author takumi
 */
public class SGFParseError extends Error {
    public SGFParseError(String msg) {
        super(msg);
    }
}