package ioc;

import com.sun.istack.internal.NotNull;

/**
 * User: Tatiana
 * Date: 28/06/13
 * Time: 02:54
 */
public class DummyExecutor implements TaskExecutor {

    @Override
    public void execute(@NotNull Task task) {
        task.run();
    }
}
