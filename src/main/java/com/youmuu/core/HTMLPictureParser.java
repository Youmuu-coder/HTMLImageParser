package com.youmuu.core;

import com.youmuu.core.command.parser.model.ParserCommand;
import com.youmuu.core.command.parser.ParserCommander;
import com.youmuu.core.state.parser.ParserState;
import com.youmuu.core.state.parser.ParserStateTransfer;
import com.youmuu.core.token.Token;
import com.youmuu.core.tokenizer.Tokenizer;
import com.youmuu.core.util.ImageInfo;
import com.youmuu.core.util.ImageInfoBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HTMLPictureParser {
    private ParserStateTransfer parserStateTransfer;
    private ParserCommander parserCommander;
    private ImageInfoBuilder imageInfoBuilder;

    public HTMLPictureParser(ParserStateTransfer parserStateTransfer, ParserCommander parserCommander, ImageInfoBuilder imageInfoBuilder) {
        this.parserStateTransfer = parserStateTransfer;
        this.parserCommander = parserCommander;
        this.imageInfoBuilder = imageInfoBuilder;
    }

    public void parseHTML(Tokenizer tokenizer) throws IOException {
        ParserState parserState = parserStateTransfer.startState();
        Token token = null;
        ParserCommand parserCommand = null;

        while (tokenizer.hasNextToken()) {
            token = tokenizer.nextToken();
            parserState = parserStateTransfer.nextState(parserState, token);
            parserCommand = parserCommander.generateCommand(token, parserState);
            parserCommand.execute();
        }
    }

    public List<ImageInfo> parseResult() {
        return new ArrayList<>(imageInfoBuilder.getImageInfoList());
    }
}
