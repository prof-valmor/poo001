package com.example.primeirofx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.*;

public class HelloController {
    @FXML
    private WebView webView;
    @FXML
    private TextField txtUrl;

    @FXML
    protected void onGoAction() {
        WebEngine engine = webView.getEngine();
        String url = txtUrl.getText();
        String searchUrl = "https://www.google.com/search?q=";
        if(url.startsWith("http")) {
            engine.load(url);
        }
        else {
            engine.load(searchUrl + url);
        }
    }
}