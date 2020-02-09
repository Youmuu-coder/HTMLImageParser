package com.youmuu.core;

import com.youmuu.connection.Reader;
import com.youmuu.core.command.tokenizer.model.TokenizerCommand;
import com.youmuu.core.command.tokenizer.TokenizerCommander;
import com.youmuu.core.state.tokenizer.TokenizerState;
import com.youmuu.core.state.tokenizer.TokenizerStateTransfer;
import com.youmuu.core.token.Token;
import com.youmuu.core.token.TokenBuilder;
import com.youmuu.core.tokenizer.Tokenizer;

import java.io.IOException;

public class SimpleHTMLTokenizer implements Tokenizer {
    private Reader reader;
    private TokenBuilder tokenBuilder;
    private TokenizerStateTransfer tokenizerStateTransfer;
    private TokenizerCommander tokenizerCommander;

    public SimpleHTMLTokenizer(Reader reader,
                               TokenBuilder tokenBuilder,
                               TokenizerStateTransfer tokenizerStateTransfer,
                               TokenizerCommander tokenizerCommander) {
        this.reader = reader;
        this.tokenBuilder = tokenBuilder;
        this.tokenizerStateTransfer = tokenizerStateTransfer;
        this.tokenizerCommander = tokenizerCommander;
    }

    @Override
    public boolean hasNextToken() throws IOException {
        return reader.hasNext();
    }

    @Override
    public Token nextToken() throws IOException {
        TokenizerState tokenizerState = tokenizerStateTransfer.startState();
        TokenizerCommand tokenizerCommand = null;
        char symbol = 0;
        while (reader.hasNext() && !tokenBuilder.isFormed()) {
            symbol = reader.nextByte();
            tokenizerState = tokenizerStateTransfer.nextState(tokenizerState, symbol);
            tokenizerCommand = tokenizerCommander.generateCommand(tokenizerState, symbol);
            tokenizerCommand.execute();
        }
        return tokenBuilder.getToken();
    }
}
