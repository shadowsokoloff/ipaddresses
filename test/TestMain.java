import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Shadow on 28.01.2017.
 */
public class TestMain {
    @Test
    public void testInputIp() throws IOException {
        IpAddresses ia = new IpAddresses();
        long address = ia.ipToLong("192.168.1.1");

        assertEquals(3232235777L,address);

    }
}
