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
package cherchecp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author germain
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Label codePoOut;
    @FXML
    private JFXTextField ville_imput;
    @FXML
    private JFXButton quit;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listeCode.chargement();
    }    

    @FXML
    private void faitLe(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    private void cherche(KeyEvent event) {
        codePoOut.setText(listeCode.codepost.get(ville_imput.getText().toUpperCase()));
    }
    
}
