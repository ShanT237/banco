package project.co.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.scene.control.TextFormatter.Change;

public class Grafica implements Initializable {

    @FXML
    private ChoiceBox<String> tipoBox;
    private String[] cuenta = {"AHORRO" , "CORRIENTE"};

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField apellidosTextField;

    @FXML
    private TextField saldoTextField;

    @FXML
    private PasswordField numeroCuentaPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tipoBox.getItems().addAll(cuenta);


        // Condciones para el usario cuando escribe
        nombreTextField.setTextFormatter(stringTextFormatter());
        apellidosTextField.setTextFormatter(stringTextFormatter());
        numeroCuentaPasswordField.setTextFormatter(integerTextFormatter());

        saldoTextField.setTextFormatter(decimalTextFormatter());
    }

    // Método para permitir solo letras y espacios en blanco
    public TextFormatter<Object> stringTextFormatter() {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[a-zA-Z\\s]*")) {
                return change;
            }
            return null;
        };
        return new TextFormatter<>(filter);
    }

    // Método para permitir solo números enteros
    public TextFormatter<Object> integerTextFormatter() {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[0-9]*")) {
                return change;
            }
            return null;
        };
        return new TextFormatter<>(filter);
    }

    // Método para permitir solo números decimales
    public TextFormatter<Object> decimalTextFormatter() {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.getControlNewText().matches("^\\d*\\.\\d+|\\d+\\.\\d*|\\d*$")) {
                return change;
            }
            return null;
        };
        return new TextFormatter<>(filter);
    }

    @FXML
    public void nombre() {
        String nombre = nombreTextField.getText();
        // Haz algo con el nombre
    }

    @FXML
    public void apellidos() {
        String apellidos = apellidosTextField.getText();
        // Haz algo con los apellidos
    }

    @FXML
    public void saldo() {
        String saldo = saldoTextField.getText();
        // Haz algo con el saldo
    }

    @FXML
    public void numeroCuenta() {
        String numeroCuenta = numeroCuentaPasswordField.getText();
    }

    @FXML
     public void crearCuenta() {
            String nombre = nombreTextField.getText();
            String apellidos = apellidosTextField.getText();
            String numeroCuenta = numeroCuentaPasswordField.getText();
            String saldoString = saldoTextField.getText();
            String tipoCuenta = tipoBox.getValue(); // Obtener la opción seleccionada
        
            // Verificar que no haya campos vacíos
            if (nombre.isEmpty() || apellidos.isEmpty() || numeroCuenta.isEmpty() || saldoString.isEmpty() || tipoCuenta == null) {
                Mensaje.mostrarError("Por favor, complete todos los campos y seleccione un tipo de cuenta.");
                return;
            }
        
            try {
                double saldo = Double.parseDouble(saldoString);
                // Aquí iría la lógica para crear la cuenta bancaria con los valores obtenidos
                // Después de crear la cuenta exitosamente, mostrar mensaje de éxito
                Mensaje.mostrarExito("La cuenta bancaria ha sido creada correctamente.");
                // Cerrar la ventana o realizar otra acción deseada
            } catch (NumberFormatException e) {
                Mensaje.mostrarError("Por favor, ingrese valores numéricos válidos en el campo de saldo.");
            } catch (Exception e) {
                Mensaje.mostrarError(e.getMessage());
            }

            
        }
        
}
