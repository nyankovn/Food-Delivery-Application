package model;

public class User {
    public int UserId;
    public String Name;
    public String Email;
    public String PhoneNumber;
    public String Username;
    public String Password;


    public  User() {}

    public User(int UserId, String Name, String email, String phoneNumber, String username, String password) {
        this.UserId = UserId;
        this.Name = Name;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.Username = username;
        this.Password = password;
    }

    public int getUserId() {
        return UserId;
    }

}
