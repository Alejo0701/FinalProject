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
                    System.out.println(i + " - " + course.getCourseName());
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
            else {
                System.out.println("Course not found");
            }
        }
        return null;
    }



    public String getCourseNameByPosition(int position) {
        position--;
        if (position > courses.size()) {
            System.out.println("There is no courses");
        }
        else {
            for (Course c : courses) {
                if (c.getCourseName().equals(courses.get(position).getCourseName())) {
                    return c.getCourseName();
                }
                else {
                    return "Course not found";
                }
            }
        }
        return null;
    }

    //show course info
    public void showCourseInfo(String courseName) {
        for (Course c : courses) {
            if (c.getCourseName().equals(courseName)) {
                String strcourse = "";
                strcourse += "Course name: " + c.getCourseName() + "\n";
                strcourse += "Class room: " + c.getClassRoom() + "\n";
                strcourse += "Teacher: " + c.getTeacher().getName() + "\n";
                strcourse += "Students: " + "\n";
                for (Student s : c.getCourseStudents()) {
                    strcourse += s.getName() + "\n";
                }
                System.out.println(strcourse);
            }
            else {
                System.out.println("Course not found");
            }
        }
    }

    //enroll student in a course
    public void enrollStudentInCourse(String courseName, Student student) {
        Course course = getCoursebyName(courseName);
        if (course != null) {
            course.setCourseStudent(student);
        }
        else {
            System.out.println("Course not found");
        }
    }




}