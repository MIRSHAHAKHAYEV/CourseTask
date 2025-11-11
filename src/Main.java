import model.Admin;
import service.AdminService;
import service.CourseService;
import service.StudentService;
import static util.Util.sc;

public class Main {
    public static void main(String[] args) {
        CourseService cs=new CourseService();
        StudentService ss=new StudentService();
        AdminService as=new AdminService();
        cs.addAdmin("admin","123");
        int op=0;
        while (op!=3){
            cs.showMainMenu();
            op=sc.nextInt();
            switch (op){
                case 1:
                    if(!cs.checkAdminOrNot()){
                        System.out.println("yanlis username ve passowrd");
                        continue;
                    }
                    while (op!=6) {
                        as.showAdminMenu();
                        op = sc.nextInt();
                        switch (op) {
                            case 1:
                                as.addStudent();
                                break;
                            case 2:
                                as.addCourse();
                                break;
                            case 3:
                                as.assignStudentToCourse();
                                break;
                            case 4:
                                as.showStudents();
                                break;
                            case 5:
                                as.showCourses();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("duzgun emeliyyat secin");
                        }
                    }
                    break;
                case 2:
                    ss.checkStudent();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("duzgun emeliyyat secin");
            }
        }
    }
}
