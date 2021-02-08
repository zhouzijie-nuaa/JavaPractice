package socket.urlconnection;

import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zzj
 * @date 2021/2/8 16:18
 **/
public class UrlConnectionTest {

    public static void main(String[] args) {
        try {
            String urlName;
            if (args.length > 0) {
                urlName = args[0];
            }else {
                urlName = "https://www.baidu.com/";
            }

            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();

            if (args.length > 2) {
                String userName = args[1];
                String password = args[2];
                String input = urlName + ":" + password;
                Base64.Encoder encoder = Base64.getEncoder();
                String encoding = encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8));
                connection.setRequestProperty("Authorization", "Basic" + encoding);
            }

            connection.connect();

            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    System.out.println(key + ":" + value);
                }
            }

            System.out.println("_______________");
            System.out.println("getContentType:" + connection.getContentType());
            System.out.println("getContentLength:"  + connection.getContentLength());
            System.out.println("getContentEncoding:" + connection.getContentEncoding());
            System.out.println("getDate:" + connection.getDate());
            System.out.println("getExpiration:" + connection.getExpiration());
            System.out.println("getLastModifed:" + connection.getLastModified());

            String encoding = connection.getContentEncoding();
            if (encoding == null) {
                encoding = "UTF-8";
            }
            try (Scanner in = new Scanner(connection.getInputStream(), encoding)) {
                for (int n =1; in.hasNextLine() && n <= 10; n++) {
                    System.out.println(in.nextLine());
                }
                if (in.hasNextLine()) {
                    System.out.println("...");
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
