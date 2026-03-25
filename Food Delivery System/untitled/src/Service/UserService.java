package Service;

import Model.Items;
import Model.Order;
import Model.User;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    User user1 = new User("Pravin","pravin@gmail.com","1234", "9080262422", "Chinniyapalayam");
    User user2 = new User("Prathosh","prathosh@gmail.com","4321", "9080262423", "Neelambur");
    User user3 = new User("Ragul","ragul@gmail.com","5678", "9080262424", "Irugur");
    RestaurantService restaurantService = new RestaurantService();
    int userId = 0;
    User user=null;
    Map<Integer,User> userMap = new HashMap<>();
    Map<Integer,List<Items>> cartmap = new HashMap<>();
    Map<Integer,Map<Integer,List<Order>>> orderMap = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    public UserService()
    {
        userMap.put(user1.getId(),user1);
        userMap.put(user2.getId(),user2);
        userMap.put(user3.getId(),user3);
    }
    public void userLogin(String email,String password) {
        boolean isReg = false;

        for (User i : userMap.values()) {
            if (email.equals(i.getEmail()) && password.equals(i.getPassword())) {
                userId = i.getId();
                user = userMap.get(userId);
                isReg = true;
                break;
            }
        }
        if (isReg) {

            while (true) {
                System.out.println("Enter Option: " + "\n1. View Menu: " + "\n2. Add to cart: " +"\n3. View Cart: "+ "\n4. Order Food: " + "\n5. Track Order: " + "\n6. Logout: ");
                int option = scan.nextInt();
                switch (option) {
                    case 1 -> {
                        restaurantService.viewMenu();
                    }
                    case 2 -> {
                        System.out.println("Enter Restaurant Id: ");
                        int rId = scan.nextInt();
                        System.out.println("Enter Item Id: ");
                        int itemId = scan.nextInt();
                        addToCart(rId,itemId);
                    }
                    case 3 -> {
                        viewCart();
                    }
                    case 4 -> {
                        orderFood();
                    }
                    case 6 -> {
                        System.out.println("Logging Out!...");
                        return;
                    }
                }
            }
        } else {
            System.out.println("Invalid Credentials!..");
            return;
        }
    }
    public void addToCart(int restId,int itemId)
    {
        List<Items> items = restaurantService.getItems(restId);
        if(items == null)
        {
            System.out.println("No items available in Restaurant!..");
            return;
        }
        for(Items i:items)
        {
            if(i.getId()==itemId)
            {
                cartmap.putIfAbsent(userId,new ArrayList<>());
                cartmap.get(userId).add(i);
                return;
            }
        }
        System.out.println("No item id available in the restaurant");
    }
    public void viewCart()
    {
        List<Items> items = cartmap.get(userId);
        if(items==null)
        {
            System.out.println("Cart is Empty!..");
            return;
        }
        for(Items i:items)
            System.out.println(i);
    }
    public void orderFood()
    {
        List<Items> items = cartmap.get(userId);
        if(items == null)
        {
            System.out.println("No items in cart to order!..");
            return;
        }cd
        double totalAmount = 0;
        for(Items i:items)
            totalAmount+=i.getPrice();
        Order order = new Order(items,totalAmount,40.0,user.getLocation());
        orderMap.putIfAbsent(userId,new HashMap<>());
        Map<Integer,List<Order>> restCartMap = orderMap.get(userId);

        restCartMap.computeIfAbsent()
        orderMap.get(userId).add(order);
    }
}
