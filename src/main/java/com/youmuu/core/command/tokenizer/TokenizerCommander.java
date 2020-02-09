package com.youmuu.core.command.tokenizer;

import com.youmuu.core.command.tokenizer.model.TokenizerCommand;
import com.youmuu.core.state.tokenizer.TokenizerState;

public class TokenizerCommander {
    private TokenizerCommandRepository tokenizerCommandRepository;
    public TokenizerCommander(TokenizerCommandRepository tokenizerCommandRepository) {
        this.tokenizerCommandRepository = tokenizerCommandRepository;
    }
    public TokenizerCommand generateCommand(TokenizerState tokenizerState, char symbol) {
        return tokenizerCommandRepository.generateCommand(tokenizerState, symbol);
    }
}
