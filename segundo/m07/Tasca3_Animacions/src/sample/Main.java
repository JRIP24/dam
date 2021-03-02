package sample;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
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

        primaryStage.setTitle("Bombilla");

        ImageView imageView = new ImageView(
                new Image(Main.class.getResourceAsStream("bombilla.png")));
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);

        //Efecto
        Glow glow = new Glow();
        imageView.setEffect(glow);

        double position = imageView.getTranslateY();
        imageView.setTranslateY(-1000);//Para que desaparezca de la pantalla
        imageView.setStyle("-fx-margin-bottom: 50px;");


        //Transición
        TranslateTransition translate = new TranslateTransition();
        translate.setToY(position);
        translate.setDuration(Duration.millis(1000));
        translate.setNode(imageView);

        Button boton = new Button();
        boton.setText("Encender");
        final boolean[] encendida = {false};
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (encendida[0]){
                    boton.setText("Encender");
                    glow.setLevel(0);
                    encendida[0] = false;
                } else {
                    boton.setText("Apagar");
                    glow.setLevel(10);
                    encendida[0] = true;
                }
            }
        });

        Button showLightBulb = new Button();
        showLightBulb.setText("Mostrar Bombilla");
        showLightBulb.setOnAction(
                event -> translate.play()
        );

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);


        root.getChildren().addAll(imageView, boton, showLightBulb);
        root.setSpacing(5);

        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
