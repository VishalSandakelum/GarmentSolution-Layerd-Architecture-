package lk.ijse.garment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.garment.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRProperties;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AcceptorderdetailFormController implements Initializable {
    public Button placeorder;
    public Button confirmbtn;
    public Text idtxt;
    public Text discounttxt;
    public Text totaltxt;

    public void placeorderbtnonaction(ActionEvent actionEvent) {

    }

    public void confirmbtnonaction(ActionEvent actionEvent) {

        Stage currentStage = (Stage) confirmbtn.getScene().getWindow();
        currentStage.close();

        String id = idtxt.getText();

        try {
            JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");
            JasperDesign jasperDesign = JRXmlLoader.load("src/main/resources/paymentjasper/Order.jrxml");
            JRDesignQuery query = new JRDesignQuery();
            query.setText("SELECT * FROM placeordertable WHERE order_id = "+id);
            jasperDesign.setQuery(query);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException | SQLException e) {
            e.printStackTrace();
        }

        /*new Alert(Alert.AlertType.CONFIRMATION,"Place Order Successfully !").show();*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idtxt.setText(PlaceorderFormController.ordID);
        discounttxt.setText(String.valueOf(PlaceorderFormController.disc)+"%");
        totaltxt.setText(String.valueOf(PlaceorderFormController.totl));
    }
}
