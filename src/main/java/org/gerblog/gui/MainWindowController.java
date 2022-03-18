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
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.gerblog.tool.listeCode;

/**
 *
 * @author germain
 */
public class MainWindowController implements Initializable {
    
    listeCode lc;
    
    private Label label;
    @FXML
    private Label codePoOut;
    @FXML
    private TextField ville_input;
    @FXML
    private JFXButton quit;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lc = new listeCode();
        lc.chargement();
    }    

    @FXML
    private void faitLe(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    private void cherche(KeyEvent event) {
       // TODO: to be simplified
        codePoOut.setText(lc.getCodepost().get(lc.chaineStandard(ville_input.getText())));
    }
    
}
