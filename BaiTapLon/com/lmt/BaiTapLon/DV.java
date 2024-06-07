package com.lmt.BaiTapLon;

import java.util.Scanner;

public abstract class DV {
    private static int dem;
    private int maDv = ++dem;
    private String tenDv;
    private double giaDv;

    public int getMaDv() {
        return maDv;
    }

    public void setMaDv(int maDv) {
        this.maDv = maDv;
    }

    public String getTenDv() {
        return tenDv;
    }

    public void setTenDv(String tenDv) {
        this.tenDv = tenDv;
    }

    public double getGiaDv() {
        return giaDv;
    }

    public void setGiaDv(double giaDv) {
        this.giaDv = giaDv;
    }

    public DV(String ten, double gia){
        this.tenDv = ten;
        this.giaDv = gia;

    }
    public DV(){}

    public abstract double tinhTien();

    public void nhapTuFile(Scanner s){
        this.tenDv = s.nextLine();
        this.giaDv = Double.parseDouble(s.nextLine());
    }

    public void nhap(){
        System.out.print("Ten dich vu: ");
        this.tenDv = CauHinh.sc.nextLine();
        System.out.print("Gia dich vu: ");
        this.giaDv = Double.parseDouble(CauHinh.sc.nextLine());
    }

    public void hienThi(){
        System.out.printf("Ma dich vu: %d\nTen dich vu: %s\nGia: %.1f\n", this.maDv, this.tenDv, this.giaDv);
    };
}
