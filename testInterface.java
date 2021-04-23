import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testInterface {
    @Test
    void testCreate(){
        Interface inter1 = new Interface();
        assertEquals(4, inter1.readLine("Video/AllVideo.txt"));
    }

    
}
