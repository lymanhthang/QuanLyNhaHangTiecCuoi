package com.lmt.BaiTapLon;

import java.util.Scanner;

public abstract class ThucPham {
    private static int dem;
    private int maTP = ++dem;
    private String tenTP;
    private double giaTP;

    public int getMaTP() {
        return maTP;
    }

    public void setMaTP(int maTP) {
        this.maTP = maTP;
    }

    public String getTenTP() {
        return tenTP;
    }

    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
    }

    public double getGiaTP() {
        return giaTP;
    }

    public void setGiaTP(double giaTP) {
        this.giaTP = giaTP;
    }

    public ThucPham(){}

    public ThucPham(String ten, double gia){
        this.tenTP = ten;
        this.giaTP = gia;
    }
    
    public void nhapTp(){
        System.out.print("Nhap ten thuc pham: ");
        this.tenTP = CauHinh.sc.nextLine();
        System.out.print("Nhap gia: ");
        this.giaTP = Double.parseDouble(CauHinh.sc.nextLine());
    }
    public void hienThi(){
        System.out.printf("Ma thuc pham: %d\nTen thuc pham: %s\nGia: %.1f\n", 
        this.maTP, this.tenTP, this.giaTP);
    }

    public void nhapTuFile(Scanner s){
        this.tenTP = s.nextLine();
        this.giaTP = Double.parseDouble(s.nextLine());
    }
    
}
