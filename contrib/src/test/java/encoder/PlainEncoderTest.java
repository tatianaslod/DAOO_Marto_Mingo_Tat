package encoder;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Tatiana
 * Date: 17/05/13
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class PlainEncoderTest extends TestCase {

    public void testEncodeDecode() {
        final PlainEncoder encoder = new PlainEncoder();

        final String decode = encoder.decode("some".getBytes());
        final byte[] encode = encoder.encode("some");

        assertEquals("Encode - Decode Test Pass", decode, new String(encode));
    }
}
