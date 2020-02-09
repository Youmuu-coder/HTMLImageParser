package com.youmuu.core.command.tokenizer.model;

import com.youmuu.core.command.UpdatableCommand;
import com.youmuu.core.token.TokenBuilder;

public class AppendStringTCommand extends TokenizerCommand implements UpdatableCommand<Character> {

    private TokenBuilder tokenBuilder;
    private Character data;

    public AppendStringTCommand(TokenBuilder tokenBuilder) {
        this.tokenBuilder = tokenBuilder;
    }

    @Override
    public void execute() {
        tokenBuilder.appendChar(data);
    }

    @Override
    public void updateData(Character data) {
        this.data = data;
    }
}
