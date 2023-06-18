package lk.ijse.garment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.garment.db.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class LoginpageFormController {
    private static final String URL = "jdbc:mysql://localhost:3306/garment";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public Button checkpasswordbtn;
    public TextField checkpasswordfield;
    public PasswordField passwordfield;
    public Button invisiblebtn;
    public Button loginbtn;
    public TextField usernametxt;
    public Button save;
    private String username;
    private String password;

    public void btncheckpasswordbtnonaction(ActionEvent actionEvent) {
        String passwrd = passwordfield.getText();
        passwordfield.setVisible(false);
        checkpasswordfield.setVisible(true);
        checkpasswordfield.setText(passwrd);
        checkpasswordbtn.setVisible(false);
        invisiblebtn.setVisible(true);
    }

    public void btninvisiblebtnonaction(ActionEvent actionEvent) {
        String passwrd = checkpasswordfield.getText();
        checkpasswordfield.setVisible(false);
        passwordfield.setVisible(true);
        passwordfield.setText(passwrd);
        invisiblebtn.setVisible(false);
        checkpasswordbtn.setVisible(true);
    }

    public void loginbtnonaction(ActionEvent actionEvent) {

        try (Connection con = DriverManager.getConnection(URL, props)) {

            String sql = "SELECT * FROM loginpage";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                username = resultSet.getString(1);
                password = resultSet.getString(2);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(username.equals(usernametxt.getText())&&password.equals(passwordfield.getText())){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/firstpage_form.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

            Stage currentStage = (Stage) loginbtn.getScene().getWindow();
            currentStage.close();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Please enter correct password").show();
        }


    }


}
