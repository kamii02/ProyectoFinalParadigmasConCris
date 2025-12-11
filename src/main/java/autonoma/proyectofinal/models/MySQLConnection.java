package autonoma.proyectofinal.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static MySQLConnection instance;   // the one and only
    private Connection connection;

    // replace with your own credentials
    private final String url = "jdbc:mysql://localhost:3306/sistemadediagnostico";
    private final String user = "root";
    private final String password = "root";

    // constructor hidden so nobody else can create instances
    private MySQLConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL!");
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to database", e);
        }
    }

    public static MySQLConnection getInstance() {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }   
}
