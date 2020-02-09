package com.youmuu.core.state.tokenizer;

import com.youmuu.core.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class TokenizerStateRepository {
    public enum TokenIdentifier {
        OPEN_BRACKET("<"), CLOSE_BRACKET(">"),
        QUOTES("\""), WHITE_SPACE(" "), NEXT_LINE("\n");
        private String word;

        TokenIdentifier(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }
    }

    public enum StateIdentifier {
        FLUSH_AND_IGNORE_BEFORE("flush_and_ignore_before"), FLUSH_AND_IGNORE_AFTER("flush_and_ignore_after"), DEFAULT_STATE("default_state"), IGNORE("ignore");
        private String state;

        StateIdentifier(String state) {
            this.state = state;
        }
        public String getState() {
            return state;
        }
    }

    private Map<Pair<TokenizerState, String>, TokenizerState> tokenizerStateMap;

    public TokenizerStateRepository() {
        tokenizerStateMap = new HashMap<>();

        //DEFAULT STATE
        tokenizerStateMap.put(new Pair<>(new TokenizerState(StateIdentifier.DEFAULT_STATE.state), TokenIdentifier.OPEN_BRACKET.word), new TokenizerState(StateIdentifier.FLUSH_AND_IGNORE_BEFORE.state));
        tokenizerStateMap.put(new Pair<>(new TokenizerState(StateIdentifier.DEFAULT_STATE.state), TokenIdentifier.CLOSE_BRACKET.word), new TokenizerState(StateIdentifier.FLUSH_AND_IGNORE_BEFORE.state));
        tokenizerStateMap.put(new Pair<>(new TokenizerState(StateIdentifier.DEFAULT_STATE.state), TokenIdentifier.WHITE_SPACE.word), new TokenizerState(StateIdentifier.FLUSH_AND_IGNORE_AFTER.state));
        tokenizerStateMap.put(new Pair<>(new TokenizerState(StateIdentifier.DEFAULT_STATE.state), TokenIdentifier.QUOTES.word), new TokenizerState(StateIdentifier.FLUSH_AND_IGNORE_AFTER.state));
        tokenizerStateMap.put(new Pair<>(new TokenizerState(StateIdentifier.DEFAULT_STATE.state), TokenIdentifier.NEXT_LINE.word), new TokenizerState(StateIdentifier.FLUSH_AND_IGNORE_AFTER.state));

        //
        tokenizerStateMap.put(new Pair<>(new TokenizerState(StateIdentifier.FLUSH_AND_IGNORE_AFTER.state), TokenIdentifier.WHITE_SPACE.word), new TokenizerState(StateIdentifier.IGNORE.state));
        tokenizerStateMap.put(new Pair<>(new TokenizerState(StateIdentifier.FLUSH_AND_IGNORE_AFTER.state), TokenIdentifier.NEXT_LINE.word), new TokenizerState(StateIdentifier.IGNORE.state));
        tokenizerStateMap.put(new Pair<>(new TokenizerState(StateIdentifier.IGNORE.state), TokenIdentifier.WHITE_SPACE.word), new TokenizerState(StateIdentifier.IGNORE.state));
        tokenizerStateMap.put(new Pair<>(new TokenizerState(StateIdentifier.IGNORE.state), TokenIdentifier.NEXT_LINE.word), new TokenizerState(StateIdentifier.IGNORE.state));
    }

    public TokenizerState nextState(TokenizerState tokenizerState, String item) {
        return tokenizerStateMap.getOrDefault(new Pair<>(tokenizerState, item), new TokenizerState(StateIdentifier.DEFAULT_STATE.state));
    }
}
