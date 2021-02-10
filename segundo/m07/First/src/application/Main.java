package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		/*
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		Button btn = new Button();
	    btn.setText("Say 'Hello World'");
	    btn.setOnAction(new EventHandler<ActionEvent>() {
	 
	       @Override
	       public void handle(ActionEvent event) {
	           System.out.println("Hello World!");
	       }
	    });
	        
	    StackPane root = new StackPane();
	    root.getChildren().add(btn);

	    Scene scene = new Scene(root, 300, 250);

	    primaryStage.setTitle("Hello World!");
	    primaryStage.setScene(scene);
	    primaryStage.show();*/
		
		Parent root = FXMLLoader.load(getClass().getResource("HelloWorld.fxml"));
        primaryStage.setTitle("Registration Form FXML Application");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
