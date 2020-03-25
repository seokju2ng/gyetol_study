package socket2;

import java.io.*;
import java.net.Socket;

public class Receiver implements Runnable {
    Socket connection;

    public Receiver(Socket connection) throws IOException {
        this.connection = connection;
    }

    @Override
    public void run() {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String msg;

            while((msg = br.readLine()) != null) {
                bw.write(msg + "\n");
                bw.flush();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
