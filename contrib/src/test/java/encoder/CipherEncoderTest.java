package encoder;


import com.sun.istack.internal.NotNull;
import daoo.ioc.MsgEncoderTest;
import junit.framework.TestCase;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


/**
 * Created with IntelliJ IDEA.
 * User: Tatiana
 * Date: 17/05/13
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
public class CipherEncoderTest extends MsgEncoderTest {
    public CipherEncoderTest(@NotNull java.lang.String message, @NotNull byte[] encodedMessage) {
        super(new CipherEncoder(), message, encodedMessage);
    }


    @Parameterized.Parameters
    public static Collection messages() {
        return Arrays.asList(new Object[][]{
                {"mensaje", "".getBytes()},
        });
    }
}
