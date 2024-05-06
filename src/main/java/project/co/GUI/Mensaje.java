package project.co.GUI;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Mensaje {

    public static void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        
        // Obtener la ventana de la alerta y asignar un icono
        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(Mensaje.class.getResourceAsStream("/project/co/Error.png")));
     
        
        alerta.showAndWait();
    }

    // Método para mostrar un mensaje de éxito
    public static void mostrarExito(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Éxito");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        
        // Obtener la ventana de la alerta y asignar un icono
        Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(Mensaje.class.getResourceAsStream("/project/co/Succes.png")));
        
        alerta.showAndWait();
    }
}


