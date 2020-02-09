package com.youmuu.core.command.tokenizer.model;

import com.youmuu.core.command.UpdatableCommand;
import com.youmuu.core.token.TokenBuilder;

public class FlushAfterTCommand extends TokenizerCommand implements UpdatableCommand<Character> {

    private TokenBuilder tokenBuilder;
    private Character data;

    public FlushAfterTCommand(TokenBuilder tokenBuilder) {
        this.tokenBuilder = tokenBuilder;
    }

    @Override
    public void updateData(Character data) {
        this.data = data;
    }

    @Override
    public void execute() {
        tokenBuilder.clear();
        tokenBuilder.appendChar(data);
        tokenBuilder.setFormed(true);
    }
}
