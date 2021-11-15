package lk.ijse.pos.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.memory.DriverArray;
import lk.ijse.pos.model.Driver;

import java.util.regex.Pattern;

public class DriverAddFormController {
    public TextField txtName;
    public TextField txtNIC;
    public TextField txtLicense;
    public TextField txtAddress;
    public TextField txtContact;
    public AnchorPane apAddDriver;

    public void addDriverOnAction(ActionEvent actionEvent) {
        boolean b = DriverArray.getInstance().setArrayDrivers(new Driver(txtName.getText(), txtNIC.getText(), txtLicense.getText(), txtAddress.getText(), txtContact.getText()));
        if (b) {
            new Alert(Alert.AlertType.CONFIRMATION, "Driver Saved").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Driver Not Saved").show();

        }
        Stage stage = (Stage) apAddDriver.getScene().getWindow();
        stage.close();

    }

    public void nameOnKeyTyped(KeyEvent keyEvent) {
        if (!txtName.getText().matches("^[A-z]{1,20} [A-z]{1,20}$")) {
            txtName.setStyle("-fx-border-color: #F21111;");
            System.out.println(txtName.getText());
        } else {
            txtName.setStyle(null);
        }
    }

    public void nicOnKeyTyped(KeyEvent keyEvent) {
        if (!txtNIC.getText().matches("^[0-9]{10}[V]$")) {
            txtNIC.setStyle("-fx-border-color: #F21111;");
            System.out.println(txtNIC.getText());
        } else {
            txtNIC.setStyle(null);
        }
    }

    public void licenseOnKeyTyped(KeyEvent keyEvent) {
        if (!txtLicense.getText().matches("^[B][0-9]{7}$")) {
            txtLicense.setStyle("-fx-border-color: #F21111;");
            System.out.println(txtLicense.getText());
        } else {
            txtLicense.setStyle(null);
        }
    }

    public void addressOnKeyTyped(KeyEvent keyEvent) {
        if (!txtAddress.getText().matches("^[#.0-9a-zA-Z\\s,-]+$")) {
            txtAddress.setStyle("-fx-border-color: #F21111;");
        } else {
            txtAddress.setStyle(null);
        }
    }

    public void contactOnKeyTyped(KeyEvent keyEvent) {
        if (!txtContact.getText().matches("^[0-9]{10}$")) {
            txtContact.setStyle("-fx-border-color: #F21111;");
        } else {
            txtContact.setStyle(null);
        }
    }


}
