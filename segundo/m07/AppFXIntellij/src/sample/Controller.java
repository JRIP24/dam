package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnServeis;

    @FXML
    private TextField textNom;

    @FXML
    public void clickDeleteBtn(ActionEvent actionEvent) {
        textNom.setText("");
    }

    public void clickBtnServeis(ActionEvent actionEvent) throws IOException {
        /*
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Serveis.fxml"));
            Stage stage = (Stage) btnServeis.getScene().getWindow();
            Scene scene = new Scene(loader.load());

        } catch (IOException io){
            io.printStackTrace();
        }*/
        Main.setRoot("Serveis");
    }

    public void clickBtnLogin(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User.fxml"));
        Scene scene;
        try {
            scene = new Scene(loader.load(), 1000, 600);
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backToMain(ActionEvent actionEvent) throws IOException {
        Main.setRoot("sample");
    }
}
