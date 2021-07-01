package com.codegym;


import com.sun.glass.ui.Clipboard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ManagerSinhVien managerSinhVien = new ManagerSinhVien();
    static Scanner scanner = new Scanner(System.in);
    static File sinhVien = new File("sinhVien.csv");


    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÍ SINH VIÊN");
            System.out.println("Chọn một chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhập");
            System.out.println("4. Xóa");
            System.out.println("5. Xắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng: ");
            int choise = Integer.parseInt(scanner.nextLine());
            switch (choise) {
                case 1:
                    managerSinhVien.show();
                    break;
                case 2:
                    managerSinhVien.themSinhVien("sv");
                    break;
                case 3:
                    managerSinhVien.editSinhVien();
                    break;
                case 4:
                    managerSinhVien.xoaSinhVien();
                    break;
                case 5:
                    managerSinhVien.sortSinhVien();
                    break;
                case 6: {
                    sinhVien.createNewFile();
                    docFile();
                    for (SinhVien sv : managerSinhVien.list) {
                        System.out.println(sv);
                    }
                }break;
                case 7: {

                    ghiFile();
                }break;
                case 8:
                    System.exit(0);
            }
        }
    }

    public static void docFile() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(sinhVien);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(", ");
                if (str.length >= 3) {
                    managerSinhVien.list.add(new SinhVien(str[0], str[1], str[2], str[3], str[4], str[5]));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }

    }

    public static void ghiFile() throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(sinhVien);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (SinhVien sv : managerSinhVien.list) {
                bufferedWriter.write(sv.ghi());
                bufferedWriter.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
        }

    }
}
