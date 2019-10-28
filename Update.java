package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Statement;

public class Update {

    @FXML
    private TextField contact;

    @FXML
    private TextField email;

    @FXML
    private Button update;

    @FXML
    void updateclick(ActionEvent event) throws Exception {
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        Statement statement=connection.createStatement();
        String sql="update registers set name='"+email.getText()+"' where contact='"+contact.getText()+"'";
        statement.executeUpdate(sql);
    }

}
