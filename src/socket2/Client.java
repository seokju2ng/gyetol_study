package socket2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("호스트 입력 : ");
        String host = scanner.nextLine();

        try (Socket client = new Socket(host, 5000)) {
            System.out.println("서버와 연결되었습니다.");

            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            String msg;

            while((msg = (String)ois.readObject()) != null) {
                System.out.println(msg);
                System.out.print("메시지: ");
                msg = scanner.nextLine();
                oos.writeObject(msg);
                oos.flush();
            }
            System.out.println("채팅을 종료합니다.");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
