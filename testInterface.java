import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class testInterface {
    @Test
    void testCreate(){
        Interface inter1 = new Interface();
        String[][] readTest = new String[][]{{"HIIT", "30", "Test1.mp4", "button_back.png"}, {"Yoga", "35", "Test2.mp4", "button_back.png"}, {"Strength", "45", "Test3.mp4", "button_back.png"}, {"Speed", "60", "Test4.mp4", "button_back.png"}};
        assertEquals(readTest, inter1.readFromFile("Video/AllVideo.txt"));
    }

    
}
