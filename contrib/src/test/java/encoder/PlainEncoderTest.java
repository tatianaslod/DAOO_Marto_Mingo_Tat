package encoder;

import com.sun.istack.internal.NotNull;
import executor.ioc.MsgEncoderTest;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

public class PlainEncoderTest extends MsgEncoderTest {
    public PlainEncoderTest(@NotNull java.lang.String message, @NotNull byte[] encodedMessage) {
        super(new PlainEncoder(), message, encodedMessage);
    }

    @Parameterized.Parameters
    public static Collection messages() {
        return Arrays.asList(new Object[][]{
                {"mensaje", "mensaje".getBytes()},
        });
    }
}
