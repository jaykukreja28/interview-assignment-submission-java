package com.studentapp;

import java.util.*;

public class Main3 {

    private static List<Student> students;
    private static Scanner sc;

    public static void main(String[] args) {

        //list of students to store a student object
        students = new ArrayList<Student>();
        System.out.println("****!!!! Student Management System !!!!****");

        sc = new Scanner(System.in);

        while (true) {
            System.out.println("**** Welcome Noobs ****");

            System.out.println("Select an Option ...Type 0 for exit");
            System.out.println("1. Register Student");
            System.out.println("2. Find Student by Student iD ..");
            System.out.println("3. List all Student information ..");
            System.out.println("4. List Student Info in Sorted Order");
            System.out.println("5. Exit");


            int optionSelection = sc.nextInt();

            switch (optionSelection) {
                case 1:
                    enrollStudent(sc);
                    break;
                case 2:
                    findStudentById(sc);
                    break;
                case 3:
                    printStudentData();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option Selected ... Enter Between 1 to 5");

            }
        }

    }

    private static void findStudentById(Scanner sc) {
        System.out.println("Enter the Student ID you want to search for");
        String studentId = sc.next();
        Student studentFound = findStudentById(studentId);
        System.out.println(studentFound);

    }

    private static void printStudentData() {
        System.out.print("--- Print Alll Student Data ----");
        if (students.size() > 0) {
            for (Student student : students) {
                student.printStudentInfo();
            }
        } else {
            System.err.println("Student List is Empty. No Student Record Found");
        }

        System.out.print("-----------------------------");
    }

    private static void enrollStudent(Scanner sc2) {
        System.out.println("Enter Student Name");
        String studentName = sc2.next();

        System.out.println("Enter Student Age");
        int studentAge = sc2.nextInt();

        System.out.println("Enter Student ID");
        String studentId = sc2.next();

        Student newStudent = new Student(studentName, studentAge, studentId);
        students.add(newStudent);
        System.out.println("Added a New Student Successfully !!");

        while (true) {
            System.out.println("Enter a course to be enrolled!! ... Type Done to exit");
            String courseName = sc2.next();
            if (courseName.equalsIgnoreCase("done")) {
                break;
            }
            newStudent.enrollCourse(courseName);
            System.out.println("Enrolled to the course !!");
        }
        newStudent.printStudentInfo();
    }

    //stream() is applicable only for collections
    public static Student findStudentById(String studentId) {
        //Since it is a local variable they do not have initial values defined implicitly like reference variables
        //therefore explicit initilizations
        Student result = null;
        try {
            result = students.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst().orElseThrow(() -> new RuntimeException("No Data Found !!"));
        } catch (RuntimeException e) {
            System.out.print("Student ID with " + studentId + " not found");
        }
        return result;

    }

    private static void sortByName() {
        Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

                /*new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };*/

        Collections.sort(students, studentNameComparator);
        System.out.println(students);
    }

}
