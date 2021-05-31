import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class AccountTest {
    @Test
    void testAccount(){
        assertEquals(false, Util.accountFormat("40085323a"));
        assertEquals(true, Util.accountFormat("400853233"));
    }
}
