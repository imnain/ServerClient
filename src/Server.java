import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class Server {

    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    public Server(int port) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server started");
        socket = server.accept();
        System.out.println("Accepted client request.");
        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String line = "";
        System.out.println("reading data from client");
        while(!line.equals("bye")){
                line = in.readUTF();
            System.out.println(line);
        }
        server.close();
        socket.close();
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server(8000);
    }
}
