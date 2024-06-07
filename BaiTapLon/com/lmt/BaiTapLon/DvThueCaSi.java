package com.lmt.BaiTapLon;

import java.util.Scanner;

public class DvThueCaSi extends DV {
    private String tenCaSi;
    private int sLBaiHat;

    public DvThueCaSi(){}
    public DvThueCaSi(String tenDv, double gia, String tenCs, int slBh){
        super(tenCs, gia);
        this.tenCaSi = tenCs;
        this.sLBaiHat = slBh;
    }
    @Override
    public double tinhTien() {
        return super.getGiaDv()*this.sLBaiHat;
    }
    public void nhapTuFile(Scanner s){
        super.nhapTuFile(s);
        this.tenCaSi = s.nextLine();
        this.sLBaiHat = Integer.parseInt(s.nextLine());
    }
    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("Ten ca si: %s\nSo luong bai hat: %d\n", this.tenCaSi, this.sLBaiHat);
    }
    public void nhap(){
        super.nhap();
        System.out.print("Ten ca si: ");
        this.tenCaSi = CauHinh.sc.nextLine();
        System.out.print("So luong bai hat: ");
        this.sLBaiHat = Integer.parseInt(CauHinh.sc.nextLine());
    }
}
