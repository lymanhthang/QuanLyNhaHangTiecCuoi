package com.lmt.BaiTapLon;


public class SanhCuoi {
    private static int dem;
    private String maSc = String.format("S%03d", ++dem);
    private String tenSc;
    private String viTri;
    private int sucChua;
    private double Gia_NgThuong;
    private double Gia_NgLe;
    private int soLanThue;
    
    public String getTenSc() {
        return tenSc;
    }

    public void setTenSc(String tenSc) {
        this.tenSc = tenSc;
    }

    public int getSoLanThue() {
        return soLanThue;
    }

    public void setSoLanThue(int soLanThue) {
        this.soLanThue = soLanThue;
    }

    public String getMaSc() {
        return maSc;
    }

    public void setMaSc(String maSc) {
        this.maSc = maSc;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public double getGia_NgThuong() {
        return Gia_NgThuong;
    }

    public void setGia_NgThuong(double gia_NgThuong) {
        Gia_NgThuong = gia_NgThuong;
    }

    public double getGia_NgLe() {
        return Gia_NgLe;
    }

    public void setGia_NgLe(double gia_NgLe) {
        Gia_NgLe = gia_NgLe;
    }

    public SanhCuoi(String ten, String viTri, int sucChua, double gia_NgThuong, double gia_NgLe) {
        this.tenSc = ten;
        this.viTri = viTri;
        this.sucChua = sucChua;
        this.Gia_NgThuong = gia_NgThuong;
        this.Gia_NgLe = gia_NgLe;
        this.soLanThue = 0;
    }

    public void tangSoLanThue() {
        this.soLanThue++;
    }

    public SanhCuoi() {
    }

    public void nhapSc() {
        System.out.print("Ten sanh cuoi: ");
        this.tenSc = CauHinh.sc.nextLine();
        System.out.print("Vi tri: ");
        this.viTri = CauHinh.sc.nextLine();
        System.out.print("Suc chua: ");
        this.sucChua = Integer.parseInt(CauHinh.sc.nextLine());
        System.out.print("Gia ngay thuong: ");
        this.Gia_NgThuong = Double.parseDouble(CauHinh.sc.nextLine());
        System.out.print("Gia ngay le: ");
        this.Gia_NgLe = Double.parseDouble(CauHinh.sc.nextLine());
    }

    public void hienThi() {
        System.out.printf(
                "Ma sanh cuoi: %s\nTen: %s\nVi tri: %s\nSuc chua: %d\nGia ngay thuong: %.1f\nGia ngay le: %.1f\nSo lan thue: %d\n",
                this.maSc, this.tenSc, this.viTri, this.sucChua, this.Gia_NgThuong, this.Gia_NgLe, this.soLanThue);
    }
    
}