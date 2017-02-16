import java.io.*;
import java.net.Socket;

/**
 * Created by 14Spaseeva on 10.02.2017.
 */
public class Client {
    public static void main(String[] args) { // в арг пишем хост и порт
        try {

            Socket socket = new Socket(args[0], Integer.parseInt( args[1]));
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String message = "";
            while (!message.equals("exit")) {
                message = bufferedReader.readLine();
                dataOutputStream.writeUTF(message);
                System.out.println("message is sent");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
