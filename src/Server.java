import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 14Spaseeva on 10.02.2017.
 */
public class Server {
    private final  static int max_value = 3;
    public static int session_ID= 0;
    public static void main(String[] args) { //в аргумент пишем номер порта
        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket( Integer.parseInt( args[0]));
            while (true) {
                Socket socket = serverSocket.accept();
                Thread new_client = new Thread(new Session(socket));
                if (session_ID < max_value) {
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.writeUTF("");
                    new_client.start();
                    session_ID++;
                    System.out.println("new client is connected");
                }
                else
                {
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.writeUTF(" U can't connect, \n Please, try later :)");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
