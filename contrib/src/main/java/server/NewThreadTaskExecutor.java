package server;

import com.sun.istack.internal.NotNull;
import ioc.Task;
import ioc.TaskExecutor;

public class NewThreadTaskExecutor implements TaskExecutor {

    @Override public void execute(@NotNull Task task) {
        Thread thread = new Thread(task);
        thread.start();
    }
}
