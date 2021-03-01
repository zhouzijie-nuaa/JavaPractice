package jdbc.exec;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author zzj
 * @date 2021/2/22 21:41
 **/
public class ExecSQL {

    public static void main(String[] args) {
        try (
            Scanner in = args.length == 0 ? new Scanner(System.in)
                    : new Scanner(Paths.get(args[0]), "UTF-8")){
            try (
                Connection conn = getConnection();
                Statement stat = conn.createStatement()){
                while (true) {
                    if (args.length == 0) {
                        System.out.println("Enter command or EXIT to exit;");
                    }
                    if (!in.hasNextLine()) {
                        return;
                    }
                    String line = in.nextLine().trim();
                    if (line.equalsIgnoreCase("EXIT")) {
                        return;
                    }
                    if (line.endsWith(";")) {
                        line = line.substring(0, line.length() - 1);
                    }
                    try {
                        boolean isResult = stat.execute(line);
                        if (isResult) {
                            try (ResultSet rs = stat.getResultSet()) {
                                showResultSet(rs);
                            }
                        }else {
                            int updateCount = stat.getUpdateCount();
                            System.out.println(updateCount + "rows updated");
                        }
                    }catch (SQLException ex) {
                        for (Throwable e : ex) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showResultSet(ResultSet result) throws SQLException {
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i < columnCount ; i++) {
            if (i > 1) {
                System.out.print(",");
            }
            System.out.print(metaData.getColumnLabel(i));
        }
        System.out.println();
        while (result.next()) {
            for (int j = 1; j < columnCount; j++) {
                if (j > 1) {
                    System.out.print(",");
                    System.out.print(result.getString(j));
                }
            }
            System.out.println();
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
