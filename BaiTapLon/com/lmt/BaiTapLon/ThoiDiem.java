package com.lmt.BaiTapLon;

public enum ThoiDiem {
    SANG(1, "Sang"), CHIEU(1.2, "Chieu"), TOI(1.5, "Toi");

    protected double heSo;
    protected String tD;
    @Override
    public String toString() {
        return this.tD;
    }

    private ThoiDiem(double hs, String td){
        this.heSo = hs;
        this.tD = td;
    }

    public double tinhGiaThueSanh(double giaThue){
        return this.heSo*giaThue;
    }
}
