package com.lmt.BaiTapLon;

import java.util.Scanner;

public class DvKaraoke extends DV {
    private double thoiGianThue;

    public DvKaraoke(){}
    public DvKaraoke(String ten, double gia, double thoiGianThue){
        super(ten, gia);
        this.thoiGianThue = thoiGianThue;
    }
    
    @Override
    public double tinhTien() {
        return super.getGiaDv()*this.thoiGianThue;
    }
    public void nhapTuFile(Scanner s){
        super.nhapTuFile(s);
        this.thoiGianThue = Double.parseDouble(s.nextLine());
    }
    public void nhap(){
        super.nhap();
        System.out.print("Thoi gian thue: ");
        this.thoiGianThue = Double.parseDouble(CauHinh.sc.nextLine());
    }
    public void hienThi(){
        super.hienThi();
        System.out.printf("Thoi gian thue: %.1f\n", this.thoiGianThue);
    }

}
