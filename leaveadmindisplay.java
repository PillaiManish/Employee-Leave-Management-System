package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.modeltableleave;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class leaveadmindisplay implements Initializable {

        @FXML
        private TableView<modeltableleave> table;

        @FXML
        private TableColumn<modeltableleave, String> name;

        @FXML
        private TableColumn<modeltableleave, String> from;

        @FXML
        private TableColumn<modeltableleave, String> to;

        @FXML
        private TableColumn<modeltableleave, String> reason;



    ObservableList<modeltableleave> oblister= FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    try {


        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
      Statement query= connection.createStatement();
      ResultSet rse=query.executeQuery("select * from register");

        while (rse.next()) {

            oblister.add(new modeltableleave(rse.getString("name"),rse.getString("from"),rse.getString("to"),rse.getString("reason")));

        }
        }
        catch(SQLException ex){
         Logger.getLogger(leaveadmindisplay.class.getName()).log(Level.SEVERE,null,ex);

            }

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        from.setCellValueFactory(new PropertyValueFactory<>("from"));
        to.setCellValueFactory(new PropertyValueFactory<>("to"));
        reason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        table.setItems(oblister);
    }


}

















/*
        Statement statement=connection.createStatement();
        String sql="insert into register"+"(name,mob,id)"+"values('"+names.getText()+"',"+ages+",210)";
        statement.executeUpdate(sql);

        System.out.println("done");

 */

