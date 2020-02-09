package com.youmuu.core.command.parser;

import com.youmuu.core.command.parser.model.ParserCommand;
import com.youmuu.core.state.parser.ParserState;
import com.youmuu.core.token.Token;

public class ParserCommander {
    private ParserCommandRepository parserCommandRepository;

    public ParserCommander(ParserCommandRepository parserCommandRepository) {
        this.parserCommandRepository = parserCommandRepository;
    }

    public ParserCommand generateCommand(Token token, ParserState parserState) {
        return parserCommandRepository.generateCommand(token, parserState);
    }
}
