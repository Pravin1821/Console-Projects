package Model;

public class User extends ParentFoodDelivery{
    static int count = 1;
    private int id;
    private String location;

    public User(String name, String email, String password, String phoneNum, String location) {
        super(name, email, password, phoneNum);
        this.id = count++;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name="+super.getName()+
                ", email='"+super.getEmail() +
                ", password='" + super.getPassword()+
                ", phoneNum='" + super.getPhoneNum() +
                ", location='" + location + '\'' +
                '}';
    }
}

