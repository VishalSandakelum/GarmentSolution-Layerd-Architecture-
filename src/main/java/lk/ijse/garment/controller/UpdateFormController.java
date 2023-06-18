package lk.ijse.garment.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class UpdateFormController implements Initializable {

    private static final String URL = "jdbc:mysql://localhost:3306/garment";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public JFXTextField updatenametxt;
    public JFXTextField updateidtxt;
    public JFXTextField updategmailtxt;
    public JFXTextField updatenictxt;
    public JFXTextField updateconumbertxt;
    public JFXTextField updatebanumbertxt;
    public JFXTextField updateaddresstxt;
    public JFXButton updatebtn;
    public JFXButton deletebtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmployeetableFromController empc = new EmployeetableFromController();
        updateidtxt.setText(empc.Id);
        updatenametxt.setText(empc.Namee);
        updategmailtxt.setText(empc.Gmaiil);
        updatenictxt.setText(empc.Nic);
        updateconumbertxt.setText(String.valueOf(empc.Cunumber));
        updatebanumbertxt.setText(String.valueOf(empc.Bannumber));
        updateaddresstxt.setText(empc.Addresss);
    }

    public void updatebtnonaction(ActionEvent actionEvent) {
        String name = updatenametxt.getText();
        String nic = updatenictxt.getText();
        String gmail = updategmailtxt.getText();
        Integer conumber = Integer.parseInt(updateconumbertxt.getText());
        String address = updateaddresstxt.getText();
        String id = updateidtxt.getText();
        Integer banumber = Integer.parseInt(updatebanumbertxt.getText());

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "UPDATE employee SET name = ?, nic = ?, gmail = ?, conumber = ?, address = ?, banumber = ? WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(2, nic);
            pstm.setString(3, gmail);
            pstm.setInt(4,conumber);
            pstm.setString(5,address);
            pstm.setInt(6, banumber);
            pstm.setString(7,id);

            boolean isUpdated = pstm.executeUpdate() > 0;
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "updated successfully").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deletebtnonaction(ActionEvent actionEvent) throws SQLException {
        String id = updateidtxt.getText();
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "DELETE FROM employee WHERE id = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);

            if (pstm.executeUpdate() > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "deletd!").show();
            }
        }
    }
}
