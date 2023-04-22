package model;

/**
 *
 * @author Vitaliy
 */
public class Quyen {
    private String maQuyen;
    private String tenQuyen;
    private String ghiChu;

    public Quyen() {
    }

    public Quyen(String maQuyen, String tenQuyen, String ghiChu) {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
        this.ghiChu = ghiChu;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
