package Service;

import Model.Items;
import Model.Restaurant;

import java.util.*;

public class RestaurantService {
    Restaurant rest1 = new Restaurant("SSS","sss@gmail.com","SSS123","1201201201","Ghandhipuram",true);
    Restaurant rest2 = new Restaurant("Thalapakati","thalapakati@gmail.com","TK123","1201201202","Neelambur",true);
    Restaurant rest3 = new Restaurant("Rudra","rudra@gmail.com","RUDRA123","1201201203","L&T",true);
    List<Items> addItem = new ArrayList<>();
    Map<Integer,Restaurant> restaurantMap = new HashMap<>();
    Map<Integer, List<Items>> itemsMap = new HashMap<>();
    static Scanner scan = new Scanner(System.in);
    public RestaurantService(){
        restaurantMap.put(rest1.getId(),rest1);
        restaurantMap.put(rest2.getId(),rest2);
        restaurantMap.put(rest3.getId(),rest3);
        addItem.add(new Items(rest1.getId(),1, "Chicken Biryani",350.0,"25min",true));
        addItem.add(new Items(rest1.getId(),2, "Mutton Biryani",450.0,"30min",true));
        addItem.add(new Items(rest2.getId(), 1, "DinduKal Chicken Biryani",300.0,"28min",true));
        addItem.add(new Items(rest2.getId(), 2, "Dindukal Mutton Biryani",400.0,"35min",true));
        addItem.add(new Items(rest3.getId(), 1, "Egg puff",35.0,"2min",true));
        addItem.add(new Items(rest3.getId(), 2, "Veg puff",45.0,"3min",true));
        addItem.add(new Items(rest3.getId(), 4, "Chicken rice",115.0,"10min",true));
        addItem.add(new Items(rest3.getId(), 2, "Chicken noodells",100.0,"10min",false));
        for (Items i : addItem) {
            itemsMap.computeIfAbsent(i.getRestaurantId(), k -> new ArrayList<>())
                    .add(i);
        }
    }
    public void RestaurantLogin(String email,String password)
    {
        boolean isLogged = false;
        int restId = 0;
        for(Restaurant i:restaurantMap.values())
        {
            if(i.getEmail().equals(email) && i.getPassword().equals(password)) {
                isLogged = true;
                restId = i.getId();
                break;
            }
        }
        if(isLogged)
        {
            while(true)
            {
                System.out.println("Enter options: "+"\n1. Update Menu"+"\n2. View Menu: "+"\n3. Delete Menu: "+"\n4. Log Out: ");
                int op = scan.nextInt();
                switch (op)
                {
                    case 1 -> {
                        System.out.println("Enter Menu Id: ");
                        int mId = scan.nextInt();
                        System.out.println("Enter availability status: ");
                        boolean isAva = scan.nextBoolean();
                        updateAvailability(restId,mId,isAva);
                    }
                    case 2 -> {
                        List<Items> items = itemsMap.get(restId);
                        viewItems(restId);
                    }
                    case 3 -> {
                        System.out.println("Enter Menu Id: ");
                        int mId = scan.nextInt();
                        removeItem(restId,mId);
                    }
                    case 4 -> {
                        System.out.println("Logging out!...");
                        return;
                    }
                }
            }
        }
        else {
            System.out.println("Invalid Credentials!..");
            return;
        }
    }
    public void updateAvailability(int Rid, int Mid, boolean status)
    {
        List<Items> items = itemsMap.get(Rid);
        Items upItem = null;
        for(Items i : items)
        {
            if(i.getId() == Mid)
            {
                upItem = i;
                break;
            }
        }
        if(upItem!=null)
        {
            upItem.setAvailable(status);
        }
        else
            System.out.println("No Item available!");
    }
    public void removeItem(int rId, int mId)
    {
        List<Items> items = itemsMap.get(rId);
        if(items!=null)
            items.removeIf(item -> item.getId()==mId);
    }
    public void viewItems(int id)
    {
        List<Items> items = itemsMap.get(id);
        if(items==null)
        {
            System.out.println("No items present!..");
            return;
        }
        for(Items i:items)
            System.out.println(i);
    }
    public void viewDetails()
    {
        for(Restaurant i: restaurantMap.values())
            System.out.println(i);
    }
    public void viewMenu()
    {
        for(Map.Entry<Integer,List<Items>> items:itemsMap.entrySet())
        {
            int key = items.getKey();
            List<Items> itemsList = items.getValue();
            if(!itemsList.isEmpty())
            {
                Restaurant restaurant = restaurantMap.get(key);
                System.out.println("Restaurant Name: "+restaurant.getName()+" Location: "+restaurant.getLocation());
                for(Items i:itemsList)
                {
                    if(i.isAvailable())
                        System.out.println(i);
                }
            }
        }
    }
}
