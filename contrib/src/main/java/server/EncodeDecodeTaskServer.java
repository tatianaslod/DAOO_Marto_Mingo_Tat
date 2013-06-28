package server;

import com.sun.istack.internal.NotNull;
import daoo.ioc.MsgEncoder;
import daoo.ioc.Task;
import daoo.ioc.TaskExecutor;
import daoo.ioc.TaskServer;

import java.net.ServerSocket;
import java.net.Socket;

public class EncodeDecodeTaskServer implements TaskServer {
    private final MsgEncoder msgEncoder;

    public EncodeDecodeTaskServer(MsgEncoder encoder) {
        this.msgEncoder = encoder;
    }

    @Override public void start(@NotNull TaskExecutor executor, int port) {
        try {
            final ServerSocket serverSocket = new ServerSocket(port);
            //noinspection InfiniteLoopStatement
            while (true) {
                System.out.println("Socket is waiting for request");
                Socket socket = serverSocket.accept();

                Task task = new EncodeDecodeTask(socket, msgEncoder);
                System.out.println("Socket is executing request");
                executor.execute(task);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
