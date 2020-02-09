package com.youmuu.connection;

import java.io.IOException;

public interface Reader extends AutoCloseable {
    boolean hasNext() throws IOException;
    String next() throws IOException;
    char nextByte() throws IOException;
}
