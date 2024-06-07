package com.lmt.BaiTapLon;

import java.util.Scanner;

public class ThucUong extends ThucPham{
    private String hangSX;
    
    public String getHangSX() {
        return hangSX;
    }
    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }
    public ThucUong(String ten, double gia, String hSx){
        super(ten, gia);
        this.hangSX = hSx;
    }
    public ThucUong(){}
    
    public void nhapTp(){
        super.nhapTp();
        System.out.print("Hang san xuat: ");
        this.hangSX = CauHinh.sc.nextLine();
    }

    public void hienThi(){
        super.hienThi();
        System.out.println("Hang san xuat: " + this.hangSX);
    }

    public void nhapTuFile(Scanner s){
        super.nhapTuFile(s);
        this.hangSX = s.nextLine();
    }
}
