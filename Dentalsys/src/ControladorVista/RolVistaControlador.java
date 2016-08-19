package ControladorVista;

import Controlador.RolControlador;
import Modelo.RolModelo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Emilce Fernandez - Tanya Aquino
 */
public class RolVistaControlador implements Initializable {

    @FXML
    private TextField txtDescripcion;

    private String usuario = "postgres";
    private String password = "1234";

    /**
     * Método Action del botón Guardar.
     * @param event Evento.
     **/
    @FXML
    private void btnGuardarAction(ActionEvent event) {
        if (txtDescripcion.getText().isEmpty()) {
            mostrarMensaje("Guardar", "Debe introducir una descripción", Alert.AlertType.WARNING);
        } else {
            RolModelo rol = new RolModelo(txtDescripcion.getText());
            RolControlador tmp = new RolControlador(usuario, password);
            boolean accion = tmp.insertar(rol);
            if (accion) {
                mostrarMensaje("Guardar", "Datos Guardados", Alert.AlertType.INFORMATION);
                btnCancelarAction(null);
            } else {
                mostrarMensaje("Guardar", "No se pudieron guardar los datos.", Alert.AlertType.ERROR);
            }
        }
    }
    
    
    @FXML
    private void btnNuevoAction(ActionEvent event) {
        txtDescripcion.setDisable(false);
        txtDescripcion.requestFocus();
    }
    
    @FXML
    private void btnModificarAction(ActionEvent event) {
        txtDescripcion.setDisable(false);
        txtDescripcion.requestFocus();
    }
    
    
    @FXML
    private void btnEliminarAction(ActionEvent event){
        txtDescripcion.setDisable(true);
    }
    
    @FXML
    private void btnCancelarAction(ActionEvent event) {
        txtDescripcion.setDisable(true);
        txtDescripcion.setText(null);
    }
    /**
     * Método para mostrar ventanas de diálogo.
     * @param titulo Título del diálogo.
     * @param mensaje Mensaje del diálogo.
     * @param tipo Icono del diálogo.
     **/
    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo){
        Alert msj = new Alert(tipo);
                msj.setTitle(titulo);
                msj.setHeaderText(null);
                msj.setContentText(mensaje);
                msj.showAndWait();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtDescripcion.setDisable(true);
    }

}
