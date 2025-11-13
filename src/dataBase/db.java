package dataBase;

import model.Admin;
import model.Course;
import model.Student;

import java.util.HashMap;

public class db {
    public static HashMap<Integer, Student> studentData = new HashMap<>();
    public static HashMap<Integer, Course> courseData = new HashMap<>();
    public static HashMap<String, Admin> adminData = new HashMap<>();
}
