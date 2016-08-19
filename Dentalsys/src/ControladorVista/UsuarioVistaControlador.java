package ControladorVista;

import Controlador.RolControlador;
import Controlador.UsuarioControlador;
import Modelo.UsuarioModelo;
import com.sun.net.httpserver.Filter;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Emilce Fernandez - Tanya Aquino
 */
public class UsuarioVistaControlador implements Initializable {

    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConfirmarPassword;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEmail;
    @FXML
    private ComboBox cboxRol;
    @FXML
    private ToggleButton tbtnActivo;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblConfirmarPassword;

    private String operacion = null;
    private String usuario = "postgres";
    private String password = "1234";

    @FXML
    private void btnNuevoAction(ActionEvent event) {
        inicializarFormulario(false, false, false);
        txtCodigo.setDisable(true);
        operacion = "NUEVO";
    }

    @FXML
    private void btnModificarAction(ActionEvent event) {
        inicializarFormulario(true, false, false);
        txtCodigo.setDisable(false);
        txtCodigo.requestFocus();
        operacion = "MODIFICAR";
    }

    @FXML
    private void btnEliminarAction(ActionEvent event) {
        inicializarFormulario(true, false, false);
        txtCodigo.setDisable(false);
        txtCodigo.requestFocus();
        operacion = "ELIMINAR";
    }

