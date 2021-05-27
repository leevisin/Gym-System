import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class EmailTest {
    @Test
    void testEmail(){
        assertEquals(0, Util.emailFormat("www.baidu.com"));
        assertEquals(1, Util.emailFormat("JohnWick@bupt.edu.cn"));
    }
}
