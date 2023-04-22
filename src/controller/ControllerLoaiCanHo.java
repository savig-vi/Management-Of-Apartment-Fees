/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitaliy
 */
public class ControllerLoaiCanHo {
    public void ThemLoaiCanHo(String maLoaiCanHo, String tenLoaiCanHo) {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_ThemLoaiCanHo ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maLoaiCanHo);
            ps.setString(2, tenLoaiCanHo);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Bạn đã thêm mới loại căn hộ thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SuaLoaiCanHo(String maLoaiCanHo, String tenLoaiCanHo) {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_SuaLoaiCanHo ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maLoaiCanHo);
            ps.setString(2, tenLoaiCanHo);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Bạn đã sửa loại căn hộ thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public ArrayList LayDanhSachLoaiCanHo() {
//        ArrayList arr = new ArrayList();
//        Connection connection = DBConnection.getConnection();
//        String query = "SELECT * FROM LoaiCanHo";
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()){
//                arr.add(loaiCanHo = new LoaiCanHo(rs.getString(1), rs.getString(2)));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return arr;
//    }
}
