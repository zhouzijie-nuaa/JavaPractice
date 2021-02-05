package socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author zzj
 * @date 2021/2/5 15:10
 **/
public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(8189)) {
            try (Socket incoming = s.accept()) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                try (Scanner in = new Scanner(inStream, "UTF-8")) {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"), true);
                    out.println("Hello! Enter BYE to exit.");
                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo:" + line);
                        if (line.trim().equals("BYE")) {
                            done = true;
                        }
                    }
                }

            }
        }
    }

}
