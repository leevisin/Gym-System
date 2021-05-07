public class TestString {

    
    public static void main(String[] args) {
        String[] str = new String[3];
        str[0]="Zoga";
        str[1]="YIIT";
        str[2]="Strength";
        // str[3]="cfe";
        
        for(int i=0; i<3; i++){
            for(int j=i; j<3; j++){
                System.out.print(str[i].compareTo(str[j]) + " ");
                if(str[i].compareTo(str[j])>0){
                    String tmp = str[i];
                    str[i] = str[j];
                    str[j] = tmp;
                }
            }
            System.out.println();
        }
        for(int i=0; i<3; i++){
            System.out.println(str[i]);
        }
    }
    
}
