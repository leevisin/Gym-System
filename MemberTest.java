import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class MemberTest {
    @Test
    public void test(){
        Member mm = new Member("LMX", "123456Aa", "123378357@gmail.com", "normal");
        assertEquals("LMX", mm.getAccount());
        assertEquals("123456Aa", mm.getPassword());
        assertEquals("123378357@gmail.com", mm.getEmail());
        assertEquals("normal", mm.getUserType());
        assertEquals(10, mm.getVideoTimes());
    }
}
