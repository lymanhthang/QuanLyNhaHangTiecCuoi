package com.lmt.BaiTapLon;

import java.util.ArrayList;
import java.util.List;

public class QuanLyBanAn {
    private List<BanAn> dSBa = new ArrayList<>();

    public List<BanAn> getdSBa() {
        return dSBa;
    }

    public void setdSBa(List<BanAn> dSBa) {
        this.dSBa = dSBa;
    }

    public double tinhGiaTatCaBanAn(){
        return this.dSBa.stream().mapToDouble(BanAn::tinhGiaBanAn).sum();
    }
}
