package com.youmuu.core.token;

import com.youmuu.core.token.Token;

public class TokenBuilder {
    private StringBuilder stringBuilder;
    private boolean isFormed;

    public TokenBuilder() {
        stringBuilder = new StringBuilder();
    }

    public boolean isFormed() {
        return isFormed;
    }

    public Token getToken() {
        Token res = new Token(stringBuilder.toString());
        clear();
        return res;
    }

    public void appendChar(Character character) {
        stringBuilder.append(character);
    }

    public void clear() {
        stringBuilder.setLength(0);
        isFormed = false;
    }

    public void setFormed(boolean formed) {
        isFormed = formed;
    }
}
