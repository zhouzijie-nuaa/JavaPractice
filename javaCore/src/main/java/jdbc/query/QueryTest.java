package jdbc.query;


import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author zzj
 * @date 2021/2/23 16:02
 **/
public class QueryTest {

    private static final String allQuery = "select Books.Price, Books.Title from Books";
    private static final String authorPublishersQuery = "select Books.price, Books.Title" +
            "from Books, BooksAuthors, Authors, Publishers" +
            "where Authors.Author_Id = BooksAuthors.Author_Id and BooksAuthors.ISBN = Books.ISBN" +
            "and Books.Publisher_Id = Publishers.Publisher_Id and Authors.Name = ?" +
            "and Publishers.Name = ?";
    private static final String authorQuery = "select Books.prices, Books.Title " +
            "from Books, BooksAuthors, Authors" +
            "where Authors.Authors.Author_Id = BooksAuthors.Author_Id " +
            "and Authors.Name = ?";
    private static final String publisherQuery = "select Books.Price, Books.Title " +
            "from Books, Publishers" +
            "where Books.Publisher_Id = Publishers.Publisher_Id " +
            "and Publishers.name = ?";
    private static final String priceUpdate = "update Books set Price = Price + ?" +
            "where Books.Publisher_Id = (select Publisher_Id from Publishers where Name = ?)";
    private static Scanner in;
    private static ArrayList<String> authors = new ArrayList<>();
    private static ArrayList<String> publishers = new ArrayList<>();

    public static void main(String[] args) throws SQLException, IOException {
        try (Connection conn = getConnection()) {
            in = new Scanner(System.in);
            authors.add("Any");
            publishers.add("Any");
            try (Statement stat = conn.createStatement()) {
                String query = "select Name from Authors";
                try (ResultSet rs = stat.executeQuery(query)) {
                    while (rs.next()) {
                        authors.add(rs.getString(1));
                    }
                }
                query = "select Name from Publishers";
                try (ResultSet rs = stat.executeQuery(query)) {
                    while (rs.next()) {
                        publishers.add(rs.getString(1));
                    }
                }
            }
            boolean done = false;
            while (!done) {
                System.out.print("Q)uery C)hange prices E)xit: ");
                String input = in.next().toUpperCase();
                if (input.equals("Q")) {
                    executeQuery(conn);
                }
                else if (input.equals("C")) {
                    changePrices(conn);
                }else {
                    done = true;
                }
            }
        }catch (SQLException ex) {
            for (Throwable e : ex) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Connection getConnection() throws IOException, SQLException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
            props.load(in);
        }
        String drovers = props.getProperty("jdbc.drivers");
        if (drovers != null) {
            System.setProperty("jdbc.drivers", drovers);
        }
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password);
    }

    private static void changePrices(Connection conn) throws SQLException {
        String publisher = select("Publishers:", publishers.subList(1,publishers.size()));
        System.out.print("Change price by:");
        double priceChange = in.nextDouble();
        PreparedStatement stat = conn.prepareStatement(priceUpdate);
        stat.setDouble(1, priceChange);
        stat.setString(2, publisher);
        int r = stat.executeUpdate();
        System.out.println(r + "records updated.");
    }

    private static String select(String prompt, List<String> options) {
        while (true) {
            System.out.println(prompt);
            for (int i = 0; i < options.size(); i++) {
                System.out.printf("%2d) %s%n", i + 1, options.get(i));
            }
            int sel = in.nextInt();
            if (sel > 0 && sel <= options.size()) {
                return options.get(sel - 1);
            }
        }
    }

    private static void executeQuery(Connection conn) throws SQLException {
        String author = select("Authors:", authors);
        String publisher = select("Publisher:", publishers);
        PreparedStatement stat;
        if (!author.equals("Any") && !publisher.equals("Any")) {
            stat = conn.prepareStatement(authorPublishersQuery);
            stat.setString(1, author);
            stat.setString(2, publisher);
        }else if (!author.equals("Any") && publisher.equals("Any")) {
            stat = conn.prepareStatement(authorQuery);
            stat.setString(1, author);
        }else if (author.equals("Any") && !publisher.equals("Any")) {
            stat = conn.prepareStatement(publisherQuery);
            stat.setString(1, publisher);
        }else {
            stat = conn.prepareStatement(allQuery);
        }
        try (ResultSet rs = stat.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + "," +rs.getString(2));
            }
        }
    }

}
