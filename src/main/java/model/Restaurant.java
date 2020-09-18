package model;

import model.User;

public class Restaurant extends User {
    public Restaurant(int UserId, String Name, String email, String phoneNumber, String username, String password) {
        super(UserId, Name, email, phoneNumber, username, password);
    }
}
