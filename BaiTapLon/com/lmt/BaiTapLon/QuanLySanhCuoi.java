package com.lmt.BaiTapLon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLySanhCuoi {
    private List<SanhCuoi> dSSc = new ArrayList<>();

    public List<SanhCuoi> getdSSc() {
        return dSSc;
    }

    public void setdSSc(List<SanhCuoi> dSSc) {
        this.dSSc = dSSc;
    }
   
    public void themSc(SanhCuoi...s){
        this.dSSc.addAll(Arrays.asList(s));
    }

    public void them1Sc(){
        SanhCuoi s = new SanhCuoi();
        s.nhapSc();
        this.dSSc.add(s);
    }

    public void xoaSc(String Sc){
        this.dSSc.removeIf(s -> s.getMaSc().equals(Sc) || s.getTenSc().equals(Sc));
    }

    public void hienThi(){
        this.dSSc.forEach(s -> s.hienThi());
    }

    public List<SanhCuoi> timKiem(String t){
        return this.dSSc.stream().filter(s -> s.getTenSc().contains(t) || s.getViTri().equals(t)).collect(Collectors.toList());
    }

    public List<SanhCuoi> timKiem(int sChua){
        return this.dSSc.stream().filter(s -> s.getSucChua() == sChua).collect(Collectors.toList());
    }

    public void sapXep(){
        this.dSSc.sort((s1, s2) -> -(s1.getSoLanThue()-s2.getSoLanThue()));
    }
    public SanhCuoi getSc(int index){
        return this.dSSc.get(index);
    }
    public SanhCuoi getSc(String ten){
        return this.dSSc.stream().filter(t -> t.getMaSc().equals(ten)).findFirst().get();
    }
}
