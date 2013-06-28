package encoder;

import daoo.ioc.MsgEncoder;
import junit.framework.TestCase;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: Tatiana
 * Date: 25/06/13
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class MockitoTest extends TestCase {

    public static void main(String[] args) {
        MsgEncoder encoder = mock(MsgEncoder.class);
        given(encoder.decode(encoder.encode("hola"))).willReturn("hola");
        String msg = encoder.decode(encoder.encode("hola"));
        assertEquals(msg,"hola");
    }
}
