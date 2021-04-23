import static org.junit.jupiter.api.Assertions.*;

public class testInterface {
    void testCreate(){
        Interface inter = new Interface();
        assertEquals("3", inter.readLine("Video/AllVideo.txt"));
    }
}
