public class Video {
    private String videoName;
    private int videoTime;
    private String filePath;
    private String figPath;
    private String tag;

    public Video(String videoName, int videoTime, String filePath, String figPath, String tag){
        setVideoName(videoName);
        setVideoTime(videoTime);
        setVideoPath(filePath);
        setVideoFig(figPath);
        setVideoTag(tag);
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
    public String getVideoFig(){
        return figPath;
    }

    public void setVideoTag(String tag){
        this.tag = tag;
    }

    public String getVideoTag(){
        return tag;
    }
}
