package socket2;

import java.io.*;
import java.net.Socket;

public class Sender implements Runnable {
    ObjectOutputStream oos;

    public Sender(Socket connection) throws IOException {
        this.oos = new ObjectOutputStream(connection.getOutputStream());
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String msg;

            while ((msg = br.readLine()) != null) {
                oos.writeObject(msg);
                oos.flush();
            }
            br.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
