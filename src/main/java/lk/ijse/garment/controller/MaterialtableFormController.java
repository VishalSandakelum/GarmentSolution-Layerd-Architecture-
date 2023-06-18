package lk.ijse.garment.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.garment.dto.tm.Material;
import lk.ijse.garment.dto.tm.tm.MaterialTM;
import lk.ijse.garment.model.MaterialModel;

import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class MaterialtableFormController implements Initializable {

    private static final String URL = "jdbc:mysql://localhost:3306/garment";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public TableView <MaterialTM> tableview;
    public TableColumn materialname;
    public TableColumn materialid;
    public TableColumn supplierid;
    public TableColumn amount;
    public TableColumn price;
    public TextField searchbar;
    public Button searchbtn;
    public Pane displaypane;
    public Text nametxt;
    public Text nictxt;
    public Text gmailtxt;
    public Text addresstxt;
    public Text monumbertxt;
    public Text banknumbertxt;
    public Text idtxt;
    public AnchorPane mainpane;
    public Text banknumbertxt1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {getAll();
    setCellValueFactory();}


    private void setCellValueFactory() {
        materialname.setCellValueFactory(new PropertyValueFactory<>("materialname"));
        materialid.setCellValueFactory(new PropertyValueFactory<>("material_id"));
        supplierid.setCellValueFactory(new PropertyValueFactory<>("id"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
    }


    private void getAll() {
        try {
            ObservableList<MaterialTM> obList = FXCollections.observableArrayList();
            List<Material> cusList = MaterialModel.getAll();

            for (Material material : cusList) {
                obList.add(new MaterialTM(
                        material.getMaterialname(),
                        material.getMaterial_id(),
                        material.getId(),
                        material.getAmount(),
                        material.getPrice()
                ));
            }
            tableview.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
        }

    public void searchbtnonaction(ActionEvent actionEvent) throws SQLException {
        String id = searchbar.getText();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM suplier WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String nic = resultSet.getString(2);
                String gmail = resultSet.getString(3);
                String address = resultSet.getString(4);
                int conumber = resultSet.getInt(5);
                int banumber = resultSet.getInt(6);
                String Id = resultSet.getString(7);

                displaypane.setVisible(true);

                nametxt.setText(name);
                nictxt.setText(nic);
                gmailtxt.setText(gmail);
                addresstxt.setText(address);
                monumbertxt.setText(String.valueOf(conumber));
                banknumbertxt1.setText(String.valueOf(banumber));
                idtxt.setText(Id);

            }else{
                new Alert(Alert.AlertType.WARNING, "Check and enter correct id").show();
            }
        }
    }

    public void tableviewmouseclickaction(MouseEvent mouseEvent) {
        searchbar.setText("");
        displaypane.setVisible(false);
    }

    public void mainpanemouseclick(MouseEvent mouseEvent) {
        searchbar.setText("");
        displaypane.setVisible(false);
    }
}

