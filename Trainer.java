public class Trainer {
    private String trainerName;
    private String trainerType;
    private String figPath;

    public Trainer(String trainerName, String trainerType, String figPath){
        setTrainerName(trainerName);
        setTrainerType(trainerType);
        setTrainerFig(figPath);
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

    public void setTrainerFig(String figPath){
        this.figPath = figPath;
    }

    public String getTrainerFig(){
        return figPath;
    }
    
}