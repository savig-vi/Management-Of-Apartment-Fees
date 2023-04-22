package model;

/**
 *
 * @author Vitaliy
 */
public class CanHo {
    private String maCanHo;
    private String tenCanHo;
    private String maToaNha;
    private String maLoaiCanHo;
    private int dienTich;
    private int phiQuanLy;
    private String chuCanHo;

    public CanHo() {
    }

    public CanHo(String maCanHo, String tenCanHo, String maToaNha, String maLoaiCanHo, int dienTich, int phiQuanLy, String chuCanHo) {
        this.maCanHo = maCanHo;
        this.tenCanHo = tenCanHo;
        this.maToaNha = maToaNha;
        this.maLoaiCanHo = maLoaiCanHo;
        this.dienTich = dienTich;
        this.phiQuanLy = phiQuanLy;
        this.chuCanHo = chuCanHo;
    }

    public String getMaCanHo() {
        return maCanHo;
    }

    public void setMaCanHo(String maCanHo) {
        this.maCanHo = maCanHo;
    }

    public String getTenCanHo() {
        return tenCanHo;
    }

    public void setTenCanHo(String tenCanHo) {
        this.tenCanHo = tenCanHo;
    }

    public String getMaToaNha() {
        return maToaNha;
    }

    public void setMaToaNha(String maToaNha) {
        this.maToaNha = maToaNha;
    }

    public String getMaLoaiCanHo() {
        return maLoaiCanHo;
    }

    public void setMaLoaiCanHo(String maLoaiCanHo) {
        this.maLoaiCanHo = maLoaiCanHo;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getPhiQuanLy() {
        return phiQuanLy;
    }

    public void setPhiQuanLy(int phiQuanLy) {
        this.phiQuanLy = phiQuanLy;
    }

    public String getChuCanHo() {
        return chuCanHo;
    }

    public void setChuCanHo(String chuCanHo) {
        this.chuCanHo = chuCanHo;
    }
            
    
}
