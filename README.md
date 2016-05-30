# SimpleSGFParser

This is an simple SGF(Smart Game Format) parser written in Java.
SimpleSGFParser can parse all SGF text which confirm to SGF standard.

## How to Use

### Maven
```xml

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

