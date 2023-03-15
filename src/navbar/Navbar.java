package navbar;

import model.Student;

import java.util.Scanner;

public class Navbar {
    public static void main(String[] args) {
        Student[] listStudents = new Student[10];
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("***************STUDENT MANAGE***************************\n" +
                    "1. Show List Student.\n" +
                    "2. Create Student \n" +
                    "3. Update Student \n" +
                    "4. Delete Student \n" +
                    "5. Sort Student By Age ASC (Tăng Dần).\n" +
                    "6. Exit");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    displayStudent(listStudents);
                    break;
                case 2:
                    createStudent(listStudents, input);
                    break;
                case 3:
                    displayStudent(listStudents);
                    updateStudent(listStudents,input);
                    break;
                case 4:
                    System.out.println("nhap id sinh vien can xoa");
                    int idDel = Integer.parseInt(input.nextLine());
                    deleteStudent(listStudents,idDel);
                    break;
                case 5:
                    sortByAge(listStudents);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhap khong dung");
                    break;
            }
        }
    }

    public static void displayStudent(Student[] list) {
        for (Student student : list) {
            if (student != null)
            System.out.println(student);
        }
    }

    public static void createStudent(Student[] list, Scanner input) {
        Student student = new Student();
        System.out.println("Nhap ten sinh vien");
        String name = input.nextLine();
        student.setStudentName(name);
        System.out.println("Nhap tuoi sinh vien");
        int age = Integer.parseInt(input.nextLine());
        student.setAge(age);
        boolean check = false;
        boolean checkNull = false;
        int idMax = 0;
        for (Student st: list) {
            if (st != null){
                checkNull = true;
                if (idMax < st.getStudentId()){
                    idMax = st.getStudentId();
                }
            }
        }
        if (checkNull) {
            student.setStudentId(idMax + 1);
        } else {
            student.setStudentId(1);
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = student;
                check = true;
                break;
            }
        }

        if (check) {
            System.out.println("Tao moi sinh vien thanh cong");
        } else {
            System.err.println("Lop da du sinh vien!");
        }
    }

    public static void updateStudent(Student[] list,Scanner input) {
        Student student = new Student();
        boolean check = false;
        System.out.println("chon id sinh vien can cap nhat");
        int idUpdate = Integer.parseInt(input.nextLine());
        System.out.println("Nhap ten sinh vien");
        String newName = input.nextLine();
        student.setStudentName(newName);
        System.out.println("Nhap tuoi sinh vien");
        int newAge = Integer.parseInt(input.nextLine());
        student.setAge(newAge);
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null){
                if (list[i].getStudentId() == idUpdate){
                    list[i] = student;
                    check = true;
                    break;
                }
            }
        }
        if (check){
            System.out.println("sua thanh cong");
        } else {
            System.err.println("Khong ton tai Id can sua");
        }
    }
    public static void deleteStudent(Student[] list,int id) {
        boolean check = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null){
                if (list[i].getStudentId() == id){
                    check = true;
                    list[i] = null;
                }
            }
        }
        if (check) {
            System.out.println("Xoa thanh cong");
        } else {
            System.out.println("Khong tim thay Id can xoa");
        }
    }

    public static void sortByAge(Student[] list) {
Student student = new Student();
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] != null && list[j] != null){
                    if (list[i].getAge() > list[j].getAge()){
                        Student temp = list[i];
                        list[i] = list[j];
                        list[j] = temp;
                    }
                }
            }
        }
    }
}
