package model;

public class Customer extends User {
    public Customer(int UserId, String Name, String email, String phoneNumber, String username, String password) {
        super(UserId, Name, email, phoneNumber, username, password);
    }
}
