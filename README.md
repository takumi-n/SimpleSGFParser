# SimpleSGFParser

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.takumi-n/simple-sgf-parser/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.takumi-n/simple-sgf-parser)
[![Build Status](https://travis-ci.org/takumi-n/SimpleSGFParser.svg?branch=master)](https://travis-ci.org/takumi-n/SimpleSGFParser)
[![Coverage Status](https://coveralls.io/repos/github/takumi-n/SimpleSGFParser/badge.svg)](https://coveralls.io/github/takumi-n/SimpleSGFParser?branch=master)


This is an simple SGF(Smart Game Format) parser written in Java.
SimpleSGFParser can parse all SGF text which confirms to SGF standard.

## How to Use

### Maven
```xml
<dependency>
    <groupId>com.github.takumi-n</groupId>
    <artifactId>simple-sgf-parser</artifactId>
    <version>1.0</version>
</dependency>
```

**very simple**

```java
SGFParser parser = new SGFParser(sgfString);
```

You can get GameTree by SGFParser#getGameTree(int index)

```java
GameTree tree = parser.getGameTree(1);
```

If SGF string has only one GameTree, it is simple to use SGFParser#getSingleGameTree()

```java
GameTree tree = parser.getSingleGameTree();
// Equals to parser.getGameTree(0);
```
