/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DBConnection;
import dao.ShareData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import model.TaiKhoanTemp;
import view.FrmAdminTrangChu;
import view.FrmQuanLyTrangChu;

/**
 *
 * @author Vitaliy
 */
public class ControllerDangNhap {

    public boolean kiemTraDangNhap(String tenDangNhap, String matKhau, JFrame frame) {
        boolean ketQua = false;
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_DanhSachTaiKhoanQuanLy ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TaiKhoanTemp taiKhoanTemp = new TaiKhoanTemp();
                taiKhoanTemp.setTenDangNhap(rs.getString("TenDangNhapQuanLy"));
                taiKhoanTemp.setMatKhau(rs.getString("MatKhau"));
                if(taiKhoanTemp.getTenDangNhap().equals(tenDangNhap) && taiKhoanTemp.getMatKhau().equals(matKhau)){
                    FrmQuanLyTrangChu frmQuanLyTrangChu = new FrmQuanLyTrangChu();
                    frame.dispose();
                    frmQuanLyTrangChu.setVisible(true);
                    DBConnection.closeConnection(connection);
                    ketQua = true;
                }
            }
            DBConnection.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public boolean KiemTraDangNhapAdmin(String TenDangNhap, String MatKhau, JFrame frame){
        boolean ketQua = false;
        try {
            String tenDangNhap ="";
            String matKhau = "";
            Connection connection = DBConnection.getConnection();
            String query = "SELECT TK.TenDangNhap, TK.MatKhau, TK.MaQuyen FROM dbo.TaiKhoan TK WHERE TK.MaQuyen = 'admin'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tenDangNhap = rs.getString("TenDangNhap");
                matKhau = rs.getString("MatKhau");
                if((TenDangNhap.equals(tenDangNhap)) && (MatKhau.equals(matKhau))){
                    FrmAdminTrangChu frmAdmin = new FrmAdminTrangChu();
                    frmAdmin.setVisible(true);
                    frame.dispose();
                    DBConnection.closeConnection(connection);
                    ketQua = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
