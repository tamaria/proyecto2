package Aplicacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Emilce Fernandez - Tanya Aquino
 */
public class Rol extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/RolVista.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Roles");
        stage.show();
    }
    
    
    
    
}