    @FXML
    private void btnGuardarAction(ActionEvent event) {
        if (txtUsuario.getText().isEmpty() || txtPassword.getText().isEmpty() || txtConfirmarPassword.getText().isEmpty()
                || txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()) {
            mostrarMensaje("Guardar", "Debe completar todos los campos", Alert.AlertType.WARNING);
        } else {
            try {
                //Carga código del Rol según la Descripción elegida en el comboBox
                RolControlador aux_rol = new RolControlador(usuario, password);
                int rol_codigo = 0;
                ResultSet rs = aux_rol.selectByDescripcion(cboxRol.getSelectionModel().getSelectedItem().toString());
                if (rs.next()) {
                    rol_codigo = rs.getInt(1);
                }

                //Carga 1 si esta activo, 2 si esta inactivo
                short activo = 0;
                if (tbtnActivo.isSelected()) {
                    activo = 1;
                } else {
                    activo = 2;
                }
                if (txtEmail.getText() == null) {
                    txtEmail.setText("");
                }
                UsuarioControlador aux_usuario_controlador = new UsuarioControlador(usuario, password);
                if (operacion.equals("NUEVO")) {
                    //Instancia un objeto UsuarioModelo con todos los datos necesarios
                    UsuarioModelo aux_usuario;
                    aux_usuario = new UsuarioModelo(
                            rol_codigo,
                            txtUsuario.getText(),
                            txtPassword.getText(),
                            Integer.parseInt(txtCedula.getText()),
                            txtNombre.getText(),
                            txtApellido.getText(),
                            activo,
                            txtEmail.getText());
                    boolean insertar = aux_usuario_controlador.insertar(aux_usuario);
                    if (insertar) {
                        mostrarMensaje("Guardar", "Datos Guardados", Alert.AlertType.INFORMATION);
                        inicializarFormulario(true, true, true);
                    } else {
                        mostrarMensaje("Guardar", "No se pudieron guardar los datos", Alert.AlertType.ERROR);
                        inicializarFormulario(true, true, true);
                    }
                }
                if (operacion.equals("MODIFICAR")) {
                    //Instancia un objeto UsuarioModelo con todos los datos necesarios
                    UsuarioModelo aux_usuario;
                    aux_usuario = new UsuarioModelo(
                            Integer.parseInt(txtCodigo.getText()),
                            rol_codigo,
                            txtUsuario.getText(),
                            txtPassword.getText(),
                            Integer.parseInt(txtCedula.getText()),
                            txtNombre.getText(),
                            txtApellido.getText(),
                            activo,
                            txtEmail.getText());
                    boolean actualizar = aux_usuario_controlador.actualizar(aux_usuario);
                    if (actualizar) {
                        mostrarMensaje("Guardar", "Datos Guardados", Alert.AlertType.INFORMATION);
                        inicializarFormulario(true, true, true);
                    } else {
                        mostrarMensaje("Guardar", "No se pudieron guardar los datos", Alert.AlertType.ERROR);
                        inicializarFormulario(true, true, true);
                    }
                }
                if (operacion.equals("ELIMINAR")) {
                    UsuarioModelo aux_usuario = new UsuarioModelo(
                            Integer.parseInt(txtCodigo.getText()),
                            rol_codigo,
                            txtUsuario.getText(),
                            txtPassword.getText(),
                            Integer.parseInt(txtCedula.getText()),
                            txtNombre.getText(),
                            txtApellido.getText(),
                            activo,
                            txtEmail.getText());
                    boolean eliminar = false;
                    boolean confirmacion = mostrarMensajeConfirmacion("Eliminar", "¿Esta seguro que desea eliminar el registro?");
                    if (confirmacion) {
                        eliminar = aux_usuario_controlador.eliminar(aux_usuario);
                        if (eliminar) {
                            mostrarMensaje("Guardar", "Datos Guardados", Alert.AlertType.INFORMATION);
                            inicializarFormulario(true, true, true);
                        } else {
                            mostrarMensaje("Guardar", "No se pudieron guardar los datos", Alert.AlertType.ERROR);
                            inicializarFormulario(true, true, true);
                        }
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioVistaControlador.class.getName()).log(Level.SEVERE, null, ex);
                mostrarMensaje("Guardar", "Ocurrió un error al guardar los datos", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    private void btnCancelarAction(ActionEvent event
    ) {
        inicializarFormulario(true, true, true);
        operacion = null;
    }

    @FXML
    private void txtCodigoAction(ActionEvent event
    ) {
        UsuarioControlador aux_usuario = new UsuarioControlador(usuario, password);
        RolControlador aux_rol = new RolControlador(usuario, password);
        ResultSet rs_usuario = aux_usuario.selectByCodigo(txtCodigo.getText());
        ResultSet rs_rol;
        try {
            if (rs_usuario.next()) {
                txtUsuario.setText(rs_usuario.getString(3));
                txtPassword.setText(rs_usuario.getString(4));
                txtConfirmarPassword.setText(rs_usuario.getString(4));
                txtCedula.setText(rs_usuario.getString(5));
                txtNombre.setText(rs_usuario.getString(6));
                txtApellido.setText(rs_usuario.getString(7));
                txtEmail.setText(rs_usuario.getString(9));
                if (rs_usuario.getShort(8) == 1) {
                    tbtnActivo.setSelected(true);
                } else {
                    tbtnActivo.setSelected(false);
                }
                rs_rol = aux_rol.selectByCodigo(String.valueOf(rs_usuario.getInt(2)));
                if (rs_rol.next()) {
                    cboxRol.getSelectionModel().select(rs_rol.getString(2));
                }
                inicializarFormulario(false, false, false);
                txtCodigo.setDisable(true);
            } else {
                mostrarMensaje("Usuario", "No existe el código ingresado", Alert.AlertType.WARNING);
                txtCodigo.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioVistaControlador.class.getName()).log(Level.SEVERE, null, ex);
            mostrarMensaje("Usuario", "No se pudo obtener el código", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void txtConfirmarPasswordKeyReleased(KeyEvent event) {
        if (txtPassword.getText().equals(txtConfirmarPassword.getText())) {
            lblConfirmarPassword.setTextFill(Color.GREEN);
            lblConfirmarPassword.setText("Correcto");
        } else {
            lblConfirmarPassword.setTextFill(Color.RED);
            lblConfirmarPassword.setText("Incorrecto");
        }
    }
    
    @FXML
    private void txtCodigoKeyTyped(KeyEvent event) {
        char c = event.getCharacter().charAt(0);
        if(!Character.isDigit(c)) {
            event.consume();
        }

    }
    
    @FXML
    private void txtCedulaKeyTyped(KeyEvent event) {
        char c = event.getCharacter().charAt(0);
        if(!Character.isDigit(c)) {
            event.consume();
        }

    }
    private void inicializarFormulario(boolean estado_campos, boolean estado_botones, boolean limpiar) {
        txtCodigo.setDisable(estado_campos);
        txtUsuario.setDisable(estado_campos);
        txtPassword.setDisable(estado_campos);
        txtConfirmarPassword.setDisable(estado_campos);
        cboxRol.setDisable(estado_campos);
        tbtnActivo.setDisable(estado_campos);
        txtCedula.setDisable(estado_campos);
        txtNombre.setDisable(estado_campos);
        txtApellido.setDisable(estado_campos);
        txtEmail.setDisable(estado_campos);

        btnNuevo.setDisable(!estado_botones);
        btnModificar.setDisable(!estado_botones);
        btnEliminar.setDisable(!estado_botones);
        btnGuardar.setDisable(estado_botones);
        btnCancelar.setDisable(estado_botones);

        if (limpiar) {
            txtCodigo.setText(null);
            txtUsuario.setText(null);
            txtPassword.setText(null);
            txtConfirmarPassword.setText(null);
            txtCedula.setText(null);
            txtNombre.setText(null);
            txtApellido.setText(null);
            txtEmail.setText(null);
            llenarRoles();
        }

    }

    private void llenarRoles() {
        RolControlador aux_rol_controlador = new RolControlador(usuario, password);
        ResultSet rs = aux_rol_controlador.select();
        try {
            cboxRol.getItems().clear();
            while (rs.next()) {
                cboxRol.getItems().add(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioVistaControlador.class.getName()).log(Level.SEVERE, null, ex);
            mostrarMensaje("Roles", "No se pudieron obtener los Roles", Alert.AlertType.ERROR);
        }
    }

    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert msj = new Alert(tipo);
        msj.setTitle(titulo);
        msj.setHeaderText(null);
        msj.setContentText(mensaje);
        msj.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarFormulario(true, true, true);
    }

}
