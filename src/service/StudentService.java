package service;
import model.Student;

import java.util.Iterator;

import static dataBase.db.*;
import static util.Util.sc;

public class StudentService {
    public void checkStudent(){
        System.out.println("ad-");String name=sc.next();
        System.out.println("soyad-");String surName=sc.next();
        for(Student student:studentData.values()){
            if(student.getName().equals(name)&&student.getSurName().equals(surName)){
                System.out.println(student);
                return;
            }
        }
        System.out.println("Belə bir tələbə tapılmadı.");
    }
}
