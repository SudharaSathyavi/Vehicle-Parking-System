package lk.ijse.pos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.memory.VehicleArray;
import lk.ijse.pos.model.Vehicle;

import java.io.IOException;
import java.util.regex.Pattern;

public class VehicleAddFormController {
    public AnchorPane apAddVehicle;
    public ComboBox comboVehicleType;
    public TextField txtNumber;
    public TextField txtMaxWeight;
    public TextField txtPassengers;
    public Button btnLogin;

    public void initialize(){
        loadComboBox();
        focusInputFields();
    }

    private void loadComboBox() {
        ObservableList<String> list= FXCollections.observableArrayList();
        list.add("Bus");
        list.add("Van");
        list.add("Cargo Lorry");
        comboVehicleType.setItems(list);
    }


    private void focusInputFields() {
        txtNumber.setOnKeyPressed(event -> {
            if (!txtNumber.getText().matches("^[A-Z-0-9]{0,10}$")) {
                txtNumber.setStyle("-fx-border-color: #F21111;");
            } else {
                txtNumber.setStyle(null);
            }
        });
        txtMaxWeight.setOnKeyPressed(event -> {
            if (!txtMaxWeight.getText().matches("^[0-9]{2,5}$")) {
                txtMaxWeight.setStyle("-fx-border-color: #F21111;");
            } else {
                txtMaxWeight.setStyle(null);
            }
        });
        txtPassengers.setOnKeyPressed(event -> {
            if (!txtPassengers.getText().matches("^[0-9]{0,3}$")) {
                txtPassengers.setStyle("-fx-border-color: #F21111;");
            } else {
                txtPassengers.setStyle(null);

            }
        });
    }



    public void addVehicleOnAction(ActionEvent actionEvent)throws IOException {

        if (Pattern.compile("^[A-Z-0-9]{0,10}$").matcher(txtNumber.getText()).matches()) {
            if (Pattern.compile("^[0-9]{2,5}$").matcher(txtMaxWeight.getText()).matches()) {
                if (Pattern.compile("^[0-9]{0,3}$").matcher(txtPassengers.getText()).matches()) {
                    if (comboVehicleType.getValue()!=null) {
                        boolean b = VehicleArray.getInstance().setArrayVehicles(new Vehicle(txtNumber.getText(), (String) comboVehicleType.getValue(), txtMaxWeight.getText(), Integer.parseInt(txtPassengers.getText())));
                        if (b){
                            new Alert(Alert.AlertType.CONFIRMATION,"Vehicle Saved").show();
                        }else {
                            new Alert(Alert.AlertType.WARNING,"Vehicle Not Saved").show();
                        }
                        Stage window = (Stage) btnLogin.getScene().getWindow();
                        window.close();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Select Vehicle Type").show();
                    }
                }
            }
        }
    }
}
