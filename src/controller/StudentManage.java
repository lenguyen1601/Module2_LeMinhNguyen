package controller;

import model.Student;
import storage.IO_WirteVsRead;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManage {
    public static ArrayList<Student> students = IO_WirteVsRead.read();

    public Student creatStudent(Scanner scanner) {
        System.out.println("Nhập mã sinh viên: ");
        String studentId = scanner.nextLine();

        System.out.println("Nhập tên sinh viên: ");
        String studentName = scanner.nextLine();

        System.out.println("Nhập tuổi sinh viên: ");
        int studentAge = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhâp giới tính: ");
        String studentGender = scanner.nextLine();

        System.out.println("Nhập dịa chỉ: ");
        String studentAdd = scanner.nextLine();

        System.out.println("Nhập điểm trung bình của sinh viên: ");
        Double studentMark = 0.0;
        
        try {
            studentMark = Double.valueOf(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Sai định dạng mời nhập lại!!!");
        }
        

        return new Student(studentId, studentName, studentAge, studentGender, studentAdd, studentMark);
    }

    public void addStudent(Scanner scanner) {
        Student student = creatStudent(scanner);
        students.add(student);
        IO_WirteVsRead.write(students);

    }

    public void displayStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void editStudent(Scanner scanner) {
        System.out.println("Nhập mã sinh viên cần sửa thông tin: ");
        String Id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(Id)) {
                System.out.println("Nhập mã sinh viên mới: ");
                String studentId = scanner.nextLine();

                System.out.println("Nhập tên sinh viên: ");
                String studentName = scanner.nextLine();

                System.out.println("Nhập tuổi sinh viên: ");
                int studentAge = Integer.parseInt(scanner.nextLine());

                System.out.println("Nhập giới tính: ");
                String studentGender = scanner.nextLine();

                System.out.println("Nhập địa chỉ : ");
                String studentAdd = scanner.nextLine();

                System.out.println("Nhập điểm trung bình: ");
                Double studentMark = Double.valueOf(scanner.nextLine());

                students.get(i).setStudentId(studentId);
                students.get(i).setStudentName(studentName);
                students.get(i).setStudentAge(studentAge);
                students.get(i).setStudentGender(studentGender);
                students.get(i).setStudentAdd(studentAdd);
                students.get(i).setStudentMark(studentMark);

                System.out.println("Sửa sản phẩm thành công!!!");
            } else {
                System.out.println("Không tìm thấy sản phẩm!!!");
            }
        }
    }

    public void studentRemove(Scanner scanner) {
        boolean check = false;
        System.out.println("Nhập mã sinh viên cần xoá: ");
        String id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(id)) {
                students.remove(i);
                System.out.println("Xoá sinh viêm thành công !");
                check = true;
            }
        }
        if (!check) {
            System.err.println("Không tìm thấy sinh viên " + id);
        }
    }
    public void read(){
        System.out.println("Đọc file thành công!");
    }

    public void write(){
        System.out.println("Ghi file thành công!");
    }

    public void sortStudentsByMarkAsc() {

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getStudentMark() == o2.getStudentMark()){
                    return 0;
                }else if (o1.getStudentMark() >  o2.getStudentMark()) {
                    return 1;
                } else {
                    return -1;
                }
            }



        };

        students.sort(comparator);
        System.out.println("Danh sách sinh sinh dần sau khi sắp xếp điểm tăng dần là: ");
        displayStudent();
    }

    public void sortStudentsByMarkDes() {
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o2.getStudentMark() == o1.getStudentMark()) {
                    return 0;
                } else if (o2.getStudentMark() > o1.getStudentMark()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        students.sort(comparator);
        System.out.println("Danh sách sinh sinh dần sau khi sắp xếp điểm giảm dần là: ");
        displayStudent();
    }

}

