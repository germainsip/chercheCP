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

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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
    List<String> result;
    
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
        result = lc.cpSearch(ville_input.getText());
        Collections.sort(result);
        ajoutAutreCp(result.size()>1);
        if (!result.isEmpty()) {
            codePoOut.setText(result.get(0));
        } else codePoOut.setText("");
    }


    public void afficheLesAutres(ActionEvent actionEvent) {
        JFXListView<Label> list = new JFXListView<>();

        for(String res : result){
            list.getItems().add(new Label(res));
        }
        JFXPopup popup = new JFXPopup(list);
        popup.show(plus);
    }

    public void ajoutAutreCp(boolean oui){
        plus.setVisible(oui);
        if (oui){
        Tooltip cpPlus = new Tooltip();
        cpPlus.setText(result.toString());
        codePoOut.setTooltip(cpPlus);}
    }
}
