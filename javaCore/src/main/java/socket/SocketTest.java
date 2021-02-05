package socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zzj
 * @date 2021/2/5 14:34
 **/
public class SocketTest {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("time-a.nist.gov", 13);
             Scanner in = new Scanner(socket.getInputStream(), "UTF-8")) {
            while (in.hasNextLine()) {
                String s = in.nextLine();
                System.out.println(s);
            }
        }
    }

}
