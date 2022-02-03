import Data.Person.*;
import Data.University.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        University university = new University();


        university.addTeacher(new Teacher("Alejandro Gómez", "Full Time", 2000000, 14, 48));
        university.addTeacher(new Teacher("Juan Solorzano","Full Time", 1000000, 12, 34));
        university.addTeacher(new Teacher("Maria Gutierrez", "Part Time", 1200000, 10, 20));
        university.addTeacher(new Teacher("Juanito Perez", "Part Time", 900000, 8, 40));

        university.addStudent(new Student("Juan Reyes","4"));
        university.addStudent(new Student("Maria Perez","3"));
        university.addStudent(new Student("Jorge Albertano","2"));
        university.addStudent(new Student("Manuel Cuero", "1"));
        university.addStudent(new Student("Jaime Cruz","4"));
        university.addStudent(new Student("Martina Mendez", "3"));

        ArrayList<Student> list1 = new ArrayList<>();
        list1.add(university.getStudentbyID(5));
        list1.add(university.getStudentbyID(6));
        list1.add(university.getStudentbyID(7));

        ArrayList<Student> list2 = new ArrayList<>();
        list2.add(university.getStudentbyID(8));
        list2.add(university.getStudentbyID(9));
        list2.add(university.getStudentbyID(10));



        university.createNewCourse("Java", "201A",university.getTeacherbyID(1),list1);
        university.createNewCourse("PHP101", "201B",university.getTeacherbyID(3), list2);
        university.createNewCourse("C #101", "201C",university.getTeacherbyID(1), list2);
        university.createNewCourse("Python 101", "201D",university.getTeacherbyID(3), list1);


        System.out.println("Welcome to the class management system");

        boolean continueToRun = true;

        Scanner scan = new Scanner(System.in);

        while (continueToRun) {
            System.out.println("\nPlease select an option: ");
            System.out.println("1. Print teachers information");
            System.out.println("2. Print Courses");
            System.out.println("3. Create new Student and add to a course");
            System.out.println("4. Create new Data.Course with a teacher and add students");
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
                    if (university.coursesSize() == 0) {
                        System.out.println("There are no courses in the university");
                        pressEnterToContinue();
                    }
                    else {
                        university.printExistingCourses();
                        boolean backToMenu = false;
                        while (!backToMenu) {
                            System.out.println("\nEnter the course ID to see the information of the course: ");
                            int courseId = scan.nextInt();
                            boolean courseIDValidation = false;
                            String name = courseName(courseId);
                            while (!courseIDValidation) {
                                if (name.equals("The course id is not valid") ) {
                                    System.out.println(name);
                                    System.out.println("Please enter a valid course ID: ");
                                    courseId = scan.nextInt();
                                    name = courseName(courseId);
                                }
                                else {
                                    System.out.println(university.showCourseInfo(name));
                                    backToMenu = true;
                                    courseIDValidation = true;
                                }

                        }
                                               }
                        pressEnterToContinue();
                    }
                    break;


                case 3:
                    System.out.println("Create new Student and add to a course");

                    System.out.println("\nEnter the student's name: ");
                    String name = scan.next();
                    System.out.println("Enter the student's level : ");
                    String level = scan.next();
                    System.out.println(name);
                    //Student studentToCreate = new Student(name, StudentID, level);
                    Student studentToCreate = new Student(name, level);
                    System.out.println("Student created");
                    System.out.println(studentToCreate.showStudentInfo());
                    university.addStudent(studentToCreate);
                    System.out.println("Courses:");
                    university.printExistingCourses();
                    System.out.println("\nSelect a course to add the student to: ");
                    int courseId = scan.nextInt();
                    String courseName = courseName(courseId);
                    university.enrollStudentInCourse(courseName, studentToCreate);

                    pressEnterToContinue();
                    break;



                case 4:
                    System.out.println("Create new Data.Course with a teacher and add students");

                    System.out.println("Enter the name of the course: ");
                    String courseNametoCreate = scan.next();

                    System.out.println("Enter the name of Class Room assigned: ");
                    String classRoomId = scan.next();

                    int teacherId= askTeacherId();
                    Teacher teacher = university.getTeacherbyID(teacherId);
                    while (teacher == null) {
                        System.out.println("Teacher not found, please enter a valid ID");
                        teacherId = askTeacherId();
                        teacher = university.getTeacherbyID(teacherId);
                    }

                    ArrayList<Student> students = new ArrayList<>();
                    boolean addStudents = true;

                    while (addStudents) {
                        System.out.println("Enter the ID of the student: ");
                        int studentId = scan.nextInt();
                        Student student = university.getStudentbyID(studentId);
                        boolean askStudentID = true;
                        while (askStudentID) {
                            if (student == null) {
                                System.out.println("Student not found, please enter a valid ID");
                                System.out.println("Enter the ID of the student: ");
                                studentId = scan.nextInt();
                            }
                            student = university.getStudentbyID(studentId);
                            if (student != null) {
                                askStudentID = false;
                            }
                        }
                        students.add(student);

                        System.out.println("Do you want to add more students? (y/n)");
                        String answer = scan.next();
                        if (answer.equals("n")) {
                            addStudents = false;
                        }
                    }

                    university.createNewCourse(courseNametoCreate, classRoomId, teacher, students);
                    pressEnterToContinue();
                    break;


                case 5:
                    System.out.println("List all courses of a Student");
                    System.out.println("Enter the ID of the student: ");
                    int studentId = scan.nextInt();
                    Student student = university.getStudentbyID(studentId);
                    if (student == null) {
                        System.out.println("Student not found");
                    }
                    else {
                        university.listAllCoursesFromStudent(student);
                    }
                    pressEnterToContinue();
                    break;


                case 6:
                    System.out.println("Goodbye!");
                    continueToRun = false;
                    break;


                default:
                    System.out.println("Invalid choice");
                    pressEnterToContinue();
                    break;
            }

        }
    }

    public static void printTeachersInfo(){
        for (Teacher teacher : University.teachers) {
            System.out.println(teacher.TeacherInfo());        }
    }

    public static void pressEnterToContinue(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Press enter to continue");
        scan.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int askTeacherId(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the id of the teacher: ");
        return scan.nextInt();
    }

    public static String courseName(int courseId){
        University searchInUniversity = new University();
        String courseName = searchInUniversity.getCourseNameByPosition(courseId);
        if (courseName == null){
            return "Course not found";
        }else {
            return courseName;
        }

    }




}





