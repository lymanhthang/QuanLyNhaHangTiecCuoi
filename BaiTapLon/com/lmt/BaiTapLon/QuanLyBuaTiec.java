package com.lmt.BaiTapLon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyBuaTiec {
    private List<BuaTiec> dSBt = new ArrayList<>();

    public List<BuaTiec> getdSBt() {
        return dSBt;
    }

    public void setdSBt(List<BuaTiec> dSBt) {
        this.dSBt = dSBt;
    }

    public void themBuaTiec(BuaTiec...a){
        this.dSBt.addAll(Arrays.asList(a));
    }

    public void xoaBt(int index){
        this.dSBt.remove(index);
    }
    public void xoaBt(String s){
        this.dSBt.removeIf(t -> t.getTen().equals(s));
    }
    public List<BuaTiec> timKiem(String s){
        return this.dSBt.stream().filter(t -> t.getTen().contains(s)).collect(Collectors.toList());
    }
    public BuaTiec getBuaTiec(int index){
        return this.dSBt.get(index);
    }
    public BuaTiec getBuaTiec(String ten){
        return this.dSBt.stream().filter(t -> t.getTen().equals(ten)).findFirst().get();
    }
    public void hienThi(){
        this.dSBt.forEach(t -> t.hienThi());
    }
    public double tinhDoanhThu(){
        return this.dSBt.stream().mapToDouble(BuaTiec::getDonGia).sum();
    }
    public void inHoaDon(){
        this.dSBt.forEach(t -> t.xuatHoaDon());
    }
    public void sapXep(){
        
    }
}
