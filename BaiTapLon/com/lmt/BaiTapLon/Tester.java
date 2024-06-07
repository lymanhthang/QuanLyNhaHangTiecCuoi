package com.lmt.BaiTapLon;

import java.time.Month;

public class Tester {
    public static void main(String[] args) {

        // SanhCuoi s = new SanhCuoi("Sanh 1", "Tang 1", 20, 30, 50);
        // DV dv1 = new DvKaraoke("Karaoke01", 250000, 2.5);
        // DV dv2 = new DvTrangTri("Trang tri ngoai canh", 2000000);
        // List<DV> dv = new ArrayList<>();
        // dv.add(dv2); dv.add(dv1);

        // ThucDon thdon = new ThucDon();
        // thdon.themTpTuFile("com/lmt/BaiTapLon/Data/thucpham.txt");
        
        // s.themThucDon(thdon);
        // BuaTiec bt1 = new BuaTiec("Sinh nhat", s, ThoiDiem.CHIEU, "11/01/2024", dv);
        // bt1.hienThi();
        QuanLyNhaHang qLNh = new QuanLyNhaHang();
        qLNh.themThucDon("com/lmt/BaiTapLon/Data/thucpham.txt");
        qLNh.themDichVu();
        // qLNh.getqLDv().hienThi();
        qLNh.themSanhCuoi();
        qLNh.themSanhCuoi();
        // qLNh.getqLSc().hienThi();
        qLNh.themBuaTiec();
        qLNh.themBuaTiec();
        qLNh.getqLBt().hienThi();
        qLNh.baoCaoDoanhThu(Month.of(1));
        
        
    }
}
