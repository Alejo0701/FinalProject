package Person;

public class Teacher extends Person {

    private String type;
    private double baseSalary;
    private int yearsOfExperience;
    private int activeHoursPerWeek;


    public Teacher(String name, int id, String type, double baseSalary, int yearsOfExperience, int activeHoursPerWeek) {
        super(name, id);
        this.type = type;
        this.baseSalary = baseSalary;
        this.yearsOfExperience = yearsOfExperience;
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }

    public void setActiveHoursPerWeek(int activeHoursPerWeek) {
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    public double getSalaryCalculated() {
        double salary = 0;
        if (this.type.equals("Full time")) {
            salary = this.baseSalary * (this.yearsOfExperience * 1.10);
        } else {
            salary = this.baseSalary * this.activeHoursPerWeek;
        }
        return salary;
    }

    //show teacher info
    public String TeacherInfo() {
        String str = "";
        str += "Name: " + this.getName() + "\n";
        str += "ID: " + this.getId() + "\n";
        str += "Type: " + this.getType() + "\n";
        str += "Base salary: $" + this.getBaseSalary() + "\n";
        str += "Years of experience: " + this.getYearsOfExperience() + " years \n";
        str += "Active hours per week: " + this.getActiveHoursPerWeek() + " hours \n";
        return str;
    }

}