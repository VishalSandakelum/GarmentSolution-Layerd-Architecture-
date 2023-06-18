package lk.ijse.garment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagepaymentFormController implements Initializable {
    public Button menu;
    public Button suppaymentbtn;
    public Button homebtn;
    public Button employeepayment;
    public Button customerpayment;
    public BarChart <CategoryAxis, NumberAxis>monthlychart;
    public AreaChart Annualchart;

    public void menubtnonAction(ActionEvent actionEvent) {

    }

    public void suppaymentbtnonactin(ActionEvent actionEvent) {
        openWindow("/view/supplierpaymenttable_form.fxml");
    }

    public void homebtnonaction(ActionEvent actionEvent) {
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

        Stage currentStage = (Stage) homebtn.getScene().getWindow();
        currentStage.close();
    }

    public void employeepaymentbtnonaction(ActionEvent actionEvent) {
        openWindow("/view/employeepaymenttable.fxml");
    }

    public void customerpaymentbtnonaction(ActionEvent actionEvent) {
        openWindow("/view/placeordertable_form.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series Org1Data = new XYChart.Series();
        Org1Data.setName("Aprail");
        Org1Data.getData().add(new XYChart.Data("Jan", 11));
        Org1Data.getData().add(new XYChart.Data("Feb", 17));
        Org1Data.getData().add(new XYChart.Data("Mar", 19));
        Org1Data.getData().add(new XYChart.Data("Apr", 15));
        Org1Data.getData().add(new XYChart.Data("May", 17));
        Org1Data.getData().add(new XYChart.Data("Jun", 24));
        Org1Data.getData().add(new XYChart.Data("Jul", 27));
        Org1Data.getData().add(new XYChart.Data("Aug", 28));
        Org1Data.getData().add(new XYChart.Data("Sep", 31));
        Org1Data.getData().add(new XYChart.Data("Oct", 26));
        Org1Data.getData().add(new XYChart.Data("Nov", 28));
        Org1Data.getData().add(new XYChart.Data("Dec", 29));

        //037.3.1: Chart Data For Org 2
        XYChart.Series Org2Data = new XYChart.Series();
        Org2Data.setName("May");
        Org2Data.getData().add(new XYChart.Data("Jan", 10));
        Org2Data.getData().add(new XYChart.Data("Feb", 12));
        Org2Data.getData().add(new XYChart.Data("Mar", 14));
        Org2Data.getData().add(new XYChart.Data("Apr", 18));
        Org2Data.getData().add(new XYChart.Data("May", 7));
        Org2Data.getData().add(new XYChart.Data("Jun", 2));
        Org2Data.getData().add(new XYChart.Data("Jul", -6));
        Org2Data.getData().add(new XYChart.Data("Aug", -2));
        Org2Data.getData().add(new XYChart.Data("Sep", 8));
        Org2Data.getData().add(new XYChart.Data("Oct", 25));
        Org2Data.getData().add(new XYChart.Data("Nov", 33));
        Org2Data.getData().add(new XYChart.Data("Dec", 36));

        //Sample 37.4: Add Chart Data to Area Chart
        monthlychart.getData().add(Org1Data);
        monthlychart.getData().add(Org2Data);

        XYChart.Series Org3Data = new XYChart.Series();
        Org3Data.setName("Aprail");
        Org3Data.getData().add(new XYChart.Data("Jan", 11));
        Org3Data.getData().add(new XYChart.Data("Feb", 17));
        Org3Data.getData().add(new XYChart.Data("Mar", 19));
        Org3Data.getData().add(new XYChart.Data("Apr", 15));
        Org3Data.getData().add(new XYChart.Data("May", 17));
        Org3Data.getData().add(new XYChart.Data("Jun", 24));
        Org3Data.getData().add(new XYChart.Data("Jul", 27));
        Org3Data.getData().add(new XYChart.Data("Aug", 28));
        Org3Data.getData().add(new XYChart.Data("Sep", 31));
        Org3Data.getData().add(new XYChart.Data("Oct", 26));
        Org3Data.getData().add(new XYChart.Data("Nov", 28));
        Org3Data.getData().add(new XYChart.Data("Dec", 29));

        //037.3.1: Chart Data For Org 2
        XYChart.Series Org4Data = new XYChart.Series();
        Org4Data.setName("May");
        Org4Data.getData().add(new XYChart.Data("Jan", 10));
        Org4Data.getData().add(new XYChart.Data("Feb", 12));
        Org4Data.getData().add(new XYChart.Data("Mar", 14));
        Org4Data.getData().add(new XYChart.Data("Apr", 18));
        Org4Data.getData().add(new XYChart.Data("May", 7));
        Org4Data.getData().add(new XYChart.Data("Jun", 2));
        Org4Data.getData().add(new XYChart.Data("Jul", -6));
        Org4Data.getData().add(new XYChart.Data("Aug", -2));
        Org4Data.getData().add(new XYChart.Data("Sep", 8));
        Org4Data.getData().add(new XYChart.Data("Oct", 25));
        Org4Data.getData().add(new XYChart.Data("Nov", 33));
        Org4Data.getData().add(new XYChart.Data("Dec", 36));


        Annualchart.getData().add(Org3Data);
        Annualchart.getData().add(Org4Data);
    }

    public void openWindow(String resource){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

}
