package com.youmuu.core.state.parser;

import com.youmuu.core.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class ParserStateRepository {
    public enum ParserTokens {
        OPEN_BRACKET("<"), CLOSE_BRACKET(">"),
        IMAGE("img"), SRC("src=");
        private String word;

        ParserTokens(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }
    }

    public enum StateIdentifier {
        IGNORE("ignore"), PREPARE_TO("prepare"), WAIT_SRC("wait_src"), DEFAULT("default"), SAVE_SRC("save_src"), NEXT_SRC("next_src");
        private String state;

        StateIdentifier(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    private Map<Pair<ParserState, String>, ParserState> parserStateMap;

    public ParserStateRepository() {
        parserStateMap = new HashMap<>();

        parserStateMap.put(new Pair<>(new ParserState(StateIdentifier.DEFAULT.state), ParserTokens.OPEN_BRACKET.word), new ParserState(StateIdentifier.PREPARE_TO.state));
        parserStateMap.put(new Pair<>(new ParserState(StateIdentifier.PREPARE_TO.state), ParserTokens.IMAGE.word), new ParserState(StateIdentifier.WAIT_SRC.state));
        parserStateMap.put(new Pair<>(new ParserState(StateIdentifier.WAIT_SRC.state), ParserTokens.SRC.word), new ParserState(StateIdentifier.NEXT_SRC.state));
    }

    public ParserState nextState(ParserState parserState, String item) {
        if(parserState.getInfo().equals(StateIdentifier.WAIT_SRC.state) && !item.equals(ParserTokens.SRC.word)) {
            return new ParserState(StateIdentifier.WAIT_SRC.state);
        }
        if(parserState.getInfo().equals(StateIdentifier.NEXT_SRC.state)) {
            return new ParserState(StateIdentifier.SAVE_SRC.state);
        }
        return parserStateMap.getOrDefault(new Pair<>(parserState, item), new ParserState(StateIdentifier.DEFAULT.state));
    }
}
