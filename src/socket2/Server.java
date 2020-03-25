package socket2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("server addr : " + addr.getHostAddress());
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try (ServerSocket server = new ServerSocket(5000);
             Socket connection = server.accept();)
        {
            System.out.println("클라이언트와 연결되었습니다.");

            ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(connection.getInputStream());
            String msg;
            System.out.print("메시지: ");

            while((msg = sc.nextLine()) != "exit") {
                oos.writeObject(msg);
                oos.flush();
                msg = (String)ois.readObject();
                System.out.println(msg);
                System.out.print("메시지: ");
            }
            System.out.println("채팅을 종료합니다.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}



