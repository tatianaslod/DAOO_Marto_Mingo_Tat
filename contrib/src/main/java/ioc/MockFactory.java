package ioc;

import static org.mockito.Matchers.anyByte;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockFactory {

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
