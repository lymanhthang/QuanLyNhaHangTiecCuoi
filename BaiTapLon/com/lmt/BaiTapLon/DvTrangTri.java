package com.lmt.BaiTapLon;

public class DvTrangTri extends DV{
    public DvTrangTri(){}
    public DvTrangTri(String tendv, double gia){
        super(tendv, gia);
    }
    @Override
    public double tinhTien() {
        return super.getGiaDv();
    }
}
