import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Shadow on 28.01.2017.
 */
public class TestMain {
    Long firstIpLong = 3232235777L;
    Long secondIpLong = 3232235786L;
    Long[] expectedArray = {3232235777L, 3232235778L, 3232235779L, 3232235780L, 3232235781L, 3232235782L, 3232235783L, 3232235784L, 3232235785L, null};


    @Test
    public void testIpToLong() throws IOException {
        IpAddresses ia = new IpAddresses();
        long address = ia.ipToLong("192.168.1.1");

        assertEquals(3232235777L,address);
    }


    @Test
    public void testMakeIpArray() {
        IpAddresses ia = new IpAddresses();
        Long[] ipArray = ia.makeIpArray(firstIpLong,secondIpLong);

        for (int i = 0; i<ipArray.length; i++) {
            assertEquals(expectedArray[i],ipArray[i]);
        }

    }

}
