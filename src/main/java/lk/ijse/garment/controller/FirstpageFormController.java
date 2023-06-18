package lk.ijse.garment.controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import lk.ijse.garment.db.DBConnection;
import org.w3c.dom.ls.LSOutput;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

public class FirstpageFormController extends Application implements Initializable {

    private static final String URL = "jdbc:mysql://localhost:3306/garment";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }
    static double pr = 0.0;

    public Button menu;
    public Pane chooselist;
    public Button backbtn;
    public ImageView firstimg;
    public Pane firstpaneimg;
    public Button cotton;
    public Pane cottonpane;
    public Button wool1;
    public Pane wollpane;
    public Button polyster;
    public Pane polysterpane;
    public Button seemorepanebtn;
    public Pane seepanenew;
    public Pane chooselist1;
    public Button backbtn1;
    public Button cotton1new;
    public Pane cottonpane1new;
    public Button wool11new;
    public Pane wollpane1new;
    public Button polyster1new;
    public Pane polysterpane1new;
    public Text textcheck;
    public Button backpanebtn2;
    public Pane leather;
    public Button leatherbtn;
    public Pane nylonpane;
    public Button nylonbtn;
    public Pane threadpane;
    public Pane needlespane;
    public Button managesupplierbtn;
    public Button manageemployeebtn;
    public Button managematerialbtn;
    public Button manageclothesbtn;
    public Button manageorderbtn;
    public Button managecustomerbtn;
    public Button managepaybtn;
    public Button incomedetailbtn;
    public Button micbtn;

    static boolean bool = true;

    public static String desiredWord;
    public Pane cottondetailpane;
    public Text idtxt;
    public Text quantitytxt;
    public Text pricetxt;
    public Pane wooldetailspane;
    public Text n;
    public Text woolid;
    public Text woolquantity;
    public Text woolprice;
    public Pane polysterdetailspane;
    public Text n1;
    public Text polysterrid;
    public Text polysterquantity;
    public Text polysterprice;
    public Button notificationbtn;
    public AreaChart <CategoryAxis, NumberAxis>areachart;
    public Text incometxt;
    public Text datetimetxt;
    public String time;
    public String date;
    public String year;

    public void menubtnonAction(ActionEvent actionEvent) {
        chooselist.setVisible(true);
    }

    public void btnbackbtnonacction(ActionEvent actionEvent) {
        chooselist.setVisible(false);
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    public void cottonmouseenter(MouseEvent mouseDragEvent) {
        cottonpane.setVisible(true);
    }

    public void cottonmouseexite(MouseEvent mouseEvent) {
        cottonpane.setVisible(false);
    }

    public void woolmouseenter(MouseEvent mouseEvent) {
        wollpane.setVisible(true);
    }

    public void woolmouseexite(MouseEvent mouseEvent) {
        wollpane.setVisible(false);
    }

    public void poliystermouseenter(MouseEvent mouseEvent) {
        polysterpane.setVisible(true);
    }

    public void poliystermouseexite(MouseEvent mouseEvent) {
        polysterpane.setVisible(false);
    }

    public void btnseemorepanebtnonaction(ActionEvent actionEvent) {
        seepanenew.setVisible(true);
    }

    public void cotton1newmouseenter(MouseEvent mouseEvent) {
        cottonpane1new.setVisible(true);
    }

    public void cotton1newmouseexite(MouseEvent mouseEvent) {
        cottonpane1new.setVisible(false);
    }

    public void wool11newmouseenter(MouseEvent mouseEvent) {
        wollpane1new.setVisible(true);
    }

    public void wool11newmouseexite(MouseEvent mouseEvent) {
        wollpane1new.setVisible(false);
    }

    public void polyster1newmouseenter(MouseEvent mouseEvent) {
        polysterpane1new.setVisible(true);
    }

    public void polyster1newmouseexite(MouseEvent mouseEvent) {
        polysterpane1new.setVisible(false);
    }

    public void btnbackpanebtnonaction(ActionEvent actionEvent) {
        seepanenew.setVisible(false);
    }

    public void leathermouseenter(MouseEvent mouseEvent) {
        leather.setVisible(true);
    }

    public void leathermouseexite(MouseEvent mouseEvent) {
        leather.setVisible(false);
    }

    public void nylonmouseenter(MouseEvent mouseEvent) {
        nylonpane.setVisible(true);
    }

    public void nylonmouseexite(MouseEvent mouseEvent) {
        nylonpane.setVisible(false);
    }

    public void threadnewmouseenter(MouseEvent mouseEvent) {
        threadpane.setVisible(true);
    }

    public void threadnewmouseexite(MouseEvent mouseEvent) {
        threadpane.setVisible(false);
    }

    public void needlesmouseenter(MouseEvent mouseEvent) {
        needlespane.setVisible(true);
    }

    public void needlesmouseexite(MouseEvent mouseEvent) {
        needlespane.setVisible(false);
    }

    public void managesupplierbtnonaction(ActionEvent actionEvent) {
        openWindow(managesupplierbtn,"/view/managesupplier_form.fxml");
    }

    public void manageemployeebtnonaction(ActionEvent actionEvent) {
        openWindow(manageemployeebtn,"/view/manageemployee_form.fxml");
    }

    public void managematerialbtnbtnonaction(ActionEvent actionEvent) {
        openWindow(managematerialbtn,"/view/managematerial_form.fxml");
    }

    public void manageclothesbtnonaction(ActionEvent actionEvent) {
        openWindow(manageclothesbtn,"/view/manageclothes_form.fxml");
    }

    public void manageorderbtnonaction(ActionEvent actionEvent) {
        openWindow(manageorderbtn,"/view/manageorder_form.fxml");
    }

    public void managecustomerbtnonaction(ActionEvent actionEvent) {
        openWindow(managecustomerbtn,"/view/managecustomer_form.fxml");
    }

    public void managepaybtnonaction(ActionEvent actionEvent) {
        openWindow(managepaybtn,"/view/managepayment_form.fxml");
    }

    public void incomedetailsbtnonaction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/payment_form.fxml"));
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

    public void micbtnonaction(ActionEvent actionEvent) throws InterruptedException, IOException {
        bool = true;

        while (bool) {
            Configuration config = new Configuration();

            config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            config.setDictionaryPath("src\\main\\resources\\voicecode\\6860.dic");
            config.setLanguageModelPath("src\\main\\resources\\voicecode\\6860.lm");


            try {
                System.out.println(bool);
                LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
                speech.startRecognition(true);

                SpeechResult speechResult = null;


                while (bool == true && (speechResult = speech.getResult()) != null) {

                    System.out.println(bool);
                    String voiceCommand = speechResult.getHypothesis();
                    System.out.println("Voice Command is " + voiceCommand);

                    miccommand(voiceCommand,speech);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void polysterbtnonaction(ActionEvent actionEvent) throws SQLException, InterruptedException {

        pr = 0.0;

        String materialname = "polyster";

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM material WHERE materialname = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, materialname);

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString(2);
                String amount = resultSet.getString(4);
                double price = resultSet.getDouble(5);

                pr += price;


                polysterdetailspane.setVisible(true);

                polysterrid.setText(id);
                polysterquantity.setText(amount);
                polysterprice.setText(String.valueOf(pr));

            }

            new Thread() {
                public void run() {
                    try {
                       Thread.sleep(2000);
                        System.out.println("ok");
                       polysterdetailspane.setVisible(false);
                    } catch (Exception e) {
                    }
                }
            }.start();


        }


    }
    public void woolbtnonaction(ActionEvent actionEvent) throws SQLException {

        pr = 0.0;

        String materialname = "wool";

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM material WHERE materialname = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, materialname);

            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(2);
                String amount = resultSet.getString(4);
                double price = resultSet.getDouble(5);

                pr += price;


                wooldetailspane.setVisible(true);

                woolid.setText(id);
                woolquantity.setText(amount);
                woolprice.setText(String.valueOf(pr));

            }

            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(2000);
                        System.out.println("ok");
                        wooldetailspane.setVisible(false);
                    } catch (Exception e) {
                    }
                }
            }.start();


        }
    }

    public void cottonbtnonaction(ActionEvent actionEvent) throws SQLException {

        pr = 0.0;

        String materialname = "cotton";

        try (Connection con = DriverManager.getConnection(URL, props)) {
                String sql = "SELECT * FROM material WHERE materialname = ?";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, materialname);

                ResultSet resultSet = pstm.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString(2);
                    String amount = resultSet.getString(4);
                    double price = resultSet.getDouble(5);

                    System.out.println("Price" + price);
                    pr += price;

                    cottondetailpane.setVisible(true);

                    idtxt.setText(id);
                    quantitytxt.setText(amount);
                    pricetxt.setText(String.valueOf(pr));

                }

                new Thread() {
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            System.out.println("ok");
                            cottondetailpane.setVisible(false);
                        } catch (Exception e) {
                        }
                    }
                }.start();


            }
        }

    public void notificationbtnonaction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/notification_form.fxml"));
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

    public void miccommand(String voiceCommand, LiveSpeechRecognizer speech){
        if (voiceCommand.equalsIgnoreCase("MATERIAL")) {
            bool = false;
            openWindow(micbtn,"/view/managematerial_form.fxml");
        } else if (voiceCommand.equalsIgnoreCase("CUSTOMER")) {
            bool = false;
            openWindow(micbtn,"/view/managecustomer_form.fxml");
        }else if (voiceCommand.equalsIgnoreCase("ORDER")) {
            bool = false;
            openWindow(micbtn,"/view/manageorder_form.fxml");

        }else if (voiceCommand.equalsIgnoreCase("MATERIAL")) {
            bool = false;
            openWindow(micbtn,"/view/managematerial_form.fxml");
        }
    }


    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        new Thread(){
            public void run(){
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

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

        areachart.getData().add(Org1Data);
        areachart.getData().add(Org2Data);

        try {
            Connection con = DBConnection.getInstance().getConnection();
            String sql = "SELECT *FROM incomedetails ORDER BY id DESC LIMIT 1";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();

            if(resultSet.next()){
                String profit = resultSet.getString(5);

                incometxt.setText("R.S. "+profit+".00");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        new Thread() {
            public void run() {
                while(bool) {
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e){}
                    java.util.Date currentDate = new Date();
                    SimpleDateFormat clockFormat = new SimpleDateFormat("h:mm a");
                    time = (clockFormat.format(currentDate));

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd ");
                    date = (dateFormat.format(currentDate));

                    SimpleDateFormat yearFormat = new SimpleDateFormat("MMMM,yyyy");
                    year = (yearFormat.format(currentDate));

                    String txt = (year+"/"+date+" "+time);

                    datetimetxt.setText(txt);

                }
            }
        }.start();

    }

    public void openWindow(Button btn, String Resource){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Resource));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

        Stage currentStage = (Stage) btn.getScene().getWindow();
        currentStage.close();
    }

}
