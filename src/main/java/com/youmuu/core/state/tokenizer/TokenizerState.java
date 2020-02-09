package com.youmuu.core.state.tokenizer;

import java.util.Objects;

public class TokenizerState {
    private static final String DEFAULT_STATE = "DEFAULT_STATE";
    private String info;

    public TokenizerState() {
        info = DEFAULT_STATE;
    }

    public TokenizerState(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenizerState)) return false;
        TokenizerState that = (TokenizerState) o;
        return Objects.equals(getInfo(), that.getInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfo());
    }
}
