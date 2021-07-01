package com.codegym;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManagerSinhVien {
    List<SinhVien> list = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static SortSinhVien sortSinhVien = new SortSinhVien();

    public void themSinhVien(String SV) {
        SinhVien sinhVien = create(SV);
        list.add(sinhVien);
    }

    private SinhVien create(String SV) {
        System.out.println("Mã sinh viên:");
        String maSinhVien = scanner.nextLine();
        System.out.println("Họ tên:");
        String hoTen = scanner.nextLine();
        System.out.println("Tuổi sinh viên:");
        String tuoi = scanner.nextLine();
        System.out.println("Giới tính sinh viên:");
        String gioiTinh = scanner.nextLine();
        System.out.println("Địa chỉ sinh viên:");
        String diaChi = scanner.nextLine();
        System.out.println("Điểm trung bình:");
        String diemTrungBinh = scanner.nextLine();
        if (SV == "sv") {
            return new SinhVien(maSinhVien, hoTen, tuoi, gioiTinh, diaChi, diemTrungBinh);
        }
        return null;
    }


    public void show() {
        for (SinhVien sv : list) {
            System.out.println(sv);
        }
    }


    public void xoaSinhVien() {
        System.out.println("Nhập tên sinh viên cần xóa");
        String tenNV = scanner.nextLine();
        list.removeIf(x -> x.getHoTen().equals(tenNV));
    }

    public void sortSinhVien() {
        Collections.sort(list, sortSinhVien);
    }

    public void editSinhVien() {
        SinhVien count = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sinh cần sửa: ");
        String index4 = scanner.nextLine();


        System.out.println("Mã sinh viên:");
        String maSinhVien = scanner.nextLine();
        System.out.println("Họ tên:");
        String hoTen = scanner.nextLine();
        System.out.println("Tuổi sinh viên:");
        String tuoi = scanner.nextLine();
        System.out.println("Giới tính sinh viên:");
        String gioiTinh = scanner.nextLine();
        System.out.println("Địa chỉ sinh viên:");
        String diaChi = scanner.nextLine();
        System.out.println("Điểm trung bình:");
        String diemTrungBinh = scanner.nextLine();


        for (SinhVien sv : list) {
            if (sv.getHoTen().equals(index4)) {
                sv.setMaSinhVien(maSinhVien);
                sv.setHoTen(hoTen);
                sv.setTuoi(tuoi);
                sv.setGioiTinh(gioiTinh);
                sv.setDiaChi(diaChi);
                sv.setDiemTrungBinh(diemTrungBinh);
            }
        }

    }




}
