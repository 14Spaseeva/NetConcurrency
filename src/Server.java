import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 14Spaseeva on 10.02.2017.
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(2000);
            Socket socket = serverSocket.accept ();

            DataInputStream dataInputStream = new  DataInputStream(socket.getInputStream());
//            DataOutputStream dataOutputStream = new  DataOutputStream(socket.getOutputStream());
//            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in));
            String message = dataInputStream.readUTF();
            System.out.println(message);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
