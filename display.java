package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.ConnectionClass;
import sample.modeltable;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class display implements Initializable{

    @FXML
    private TableView<modeltable> table;

    @FXML
    private TableColumn<modeltable, String> name;

    @FXML
    private TableColumn<modeltable, String> designation;

    @FXML
    private TableColumn<modeltable, String> gender;

    @FXML
    private TableColumn<modeltable, String> age;

    @FXML
    private TableColumn<modeltable, String> contact;

    @FXML
    private TableColumn<modeltable, String> emailid;

    @FXML
    private TableColumn<modeltable, String> address;

    ObservableList<modeltable> oblist= FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    try {


        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

      //  ResultSet rs = connection.createStatement().executeQuery("select * from registers");
      Statement query= connection.createStatement();
      ResultSet rs=query.executeQuery("select * from elms.registers");

        while (rs.next()) {
            //String tab=rs.getString("name");
            //System.out.println(tab);
            oblist.add(new modeltable(rs.getString("name"),rs.getString("designation"),rs.getString("gender"),rs.getString("age"),rs.getString("contact"),rs.getString("emailid"),rs.getString("address")));
        }
        }
        catch(SQLException ex){
         Logger.getLogger(display.class.getName()).log(Level.SEVERE,null,ex);

            }

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        designation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        emailid.setCellValueFactory(new PropertyValueFactory<>("emailid"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

            table.setItems(oblist);
    }


}

















/*
        Statement statement=connection.createStatement();
        String sql="insert into register"+"(name,mob,id)"+"values('"+names.getText()+"',"+ages+",210)";
        statement.executeUpdate(sql);

        System.out.println("done");

 */



