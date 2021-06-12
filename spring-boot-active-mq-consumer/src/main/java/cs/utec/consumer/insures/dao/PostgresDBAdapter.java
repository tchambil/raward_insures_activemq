package cs.utec.consumer.insures.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PostgresDBAdapter implements  IDBAdapter {
    private ResourceBundle rb = ResourceBundle.getBundle("application");
    String url = rb.getString("spring.datasource.url");
    String user = rb.getString("spring.datasource.username");
    String password = rb.getString("spring.datasource.password");

    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
