package controller;

import model.Student;
import storage.IO_WirteVsRead;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManage {
    public static ArrayList<Student> students = IO_WirteVsRead.read();

    public Student creatStudent(Scanner scanner) {
        System.out.println("Nhap ma sinh vien: ");
        String studentId = scanner.nextLine();

        System.out.println("Nhap ten sinh vien: ");
        String studentName = scanner.nextLine();

        System.out.println("Nhap tuoi sinh vien: ");
        int studentAge = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhap gioi tinh: ");
        String studentGender = scanner.nextLine();

        System.out.println("Nhap dia chi sinh vien: ");
        String studentAdd = scanner.nextLine();

        System.out.println("Nhap diem trung binh sinh vien: ");
        Double studentMark = 0.0;
        
        try {
            studentMark = Double.valueOf(scanner.nextLine());
        }catch (Exception e){
            System.out.println("sai dinh dang moi nhap lai");
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
        System.out.println("Nhap ma sinh vien can sua thong tin: ");
        String Id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(Id)) {
                System.out.println("Nhap ma sinh vien moi: ");
                String studentId = scanner.nextLine();

                System.out.println("Nhap ten sinh vien: ");
                String studentName = scanner.nextLine();

                System.out.println("Nhap tuoi sinh vien: ");
                int studentAge = Integer.parseInt(scanner.nextLine());

                System.out.println("Nhap gioi tinh: ");
                String studentGender = scanner.nextLine();

                System.out.println("Nhap dia chi: ");
                String studentAdd = scanner.nextLine();

                System.out.println("Nahp diem trung binh: ");
                Double studentMark = Double.valueOf(scanner.nextLine());

                students.get(i).setStudentId(studentId);
                students.get(i).setStudentName(studentName);
                students.get(i).setStudentAge(studentAge);
                students.get(i).setStudentGender(studentGender);
                students.get(i).setStudentAdd(studentAdd);
                students.get(i).setStudentMark(studentMark);

                System.out.println("Sua san pham thanh cong!!!");
            } else {
                System.out.println("Khong tim thay san pham!!!");
            }
        }
    }

    public void studentRemove(Scanner scanner) {
        boolean check = false;
        System.out.println("Nhap ma sinh vien can xoa: ");
        String id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(id)) {
                students.remove(i);
                System.out.println("Xoa sinh vien thanh cong !");
                check = true;
            }
        }
        if (!check) {
            System.err.println("Khong tim thay sinh vien ! " + id);
        }
    }
    public void read(){
        System.out.println("Doc thanh cong");
    }

    public void write(){
        System.out.println("Ghi thanh cong");
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
        System.out.println("Danh sach sinh vien sau khi sap xep diem tang dan la: ");
        displayStudent();
    }

    public void sortStudentsByMarkDes() {
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getStudentMark() == o2.getStudentMark()) {
                    return 0;
                } else if (o1.getStudentMark() > o2.getStudentMark()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        students.sort(comparator);
        System.out.println("Danh sach sinh vien sau khi sap xep diem giam dan la: ");
        displayStudent();
    }

}

