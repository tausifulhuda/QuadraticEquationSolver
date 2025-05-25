package javafx.quadraticequationsolver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;


public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("primary.fxml"));
        Scene scene=new Scene(root);
        Image icon=new Image(getClass().getResource("/javafx/quadraticequationsolver/Icon.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setTitle("Quadratic Equation Solver");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    
    public static void main(String[] args) {
        launch();
    }
}