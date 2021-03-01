package jdbc.test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

/**
 * @author zzj
 * @date 2021/2/17 16:42
 **/
public class TestDB {

    public static void main(String[] args) throws IOException {
        try {
            runTest();
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }
    }

    private static void runTest() throws IOException, SQLException {
        try (Connection conn = getConnection();
            Statement stat = conn.createStatement()) {
            stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20) ) ");
            stat.executeUpdate("insert into Greeting values ('Hello, world!')");

            try (ResultSet result = stat.executeQuery("select * from Greetings")){
                if (result.next()) {
                    System.out.println(result.getString(1));
                }
            }
            stat.executeUpdate("Drop table Greetings");
        }
    }

    private static Connection getConnection() throws IOException, SQLException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }

}
