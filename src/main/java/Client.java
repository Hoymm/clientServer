import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // TOMEK
        //Socket socket = new Socket("10.30.1.85", 8189);

        Socket socket = new Socket("localhost", 7777);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        new Thread(() -> {
            try {
                while(true) {
                    writeMessageWithSleep(bufferedWriter, "POWOLNY SPAM SPAM SPAM :)");
                }
                /*writeMessageWithSleep(bufferedWriter, "Hello");
                writeMessageWithSleep(bufferedWriter, "Guys");
                writeMessageWithSleep(bufferedWriter, "I am sending messages to server !!! : )");
                writeMessageWithSleep(bufferedWriter, "Go out !!");
                writeMessageWithSleep(bufferedWriter, "Ok, I am busy");
                writeMessageWithSleep(bufferedWriter, "Tired...");
                writeMessageWithSleep(bufferedWriter, "Can I go for a break...?");
                writeMessageWithSleep(bufferedWriter, "Ok... gotta go !");
                writeMessageWithSleep(bufferedWriter, "Bye");*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void writeMessageWithSleep(BufferedWriter bufferedWriter, String text) throws IOException {
        bufferedWriter.write(text + "\n");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bufferedWriter.flush();
    }
}
