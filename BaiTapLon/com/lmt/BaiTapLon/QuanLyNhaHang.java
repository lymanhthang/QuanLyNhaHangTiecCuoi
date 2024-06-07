package com.lmt.BaiTapLon;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyNhaHang {
    private QuanLySanhCuoi qLSc = new QuanLySanhCuoi();
    private QuanLyDichVu qLDv = new QuanLyDichVu();
    private QuanLyBuaTiec qLBt = new QuanLyBuaTiec();
    private QuanLyThucDon qLTd = new QuanLyThucDon();

    public QuanLyBuaTiec getqLBt() {
        return qLBt;
    }

    public void setqLBt(QuanLyBuaTiec qLBt) {
        this.qLBt = qLBt;
    }

    public QuanLySanhCuoi getqLSc() {
        return qLSc;
    }

    public void setqLSc(QuanLySanhCuoi qLSc) {
        this.qLSc = qLSc;
    }

    public QuanLyDichVu getqLDv() {
        return qLDv;
    }

    public void setqLDv(QuanLyDichVu qLDv) {
        this.qLDv = qLDv;
    }

    public QuanLyThucDon getqLTd() {
        return qLTd;
    }

    public void setqLTd(QuanLyThucDon qLTd) {
        this.qLTd = qLTd;
    }

    public void themSanhCuoi() {
        System.out.println("=== THEM SANH CUOI ===");
        SanhCuoi sanhCuoi = new SanhCuoi();
        sanhCuoi.nhapSc();
        this.qLSc.themSc(sanhCuoi);
    }

    public void themDichVu() {
        System.out.println("=== THEM DICH VU ===");
        System.out.print(
                "Chon loai dich vu:\n1. Dich vu trang tri\n2. Dich vu Karaoke\n3. Dich vu thue ca si\nLua chon: ");

        switch (CauHinh.sc.nextLine()) {
            case "1" -> {
                DV dv = new DvTrangTri();
                dv.nhap();
                this.qLDv.themDv(dv);
                break;
            }
            case "2" -> {
                DV dv = new DvKaraoke();
                dv.nhap();
                this.qLDv.themDv(dv);
                break;
            }
            case "3" -> {
                DV dv = new DvThueCaSi();
                dv.nhap();
                this.qLDv.themDv(dv);
                break;
            }
        }
    }

    public void themDichVuTuFile(String path) {
        this.qLDv.themDvTuFile(path);
    }

    public void themThucDon(String path) {
        System.out.println("=== THEM THUC DON ===");
        ThucDon thDon = new ThucDon();
        thDon.themTpTuFile(path);
        this.qLTd.themTd(thDon);
    }

    public void themBuaTiec() {
        System.out.println("=== THEM BUA TIEC ===");
        BuaTiec bT = new BuaTiec();
        System.out.print("Ten bua tiec: ");
        bT.setTen(CauHinh.sc.nextLine());
        System.out.println("===> Chon sanh cuoi:");
        this.qLSc.hienThi();
        System.out.print("Lua chon: ");
        bT.setsC(this.qLSc.getSc(Integer.parseInt(CauHinh.sc.nextLine()) - 1));
        for (int i = 0; i < bT.getsC().getSucChua(); i++) {
            System.out.printf("===> Chon thuc don cho ban %d:\n", i + 1);
            this.qLTd.hienThi();
            System.out.print("Lua chon: ");
            // bT.getsC().themThucDon(this.qLTd.getThucDon(Integer.parseInt(CauHinh.sc.nextLine())));
            bT.getQlba().getdSBa().add(new BanAn(this.qLTd.getThucDon(Integer.parseInt(CauHinh.sc.nextLine()))));
        }

        System.out.print("===> Chon thoi diem:\n1. Sang\n2. Chieu\n3. Toi\nLua chon: ");
        int choice = Integer.parseInt(CauHinh.sc.nextLine());
        switch (choice) {
            case 1 -> bT.setThDiem(ThoiDiem.SANG);
            case 2 -> bT.setThDiem(ThoiDiem.CHIEU);
            case 3 -> bT.setThDiem(ThoiDiem.TOI);
        }
        System.out.print("Ngay: ");
        bT.setNgayThue(LocalDate.parse(CauHinh.sc.nextLine(), CauHinh.dmy));

        QuanLyDichVu qldv = new QuanLyDichVu();
        System.out.println("===> Chon dich vu:");
        Boolean flag = true;
        while (flag) {
            this.qLDv.hienThi();
            System.out.print("Lua chon: ");
            qldv.themDv(this.qLDv.getDv(Integer.parseInt(CauHinh.sc.nextLine())-1));
            System.out.print("Them dich vu khac (y/n): ");
            if (!CauHinh.sc.nextLine().equals("y")) {
                flag = false;
            }
        }
        bT.setQldv(qldv);

        this.qLBt.themBuaTiec(new BuaTiec(bT.getTen(), bT.getsC(), bT.getThDiem(), bT.getNgayThue().format(CauHinh.dmy),
                bT.getQldv(), bT.getQlba()));
    }

    public void sapXepSanhCuoi() {
        QuanLySanhCuoi qlsc = new QuanLySanhCuoi();
        qlsc = this.qLSc;
        qlsc.sapXep();
        qlsc.hienThi();
    }

    public void sapXepSanhCuoi(int nam) {
        List<BuaTiec> bt1 = new ArrayList<>();
        bt1 = this.qLBt.getdSBt().stream().filter(t -> t.getNgayThue().getYear() == nam).collect(Collectors.toList());

        bt1.sort(null);

        List<SanhCuoi> sc1 = new ArrayList<>();
        sc1.add(bt1.get(0).getsC());
        for (int i = 1; i < bt1.size(); i++) {
            if (!(bt1.get(i).getsC().getMaSc().equals(bt1.get(i - 1).getsC().getMaSc()))) {
                sc1.add(bt1.get(i).getsC());
            }
        }
        QuanLySanhCuoi qlsc = new QuanLySanhCuoi();
        qlsc.setdSSc(sc1);
        qlsc.sapXep();
        qlsc.hienThi();
    }

    public double baoCaoDoanhThu(Month th) {
        QuanLyBuaTiec qlbt = new QuanLyBuaTiec();
        qlbt.setdSBt(this.qLBt.getdSBt().stream().filter(t -> t.getNgayThue().getYear() == LocalDate.now().getYear())
                .filter(t1 -> t1.getNgayThue().getMonth().equals(th)).collect(Collectors.toList()));
        for (int i = 0; i < qlbt.getdSBt().size(); i++) {
            System.out.printf("Ten bua tiec: %s\nDoanh thu: %.1f\n", qlbt.getBuaTiec(i).getTen(),
                    qlbt.getBuaTiec(i).getDonGia());
        }
        System.out.printf("Tong doanh thu thang %d: %.1f\n", th.getValue(), qlbt.tinhDoanhThu());
        return qlbt.tinhDoanhThu();
    }

    public void baoCaoDoanhThu(int quy) {
        int startMonth = (quy - 1) * 3 + 1;
        int endMonth = startMonth + 2;

        double sum = 0;
        for (int i = startMonth; i <= endMonth; i++) {
            sum += this.baoCaoDoanhThu(Month.of(i));
        }

        System.out.printf("Doanh thu quy %d: %.1f\n", quy, sum);
    }
}
