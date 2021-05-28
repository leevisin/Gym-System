public class Member {
    private String account;
    private String password;
    private String email;
    private String userType;//userType is "normal" in default      can be "VIP" after updating
    private int videotimes;

    public Member() {
    }

    public Member(String account, String password, String email,String userType) {
        this.account = account;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.videotimes = 10;
    }
    public int getVedioTimes(){
        return this.videotimes;
    }
    public void setVedioTimes(int vediotimes){
        this.videotimes = vediotimes;

    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType(){
        return userType;
    }
    public void setUserType(String userType){
        this.userType = userType;
    }


    public String toString() {
        return "Member{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                ", vediotimes='" + vediotimes + '\'' +
                '}';
    }
}

