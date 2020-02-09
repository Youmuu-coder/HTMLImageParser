package com.youmuu.core.command.parser;

import com.youmuu.core.command.UpdatableCommand;
import com.youmuu.core.command.parser.model.EmptyCommand;
import com.youmuu.core.command.parser.model.ParserCommand;
import com.youmuu.core.command.parser.model.SaveSourcePicturePCommand;
import com.youmuu.core.state.parser.ParserState;
import com.youmuu.core.state.parser.ParserStateRepository;
import com.youmuu.core.token.Token;
import com.youmuu.core.urlanalyzer.URLAnalyzer;
import com.youmuu.core.util.ImageInfoBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserCommandRepository {
    private Map<String, ParserCommand> commands;
    private List<UpdatableCommand<String>> updatableCommands;

    public ParserCommandRepository(ImageInfoBuilder imageInfoBuilder, URLAnalyzer urlAnalyzer) {
        commands = new HashMap<>();
        updatableCommands = new ArrayList<>();
        SaveSourcePicturePCommand saveSourcePicturePCommand = new SaveSourcePicturePCommand(imageInfoBuilder, urlAnalyzer);
        commands.put(ParserStateRepository.StateIdentifier.SAVE_SRC.getState(), saveSourcePicturePCommand);
        updatableCommands.add(saveSourcePicturePCommand);
    }

    public ParserCommand generateCommand(Token token, ParserState parserState) {
        updatableCommands.forEach(x -> x.updateData(token.getInfo()));
        return commands.getOrDefault(parserState.getInfo(), new EmptyCommand());
    }
}
