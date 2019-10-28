package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {

    @FXML
    private TextField userid;

    @FXML
    private Button login;
    @FXML
    private PasswordField password;
    @FXML
    private Label label;

    @FXML
    void login(ActionEvent event) throws SQLException {
        String user=userid.getText().toString();
        String pass=password.getText().toString();

        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();


        String sql="select * from registers where contact=? and name=?";


        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,user);
        preparedStatement.setString(2,pass);
        ResultSet resultSet=preparedStatement.executeQuery();

        if(!resultSet.next()) {
            label.setText("Enter right details");

        }
        else
            label.setText("LOGIN DETAILS CORRECT");




    }

}
