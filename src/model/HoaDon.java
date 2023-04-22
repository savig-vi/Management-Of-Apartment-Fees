package model;

import java.util.Date;

/**
 *
 * @author Vitaliy
 */
public class HoaDon {
    private int maHoaDon;
    private String maCanHo;
    private Date ngayLapHoaDon;
    private Date ngayThanhToan;
    private int tongTien;
    private boolean trangThai;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, String maCanHo, Date ngayLapHoaDon, Date ngayThanhToan, int tongTien, boolean trangThai) {
        this.maHoaDon = maHoaDon;
        this.maCanHo = maCanHo;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaCanHo() {
        return maCanHo;
    }

    public void setMaCanHo(String maCanHo) {
        this.maCanHo = maCanHo;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    
}
