import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class ConcurrencyHttpServe {
    public static void main(String[] args0) throws IOException {
        ServerSocket serviceSocket = new ServerSocket(8801);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        while(true){
            Socket socket = serviceSocket.accept();
            executorService.submit(()->service(socket));
        }
    }

    private static void service(Socket socket){

        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,nio1";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.flush();
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}