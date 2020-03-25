package socket;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleServer {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("server addr : " + addr);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try (ServerSocket server = new ServerSocket(5000);
             Socket connection = server.accept();
             InputStream is = connection.getInputStream();
             ObjectInputStream ois = new ObjectInputStream(is))
        {
            String str = (String) ois.readObject();
            System.out.println("받은 문자열 = " + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
