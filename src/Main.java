import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.io.FileNotFoundException;

public class Main extends Application {

    public static void main(String[] args) {
        //setup program as javafx application. (calls start)
        launch(args);
    }

    @Override
    public void start(Stage window) throws FileNotFoundException {

        BST tree = new BST();

        //get image from resources.
        //https://www.tutorialspoint.com/javafx/javafx_images.htm

        Image jungleImage = new Image(
                getClass().getResource("resources/jungleImage.jpg").toString()
        );

        Image bookImage = new Image(
                getClass().getResource("resources/book.jpeg").toString()
        );

        Image trunkImage = new Image(
                getClass().getResource("resources/trunk.jpeg").toString()
        );

        Image nodeImage = new Image(
                getClass().getResource("resources/logNode.jpeg").toString()
        );

        //create jungle background imageViewers.
        ImageView jungleImageView = new ImageView(jungleImage);
        jungleImageView.setPreserveRatio(true);
        ImageView jungleImageView2 = new ImageView(jungleImage);
        jungleImageView.setPreserveRatio(true);

        //create trunk imageViewer
        ImageView trunkImageViewer = new ImageView(trunkImage);
        trunkImageViewer.setPreserveRatio(true);
        trunkImageViewer.setScaleY(3);
        trunkImageViewer.setScaleX(3);
        trunkImageViewer.setY(600);
        trunkImageViewer.setX(450);

        //create the image view for the book.
        ImageView bookImageView = new ImageView(bookImage);
        bookImageView.setPreserveRatio(true);
        bookImageView.setSmooth(true);
        bookImageView.setX(600);
        bookImageView.setY(230);
        bookImageView.setScaleX(2.0);
        bookImageView.setScaleY(2.0);

        //create node imageViewer
        ImageView nodeImageView = new ImageView(nodeImage);

        //create textField
        TextField textField = new TextField();
        textField.setTranslateY(350);
        textField.setText("new node");

        //create button to insert, delete, and search nodes.
        Button buttonInsert = new Button("insert");
        buttonInsert.setTranslateY(380);
        buttonInsert.setOnAction(e -> {
            System.out.println("insert");
            //textField.getText();
            //tree.initInsert(0);
        });
        Button buttonDelete = new Button("delete");
        buttonDelete.setTranslateY(380);
        buttonDelete.setTranslateX(48);
        Button buttonSearch = new Button("search");
        buttonSearch.setTranslateY(380);
        buttonSearch.setTranslateX(100);

        //create scene for gameplay.
        Group gameRoot = new Group(
                jungleImageView2, textField, buttonInsert, buttonDelete, buttonSearch
            );
        Scene sceneGame = new Scene(gameRoot, 1365, 700);

        //create button that will go from menu to the gameplay
        Button startButton = new Button("Start");
        startButton.setLayoutX(645);
        startButton.setLayoutY(450);
        startButton.setOnAction(e -> {
            window.setScene(sceneGame);
        });

        //create scene for start menu
        Group menuRoot = new Group(jungleImageView, bookImageView, startButton);
        Scene sceneMenu = new Scene(menuRoot, 1365, 700);

        //set the title of the window, maximize it, and show it.
        window.setScene(sceneMenu);
        window.setTitle("TreeFall");
        window.show();
    }
}
