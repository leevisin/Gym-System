public class Member {
    private String account;
    private String password;
    private String email;

    public Member() {
    }

    public Member(String account, String password, String email) {
        this.account = account;
        this.password = password;
        this.email = email;
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


    public String toString() {
        return "Member{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

