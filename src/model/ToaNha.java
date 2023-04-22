package model;

/**
 *
 * @author Vitaliy
 */
public class ToaNha {
    private String maToaNha;
    private String tenToaNha;

    public ToaNha() {
    }

    public ToaNha(String maToaNha, String tenToaNha) {
        this.maToaNha = maToaNha;
        this.tenToaNha = tenToaNha;
    }

    public String getMaToaNha() {
        return maToaNha;
    }

    public void setMaToaNha(String maToaNha) {
        this.maToaNha = maToaNha;
    }

    public String getTenToaNha() {
        return tenToaNha;
    }

    public void setTenToaNha(String tenToaNha) {
        this.tenToaNha = tenToaNha;
    }
    
    
}
