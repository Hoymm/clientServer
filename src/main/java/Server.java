import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7777);
            Socket client = serverSocket.accept();

            writeTo(client, "Hi dude!");
            getInputFromClient(client);
            writeTo(client, "Come back to me later !!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getInputFromClient(Socket client) throws IOException {
        Scanner scanner = new Scanner(client.getInputStream());
        String userInput = null;
        while (!"BYE".equalsIgnoreCase(userInput)) {
            System.out.println(userInput = scanner.nextLine());
        }
    }

    private static void writeTo(Socket client, String text) throws IOException {
        OutputStream outputStream = client.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println(text);
        writer.flush();
    }
}
