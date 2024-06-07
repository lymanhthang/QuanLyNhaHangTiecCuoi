package com.lmt.BaiTapLon;

import java.util.Scanner;

public class ThucAn extends ThucPham {
    private boolean isAnChay;

    public boolean isAnChay() {
        return isAnChay;
    }

    public void setAnChay(boolean isAnChay) {
        this.isAnChay = isAnChay;
    }

    public ThucAn(String ten, double gia, boolean isAc){
        super(ten, gia);
        this.isAnChay = isAc;
    }

    public ThucAn(){}

    public void nhapTp(){
        super.nhapTp();
        System.out.print("An chay duoc khong(y/n): ");
        if(CauHinh.sc.nextLine() == "y"){
            this.isAnChay = false;
        } else {
            this.isAnChay = true;
        }
    }

    public void hienThi(){
        super.hienThi();
        if(this.isAnChay){
            System.out.println("An chay: Co");
        } else {
            System.out.println("An chay: Khong");
        }
    }
    public void nhapTuFile(Scanner s){
        super.nhapTuFile(s);
        this.isAnChay = Boolean.parseBoolean(s.nextLine());
    }
}
