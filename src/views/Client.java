package views;

import controller.StudentManage;
import storage.IO_WirteVsRead;


import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManage studentManage = new StudentManage();
        int choice;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xoá");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đoc file");
            System.out.println("7. Ghi file");
            System.out.println("8. Thoát chương trình");
            System.out.println("--------------------------------------------------------");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> studentManage.displayStudent();
                case 2 -> studentManage.addStudent(scanner);
                case 3 -> studentManage.editStudent(scanner);
                case 4 -> studentManage.studentRemove(scanner);
                case 5 -> {
                    int choice1;
                    System.out.println("1. Sắp xếp tăng dần");
                    System.out.println("2. Sắp xếp giảm dần");
                    choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1 -> studentManage.sortStudentsByMarkAsc();
                        case 2 -> studentManage.sortStudentsByMarkDes();
                    }
                }
                case 6 -> studentManage.read();
                case 7 -> studentManage.write();
                case 8 -> System.exit(0);
            }
        } while (true);
    }
}


