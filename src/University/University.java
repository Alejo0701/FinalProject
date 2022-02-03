package University;

import Course.Course;
import Person.Student;
import Person.Teacher;

import java.util.ArrayList;
import java.util.Arrays;

public class University {

    private static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private static ArrayList<Course> courses = new ArrayList<Course>();
    private static int counter = 1;
    private int idToGenerate;


    //add a teacher to the list
    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void printExistingCourses() {
        int i = 1;
        if (courses.size() == 0) {
            System.out.println("No courses exist");
        }
        if (courses.size() > 0) {
            for (Course course : courses) {
                    System.out.println(i + " - " + course.getCourseName()+ " - " + courses.indexOf(course));
                    i++;
            }
        }
    }

    public boolean createNewCourse(String courseName, String classRoom, Teacher teacher, ArrayList<Student> students) {

        if (courseName.equals("")) {
            System.out.println("Course name is empty");
            return false;
        }
        if (classRoom.equals("")) {
            System.out.println("Class room is empty");
            return false;
        }

        if (teacher == null) {
            System.out.println("Teacher is empty");
            return false;
        }

        Course course = new Course(courseName, classRoom, teacher, students);
        this.courses.add(course);
        return true;
    }



    public Teacher getTeacherbyID(int id) {
        for (Teacher t : teachers) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public Student getStudentbyID(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public Course getCoursebyName(String name) {
        for (Course c : courses) {
            if (c.getCourseName().equals(name)) {
                return c;
            }
            /*else {
                //System.out.println("Course not found");
                System.out.println("getCoursebyName");
            }*/
        }
        return null;
    }



    public String getCourseNameByPosition(int position) {
        position--;
        String strcourse = "Course not found";

        if (position > courses.size()) {
            strcourse = "There is no courses";
        }
        else {
            for (Course c : courses) {
                if (c.getCourseName().equals(courses.get(position).getCourseName())) {
                    strcourse = c.getCourseName();
                }
            }
        }
        return strcourse;
    }

    //show course info
    public String showCourseInfo(String courseName) {
        String strcourse = "";
        for (Course c : courses) {
            if (c.getCourseName().equals(courseName)) {
                //course position
                strcourse += "Course position: " + courses.indexOf(c) + "\n";
                strcourse += "Course name: " + courseName + "\n";
                strcourse += "Class room: " + c.getClassRoom() + "\n";
                strcourse += "Teacher: " + c.getTeacher().getName() + "\n";
                strcourse += "Students: " + "\n";
                for (Student s : c.getCourseStudents()) {
                    strcourse += s.getName() + " - ID:" +s.getId() + "\n";
                }
            }
        }
        return strcourse;
    }

    //enroll student in a course
    public void enrollStudentInCourse(String courseName, Student student) {
        Course course = getCoursebyName(courseName);
        if (course != null) {
            course.setCourseStudent(student);
        }
        else {
            //System.out.println("Course not found");
            System.out.println("enrollStudentInCourse");
        }
    }

    //List all courses from a student
    public void listAllCoursesFromStudent(Student student) {
        String strcourses = "";
        System.out.println(student.getName() + "\n");
        for (Course c : courses) {
            if (c.getCourseStudents().contains(student)) {
                strcourses += c.getCourseName() + "\n";
            }
        }
        System.out.println(strcourses);
    }

    //ID generator
    public int generateID() {
       idToGenerate = counter;
       counter++;
       return idToGenerate;
    }




}