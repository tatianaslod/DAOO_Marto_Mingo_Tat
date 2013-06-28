package daoo.ioc;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Mingus
 * Date: 01/06/13
 * Time: 06:26
 * To change this template use File | Settings | File Templates.
 */
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

    /*
    @Test
    public void whenNull(){
        assertNotNull(encoder.encode(null));
        assertNotNull(encoder.decode(null));
    } */

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