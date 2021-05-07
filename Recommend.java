import java.io.*;

public class Recommend {
    
    // Get the user information from file.txt
    public String[][] readFromFile(String filename){
        // Exit when file not exist
        try {
            File file = new File(filename);
            if(!file.exists()){
                System.out.println("No such file, then we will exit..");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Create Base Enviroment Error!");
        }

        String contents = "";
        try{
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String oneLine = bufferedReader.readLine();
            while(oneLine != null){
                contents += oneLine + ",";
                oneLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException e) {
            System.out.println("Errors occured: IOException!");
            System.exit(1);
        }     

        // Store file contents into array
        int rows = readLine(filename);
        String[] courseContents = contents.split(",");
        int columns = courseContents.length/rows;
        String[][] infoArray = new String[rows][columns];
        int k=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                infoArray[i][j] = courseContents[k];
                k++;
            }
        }

        // Read information to an array and storage it, so that it needn't read twice.
        return infoArray;
     }

    // Read Line, i.e number of users
    public int readLine(String filename){
        int lines = 0;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String oneLine = bufferedReader.readLine();
            while(oneLine != null){
                lines++;
                oneLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            System.out.println("readLine function error!");
        }
        return lines;
    }

    // Get Current User Information
    public String readCurrentUserAccount(){
        String userInfo = "";
        try{
            FileReader fileReader = new FileReader("Source/currentuser.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String oneLine = bufferedReader.readLine();
                userInfo += oneLine;
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException e) {
            System.out.println("Errors occured: IOException!");
            System.exit(1);
        }     
        return userInfo.split(",")[0]; // Return User Account
    }

    // Get user infomation and need currentuser.txt
    public String[] getInformation(String filename){
        String userAccount = readCurrentUserAccount();
        String[][] usersInformation = readFromFile(filename);
        String[] searchResult = new String[usersInformation[0].length];
        for(int i=0; i<usersInformation.length; i++){
            if(usersInformation[i][0].equals(userAccount)){
                for(int j=0; j<usersInformation[0].length; j++){
                    searchResult[j] = usersInformation[i][j];
                }
                return searchResult;
            }
        }
        return null;
    }


    // Calculate BMI value based on heigt(cm) and weight(kg)
    public double calBMI(Double height, Double weight){
        return weight/(height*height);
    }

    // Get BMI range feedback
    public String BMIFeedback(double BMI){
        if(BMI<=0){
            return "BMI Error.";
        }
        else if(BMI<=18.4){
            return "Underweight";
        }
        else if(BMI<=24.9){
            return "Normal Weight";
        }
        else if(BMI<=29.9){
            return  "Overweight";
        }
        else{
            return "Obesity";
        }
    }

    // Base on User BMI, Will, Time and Frequency
    // Current User Information Stores in String[] getInformation(String filename)
    // Need to judge null String situation (Not implements)
    public String[][] recommendCourse(){
        return null;
    }

    // Generate recommend page
}
