package com.lmt.BaiTapLon;
import com.lmt.BaiTapLon.CauHinh;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        QuanLyNhaHang qLNH = new QuanLyNhaHang();
        Boolean flag = true;
        while (flag) {
            System.out.print(
                    "=== QUAN LY NHA HANG TIEC CUOI ===\n1. Quan ly sanh cuoi\n2. Quan ly dich vu\n3. Quan ly thuc don\n4. Quan ly bua tiec\n5. Thoat\nLua chon: ");
            switch (Integer.parseInt(CauHinh.sc.nextLine())) {
                case 1 -> {
                    Boolean fsc = true;
                    while (fsc) {
                        System.out.print(
                                "1. Them sanh cuoi\n2. Xoa sanh cuoi\n3. Tra cuu\n4. Hien thi danh sach sanh cuoi\n5. Sap xep sanh cuoi theo tan suat\n6. Thoat\nLua chon: ");
                        switch (Integer.parseInt(CauHinh.sc.nextLine())) {
                            case 1 -> qLNH.themSanhCuoi();
                            case 2 -> {
                                if (qLNH.getqLSc().getSc(0) != null) {
                                    qLNH.getqLSc().hienThi();
                                    System.out.print("Nhap sanh muon xoa: ");
                                    String sC = CauHinh.sc.nextLine();
                                    qLNH.getqLSc().xoaSc(sC);
                                }
                            }
                            case 3 -> {
                                System.out.print("Nhap tu khoa: "); // ma sanh cuoi, ten sach cuoi, suc chua
                                String sC = CauHinh.sc.nextLine();
                                List<SanhCuoi> tK = new ArrayList<>();
                                try {
                                    tK = qLNH.getqLSc().timKiem(Integer.parseInt(sC));
                                } catch (Exception e) {
                                    tK = qLNH.getqLSc().timKiem(sC);
                                }
                                tK.forEach(s -> s.hienThi());
                            }
                            case 4 -> {
                                qLNH.getqLSc().hienThi();
                            }
                            case 5 -> {
                                System.out.print(
                                        "1. Sap xep theo tan so su dung\n2. Sap xep theo tan so su dung dua vao nam\nLua chon: ");
                                switch (Integer.parseInt(CauHinh.sc.nextLine())) {
                                    case 1 -> {
                                        qLNH.sapXepSanhCuoi();
                                    }
                                    case 2 -> {
                                        System.out.print("Nhap nam: ");
                                        qLNH.sapXepSanhCuoi(Integer.parseInt(CauHinh.sc.nextLine()));
                                    }
                                }
                            }
                            case 6 -> {
                                fsc = false;
                            }
                        }
                    }

                }
                case 2 -> {
                    Boolean fdv = true;
                    while (fdv) {
                        System.out.print(
                                "1. Them dich vu\n2. Xoa dich vu\n3. Tra cuu theo ten\n4. Hien thi danh sach dich vu\n5. Thoat\nLua chon: ");
                        switch (Integer.parseInt(CauHinh.sc.nextLine())) {
                            case 1 -> {
                                System.out.print("1. Nhap dich vu\n2. Them tu file\nLua chon: ");
                                int lc = Integer.parseInt(CauHinh.sc.nextLine());
                                if (lc == 1) {
                                    qLNH.themDichVu();
                                } else if (lc == 2) {
                                    System.out.print("Nhap duong dan: ");
                                    qLNH.themDichVuTuFile(CauHinh.sc.nextLine());
                                }
                            }
                            case 2 -> {
                                System.out.print("Nhap ten dich vu: ");
                                qLNH.getqLDv().xoaDv(CauHinh.sc.nextLine());
                            }
                            case 3 -> {
                                List<DV> tK = new ArrayList<>();
                                System.out.print("Nhap ten dich vu: ");
                                tK = qLNH.getqLDv().timKiem(CauHinh.sc.nextLine());
                                tK.forEach(t -> t.hienThi());
                            }
                            case 4 -> {
                                qLNH.getqLDv().hienThi();
                            }
                            case 5 -> {
                                fdv = false;
                            }
                        }
                    }
                }
                case 3 -> {
                    Boolean ftd = true;
                    while (ftd) {
                        System.out
                                .print("1. Them thuc don\n2. Xoa thuc don\n3. Hien thi thuc don\n4. Thoat\nLua chon: ");
                        switch (Integer.parseInt(CauHinh.sc.nextLine())) {
                            case 1 -> {
                                System.out.print("1. Them tu file\n2. Nhap thuc don\nLua chon: ");
                                int lc = Integer.parseInt(CauHinh.sc.nextLine());
                                if (lc == 1) {
                                    System.out.print("Nhap duong dan: ");
                                    qLNH.themThucDon(CauHinh.sc.nextLine());
                                } else if (lc == 2) {
                                    ThucDon tD = new ThucDon();
                                    Boolean next = true;
                                    while (next) {
                                        System.out.print("1. Them thuc an\n2. Them thuc uong\n3. Thoat\nLua chon: ");
                                        int lc1 = Integer.parseInt(CauHinh.sc.nextLine());
                                        if (lc1 == 1) {
                                            tD.them1Tp("ThucAn");
                                        } else if (lc1 == 2) {
                                            tD.them1Tp("ThucUong");
                                        } else {
                                            next = false;
                                        }
                                    }
                                    qLNH.getqLTd().themTd(tD);
                                }
                            }
                            case 2 -> {
                                qLNH.getqLTd().hienThi();
                                System.out.print("Nhap thuc don muon xoa: ");
                                qLNH.getqLTd().xoaTd(Integer.parseInt(CauHinh.sc.nextLine()));
                            }
                            case 3 -> {
                                qLNH.getqLTd().hienThi();
                            }
                            case 4 -> ftd = false;
                        }
                    }
                }
                case 4 -> {
                    Boolean fbt = true;
                    while (fbt) {
                        System.out.print(
                                "1. Them bua tiec\n2. Xoa bua tiec\n3. Hien thi danh sach bua tiec\n4. Xuat hoa don\n5. Bao cao doanh thu\n6. Thoat\nLua chon: ");
                        switch (Integer.parseInt(CauHinh.sc.nextLine())) {
                            case 1 -> {
                                qLNH.themBuaTiec();
                            }
                            case 2 -> {
                                System.out.print("Xoa: ");
                                String t = CauHinh.sc.nextLine();
                                try {
                                    qLNH.getqLBt().xoaBt(Integer.parseInt(t));
                                } catch (Exception e) {
                                    qLNH.getqLBt().xoaBt(t);
                                }
                            }
                            case 3 -> {
                                qLNH.getqLBt().hienThi();
                            }
                            case 4 -> {
                                System.out.print("Nhap ten bua tiec: ");
                                qLNH.getqLBt().getBuaTiec(CauHinh.sc.nextLine()).xuatHoaDon();
                            }
                            case 5 -> {
                                System.out.print("1. Doanh thu theo thang\n2. Doanh thu theo quy\nLua chon: ");
                                if(Integer.parseInt(CauHinh.sc.nextLine()) == 1){
                                    System.out.print("Nhap thang: ");
                                    qLNH.baoCaoDoanhThu(Month.of(Integer.parseInt(CauHinh.sc.nextLine())));
                                }else {
                                    System.out.print("Nhap quy: ");
                                    qLNH.baoCaoDoanhThu(Integer.parseInt(CauHinh.sc.nextLine()));
                                }
                            }
                            case 6 -> fbt = false;

                        }
                    }

                }
                case 5 -> flag = false;
            }
        }
    }
}
