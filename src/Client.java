import java.io.*;
import java.net.Socket;

/**
 * Created by 14Spaseeva on 10.02.2017.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2000);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Hello world");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
