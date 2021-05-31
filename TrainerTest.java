import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TrainerTest {
    @Test
    public void test(){
        Trainer tr = new Trainer("John", "Strength", "figPath", "a good trainer");
        assertEquals("John", tr.getTrainerName());
        assertEquals("Strength", tr.getTrainerType());
        assertEquals("figPath", tr.getTrainerFig());
        assertEquals("a good trainer", tr.getTrainerIntro());
    }
}