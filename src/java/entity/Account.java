package entity;

public class Account {
    private String username;
    private String password;
    private String gmail;

    public Account() {}

    public Account(String username, String password, String gmail) {
        this.username = username;
        this.password = password;
        this.gmail = gmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", gmail=" + gmail + '}';
    }  
}
