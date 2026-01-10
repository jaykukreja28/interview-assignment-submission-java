package com.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    private static List<Student> students;

    public static void main(String[] args) {

        //list of students to store a student object
        students = new ArrayList<Student>();


        System.out.println("**** Student Management System ****");
        System.out.println("**** Welcome Noobs ****");

        Student obj1 = new Student("Mohit Jhangir", 22, "S-123");
        //As soon as this object is created, 3 things happen
        // Class loaded into memory -> Instance variable will be created -> constructor is getting called

        //toString() is overriden to get the state of object i.e the instance variables.
        //if toString() is not overriden, then we would be able to the hashcode value assigned to the object stored in ref var.
        obj1.enrollCourse("Java");
        obj1.enrollCourse("C++");
        //obj1.enrollCourse("C++");
        //obj1.enrollCourse("Jamshedpur");

        //System.out.println(obj1);
        //obj1.printStudentInfo();

        Student obj2 = new Student("Mango Vihari", 27, "S-125");
        obj2.enrollCourse("C++");
        //obj2.printStudentInfo();


        Student obj3 = new Student("Mannu Master", 28, "S-128");
        obj3.enrollCourse("DevOps");
        //obj3.printStudentInfo();

        students.add(obj1); // storing reference of Student 1 object.
        students.add(obj2);
        students.add(obj3);

        Student result = findStudentById("S-125");
        System.out.println("Result is: " + result);

        //stream() is applicable only for collections
    }

    public static Student findStudentById(String studentId) {
        //Since it is a local variable they do not have initial values defined implicitly like reference variables
        //therefore explicit initilizations
        Student result = null;
        try {
            result = students.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).
                    findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data Found !!"));
        }
        catch(RuntimeException e) {
            System.out.print("Student ID with " + studentId + " not found");
        }
            return result;

    }


}
