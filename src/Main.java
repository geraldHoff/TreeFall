import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    public static void main(String[] args) {
        //setup program as javafx application. (calls start)
        launch(args);
    }

    @Override
    public void start(Stage window) throws FileNotFoundException {

        //get image from resources.
        //https://www.tutorialspoint.com/javafx/javafx_images.htm

        Image image = new Image(
                getClass().getResource("resources/jungleImage.jpg").toString()
        );

        ImageView imageView = new ImageView(image);

        imageView.setX(50);
        imageView.setY(50);

        imageView.setFitHeight(455);
        imageView.setFitWidth(500);

        imageView.setPreserveRatio(true);

        Group root = new Group(imageView);
        
        Scene scene1 = new Scene(root, 600, 600);

        //set the title of the window, maximize it, and show it.
        window.setScene(scene1);
        window.setTitle("TreeFall");
        window.setMaximized(true);
        window.show();

    }
}
