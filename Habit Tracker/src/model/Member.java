package model;

public class Member {
    int c=1;
    private int id;
    private String name;
    private String member;

    public Member(String name, String member) {
        this.id = c++;
        this.name = name;
        this.member = member;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }
}
