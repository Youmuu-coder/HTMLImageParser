package com.youmuu.core.command.tokenizer.model;

import com.youmuu.core.token.TokenBuilder;

public class FlushBeforeTCommand extends TokenizerCommand {

    private TokenBuilder tokenBuilder;

    public FlushBeforeTCommand(TokenBuilder tokenBuilder) {
        this.tokenBuilder = tokenBuilder;
    }

    @Override
    public void execute() {
        tokenBuilder.setFormed(true);
    }
}
