package model;

public class Manager {
    private String name;
    private int id;

    public Manager(String name, int id){
        this.name = name;
        this.id  = id;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "\n* Name: " + name + "\n" +
                "* Password: " + id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
