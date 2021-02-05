package socket.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zzj
 * @date 2021/2/5 14:56
 **/
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        if (args.length > 0) {
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress a : addresses) {
                System.out.println(a);
            }
        }
        else {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
            System.out.println(localHostAddress.getHostName());
            System.out.println(localHostAddress.getHostAddress());
        }
    }

}
