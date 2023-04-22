package model;

/**
 *
 * @author Vitaliy
 */
public class ChiTietHoaDon {
    private int maHoaDon;
    private String maDichVu;
    private int soLuong;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maHoaDon, String maDichVu, int soLuong) {
        this.maHoaDon = maHoaDon;
        this.maDichVu = maDichVu;
        this.soLuong = soLuong;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
