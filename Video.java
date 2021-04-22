public class Video {
    private String videoName;
    private int videoTime;
    private String filePath;
    private String figPath;

    public Video(String videoName, int videoTime, String filePath, String figPath){
        setVideoName(videoName);
        setVideoTime(videoTime);
        setVideoPath(filePath);
        setVideoFig(figPath);
    }

    public String getVideoName(){
        return videoName;
    }
    public int getVideoTime(){
        return videoTime;
    }
    public void setVideoName(String videoName){
        this.videoName = videoName;
    }
    public void setVideoTime(int videoTime){
        this.videoTime = videoTime;
    }
    public void setVideoPath(String filePath){
        this.filePath = filePath;
    }
    public String getVideoPath(){
        return filePath;
    }
    public void setVideoFig(String figPath){
        this.figPath = figPath;
    }
    public String getVideoFile(){
        return figPath;
    }
}
