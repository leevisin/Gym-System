import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    void testUtilFunction(){
        /*emailFormat function*/
        String email1 = "123456";
        String email2 = "123456@qq.com";
        String email3 = "";
        assertEquals(0,Util.emailFormat(email1));
        assertEquals(1,Util.emailFormat(email2));
        assertEquals(0,Util.emailFormat(email3));


        /*passwordFormat function*/
        String password1 = "123a";
        String password2 = "123456a";
        String password3 = "1234567";
        assertEquals(-1,Util.passwordFormat(password1));
        assertEquals(1,Util.passwordFormat(password2));
        assertEquals(0,Util.passwordFormat(password3));//this one have problem expected 0 but is 1

        /*record currentuser*/
        Member member1 = new Member("Happy", "123456a", "123456@qq.com");//account, password, email
        Util.recordCurrentUser(member1);//test for records for once time
   


    }


     }
    

