package executor;

import ioc.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import server.EncodeDecodeTaskServer;
import server.NewThreadTaskExecutor;
import server.PoolThreadTaskExecutor;
import server.QueuedTaskExecutor;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Matchers.anyByte;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * User: Tatiana
 * Date: 28/06/13
 * Time: 15:24
 */
//@RunWith(Parameterized.class)
public class QueuedExecutorTest {
    private final Context context;

    public QueuedExecutorTest() {
        context = new Context();
        context.setEncoder(MockFactory.getMsgEncoder());
        context.setExecutor(new QueuedTaskExecutor());
    }

    @Test
    public void testExecutor(){
        Task task = mock(Task.class);

        try {
            context.getTaskExecutor().execute(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
        verify(task).run();
    }
//
//    @Parameterized.Parameters
//    public static Collection taskExecutor() {
//        return Arrays.asList(new Object[][]
//                {{new NewThreadTaskExecutor()},{new QueuedTaskExecutor()},{new PoolThreadTaskExecutor()}});
//    }

}
