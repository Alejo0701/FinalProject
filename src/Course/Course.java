package Course;

import Person.Student;
import Person.Teacher;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private String classRoom;
    private Teacher teacher;
    private ArrayList<Student> courseStudents = new ArrayList<Student>();

    public Course(String courseName, String classRoom, Teacher teacher, ArrayList<Student> courseStudents) {
        this.courseName = courseName;
        this.classRoom = classRoom;
        this.teacher = teacher;
        this.courseStudents = courseStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(ArrayList<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }

    public void setCourseStudent(Student student){
        //validate if student is already in the course
        if(!courseStudents.contains(student)){
            courseStudents.add(student);
            System.out.println("Student added to course: " + courseName);
        }
        else{
            System.out.println("Student already in course");
        }
    }

    //show an specific course info
    public void showCourseInfoByName(Course course){
        System.out.println("Course name: " + course.getCourseName());
        System.out.println("Class room: " + course.getClassRoom());
        System.out.println("Teacher: " + course.getTeacher().getName());
        System.out.println("Students: ");
        for(Student student : course.getCourseStudents()){
            System.out.println(student.getName());
        }
    }


}
