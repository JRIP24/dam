package sample;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 300, 275));*/
        primaryStage.setTitle("Hello World");

        Image img1 = new Image("https://www.javatpoint.com/linux/images/linux-first.png");

        ImageView imgview1 = new ImageView(img1);
        imgview1.setX(70);
        imgview1.setY(90);
        Glow glow = new Glow();
        glow.setLevel(10);
        imgview1.setEffect(glow);

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        /*btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });*/
        /*
        btn.setOnAction(
                event -> rotate.play()
        );*/

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);


        root.getChildren().addAll(btn,imgview1);

        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
