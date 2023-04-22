package model;

/**
 *
 * @author Vitaliy
 */
public class DichVu {
    private String maDichVu;
    private String tenDichVu;
    private int donGia;

    public DichVu() {
    }

    public DichVu(String maDichVu, String tenDichVu, int donGia) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.donGia = donGia;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    
    
}
