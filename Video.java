public class Video {
    private String videoName;
    private int videoTime;
    private String filePath;

    public Video(String videoName, int videoTime, String filePath){
        setVideoName(videoName);
        setVideoTime(videoTime);
        setVideoPath(filePath);
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
}
