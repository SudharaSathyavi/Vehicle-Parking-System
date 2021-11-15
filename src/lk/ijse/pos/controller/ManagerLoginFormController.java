package lk.ijse.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class ManagerLoginFormController {
    public AnchorPane apLogin;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public Button btnLogIn;
    public Button btnLogOut;
    int i = 0;

        public void initialize() {
            focus();
        }

        public void focus() {
            txtUserName.setOnKeyPressed(event -> {
                if (!txtUserName.getText().matches("^[a-zA-Z0-9]{0,10}$")) {
                    txtUserName.setStyle("-fx-border-color: #F21111;");
                } else {
                    txtUserName.setStyle(null);

                }
            });
            txtPassword.setOnKeyPressed(event -> {
                if (!txtPassword.getText().matches("^[a-zA-Z0-9]{0,10}$")) {
                    txtPassword.setStyle("-fx-border-color: #F21111;");
                } else {
                    txtPassword.setStyle(null);

                }
            });

        }

    public void logInOnAction(ActionEvent actionEvent) throws IOException {

        if (Pattern.compile("^[a-zA-Z0-9]{0,10}$").matcher(txtUserName.getText()).matches()) {
            if (Pattern.compile("^[a-zA-Z0-9]{0,10}$").matcher(txtPassword.getText()).matches()) {
                if (txtUserName.getText().trim().equals("45MMGG")) {
                    if (txtPassword.getText().trim().equals("12345")) {
                        Stage newStage = new Stage();
                        newStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MDashBoardForm.fxml"))));
                        newStage.show();
                        Stage window = (Stage) btnLogIn.getScene().getWindow();
                        window.close();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Wrong Password").show();
                    }
                } else {
                    new Alert(Alert.AlertType.WARNING, "Wrong User Name").show();
                }
            }
        }
    }

    public void cancelOnAction(ActionEvent actionEvent) {
            Stage window = (Stage) btnLogOut.getScene().getWindow();
            window.close();

        }
    }

