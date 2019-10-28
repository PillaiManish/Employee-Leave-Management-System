package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class Cregister {

    @FXML
    private TextField names;

    @FXML
    private TextField designations;

    @FXML
    private TextField ageo;

    @FXML
    private TextField contacts;

    @FXML
    private TextField eamil;


    @FXML
    private TextField addresser;

    @FXML
    private Button register;

    @FXML
    void registerclick(ActionEvent event) throws Exception {
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();

        String sql="insert into registers"+"(`name`, `designation`, `gender`, `age`, `contact`, `emailid`, `address`)"+"values('"+names.getText()+"','"+designations.getText()+"','"+names.getText()+"','"+ageo.getText()+"','"+contacts.getText()+"','"+eamil.getText()+"','"+addresser.getText()+"')";
        statement.executeUpdate(sql);


        //
        System.out.println("done");


        //new page
        System.out.println("YUPP");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Update.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();








/*
        Statement statement=connection.createStatement();
        String sql="insert into register"+"(name,mob,id)"+"values('"+names.getText()+"',"+ages+",210)";
        statement.executeUpdate(sql);

        System.out.println("done");

 */

    }

}