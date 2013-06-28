package ioc;

import daoo.ioc.MsgEncoder;
import daoo.ioc.Task;
import daoo.ioc.TaskExecutor;
import org.mockito.Matchers;
import server.NewThreadTaskExecutor;

import static org.mockito.Matchers.anyByte;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockProvider {

    public static MsgEncoder getMsgEncoder() {
        MsgEncoder encoder = mock(MsgEncoder.class);
        when(encoder.encode(anyString())).thenReturn("mockito test".getBytes());
        when(encoder.decode(new byte[]{anyByte()})).thenReturn("mockito test");
        return encoder;
    }

    public static TaskExecutor getExecutor() {
        return new DummyExecutor();
    }

}
