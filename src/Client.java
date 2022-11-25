import java.io.*;
import java.net.Socket;


public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    public Client(String address, int port) throws IOException {
        socket = new Socket(address, port);
        input = new DataInputStream(System.in);
        output = new DataOutputStream(socket.getOutputStream());
        String line = "";
        while(!line.equals("bye")){
            line = input.readLine();
            output.writeUTF(line);
        }
        System.out.println("closing client bye!");
        socket.close();
        input.close();
        output.close();
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1",8000);
    }
}
