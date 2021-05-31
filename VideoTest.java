
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class VideoTest {
    @Test
    public void test(){
        Video vd = new Video("DO 20 PUSHUPS", 30, "videos/pushup.mp4", "images/button_back", "Strength", 0);
        assertEquals("DO 20 PUSHUPS", vd.getVideoName());
        assertEquals(30, vd.getVideoTime());
        assertEquals("videos/pushup.mp4", vd.getVideoPath());
        assertEquals("images/button_back", vd.getVideoFig());
        assertEquals("Strength", vd.getVideoTag());
        assertEquals(0, vd.getVideoVip());


    }
}