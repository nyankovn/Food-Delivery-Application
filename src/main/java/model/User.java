package model;

public class User {
    public int UserId;
    public String Name;
    public String Email;
    public String PhoneNumber;
    public String Username;
    public String Password;


    public User(int UserId, String Name, String email, String phoneNumber, String username, String password) {
        UserId = UserId;
        Name = Name;
        Email = email;
        PhoneNumber = phoneNumber;
        Username = username;
        Password = password;
    }

    public int getUserId() {
        return UserId;
    }
}
