package UI;

import DAO.StudentImpl;
import Entity.Students;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String, Students> list = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);
   public static StudentImpl student  = new StudentImpl();

    public static void main(String[] args) {
        menuShow();
    }

   public static void menuShow(){
       System.out.println("Chào mừng đến với hệ thống quản lý học viên.");
       System.out.println("Lựa chọn chức năng theo menu.");
       System.out.println("Bấm 1: Đăng ký học viên.");
       System.out.println("Bấm 2: Sửa thông tin học viên.");
       System.out.println("Bấm 3: Xóa danh sách học viên.");
       System.out.println("Bấm 4: Xếp loại học viên.");
       System.out.println("Bấm 5: Nhập điểm học viên.");
       System.out.println("Bấm 6: Sửa điểm học viên.");
       System.out.println("Bấm 7: Xem danh sách học viên.");
       System.out.println("Bấm 0: Thoát hệ thống quản lý học viên.");
       System.out.println("Mời bạn nhập lựa chọn.");

       while (true) {
           String choice = scanner.next();
           switch (choice) {
               case "1" -> student.addStudent();
               case "2" -> student.editStudent();
               case "3" -> student.delete();
               case "4" -> student.sort();
               case "5" -> student.addMark();
               case "6" -> student.editMark();
               case "7" -> student.show();
               case "0" -> {
                   System.out.println("Cảm ơn đã sử dụng dịch vụ.");
                   System.exit(0);
               }
               default -> System.out.println("Thực hiện theo chức năng Menu.");
           }
       }
   }
}
