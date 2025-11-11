package service;
import model.Student;

import java.util.Iterator;

import static dataBase.db.*;
import static util.Util.sc;

public class StudentService {
    public void checkStudent(){
        System.out.println("ad-");String name=sc.next();
        System.out.println("soyad-");String surName=sc.next();
        Iterator<Integer> s=studentData.keySet().iterator();
        boolean isEqual=false;
        int idOfEqual=0;
        while (s.hasNext()){
            Student currentStudent=studentData.get(s.next());
            if(currentStudent.getName().equals(name)&&currentStudent.getSurName().equals(surName)){
                isEqual=true;
                idOfEqual=currentStudent.getId();
            }
        }
        if(isEqual){
            System.out.println(studentData.get(idOfEqual).toString());
        }
        else System.out.println("bele bir telebe tapilmadi");
    }
}
