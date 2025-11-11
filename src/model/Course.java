package model;

import java.util.ArrayList;

public class Course {
    private static int staticId=1;
    private int id;
    private String name;
    private String teacherName;
    private String description;
    private ArrayList<Student> students=new ArrayList<>();

    public Course(String name, String teacherName, String description) {
        id=staticId;
        staticId++;
        this.name = name;
        this.teacherName = teacherName;
        this.description = description;
    }
    public int getId(){
        return id;
    }
    public String getDescription() {
        return description;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
