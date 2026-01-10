package com.studentapp;

public class Main {
    public static void main(String[] args) {
        System.out.println("**** Student Management System ****");
        System.out.println("**** Welcome Noobs ****");

        Student obj1 = new Student("Mohit Jhangir",22,"S-123");
        //As soon as this object is created, 3 things happen
        // Class loaded into memory -> Instance variable will be created -> constructor is getting called

        //toString() is overriden to get the state of object i.e the instance variables.
        //if toString() is not overriden, then we would be able to the hashcode value assigned to the object stored in ref var.
        obj1.enrollCourse("Java");
        //obj1.enrollCourse("C++");
        //obj1.enrollCourse("Jamshedpur");
        obj1.enrollCourse("C++");

        //System.out.println(obj1);
        obj1.printStudentInfo();

        Student obj2 = new Student("Mango Vihari",27,"S-125");
        obj2.enrollCourse("C++");
        obj2.printStudentInfo();


        Student obj3 = new Student("Mannu Master",28,"S-128");
        obj3.enrollCourse("DevOps");
        obj3.printStudentInfo();

    }
}
