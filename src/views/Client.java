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
            System.out.println("---- CHUONG TRINH QUAN LY SAN PHAM ----");
            System.out.println("1. Xem danh sach sinh vien");
            System.out.println("2. Them moi sinh vien");
            System.out.println("3. Cap nhat sinh vien");
            System.out.println("4. Xoa");
            System.out.println("5. Sap xep");
            System.out.println("6. Doc tu file Csv");
            System.out.println("7. Ghi vao file Csv");
            System.out.println("8. Thoat chuong trinh");
            System.out.println("--------------------------------------------------------");
            System.out.print("Chon chuc nang: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> studentManage.displayStudent();
                case 2 -> studentManage.addStudent(scanner);
                case 3 -> studentManage.editStudent(scanner);
                case 4 -> studentManage.studentRemove(scanner);
                case 5 -> {
                    int choice1;
                    System.out.println("1. Sap xep tang dan");
                    System.out.println("2. Sap xep giam dan");
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


