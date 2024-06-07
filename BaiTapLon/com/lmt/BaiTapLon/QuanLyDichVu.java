package com.lmt.BaiTapLon;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuanLyDichVu {
    private List<DV> dSDv = new ArrayList<>();

    public List<DV> getdSDv() {
        return dSDv;
    }

    public void setdSDv(List<DV> dSDv) {
        this.dSDv = dSDv;
    }

    public void themDv(DV... dv) {
        this.dSDv.addAll(Arrays.asList(dv));
    }

    public void them1Dv(String loaiDv) {
        String path = "com.lmt.BaiTapLon." + loaiDv;
        try{
            Class c = Class.forName(path);
            DV dv = (DV) c.getConstructor().newInstance();
            dv.nhap();
            this.dSDv.add(dv);
        } catch (Exception e){}
    }

    public void themDvTuFile(String filePath) {
        try{
            File f = new File(filePath);
            Scanner Sc = new Scanner(f);
            while (Sc.hasNext()) {
                String path = "com.lmt.BaiTapLon." + Sc.nextLine();
                Class c = Class.forName(path);
                DV dv = (DV) c.getConstructor().newInstance();
                dv.nhapTuFile(Sc);
                this.dSDv.add(dv);
            }
        } catch(Exception e){}
    }

    // public void themDvTuFile() {
        
    // }

    public void xoaDv(int pos) {
        this.dSDv.remove(pos);
    }

    public void xoaDv(String name) {
        this.dSDv.removeIf(dv -> dv.getTenDv().contains(name));
    }

    public List<DV> timKiem(String name) {
        return this.dSDv.stream().filter(dv -> dv.getTenDv().contains(name)).collect(Collectors.toList());
    }
    public double tinhTien(){
        return this.dSDv.stream().mapToDouble(DV::tinhTien).sum();
    }
    public void hienThi() {
        this.dSDv.forEach(dv -> dv.hienThi());
    }

    public DV getDv(int index){
        return this.dSDv.get(index);
    }
}
