import Course.Course;
import Person.*;
import University.*;

import java.util.ArrayList;
import java.util.Scanner;

import static University.University.*;

public class Runner {

    public static void main(String[] args) {

        //create a new university
        University university = new University();


        // create a new teacher an add it to the list of teachers
        university.addTeacher(new Teacher("Alejandro", 1110449696, "Full Time", 2000000, 14, 48));
        university.addTeacher(new Teacher("Juan", 1110231231, "Full Time", 1000000, 12, 34));
        university.addTeacher(new Teacher("Maria", 10293845, "Part Time", 1200000, 10, 20));
        university.addTeacher(new Teacher("Juanito", 12343212, "Part Time", 900000, 8, 40));

        university.addStudent(new Student("Juan", 11111, "4"));
        university.addStudent(new Student("Maria", 22222, "3"));
        university.addStudent(new Student("Juanito", 33333, "2"));
        university.addStudent(new Student("Alejandro", 44444, "1"));
        university.addStudent(new Student("Jorge", 55555, "4"));
        university.addStudent(new Student("Martina", 66666, "3"));

        System.out.println("Welcome to the class management system");

        boolean continueToRun = true;

        Scanner scan = new Scanner(System.in);

        while (continueToRun) {
            System.out.println("\nPlease select an option: ");
            System.out.println("1. Print teachers information");
            System.out.println("2. Print Courses");
            System.out.println("3. Create new Student and add to a course");
            System.out.println("4. Create new Course with a teacher and add students");
            System.out.println("5. List all courses of a Student");
            System.out.println("6. Exit");
            System.out.println("\nEnter your choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Teachers:");
                    printTeachersInfo();
                    pressEnterToContinue();
                    break;


                case 2:
                    System.out.println("Courses:");
                    university.printExistingCourses();
                    boolean backToMenu = false;
                    while (!backToMenu) {
                        System.out.println("\nSelect a course to see its information: ");
                        int courseId = scan.nextInt();
                        String name = courseName(courseId);
                        if (name != null || !name.equals("Course not found")) {
                            university.showCourseInfo(name);
                        }
                        System.out.println("\n1. Back to menu");
                        System.out.println("2. Exit");
                        System.out.println("\nEnter your choice: ");
                        int choice2 = scan.nextInt();
                        switch (choice2) {
                            case 1:
                                backToMenu = true;
                                break;
                            case 2:
                                continueToRun = false;
                                break;
                        }
                    }
                    pressEnterToContinue();
                    break;


                case 3:
                    System.out.println("Create new Student and add to a course");
                    pressEnterToContinue();
                    break;


                case 4:
                    System.out.println("Create new Course with a teacher and add students");

                    System.out.println("Enter the name of the course: ");
                    String courseName = scan.next();

                    System.out.println("Enter id Class Room assigned: ");
                    String classRoomId = scan.next();

                    /*System.out.println("Enter the id of the teacher: ");
                    int teacherId = scan.nextInt();*/
                    int teacherId= askTeacherId();
                    Teacher teacher = university.getTeacherbyID(teacherId);
                    while (teacher == null) {
                        System.out.println("Teacher not found, please enter a valid id");
                        teacherId = askTeacherId();
                        teacher = university.getTeacherbyID(teacherId);
                    }
                    /*if (teacher == null) {
                        System.out.println("Teacher not found");
                        break;
                    }*/
                    ArrayList<Student> students = new ArrayList<>();
                    boolean addStudents = true;

                    while (addStudents) {
                        System.out.println("Enter the id of the student: ");
                        int studentId = scan.nextInt();
                        Student student = university.getStudentbyID(studentId);
                        if (student == null) {
                            System.out.println("Student not found");
                        }else{
                            students.add(student);
                        }
                        System.out.println("Do you want to add more students? (y/n)");
                        String answer = scan.next();
                        if (answer.equals("n")) {
                            addStudents = false;
                        }
                    }

                    university.createNewCourse(courseName, classRoomId, teacher, students);
                    pressEnterToContinue();
                    break;


                case 5:
                    System.out.println("List all courses of a Student");
                    pressEnterToContinue();
                    break;


                case 6:
                    System.out.println("Goodbye!");
                    continueToRun = false;
                    break;


                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }
    }

    public static void printTeachersInfo(){
        for (Teacher teacher : University.teachers) {
            System.out.println(teacher.TeacherInfo());        }
    }

    //press enter to continue and clear the screen
    public static void pressEnterToContinue(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Press enter to continue");
        scan.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //ask teacher id
    public static int askTeacherId(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the id of the teacher: ");
        int teacherId = scan.nextInt();
        return teacherId;
    }

    public static String courseName(int courseId){
        University searchInUniversity = new University();
        String courseName = searchInUniversity.getCourseNameByPosition(courseId);
        return courseName;

    }


}





