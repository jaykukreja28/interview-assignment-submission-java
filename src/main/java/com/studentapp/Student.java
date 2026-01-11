package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    //instance variables: always marked with private keyword
    // Always need to be protected from access from classes outside of this class.

    //int, byte,short, long, double, float, char - primitive
    private String name; //non primitive, hence a reference variable. default: null hence
    private int age; //primitive; default: 0
    private String studentId; //non primitive hence a reference variable. default: null hence
    private List<String> courses; //non primitive hence a reference variable. default: null hence

    //for most instance variables we need validation checks :)

    public Student(String name, int age, String studentId) {
        super();
        //If validation fails then the program will not assign the wrong values and all the default values be assigned to the variables.
        //Also, side note: "this" refers to the current object. Since constructor is a method and on the stack and instance variables are in heap memory
        // "this" helps us differentiate between local and instance variables. the ones using this are instance variables i.e. those that live in the
        //heap
        if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            //List is an interface and we cannot create objects of an interface.
            //List Interface is implemented by ArrayList class. Hence we have to create an obj of AL class

            courses = new ArrayList<String>(); //Initialization of courses.
        }
    }

    private boolean validateStudentId(String studentId) {
        String studentIdRegex = "S-\\d+$"; // '+' Many combinations like S-001 S-010 ... or S-\\d+$
        Pattern studentIdPattern = Pattern.compile(studentIdRegex);
        Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
        if (studentIdMatcher.matches()) {
            return true;
        } else {
            System.err.println("Invalid Name !! enter S- and followed by Digits :)");
            return false;
        }
    }


    public void enrollCourse(String course) {
        if (courses.contains(course)) {
            System.err.println("Student is already enrolled to the " + course);
        } else {
            if (validateCourseName(course)) {
                courses.add(course);
                System.out.println("Student is enrolled to: " + course + " successfully.");
            }

        }

    }

    public boolean validateCourseName(String course) {
        if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("C++") || course.equalsIgnoreCase("DevOps")) {
            return true;
        } else {
            System.err.println("Please enter valid COurse Name");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", studentId='" + studentId + '\'' + ", courses=" + courses + '}';
    }

    public void printStudentInfo() {
        System.out.println("===== Student Information =====");
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student ID: " + studentId);
        System.out.println("Student List of Courses: " + courses);

    }

    //validation methods: extra credit
    //If you are a great java dev, you wil first make the constructor do the validations and then the assignment.
    //Invalid value assignment should be done with error handling

    public boolean validateAge(int age) {
        if (age >= 19 && age <= 35) {
            return true;
        } else {
            System.err.println("Invalid Age !! Student Age needs to be between 19 and 35");
            return false;
        }
    }

    //RegeX in the House
    public boolean validateName(String name) {
        //let's say it will start with an alphabet. It can start with lower case and upper case and any of those combinations
        // \\s means whitespaces are allowed in the middle.
        // '+' means 'n' number of combinations, $ - ends with alphabets uppercase or lowercase.
        String nameRegexExpected = "^[a-zA-Z\\s]+$";
        //compile method returns a Pattern since it is a static method
        Pattern namePattern = Pattern.compile(nameRegexExpected);
        Matcher nameMatcher = namePattern.matcher(name);
        if (nameMatcher.matches()) {
            return true;
        } else {
            System.err.println("Invalid Name !! enter alphabets only :)");
            return false;
        }
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public String getStudentId() {
        return studentId;
    }

}
