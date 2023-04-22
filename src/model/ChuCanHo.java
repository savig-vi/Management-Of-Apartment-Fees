package model;

/**
 *
 * @author Vitaliy
 */
public class ChuCanHo {
    private String tenDangNhapChuCanHo;
    private String ho;
    private String ten;
    private String tenDangNhap;
    private boolean trangThai;

    public ChuCanHo() {
    }

    public ChuCanHo(String tenDangNhapChuCanHo, String ho, String ten, String tenDangNhap, boolean trangThai) {
        this.tenDangNhapChuCanHo = tenDangNhapChuCanHo;
        this.ho = ho;
        this.ten = ten;
        this.tenDangNhap = tenDangNhap;
        this.trangThai = trangThai;
    }

    public String getTenDangNhapChuCanHo() {
        return tenDangNhapChuCanHo;
    }

    public void setTenDangNhapChuCanHo(String tenDangNhapChuCanHo) {
        this.tenDangNhapChuCanHo = tenDangNhapChuCanHo;
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
