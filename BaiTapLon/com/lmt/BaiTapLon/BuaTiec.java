package com.lmt.BaiTapLon;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class BuaTiec implements Comparable{
    private String tenBtiec;
    private SanhCuoi sC;
    private double giaDonThueSanh;
    private ThoiDiem thDiem;
    private LocalDate ngayThue;
    private QuanLyDichVu qldv = new QuanLyDichVu();
    private QuanLyBanAn qlba = new QuanLyBanAn();
    private double donGia;
    
    public QuanLyBanAn getQlba() {
        return qlba;
    }
    public void setQlba(QuanLyBanAn qlba) {
        this.qlba = qlba;
    }
    public String getTen() {
        return tenBtiec;
    }
    public void setTen(String ten) {
        this.tenBtiec = ten;
    }
    public SanhCuoi getsC() {
        return sC;
    }
    public void setsC(SanhCuoi sC) {
        this.sC = sC;
    }
    public double getgiaDonThueSanh() {
        return giaDonThueSanh;
    }
    public void setgiaDonThueSanh(double giaDonThueSanh) {
        this.giaDonThueSanh = giaDonThueSanh;
    }
    public ThoiDiem getThDiem() {
        return thDiem;
    }
    public void setThDiem(ThoiDiem thDiem) {
        this.thDiem = thDiem;
    }
    public LocalDate getNgayThue() {
        return ngayThue;
    }
    public void setNgayThue(LocalDate ngayThue) {
        this.ngayThue = ngayThue;
    }
    
    public QuanLyDichVu getQldv() {
        return qldv;
    }
    public void setQldv(QuanLyDichVu qldv) {
        this.qldv = qldv;
    }
    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    public BuaTiec(){}
    
    public BuaTiec(String ten, SanhCuoi s, ThoiDiem thDiem, String ngThue, QuanLyDichVu qldv, QuanLyBanAn qlba){
        this.tenBtiec = ten;
        this.sC = s;
        s.tangSoLanThue();
        this.thDiem = thDiem;
        this.ngayThue = LocalDate.parse(ngThue, CauHinh.dmy);
        this.qldv = qldv;
        this.qlba = qlba;
        if(this.ngayThue.getDayOfWeek() == DayOfWeek.SUNDAY || this.ngayThue.getDayOfWeek() == DayOfWeek.SATURDAY){
            this.giaDonThueSanh = this.thDiem.tinhGiaThueSanh(this.sC.getGia_NgLe());
        } else {
            this.giaDonThueSanh = this.thDiem.tinhGiaThueSanh(this.sC.getGia_NgThuong());
        }
        
        this.donGia = this.giaDonThueSanh + this.qlba.tinhGiaTatCaBanAn() + this.qldv.tinhTien();
    }
    
    public void hienThi(){
        System.out.printf("Ten bua tiec: %s\nSanh cuoi: %s\nNgay: %s\nThoi diem: %s\nDon gia thue sanh: %.1f\nDon gia mon an: %.1f\nDon gia dich vu: %.1f\nTong cong: %.1f\n", 
        this.tenBtiec, this.sC.getMaSc(), this.ngayThue.format(CauHinh.dmy), this.thDiem.toString(), this.giaDonThueSanh, this.qlba.tinhGiaTatCaBanAn(), this.qldv.tinhTien(), this.donGia);
    }
    public void xuatHoaDon(){
        System.out.println("=== HOA DON ===");
        System.out.printf("Ten bua tiec: %s\nNgay: %s\nGia thue sanh: %.1f\n", this.tenBtiec, this.ngayThue.format(CauHinh.dmy), this.giaDonThueSanh);
        for(int i=0; i<this.getsC().getSucChua(); i++){
            System.out.printf("Thuc don ban %d\n:", i+1);
            // this.sC.getBanAn().get(i).gettDon().hienThi();
            this.qlba.getdSBa().get(i).gettDon().hienThi();
            System.out.printf("Hoa don ban %d: %.1f\n", i+1, this.qlba.getdSBa().get(i).tinhGiaBanAn());
        }
        System.out.printf("Hoa don tien an: %.1f\n", this.qlba.tinhGiaTatCaBanAn());
        System.out.println("Cac dich vu su dung:");
        this.qldv.hienThi();
        System.out.printf("Hoa don dich vu: %.1f\nTONG CONG: %.1f\n", this.qldv.tinhTien(), this.donGia);
    }

    @Override
    public int compareTo(Object o) {
        BuaTiec a = (BuaTiec) o;
        return this.sC.getMaSc().compareTo(a.getsC().getMaSc());
    }
}
 