package com.youmuu.core.state.tokenizer;

public class TokenizerStateTransfer {
    private TokenizerStateRepository tokenizerStateRepository;
    private StringBuilder converter;

    public TokenizerStateTransfer(TokenizerStateRepository tokenizerStateRepository) {
        this.tokenizerStateRepository = tokenizerStateRepository;
        this.converter = new StringBuilder();
    }

    public TokenizerState startState() {
        return new TokenizerState(TokenizerStateRepository.StateIdentifier.DEFAULT_STATE.getState());
    }

    public TokenizerState nextState(TokenizerState tokenizerState, char symbol) {
        converter.append(symbol);
        String next = converter.toString();
        converter.setLength(0);
        return tokenizerStateRepository.nextState(tokenizerState, next);
    }
}
