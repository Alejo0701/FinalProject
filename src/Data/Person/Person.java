package Data.Person;

public class Person {

    private String name;
    private int id;
    private static int counter = 1;

    public Person(String name) {
        this.name = name;
        this.id = counter;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
