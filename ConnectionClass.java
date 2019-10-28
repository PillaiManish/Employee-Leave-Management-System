package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection connection;
    public Connection getConnection(){

        String dbName="elms";
        String username="root";
        String password="vamps";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,username,password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
