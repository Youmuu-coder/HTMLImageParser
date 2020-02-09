package com.youmuu.core.command.tokenizer;

import com.youmuu.core.command.UpdatableCommand;
import com.youmuu.core.command.tokenizer.model.*;
import com.youmuu.core.state.tokenizer.TokenizerState;
import com.youmuu.core.state.tokenizer.TokenizerStateRepository;
import com.youmuu.core.token.TokenBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenizerCommandRepository {
    private Map<String, TokenizerCommand> commands;
    private List<UpdatableCommand<Character>> updatableCommands;

    public TokenizerCommandRepository(TokenBuilder tokenBuilder) {
        commands = new HashMap<>();
        updatableCommands = new ArrayList<>();
        AppendStringTCommand appendStringTCommand = new AppendStringTCommand(tokenBuilder);
        FlushAfterTCommand flushAfterTCommand = new FlushAfterTCommand(tokenBuilder);
        FlushBeforeTCommand flushBeforeTCommand = new FlushBeforeTCommand(tokenBuilder);
        EmptyTCommand emptyTCommand = new EmptyTCommand();

        commands.put(TokenizerStateRepository.StateIdentifier.DEFAULT_STATE.getState(), appendStringTCommand);
        commands.put(TokenizerStateRepository.StateIdentifier.FLUSH_AND_IGNORE_AFTER.getState(), flushBeforeTCommand);
        commands.put(TokenizerStateRepository.StateIdentifier.FLUSH_AND_IGNORE_BEFORE.getState(), flushAfterTCommand);
        commands.put(TokenizerStateRepository.StateIdentifier.IGNORE.getState(),emptyTCommand);
        updatableCommands.add(appendStringTCommand);
        updatableCommands.add(flushAfterTCommand);
    }

    public TokenizerCommand generateCommand(TokenizerState tokenizerState, char symbol) {
        updatableCommands.forEach(x -> x.updateData(Character.valueOf(symbol)));
        return commands.get(tokenizerState.getInfo());
    }
}
