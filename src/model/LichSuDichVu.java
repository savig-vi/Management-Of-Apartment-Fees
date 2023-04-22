package model;

import java.util.Date;

/**
 *
 * @author Vitaliy
 */
public class LichSuDichVu {
    private String maDichVu;
    private Date ngayHieuLuc;
    private int donGia;

    public LichSuDichVu() {
    }

    public LichSuDichVu(String maDichVu, Date ngayHieuLuc, int donGia) {
        this.maDichVu = maDichVu;
        this.ngayHieuLuc = ngayHieuLuc;
        this.donGia = donGia;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public Date getNgayHieuLuc() {
        return ngayHieuLuc;
    }

    public void setNgayHieuLuc(Date ngayHieuLuc) {
        this.ngayHieuLuc = ngayHieuLuc;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}
