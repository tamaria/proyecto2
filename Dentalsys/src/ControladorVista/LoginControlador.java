package ControladorVista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Emilce Fernandez - Tanya Aquino
 */
public class LoginControlador implements Initializable {

    @FXML
    private Label lblMensaje;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    
    
    @FXML
    private void btnLoginAction(ActionEvent event) {
        
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
