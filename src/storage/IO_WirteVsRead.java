package storage;

import model.Student;

import java.io.*;
import java.util.ArrayList;

import static controller.StudentManage.students;

public class IO_WirteVsRead {
    static File file =new File("D:\\Intellij\\APJ_EXAM_LeMinhNguyen\\src\\data\\students.csv");


    public static void write(ArrayList<Student> students){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Student> read(){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Student> students = (ArrayList<Student>) objectInputStream.readObject();
            return students;
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
