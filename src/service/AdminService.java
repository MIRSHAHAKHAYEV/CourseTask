package service;
import static  dataBase.db.*;
import static util.Util.sc;

import model.Course;
import model.Student;

import java.util.Iterator;


public class AdminService{
    public void showAdminMenu(){
        System.out.println("=== ADMIN PANEL ===\n" +
                "1. Yeni tələbə əlavə et\n" +
                "2. Yeni kurs əlavə et\n" +
                "3. Tələbəni kursa təyin et\n" +
                "4. Tələbələrin siyahısını göstər\n" +
                "5. Kursların siyahısını göstər\n" +
                "6. Geri qayıt");
    }
    public void addStudent(){
        System.out.println("Ad:");String name=sc.next();
        System.out.println("Soyad:");String surnameName=sc.next();
        System.out.println("Yaş:");int age=sc.nextInt();
        Student s=new Student(name,surnameName,age);
        studentData.put(s.getId(),s);
        System.out.println("→ Tələbə uğurla əlavə edildi!");
    }
    public void addCourse(){
        System.out.println("Kurs adı:");String name=sc.next();
        System.out.println("Müəllim:");String teach=sc.next();
        System.out.println("Təsvir:");String des=sc.next();
        Course c=new Course(name,teach,des);
        courseData.put(c.getId(),c);
        System.out.println("→ Kurs uğurla əlavə edildi!");
    }
    public void assignStudentToCourse(){
        Iterator<Integer>keyOfStudents=studentData.keySet().iterator();
        Iterator<Integer>keyOfCourses=courseData.keySet().iterator();
        System.out.println("=== Tələbələr ===");
        while (keyOfStudents.hasNext()){
            Student currentStudent=studentData.get(keyOfStudents.next());
            System.out.println(currentStudent.getId()+". "+currentStudent.getName()+" "+currentStudent.getSurName());
        }
        System.out.println("=== Kurslar ===");
        while (keyOfCourses.hasNext()){
            Course currentCourse=courseData.get(keyOfCourses.next());
            System.out.println(currentCourse.getId()+". "+currentCourse.getName());
        }
        System.out.println("Tələbə nömrəsini daxil edin:");
        Student selectedStudent=studentData.get(sc.nextInt());
        System.out.println("Kurs nömrəsini daxil edin:");
        Course selectedCourse=courseData.get(sc.nextInt());
        selectedStudent.getCurrentCourses().add(selectedCourse);
        selectedCourse.getStudents().add(selectedStudent);
        System.out.println("→ "+selectedStudent.getName()+" "+selectedStudent.getSurName()+" “"+selectedCourse.getName()+"” kursuna əlavə olundu!");
    }
    public void showStudents(){
        Iterator<Integer>keyOfStudents=studentData.keySet().iterator();
        System.out.println("=== Tələbələr Siyahısı ===");
        while (keyOfStudents.hasNext()){
            Student cs=studentData.get(keyOfStudents.next());
            System.out.println(cs.getId()+". "+cs.getName()+" "+cs.getSurName()+", Yaş: "+cs.getAge());
            System.out.print("   Kurslar:");
            if(cs.getCurrentCourses().isEmpty()){
                System.out.print("YOXDUR");
            }
            else {
            Iterator<Course>c=cs.getCurrentCourses().iterator();
            while (c.hasNext()){
                System.out.print(c.next().getName()+" ");
             }
            }
            System.out.println();
        }
    }
    public void showCourses(){
        Iterator<Integer>c=courseData.keySet().iterator();
        System.out.println("=== Kurs Siyahısı ===");
        while (c.hasNext()){
            Course currentCourse=courseData.get(c.next());
            System.out.println(currentCourse.getId()+". "+currentCourse.getName()+"(Müəllim:"+currentCourse.getTeacherName()+")");
        }
    }
}
