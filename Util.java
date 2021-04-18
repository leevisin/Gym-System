import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static String pathname = "member.txt";
    public static String currentuser = "currentaccount.txt";

    public static List<Member> readFile() {
        List<Member> memberList = new ArrayList<>();
        BufferedReader br = null;
        InputStreamReader reader = null;

        try {
            if (!new File(pathname).exists()) {
                new File(pathname).createNewFile();
            }
            reader = new InputStreamReader(new FileInputStream(new File(pathname)), StandardCharsets.UTF_8);
            br = new BufferedReader(reader);
            StringBuilder all = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                all.append(line);
            }
            br.close();
            if (all.length() != 0) {
                return StringToArrayList(all.toString());
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean writeFile(List<Member> memberList) {
        OutputStreamWriter writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(new File(pathname)), StandardCharsets.UTF_8);
            writer.flush();
            String str = memberList.toString();
            writer.write(str);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static List<Member> StringToArrayList(String str) {
        List<Member> members = new ArrayList<>();
        if (str.length() == 2) {
            return new ArrayList<>();
        } else {
            String[] strings = str.replace("Member{", "").split("},");
            for (int i = 0; i < strings.length; i++) {
                String string = strings[i].replace("{", "").replace("'", "").replace("[", "").replace("]", "").replace("}", "");
                String[] keyAndValue = string.split(",");
                Member member = new Member();
                for (int j = 0; j < keyAndValue.length; j++) {
                    keyAndValue[j] = keyAndValue[j].trim();
                    String[] world = keyAndValue[j].split("=");
                    if (world[0].equals("account")) {
                        member.setAccount(world[1]);
                    } else if (world[0].equals("email")) {
                        member.setEmail(world[1]);
                    } else if (world[0].equals("password")) {
                        member.setPassword(world[1]);
                    }
                }
                members.add(member);
            }
            return members;
        }
    }

    /**
	 * Verify the format of a new password
	 * @param pasword the password choose by user
	 * @return int value indicate the verified outcome,1=success,0=require both number and character,-1=lenth less than 6 
	 */
    public static int passwordFormat(String password){
        //chek for the length of password
        if(password.length()<6)
        {return -1;}
        //chek for the both character and number
        boolean havechar = false;
        boolean havenum = false;
        for (int i = 0; i < password.length(); i++) {
            if(password.charAt(i)<='9'||password.charAt(i)>='0')
            {havenum = true;}
            if(password.charAt(i)<='z'||password.charAt(i)>='a'||password.charAt(i)<='Z'||password.charAt(i)>='A')
            {havechar = true;}
        }

        if(havenum&havechar){
            return 1;
        }
        else{
            return 0;
        }
    }
 
      	/**
	 * Verify the format of a new email
	 * @param email the email choose by user
	 * @return int value indicate the verified outcome,1=valid,0=invalid
	 */
     public static int emailFormat(String email){
         boolean valid = false;
        for (int i = 0; i < email.length(); i++) {
            if(email.charAt(i)=='@'){
               valid = true;
            }
        }

        if(valid == true){
            return 1;
        }
        else{
            return 0;
        }

     
    }




    
}
