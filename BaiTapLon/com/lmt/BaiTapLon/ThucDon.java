package com.lmt.BaiTapLon;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThucDon {
    private List<ThucPham> dsTp = new ArrayList<>();

    public List<ThucPham> getDsTp() {
        return dsTp;
    }

    public void setDsTp(List<ThucPham> dsTp) {
        this.dsTp = dsTp;
    }

    public void themTp(ThucPham... a) {
        this.dsTp.addAll(Arrays.asList(a));
    }

    public void them1Tp(String loaiTp) {
        try {
            String path = "com.lmt.BaiTapLon." + loaiTp;
            Class c = Class.forName(path);
            ThucPham tp = (ThucPham) c.getConstructor().newInstance();
            tp.nhapTp();
            this.dsTp.add(tp);
        } catch (Exception e) {
        }
    }

    public void hienThi() {
        this.dsTp.forEach(tp -> tp.hienThi());
    }

    public void themTpTuFile(String filePath) {
        try{
            File f = new File(filePath);
            Scanner Sc = new Scanner(f);
            while (Sc.hasNext()) {
                String path = "com.lmt.BaiTapLon." + Sc.nextLine();
                Class c = Class.forName(path);
                ThucPham tp = (ThucPham) c.getConstructor().newInstance();
                tp.nhapTuFile(Sc);
                this.dsTp.add(tp);
            }
        } catch(Exception e){}
    }

    public double tinhGiaThucDon() {
        return this.dsTp.stream().mapToDouble(ThucPham::getGiaTP).sum();
    }

    public List<ThucPham> timKiem(String name) {
        return this.dsTp.stream().filter(tp -> tp.getTenTP().contains(name)).collect(Collectors.toList());
    }

    public ThucPham timKiem(int num) {
        return this.dsTp.stream().filter(tp -> tp.getMaTP() == num).findFirst().get();
    }

    public void xoaTp(String name) {
        this.dsTp.removeIf(tp -> tp.getTenTP().equals(name));
    }

    public void xoaTp(int maTp) {
        this.dsTp.remove(maTp - 1);
    }

    public double tinhTien(){
        return this.dsTp.stream().mapToDouble(ThucPham::getGiaTP).sum();
    }
}
