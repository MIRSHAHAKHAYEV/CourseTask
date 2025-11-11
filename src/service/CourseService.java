package service;
import model.Admin;
import model.Student;

import static util.Util.sc;
import static dataBase.db.*;

public class CourseService {
    public void showMainMenu(){
        System.out.println("=== COURSE MANAGEMENT SYSTEM ===\n" +
                "1. Admin kimi daxil ol\n" +
                "2. Tələbə kimi daxil ol\n" +
                "3. Çıxış\n" +
                "Seçiminizi daxil edin:");
    }
    public void addAdmin(String name,String pass){
        Admin ad=new Admin(name,pass);
        adminData.put(name,ad);
    }
    public Boolean checkAdminOrNot(){
        System.out.println("username-");String n= sc.next();
        System.out.println("password-");String p= sc.next();
        if(adminData.containsKey(n)){
            return adminData.get(n).getPassword().equals(p);
        }
        return false;
    }
}
