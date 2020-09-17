package model;

import model.User;

public class Restaurant extends User {
    public Restaurant(int userId, String Name, String email, String phoneNumber, String username, String password) {
        super(userId, Name, email, phoneNumber, username, password);
    }
}
