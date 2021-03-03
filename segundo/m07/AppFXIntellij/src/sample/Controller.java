package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {


    private final StringProperty nombre = new SimpleStringProperty("nombre");
    private final StringProperty nomFiscalText = new SimpleStringProperty("nomFiscal");
    private final StringProperty direccionText = new SimpleStringProperty("");
    private final StringProperty ciudadText = new SimpleStringProperty("");
    private final StringProperty provinciaText = new SimpleStringProperty("");

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnServeis;

    @FXML
    private Button btnConsulta;

    @FXML
    private TextField textNom;

    @FXML
    private TextField textNomFiscal;

    @FXML
    private TextField direccion;

    @FXML
    private TextField ciudad;

    @FXML
    private TextField provincia;


    public void initialize() {

        //Bind entre controles
        textNom.textProperty()
                .bindBidirectional(textNomFiscal.textProperty());

        //Bind de controles y atributos de la clase
        nombre.bind(textNom.textProperty());
        nomFiscalText.bind(textNomFiscal.textProperty());
        direccionText.bind(direccion.textProperty());
        ciudadText.bind(ciudad.textProperty());
        provinciaText.bind(provincia.textProperty());

    }

    @FXML
    public void clickDeleteBtn(ActionEvent actionEvent) {
        textNom.setText("");
        direccion.setText("");
        ciudad.setText("");
        provincia.setText("");
    }

    @FXML
    public void clickConsultaBtn(ActionEvent actionEvent) {//Mostramos por cosola los datos enlazados

        System.out.println("Nombre Fiscal: " + nomFiscalText.get());
        System.out.println("Nombre: " + nombre.get());
        System.out.println("Dirección: " + direccionText.get());
        System.out.println("Ciudad: " + ciudadText.get());
        System.out.println("Provincia: " + provinciaText.get());
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
