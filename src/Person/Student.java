package Person;

public class Student extends Person {

    private String level;

    public Student(String name, int id, String level) {
        super(name, id);
        this.level = level;
    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


}