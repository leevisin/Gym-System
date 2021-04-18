public class Trainer {
    private String trainerName;
    private String trainerType;

    public Trainer(String trainerName, String trainerType){
        setTrainerName(trainerName);
        setTrainerType(trainerType);
    }

    public String getTrainerName(){
        return trainerName;
    }

    public String getTrainerType(){
        return trainerType;
    }

    public void setTrainerName(String trainerName){
        this.trainerName = trainerName;
    }

    public void setTrainerType(String trainerType){
        this.trainerType = trainerType;
    }
    
}