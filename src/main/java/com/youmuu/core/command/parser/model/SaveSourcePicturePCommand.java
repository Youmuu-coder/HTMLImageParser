package com.youmuu.core.command.parser.model;

import com.youmuu.core.command.UpdatableCommand;
import com.youmuu.core.urlanalyzer.URLAnalyzer;
import com.youmuu.core.util.ImageInfoBuilder;

public class SaveSourcePicturePCommand extends ParserCommand implements UpdatableCommand<String> {
    private ImageInfoBuilder imageInfoBuilder;
    private URLAnalyzer urlAnalyzer;
    private String data;

    public SaveSourcePicturePCommand(ImageInfoBuilder imageInfoBuilder, URLAnalyzer urlAnalyzer) {
        this.imageInfoBuilder = imageInfoBuilder;
        this.urlAnalyzer = urlAnalyzer;
    }

    @Override
    public void execute() {
        if(!urlAnalyzer.isURL(data)) {
            data = urlAnalyzer.configureURL(data);
        }
        imageInfoBuilder.newSrc(data);
    }
    @Override
    public void updateData(String data) {
        this.data = data;
    }
}
