package com.youmuu.core.tokenizer;

import com.youmuu.connection.Reader;
import com.youmuu.core.SimpleHTMLTokenizer;
import com.youmuu.core.command.tokenizer.TokenizerCommandRepository;
import com.youmuu.core.command.tokenizer.TokenizerCommander;
import com.youmuu.core.state.tokenizer.TokenizerStateRepository;
import com.youmuu.core.state.tokenizer.TokenizerStateTransfer;
import com.youmuu.core.token.TokenBuilder;

public class TokenizerBuilder {

    public Tokenizer buildTokenizer(Reader reader) {
        TokenBuilder tokenBuilder = new TokenBuilder();
        TokenizerStateTransfer tokenizerStateTransfer = new TokenizerStateTransfer(new TokenizerStateRepository());
        TokenizerCommander tokenizerCommander = new TokenizerCommander(new TokenizerCommandRepository(tokenBuilder));
        SimpleHTMLTokenizer simpleHTMLTokenizer = new SimpleHTMLTokenizer(reader,
                tokenBuilder,
                tokenizerStateTransfer,
                tokenizerCommander
                );
        return simpleHTMLTokenizer;
    }
}
