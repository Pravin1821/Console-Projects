package Service;

import Model.User;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    User user1 = new User("Pravin","pravin@gmail.com","1234", "9080262422", "Chinniyapalayam");
    User user2 = new User("Prathosh","prathosh@gmail.com","4321", "9080262423", "Neelambur");
    User user3 = new User("Ragul","ragul@gmail.com","5678", "9080262424", "Irugur");
    static RestaurantService restaurantService = new RestaurantService();
    Map<Integer,User> userMap = new HashMap<>();
    static Scanner scan = new Scanner(System.in);
    public UserService()
    {
        userMap.put(user1.getId(),user1);
        userMap.put(user2.getId(),user2);
        userMap.put(user3.getId(),user3);
    }
    public void userLogin(String email,String password)
    {
        boolean isReg = false;
        for(User i:userMap.values())
        {
            if (email.equals(i.getEmail()) && password.equals(i.getPassword())) {
                isReg = true;
                break;
            }
        }
        if(isReg)
        {
            while(true)
            {
                System.out.println("Enter Option: "+"\n1. View Menu: "+"\n2. Add to cart: "+"\n3. Order Food: "+"\n4. Track Order: "+"\n5. Logout: ");
                int option = scan.nextInt();
                switch(option)
                {
                    case 1 -> {
                        restaurantService.viewMenu();
                    }
                    case 5 ->
                    {
                        System.out.println("Logging Out!...");
                        return;
                    }
                }
            }
        }
        else
        {
            System.out.println("Invalid Credentials!..");
            return;
        }
    }
}
