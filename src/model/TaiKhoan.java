package model;

/**
 *
 * @author Vitaliy
 */
public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    private String maQuyen;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDangNhap, String matKhau, String maQuyen) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.maQuyen = maQuyen;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }
   
}
