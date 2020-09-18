package repository;

import model.Admin;
import model.Customer;
import model.Restaurant;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDataStore {
    private List<User> users=new ArrayList<>();

    public FakeDataStore(){
       User restaurant=new Restaurant(1,"De fried bar","deBar@gmail.com","+3184542652","deBar123","pass");
       User admin=new Admin(2,"John de Boss","John@gmail.com","+31885274852","johnyy123","123");
       User customer=new Customer(3,"Harry","harry@gmail.com","+318528528772","harryyy","pAsSS");

        users.add(restaurant);
        users.add(admin);
        users.add(customer);
    }

    public List<User> getUsers(){return users;}

    public User getUser(int id) {
        for (User user : users) {
            if (user.getUserId() == id)
                return user;
        }
        return null;
    }
    public List<User> getAllCustomers() {
        List<User> customers=new ArrayList<>();

        for (User user : users) {
            if (user instanceof Customer){
                customers.add(user);
            }
        }
        return customers;
    }
}
