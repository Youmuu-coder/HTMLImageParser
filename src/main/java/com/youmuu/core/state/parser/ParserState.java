package com.youmuu.core.state.parser;

import java.util.Objects;

public class ParserState {
    private String info;

    public ParserState(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParserState)) return false;
        ParserState that = (ParserState) o;
        return Objects.equals(getInfo(), that.getInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfo());
    }
}
