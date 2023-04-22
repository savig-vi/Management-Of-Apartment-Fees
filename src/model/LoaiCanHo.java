package model;

/**
 *
 * @author Vitaliy
 */
public class LoaiCanHo {
    private String maLoaiCanHo;
    private String tenLoaiCanHo;

    public LoaiCanHo() {
    }

    public LoaiCanHo(String maLoaiCanHo, String tenLoaiCanHo) {
        this.maLoaiCanHo = maLoaiCanHo;
        this.tenLoaiCanHo = tenLoaiCanHo;
    }

    public String getMaLoaiCanHo() {
        return maLoaiCanHo;
    }

    public void setMaLoaiCanHo(String maLoaiCanHo) {
        this.maLoaiCanHo = maLoaiCanHo;
    }

    public String getTenLoaiCanHo() {
        return tenLoaiCanHo;
    }

    public void setTenLoaiCanHo(String tenLoaiCanHo) {
        this.tenLoaiCanHo = tenLoaiCanHo;
    }
    
    
}
