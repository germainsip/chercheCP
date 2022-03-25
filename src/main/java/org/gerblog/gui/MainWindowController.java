/*
 *  ___ _                    _                   
 * |_ _| |_  __ __ _____ _ _| |__ ___  ___ _ _   
 *  | ||  _| \ V  V / _ \ '_| / /(_-< / _ \ ' \  
 * |___|\__|  \_/\_/\___/_| |_\_\/__/ \___/_||_| 
 *  _ __ _  _   _ __  __ _ __| |_ (_)_ _  ___    
 * | '  \ || | | '  \/ _` / _| ' \| | ' \/ -_)   
 * |_|_|_\_, | |_|_|_\__,_\__|_||_|_|_||_\___|   
 *       |__/                                    
 */
package org.gerblog.gui;

import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.util.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.gerblog.tool.listeCode;
import org.gerblog.tool.listeCodeV2;

/**
 *
 * @author germain
 */
public class MainWindowController implements Initializable {

    public JFXButton plus;
    public HBox focus;
    private listeCodeV2 lc;
    
    private Label label;
    @FXML
    private Label codePoOut;
    @FXML
    private TextField ville_input;
    @FXML
    private JFXButton quit;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->focus.requestFocus());
        lc = new listeCodeV2();
    }

    @FXML
    private void quit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void cherche(KeyEvent event) {
        List<String> result = lc.cpSearch(ville_input.getText());
        Collections.sort(result);
        plus.setVisible(result.size()>1); //TODO: ajouter la fenêtre de codes supplémentaires
        if (!result.isEmpty()) {
            codePoOut.setText(result.get(0));
        } else codePoOut.setText("");
    }
    
}
