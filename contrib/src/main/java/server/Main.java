package server;

import daoo.ioc.TaskServer;
import ioc.Context;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Context context = new Context();
        context.init("contrib/configuration.txt");
        try {
            final TaskServer server = new EncodeDecodeTaskServer(context.getMsgEncoder());
            server.start(context.getTaskExecutor(),8080);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
