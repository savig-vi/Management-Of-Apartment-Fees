/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;



/**
 *
 * @author Vitaliy
 */
public class ControllerToaNha {
    public void SuaToaNha(String maToaNha, String tenToaNha){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_SuaToaNha ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maToaNha);
            ps.setString(2, tenToaNha);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Bạn đã sửa thành kum rồi nhé!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ThemToaNha(String maToaNha, String tenToaNha){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_ThemToaNha ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, maToaNha);
            ps.setString(2, tenToaNha);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Bạn đã thêm mới tòa nhà thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
