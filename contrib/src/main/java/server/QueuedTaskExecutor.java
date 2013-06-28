package server;

import com.sun.istack.internal.NotNull;
import daoo.ioc.Task;
import daoo.ioc.TaskExecutor;

import java.util.LinkedList;

public class QueuedTaskExecutor extends Thread implements TaskExecutor {
    private LinkedList<Task> queue;
    private Thread thread;

    @Override
    public void execute(@NotNull Task task) {
        queue.add(task);
    }

    public QueuedTaskExecutor() {
        queue = new LinkedList<>();
        thread = new Thread();
        start();
    }

    public void run() {
        while (true) {
            if (!thread.isAlive() && !queue.isEmpty()) {
                thread = new Thread(queue.remove());
                thread.start();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Running Task - Actual Queeue size: " + queue.size());
            }
        }
    }
}
