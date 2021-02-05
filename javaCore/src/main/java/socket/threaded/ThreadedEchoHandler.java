package socket.threaded;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zzj
 * @date 2021/2/5 15:33
 **/
public class ThreadedEchoHandler implements Runnable {
    private Socket incoming;
    public ThreadedEchoHandler(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try (InputStream inStream = incoming.getInputStream();
             OutputStream outputStream = incoming.getOutputStream()) {
            Scanner in = new Scanner(inStream, "UTF-8");
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(outputStream, "UTF-8"),
                    true
            );
            out.println("HELLO ! Enter BYE to exit.");
            boolean done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo:" + line);
                if (line.trim().equals("BYE")) {
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

