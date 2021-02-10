package socket.post;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author zzj
 * @date 2021/2/10 14:55
 **/
public class PostTest {

    public static void main(String[] args) throws IOException {
        String propsFilename = args.length > 0 ? args[0] : "socket/post/post.properties";
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(propsFilename))) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = props.remove("url").toString();
        Object userAgent = props.remove("User—Agent");
        Object redirects = props.remove("redirects");
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        String result = doPost(new URL(url), props, userAgent == null ? null : userAgent.toString(),
                redirects == null ? -1 : Integer.parseInt(redirects.toString()));

        System.out.println(result);
        }

    public static String doPost(URL url, Properties props, String s, int i) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (s != null) {
            connection.setRequestProperty("User-Agent", s);
        }
        if (i >= 0) {
            connection.setInstanceFollowRedirects(false);
        }
        connection.setDoOutput(true);
        StringBuilder response = new StringBuilder();
        try (PrintWriter out = new PrintWriter(connection.getOutputStream())) {
            boolean first = true;
            for (Map.Entry<Object, Object> pair : props.entrySet()) {
                if (first) {
                    first = false;
                }
                else {
                out.print("&");
                }
                String name = pair.getKey().toString();
                String value = pair.getValue().toString();
                out.print(name);
                out.print('=');
                out.print(URLEncoder.encode(value, "UTF-8"));
            }
            String encoding = connection.getContentEncoding();
            if (encoding == null) {
                encoding = "UTF-8";
            }

            try (Scanner in = new Scanner(connection.getInputStream(), encoding)) {
                while (in.hasNextLine()) {
                    response.append(in.nextLine());
                    response.append("\n");
                }
            }

        }
         return response.toString();
    }
}
