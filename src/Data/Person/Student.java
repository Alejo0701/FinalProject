package Data.Person;

public class Student extends Person {

    private String level;

    public Student(String name, String level) {
        super(name);
        this.level = level;
    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String showStudentInfo(){
        String data = "";
        data += "Student: " + getName() + "\n";
        data += "ID: " + getId() + "\n";
        data += "Level: " + getLevel() + "\n";
        return data;
    }


}