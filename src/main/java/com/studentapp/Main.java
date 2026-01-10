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
        System.out.println(obj1);
    }
}
