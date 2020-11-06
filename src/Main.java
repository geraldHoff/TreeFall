import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        Image jungleImage = new Image(
                getClass().getResource("resources/jungleImage.jpg").toString()
        );

        Image bookImage = new Image(
                getClass().getResource("resources/book.jpeg").toString()
        );

        ImageView jungleImageView = new ImageView(jungleImage);
        jungleImageView.setPreserveRatio(true);

        ImageView jungleImageView2 = new ImageView(jungleImage);
        jungleImageView.setPreserveRatio(true);

        //create the image view for the book.
        ImageView bookImageView = new ImageView(bookImage);
        bookImageView.setPreserveRatio(true);
        bookImageView.setX(600);
        bookImageView.setY(230);
        bookImageView.setScaleX(2.0);
        bookImageView.setScaleY(2.0);

        //create scene for gameplay.
        Group gameRoot = new Group(jungleImageView2);
        Scene sceneGame = new Scene(gameRoot, 1200, 1200);

        //create button that will go from menu to the gameplay
        Button startButton = new Button("Start");
        startButton.setLayoutX(645);
        startButton.setLayoutY(450);
        startButton.setOnAction(e -> {
            window.setScene(sceneGame);
            window.setMaximized(false);
            window.setMaximized(true);
        });

        //create scene for start menu
        Group menuRoot = new Group(jungleImageView, bookImageView, startButton);
        Scene sceneMenu = new Scene(menuRoot, 1200, 1200);

        //set the title of the window, maximize it, and show it.
        window.setScene(sceneMenu);
        window.setTitle("TreeFall");
        window.setMaximized(true);
        window.show();
    }
}
