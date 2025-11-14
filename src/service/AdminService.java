package service;

import static dataBase.db.*;
import static util.Util.sc;

import model.Course;
import model.Student;

import java.util.Iterator;


public class AdminService {
    public void showAdminMenu() {
        System.out.println("=== ADMIN PANEL ===\n" +
                "1. Yeni tələbə əlavə et\n" +
                "2. Yeni kurs əlavə et\n" +
                "3. Tələbəni kursa təyin et\n" +
                "4. Tələbələrin siyahısını göstər\n" +
                "5. Kursların siyahısını göstər\n" +
                "6. Geri qayıt");
    }

    public void addStudent() {
        System.out.println("Ad:");
        String name = sc.next();
        System.out.println("Soyad:");
        String surnameName = sc.next();
        System.out.println("Yaş:");
        int age = sc.nextInt();
        Student s = new Student(name, surnameName, age);
        studentData.put(s.getId(), s);
        System.out.println("→ Tələbə uğurla əlavə edildi!");
    }

    public void addCourse() {
        System.out.println("Kurs adı:");
        String name = sc.next();
        System.out.println("Müəllim:");
        String teach = sc.next();
        System.out.println("Təsvir:");
        sc.nextLine();
        String des = sc.nextLine();
        Course c = new Course(name, teach, des);
        courseData.put(c.getId(), c);
        System.out.println("→ Kurs uğurla əlavə edildi!");
    }

    public void assignStudentToCourse() {
        System.out.println("=== Tələbələr ===");
        for (Student currentStudent : studentData.values()) {
            System.out.println(currentStudent.getId() + ". " + currentStudent.getName() + " " + currentStudent.getSurName());
        }
        System.out.println("=== Kurslar ===");
        for (Course currentCourse : courseData.values()) {
            System.out.println(currentCourse.getId() + ". " + currentCourse.getName());
        }
        System.out.println("Tələbə nömrəsini daxil edin:");
        Student selectedStudent = studentData.get(sc.nextInt());
        System.out.println("Kurs nömrəsini daxil edin:");
        Course selectedCourse = courseData.get(sc.nextInt());
        selectedStudent.getCurrentCourses().add(selectedCourse);
        selectedCourse.getStudents().add(selectedStudent);
        System.out.println("→ " + selectedStudent.getName() + " " + selectedStudent.getSurName() + " “" + selectedCourse.getName() + "” kursuna əlavə olundu!");
    }

    public void showStudents() {
        ;
        System.out.println("=== Tələbələr Siyahısı ===");
        for (Student cs : studentData.values()) {
            System.out.println(cs.getId() + ". " + cs.getName() + " " + cs.getSurName() + ", Yaş: " + cs.getAge());
            System.out.print("   Kurslar:");
            if (cs.getCurrentCourses().isEmpty()) {
                System.out.print("YOXDUR");
            } else {
                for (Course c : cs.getCurrentCourses()) {
                    System.out.print(c.getName() + " ");
                }
            }
            System.out.println();
        }
    }

    public void showCourses() {
        System.out.println("=== Kurs Siyahısı ===");
        for (Course currentCourse : courseData.values()) {
            System.out.println(currentCourse.getId() + ". " + currentCourse.getName() + "(Müəllim:" + currentCourse.getTeacherName() + ")");
        }
    }
}
