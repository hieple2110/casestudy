package DAO;

import Entity.FileIO;
import Entity.Students;

import java.util.*;
import java.util.regex.Pattern;


public class StudentImpl implements StudentDAO {
    public static HashMap<String, Students> listStudent = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);
    public static int lengthId = 2;
    public static int lengthName = 4;
    public static int lengthGender = 6;
    public static int lengthPhone = 4;
    public static int lengthMark1 = 5;
    public static int lengthMark2 = 5;
    public static int lengthMark3 = 5;
    public static int lengthMark4 = 5;
    public static int lengthAvgMark = 5;


    public HashMap<String, Students> getAllStudents() {
        return listStudent;
    }

    @Override
    public void addStudent() {
        FileIO.readerStudent();
        String id = checkId();
        String name = checkedName();
        System.out.print("Nhập giới tính của học viên: ");
        String gender = scanner.nextLine();
        String phone = checkNumberPhone();
        String mark1 = checkMark();
        String mark2 = checkMark();
        String mark3 = checkMark();
        String mark4 = checkMark();
        String avg = checkMark();
        if (listStudent.containsKey(id)) {
            System.out.println("Học viên đã có trong danh sách.!");
            System.out.println("Thực hiện theo hướng dẫn Menu.!");
        } else {
            Students students = new Students(id, name, gender, phone, mark1, mark2, mark3, mark4, avg);
            listStudent.put(id, students);
            length(students);
            FileIO.writerStudent(listStudent);
            System.out.println("Học viên " + name + " đã đăng ký thành công.!");
            System.out.println("Mời bạn nhập lựa chọn.!");

        }
    }

    @Override
    public void editStudent() {
        FileIO.readerStudent();
        System.out.print("Nhập id học viên cần sửa: ");
        String numberId = scanner.nextLine();
        if (listStudent.containsKey(numberId)) {
            System.out.println("Nhập id học viên.");
            listStudent.get(numberId).setIdStudent(scanner.nextLine());
            System.out.println("Nhập tên học viê.");
            listStudent.get(numberId).setName(scanner.nextLine());
            System.out.println("Nhập giới tính học viên.");
            listStudent.get(numberId).setGender(scanner.nextLine());
            System.out.println("Nhập số điện thoại học viên cần sửa.");
            listStudent.get(numberId).setNumberPhone(scanner.nextLine());
            FileIO.writerStudent(listStudent);
            System.out.println("Học viên đã cập nhập thông tin thành công.");
        } else {
            System.out.println("Học viên không tồn tại trong danh sách. ");
        }
    }

    @Override
    public void delete() {
        FileIO.readerStudent();
        System.out.print("Nhập id học viên cần xóa: ");
        String id = scanner.nextLine();
        if (listStudent.containsKey(id)) {
            listStudent.remove(id);
            System.out.println("Học viên đã được xóa.");
            FileIO.writerStudent( listStudent);
        } else {
            System.out.println("Học viên không có trong danh sách: ");
        }
    }

    @Override
    public void show() {
        display();
        System.out.println("Mời bạn nhập lựa chọn.!");
    }

    @Override
    public void sort() {
        List<Students> studentsList = new ArrayList<>(listStudent.values());
        Collections.sort(studentsList);
        display();
        FileIO.writerStudent(listStudent);
//        for (var i : studentsList){
//            System.out.println(i);
//        }
//        List<Map.Entry<String, Students>> studentList = new ArrayList<Map.Entry<String, Students>>(listStudent.entrySet());

//        studentList.sort(new Comparator<Map.Entry<String, Students>>() {
//            @Override
//            public int compare(Map.Entry<String, Students> o1, Map.Entry<String, Students> o2) {
//                return o2.getValue().getAvgMark().compareTo(o1.getValue().getAvgMark());
//            }
//        });
//        for (Map.Entry<String, Students> list: studentList){
//            System.out.println(list);
//        }
//        System.out.println("Sắp xếp thành công.");
    }

    @Override
    public void addMark() {
        FileIO.readerStudent();
        System.out.print("Nhập id học viên cần nhập điểm: ");
        String numberId = scanner.nextLine();
        if (listStudent.containsKey(numberId)) {
            System.out.print("Nhập điểm lần 1: ");
            float mark1 = scanner.nextFloat();
            listStudent.get(numberId).setMark1(String.valueOf(mark1));
            System.out.print("Nhập điểm lần 2: ");
            float mark2 = scanner.nextFloat();
            listStudent.get(numberId).setMark2(String.valueOf(mark2));
            System.out.print("Nhập điểm lần 3: ");
            float mark3 = scanner.nextFloat();
            listStudent.get(numberId).setMark3(String.valueOf(mark3));
            System.out.print("Nhập điểm lần 4: ");
            float mark4 = scanner.nextFloat();
            listStudent.get(numberId).setMark4(String.valueOf(mark4));
            System.out.print("Điểm trung bình: ");
            float aveg = ((mark1 + mark2) + (mark3 * 2) + (mark4 * 3)) / 7;
            listStudent.get(numberId).setAvgMark(String.valueOf(aveg));
            System.out.println("Đã nhập điểm thành công.");
            FileIO.writerStudent( listStudent);
        } else {
            System.out.println("Học viên không tồn tại trong danh sách.");
        }
    }

    @Override
    public void editMark() {
        FileIO.readerStudent();
        System.out.print("Nhập id học viên cần sửa điểm: ");
        String numberId = scanner.nextLine();
        if (listStudent.containsKey(numberId)) {
            System.out.print("Sửa điểm hệ số 1: ");
            float mark1 = scanner.nextFloat();
            listStudent.get(numberId).setMark1(String.valueOf(mark1));
            System.out.print("Sửa điểm hệ số 2: ");
            float mark2 = scanner.nextFloat();
            listStudent.get(numberId).setMark2(String.valueOf(mark2));
            System.out.print("Sửa điểm hệ số 3: ");
            float mark3 = scanner.nextFloat();
            listStudent.get(numberId).setMark3(String.valueOf(mark3));
            System.out.print("Sửa điểm hệ số 4: ");
            float mark4 = scanner.nextFloat();
            listStudent.get(numberId).setMark4(String.valueOf(mark4));
            System.out.print("Điểm trung bình: ");
            float aveg = ((mark1 + mark2) + (mark3 * 2) + (mark4 * 3)) / 7;
            listStudent.get(numberId).setAvgMark(String.valueOf(aveg));
            System.out.println("Điểm học viên đã cập nhập thành công.");
            FileIO.writerStudent( listStudent);
        } else {
            System.out.println("Học viên không tồn tại trong danh sách.");
        }
    }

    public static String checkId() {
        String id;
        String regex = "^\\d{2}$";
        while (true) {
            System.out.print("Nhập id của học viên: ");
            id = scanner.nextLine();
            Pattern patternName = Pattern.compile(regex);
            if (patternName.matcher(id).find()) {
                return id;
            } else {
                System.out.println("Id của học viên nhập chưa chính xác... ");
            }
        }
    }

    public static String checkMark() {
        String mark;
        String regex = "^\\d{1}$";
        while (true) {
            System.out.print("Nhập điểm của học viên: ");
            mark = scanner.nextLine();
            Pattern patternName = Pattern.compile(regex);
            if (patternName.matcher(mark).find()) {
                return mark;
            } else {
                System.out.println("Điểm của học viên nhập chưa chính xác...");
            }
        }
    }

    public static String checkedName() {
        String name;
        String regex = "^[a-zA-Z\\s]+$";
        while (true) {
            System.out.print("Nhập tên học viên: ");
            name = scanner.nextLine();
            Pattern patternName = Pattern.compile(regex);
            if (patternName.matcher(name).find()) {
                return name;
            } else {
                System.out.println("Tên học viên không chính xác! ");
            }
        }

    }

    public static String checkNumberPhone() {
        String phone;
        String regex = "^(08|09|07|03)\\d{8}$";
        while (true) {
            System.out.print("Nhập số điện thoại của học viên: ");
            phone = scanner.nextLine();
            Pattern patternName = Pattern.compile(regex);
            if (patternName.matcher(phone).find()) {
                return phone;
            } else {
                System.out.println("Số điện thoại nhập chưa chính xác...");
            }
        }
    }

    public static void length(Students students) {
        if (students.getIdStudent().length() > lengthId) {
            lengthId = students.getIdStudent().length();
        }
        if (students.getName().length() > lengthName) {
            lengthName = students.getName().length();
        }
        if (students.getGender().length() > lengthGender) {
            lengthGender = students.getGender().length();
        }
        if (students.getNumberPhone().length() > lengthPhone) {
            lengthPhone = students.getNumberPhone().length();
        }
        if (students.getMark1().length() > lengthMark1) {
            lengthMark1 = students.getMark1().length();
        }
        if (students.getMark2().length() > lengthMark2) {
            lengthMark2 = students.getMark2().length();
        }
        if (students.getMark3().length() > lengthMark3) {
            lengthMark3 = students.getMark3().length();
        }
        if (students.getMark4().length() > lengthMark4) {
            lengthMark4 = students.getMark4().length();
        }
        if (students.getAvgMark().length() > lengthAvgMark) {
            lengthAvgMark = students.getAvgMark().length();
        }
    }

    public static void display() {
        System.out.println(getString(47 + lengthId + lengthName + lengthGender + lengthPhone + lengthMark1 + lengthMark2 + lengthMark3 + lengthMark4 + lengthAvgMark));
        System.out.print("| Id" + getStringByInt(lengthId - 2 + 3) + "|");
        System.out.print(" Name" + getStringByInt(lengthName - 4 + 3) + "|");
        System.out.print(" Gender" + getStringByInt(lengthGender - 6 + 3) + "|");
        System.out.print(" Phone" + getStringByInt(lengthPhone - 5 + 3) + "|");
        System.out.print(" Mark1" + getStringByInt(lengthMark1 - 5 + 3) + "|");
        System.out.print(" Mark2" + getStringByInt(lengthMark2 - 5 + 3) + "|");
        System.out.print(" Mark3" + getStringByInt(lengthMark3 - 5 + 3) + "|");
        System.out.print(" Mark4" + getStringByInt(lengthMark4 - 5 + 3) + "|");
        System.out.print(" AvgMark" + getStringByInt(lengthAvgMark - 5 + 3) + "|");
        System.out.println();
        for (Students students : listStudent.values()) {
            String code = students.getIdStudent();
            System.out.print("| " + code + getStringByInt(lengthId + 3 - code.length()) + "|");
            String name = students.getName();
            System.out.print(" " + name + getStringByInt(lengthName + 3 - name.length()) + "|");
            String gender = students.getGender();
            System.out.print(" " + gender + getStringByInt(lengthGender + 3 - gender.length()) + "|");
            String phone = students.getNumberPhone();
            System.out.print(" " + phone + getStringByInt(lengthPhone + 3 - phone.length()) + "|");
            String mark1 = students.getMark1();
            System.out.print(" " + mark1 + getStringByInt(lengthMark1 + 3 - mark1.length()) + "|");
            String mark2 = students.getMark2();
            System.out.print(" " + mark2 + getStringByInt(lengthMark2 + 3 - mark2.length()) + "|");
            String mark3 = students.getMark3();
            System.out.print(" " + mark3 + getStringByInt(lengthMark3 + 3 - mark3.length()) + "|");
            String mark4 = students.getMark4();
            System.out.print(" " + mark4 + getStringByInt(lengthMark4 + 3 - mark4.length()) + "|");
            String avg = students.getAvgMark();
            System.out.print(" " + avg + getStringByInt(lengthAvgMark + 4 - avg.length()) + "|");
            System.out.println();
        }
        FileIO.writerStudent(listStudent);
    }

    private static String getStringByInt(int i) {
        String result = "";
        for (int j = 0; j < i; j++) {
            result += " ";
        }
        return result;
    }

    private static String getString(int i) {
        String result = "";
        for (int j = 0; j < i; j++) {
            result += "-";
        }
        return result;
    }


}

