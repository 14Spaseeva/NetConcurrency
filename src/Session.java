import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by ASPA on 02.03.2017.
 */
public class Session implements Runnable {

    private Socket socket;

    public Session(Socket socket_) {
        this.socket = socket_;
    }

    public void run() {


        try {

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

//            DataOutputStream dataOutputStream = new  DataOutputStream(socket.getOutputStream());
//            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in));
            String message = "";
            while (!message.equals("exit")) {

                message = dataInputStream.readUTF();
                System.out.println(message);

            }
            Server.session_ID--;
        } catch (Exception e) {

            if (e.getMessage().equals("Connection reset")) {
                Server.session_ID--;


            }
        }
    }
}
