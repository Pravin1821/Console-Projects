import Service.RestaurantService;
import Service.UserService;

import java.util.*;
public class Main{
    static UserService userService = new UserService();
    static RestaurantService restaurantService = new RestaurantService();
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter Option: "+"\n1. Customer Login: "+"\n2. Restaurant Login: "+"\n3. Exit: ");
            int op = scan.nextInt();
            switch(op)
            {
                case 1 -> {
                    System.out.println("Enter userEmail: ");
                    String email = scan.next();
                    System.out.println("Enter password: ");
                    String password = scan.next();
                    userService.userLogin(email,password);
                }
                case 2 -> {
                    restaurantService.viewDetails();
                    System.out.println("Enter restaurantEmail: ");
                    String email = scan.next();
                    System.out.println("Enter Password: ");
                    String password = scan.next();
                    restaurantService.RestaurantLogin(email,password);
                }
                case 3 -> {
                    System.exit(0);
                }
            }
        }
    }
}