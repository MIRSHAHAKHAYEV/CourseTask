package model;

public class Admin {
    private static int staticId=0;
    private int id;
    private String userName;
    private String password;

    public Admin(String userName, String password) {
        id=staticId;
        staticId++;
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
