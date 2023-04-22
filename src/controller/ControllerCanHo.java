/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitaliy
 */
public class ControllerCanHo {
//    public void ThemCanHo(String MaCanHo, String TenCanHo, String MaToaNha,
//            String MaLoaiCanHo, String DienTich, String PhiQuanLy, String ChuCanHo, String TinhTrang){
//        try {
//            Connection connection = DBConnection.getConnection();
//            String query = "EXEC SP_ThemCanHo ?, ?, ?, ?, ?, ?, ?, ?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, MaCanHo);
//            ps.setString(2, TenCanHo);
//            ps.setString(3, MaToaNha);
//            ps.setString(4, MaLoaiCanHo);
//            ps.setString(5, DienTich);
//            ps.setString(6, PhiQuanLy);
//            ps.setString(7, ChuCanHo);
//            ps.setString(8, TinhTrang);
//            ps.executeUpdate();
//            DBConnection.closeConnection(connection);
//            JOptionPane.showMessageDialog(null, "Bạn đã thêm mới căn hộ thành công!");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void ThemCanHo(){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_ThemCanHo 'CANHO-MOI', 'Căn hộ mới nha', 'A', 'vip', 200, 200, 'chucanho2', 'Dùng như shit'";
            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, MaCanHo);
//            ps.setString(2, TenCanHo);
//            ps.setString(3, MaToaNha);
//            ps.setString(4, MaLoaiCanHo);
//            ps.setString(5, DienTich);
//            ps.setString(6, PhiQuanLy);
//            ps.setString(7, ChuCanHo);
//            ps.setString(8, TinhTrang);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Bạn đã thêm mới căn hộ thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
