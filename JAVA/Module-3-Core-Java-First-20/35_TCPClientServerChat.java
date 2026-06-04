import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TcpChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            output.println("Hello from server.");
            System.out.println("Client says: " + input.readLine());

            socket.close();
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

class TcpChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Server says: " + input.readLine());
            output.println("Hello from client.");
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
