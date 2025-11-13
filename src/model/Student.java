package model;

import java.util.ArrayList;

public class Student {
    private static int staticId=1;
    private int id;
    private String name;
    private String surName;
    private int age;
    private ArrayList<Course> currentCourses=new ArrayList<>();

    public Student(String name, String surName, int age) {
        id=staticId;
        staticId++;
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Course> getCurrentCourses() {
        return currentCourses;
    }

    @Override
    public String toString() {
        return "=== Tələbə Profili ===\n" +
                "Ad: "+name +"\n"+
                "Soyad: "+surName+"\n" +
                "Yaş: "+age+"\n" +
                "Tədris aldığı kurslar:" +
                (currentCourses.isEmpty()?"YOXDUR":currentCourses);
    }

}
