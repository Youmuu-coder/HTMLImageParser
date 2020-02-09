package com.youmuu.core.tokenizer;

import com.youmuu.core.token.Token;

import java.io.IOException;

public interface Tokenizer {
    boolean hasNextToken() throws IOException;
    Token nextToken() throws IOException;
}
