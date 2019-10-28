package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.time.LocalDate;

public class leaverequest {


    @FXML
    private DatePicker from;

    @FXML
    private DatePicker to;

    @FXML
    private TextField reason;


    @FXML
    private Button submitbtn;


    @FXML
    private Label label;


    @FXML
    void submit(ActionEvent event) throws Exception {
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();


       // LocalDate lb1=from.getValue();
        //String lb2=((TextField)to.getEditor()).getText();
        //System.out.println(lb1);


        String sql="insert into leave"+"(`user`, `from`, `to`, `reason`)"+"values(?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
          preparedStatement.setString(1,"asd");
         preparedStatement.setString(2,"asd");
        preparedStatement.setString(3,"asd");
        preparedStatement.setString(4,"asd");

         preparedStatement.executeUpdate();
      //statement.executeUpdate(sql);





    }

}
