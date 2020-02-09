package com.youmuu.core.parser;

import com.youmuu.core.HTMLPictureParser;
import com.youmuu.core.command.parser.ParserCommandRepository;
import com.youmuu.core.command.parser.ParserCommander;
import com.youmuu.core.state.parser.ParserStateRepository;
import com.youmuu.core.state.parser.ParserStateTransfer;
import com.youmuu.core.urlanalyzer.URLAnalyzer;
import com.youmuu.core.util.ImageInfoBuilder;

import java.net.URL;

public class ParserBuilder {
    public HTMLPictureParser buildHtmlPictureParser(URL reading) {
        ParserStateTransfer parserStateTransfer = new ParserStateTransfer(new ParserStateRepository());
        ImageInfoBuilder imageInfoBuilder = new ImageInfoBuilder();
        ParserCommander parserCommander = new ParserCommander(new ParserCommandRepository(imageInfoBuilder, new URLAnalyzer(reading)));

        HTMLPictureParser htmlPictureParser = new HTMLPictureParser(parserStateTransfer,
                parserCommander,
                imageInfoBuilder);
        return htmlPictureParser;
    }
}
