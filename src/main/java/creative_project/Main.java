package creative_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


//진짜버젼
public class Main extends Application {
    Parent root = null;
    @Override
    public void start(Stage primarystage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primarystage.setTitle("Outdoorgram");
        primarystage.setScene(new Scene( root ,600, 400));

        // Center the window on the screen
        primarystage.setX((500));
        primarystage.setY((100));

        primarystage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}