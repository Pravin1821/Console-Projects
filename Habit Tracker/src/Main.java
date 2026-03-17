import model.Habit;
import model.User;
import service.HabitService;
import service.UserService;

import java.util.*;
public class Main{
    static UserService userService = new UserService();
    static HabitService habitService = new HabitService();
    static Scanner scan = new Scanner(System.in);
    public static void main(String [] args)
    {
            System.out.println("Enter Choice: "+"\n1. Create Useer: "+"\n2. Sign in: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Create User Id: ");
                    int userId = scan.nextInt();
                    System.out.println("Create User Name: ");
                    String userName = scan.next();
                    System.out.println("Enter email: ");
                    String email = scan.next();
                    System.out.println("Create password: ");
                    String password = scan.next();
                    User user = new User(userId, userName, email, password);
                    userService.createUser(user);
                    showDashboard(userId);
                }
                case 2 -> {
                    System.out.println("Enter user id: ");
                    int id = scan.nextInt();
                    System.out.println("Enter password: ");
                    String pass = scan.next();
                    if(userService.signin(id,pass))
                    {
                        showDashboard(id);
                    }
                }
            }

    }
    public static void showDashboard(int id)
    {
        while(true)
        {
            System.out.println("Enter Options: "+"\n1. Create Habits: "+"\n2. Habit Progress: "+"\n3. View Habits: "+"\n4 Rewards: "+"\n5. Log out: ");
            int op=scan.nextInt();
            switch (op){
                case 1 -> {
                    System.out.println("Enter HabitId: ");
                    int hId = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter Habit Name: ");
                    String name = scan.nextLine();
                    Habit habit = new Habit(hId,id,name);
                    habitService.createHabits(habit);
                }
                case 2 -> {
                    System.out.println("Enter HabitId: ");
                    int habitId = scan.nextInt();
                    System.out.println("Enter Completed Status: ");
                    boolean status = scan.nextBoolean();
                    habitService.TrackHabit(id,habitId,status);
                }
                case 3 -> {
                    habitService.viewHabits(id);
                }
                case 4 ->
                    habitService.getRewards(id);
                case 5 -> {
                    System.out.println("Logging out...");
                    return;
                }
            }
        }
    }
}