package service;

import model.User;

import java.util.HashMap;

public class UserService {
    HashMap<Integer, User> userHashMap = new HashMap<>();
    public void createUser(User user)
    {
        if(userHashMap.containsKey(user.getUserId()))
        {
            System.out.println("User ID already exists");
            return;
        }
        userHashMap.put(user.getUserId(), user);
        System.out.println("User created successfully");
    }
    public boolean signin(int id,String pass)
    {
        if(!userHashMap.containsKey(id))
        {
            System.out.println("No user id exists");
            return false;
        }
        if(!userHashMap.get(id).getPassword().equals(pass))
        {
            System.out.println("Incorrect Password!");
            return false;
        }
        System.out.println("Welcome back! "+userHashMap.get(id).getUserName());
        return true;
    }
}
