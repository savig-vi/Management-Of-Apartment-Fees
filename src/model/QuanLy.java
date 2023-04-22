package model;

/**
 *
 * @author Vitaliy
 */
public class QuanLy {
    private String tenDangNhapQuanLy;
    private String ho;
    private String ten;
    private String tenDangNhap;
    private boolean trangThai;

    public QuanLy() {
    }

    public QuanLy(String tenDangNhapQuanLy, String ho, String ten, String tenDangNhap, boolean trangThai) {
        this.tenDangNhapQuanLy = tenDangNhapQuanLy;
        this.ho = ho;
        this.ten = ten;
        this.tenDangNhap = tenDangNhap;
        this.trangThai = trangThai;
    }

    public String getTenDangNhapQuanLy() {
        return tenDangNhapQuanLy;
    }

    public void setTenDangNhapQuanLy(String tenDangNhapQuanLy) {
        this.tenDangNhapQuanLy = tenDangNhapQuanLy;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
