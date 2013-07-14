package executor.ioc;

import ioc.MsgEncoder;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MsgEncoderTest {

    private final String message;
    private final byte[] encodedMessage;
    private final MsgEncoder encoder;

    public MsgEncoderTest(@NotNull MsgEncoder encoder, @NotNull String message, @NotNull byte[] encodedMessage) {
        this.message = message;
        this.encodedMessage = encodedMessage;
        this.encoder = encoder;
    }

    @Test
    public void encode() {
        assertEquals(encodedMessage,encoder.encode(message));
    }

    @Test
    public void decode() {
        assertEquals(message,encoder.decode(encodedMessage));
    }

    @Test
    public void encode_decode() {
        assertEquals("pizza party", encoder.decode(encoder.encode("pizza party")));
    }

}