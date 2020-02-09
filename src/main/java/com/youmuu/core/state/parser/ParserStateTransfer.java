package com.youmuu.core.state.parser;

import com.youmuu.core.token.Token;

public class ParserStateTransfer {
    private ParserStateRepository parserStateRepository;

    public ParserStateTransfer(ParserStateRepository parserStateRepository) {
        this.parserStateRepository = parserStateRepository;
    }

    public ParserState startState() {
        return new ParserState(ParserStateRepository.StateIdentifier.DEFAULT.getState());
    }

    public ParserState nextState(ParserState parserState, Token token) {
        return parserStateRepository.nextState(parserState, token.getInfo());
    }
}
