import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class PasswordTest {
    @Test
    void testPassword(){
        assertEquals(-1, Util.passwordFormat("1234a"));
        
        assertEquals(0, Util.passwordFormat("1234567"));
        
        assertEquals(1, Util.passwordFormat("1234567a"));
        


        System.out.println(Util.passwordFormat("1234"));
        System.out.println(Util.passwordFormat("1234567"));
        System.out.println(Util.passwordFormat("123456a"));
    }
}
