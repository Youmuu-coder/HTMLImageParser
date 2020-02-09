package com.youmuu.controller;

import com.youmuu.connection.BufferedHTMLReader;
import com.youmuu.connection.WebReader;
import com.youmuu.core.HTMLPictureParser;
import com.youmuu.core.parser.ParserBuilder;
import com.youmuu.core.tokenizer.Tokenizer;
import com.youmuu.core.tokenizer.TokenizerBuilder;
import com.youmuu.core.util.ImageInfo;
import com.youmuu.core.util.ImageInfoConfigurator;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class SimpleSceneController {
    @FXML
    private Button submit;
    @FXML
    private TextField url;

    @FXML
    private TableView<ImageInfo> table;

    @FXML
    private TableColumn<ImageInfo, String> urlCol;

    @FXML
    private TableColumn<ImageInfo, String> byteCol;

    @FXML
    private TableColumn<ImageInfo, String> formatCol;

    @FXML
    private DialogPane dialog;

    @FXML
    private void initialize() {
        submit.setOnAction(e -> submitButtonEvent(url.getText()));

        urlCol.setCellValueFactory(new PropertyValueFactory<ImageInfo, String>("url"));
        byteCol.setCellValueFactory(new PropertyValueFactory<ImageInfo, String>("size"));
        formatCol.setCellValueFactory(new PropertyValueFactory<ImageInfo, String>("format"));
    }

    private void submitButtonEvent(String URL) {
        try(WebReader webReader = new BufferedHTMLReader()) {
            dialog.setContentText("WAIT");
            webReader.setConnection(URL, "UTF-8");
            HTMLPictureParser htmlPictureParser = new ParserBuilder().buildHtmlPictureParser(new URL(URL));
            Tokenizer tokenizer = new TokenizerBuilder().buildTokenizer(webReader);
            htmlPictureParser.parseHTML(tokenizer);
            List<ImageInfo> result = htmlPictureParser.parseResult();
            ImageInfoConfigurator.configure(result);
            table.getItems().clear();
            result.forEach(this::addToTableElements);
            dialog.setContentText("SUCCESS");
        } catch (Exception e) {
            dialog.setContentText(e.getMessage());
        }
    }

    private void addToTableElements(ImageInfo imageInfo) {
        ObservableList<ImageInfo> list = table.getItems();
        System.out.println(imageInfo.getUrl());
        list.add(imageInfo);
        table.setItems(list);
    }
}
