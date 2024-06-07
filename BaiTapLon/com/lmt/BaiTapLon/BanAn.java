package com.lmt.BaiTapLon;

public class BanAn {
    private ThucDon tDon;


    public BanAn(){
        this.tDon = new ThucDon();
    }

    public BanAn(ThucDon td){
        this.tDon = td;
    }
    public double tinhGiaBanAn(){
        return this.tDon.tinhGiaThucDon();
    }
    public ThucDon gettDon() {
        return tDon;
    }

    public void settDon(ThucDon tDon) {
        this.tDon = tDon;
    }
}
