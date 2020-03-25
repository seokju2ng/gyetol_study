package socket;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {

        try (Socket client = new Socket("192.168.10.100", 5000);
             OutputStream os = client.getOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(os);) {

            System.out.print("입력할 문자열 : ");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            oos.writeObject(str);
            oos.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
