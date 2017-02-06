import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Shadow on 28.01.2017.
 */
public class TestMain {
    Long firstIpLong = 3232235777L;
    Long secondIpLong = 3232235786L;
    Long[] expectedArray = {3232235777L, 3232235778L, 3232235779L, 3232235780L, 3232235781L, 3232235782L, 3232235783L, 3232235784L, 3232235785L, null};
    String defaultIp = "192.168.1.1";
    String invalidIp = "192.168.1.255";


    @Test
    public void testIpToLong() throws IOException {
        IpAddresses ia = new IpAddresses();
        Long address = ia.ipToLong(defaultIp);

        assertEquals( firstIpLong, address);
    }


    @Test
    public void testMakeIpArray() {
        IpAddresses ia = new IpAddresses();
        Long[] ipArray = ia.makeIpArray(firstIpLong, secondIpLong);

        assertArrayEquals(expectedArray, ipArray);

    }

    @Test
    public void testTryParse() throws IOException {
        IpAddresses ia = new IpAddresses();
        boolean result = ia.tryParseLong(defaultIp);
        boolean resultFalse = ia.tryParseLong("Привет!");
        boolean resultInvalid = ia.tryParseLong(invalidIp);

        assertEquals(true, result);
        assertEquals(false, resultFalse);
        assertEquals(false, resultInvalid);

    }


    @Test
    public void testLongToIp()
    {
        IpAddresses ia = new IpAddresses();
        String address = ia.longToIp(firstIpLong);

        assertEquals(defaultIp, address);
    }


}
