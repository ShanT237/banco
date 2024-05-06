package project.co.GUI;

/**
 * JavaFX App
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/project/co/grafica.fxml"));

        Image icon = new Image(getClass().getResourceAsStream("/project/co/S.png"));
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("Banco");
        primaryStage.setScene(new Scene(root, 350, 430));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
