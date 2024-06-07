package com.lmt.BaiTapLon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuanLyThucDon {
    private List<ThucDon> qLTD = new ArrayList<>();

    public void themTd(ThucDon...tD){
        this.qLTD.addAll(Arrays.asList(tD));
    }
    public void xoaTd(int index){
        this.qLTD.remove(index);
    }
    public ThucDon getThucDon(int index){
        ThucDon other = new ThucDon();
        other = this.qLTD.get(index);
        return other;
    }

    public void hienThi(){
        for(int i=0; i<this.qLTD.size();i++){
            System.out.printf("=== Thuc don %d ===\n", i);
            this.qLTD.get(i).hienThi();
        }
    }
}
