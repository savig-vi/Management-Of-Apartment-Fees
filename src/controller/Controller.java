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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.CanHo;
import model.ChiTietHoaDon;
import model.ChuCanHo;
import model.DichVu;
import model.HoaDon;
import model.LichSuDichVu;
import model.LoaiCanHo;
import model.QuanLy;
import model.Quyen;
import model.TaiKhoan;
import model.TaiKhoanTemp;
import model.ToaNha;
import view.FrmAdminTrangChu;
import view.FrmQuanLyTrangChu;

/**
 *
 * @author Vitaliy
 */
public class Controller {
    private CanHo canHo;
    private ChiTietHoaDon chiTietHoaDon;
    private ChuCanHo chuCanHo;
    private DichVu dichVu;
    private HoaDon hoaDon;
    private LichSuDichVu lichSuDichVu;
    private LoaiCanHo loaiCanHo;
    private QuanLy quanLy;
    private Quyen quyen;
    private TaiKhoan taiKhoan;
    private ToaNha toaNha;
    
    //TÀI KHOẢN!
    
    public void TaoTaiKhoan(String TenDangNhap, String MatKhau, int MaQuyen){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_TaoTaiKhoan ?, ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, TenDangNhap);
            ps.setString(2, MatKhau);
            ps.setInt(3, MaQuyen);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void TaoTaiKhoanQuanLy(String TenDangNhapQuanLy, String Ho, String Ten, String TenDangNhap){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_TaoTaiKhoanQuanly ?, ?, ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, TenDangNhapQuanLy);
            ps.setString(2, Ho);
            ps.setString(3, Ten);
            ps.setString(4, TenDangNhap);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void TaoTaiKhoanChuCanHo(String TenDangNhapChuCanHo, String Ho, String Ten, String TenDangNhap){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_TaoTaiKhoanChuCanHo ?, ?, ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, TenDangNhapChuCanHo);
            ps.setString(2, Ho);
            ps.setString(3, Ten);
            ps.setString(4, TenDangNhap);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean KiemTraTaiKhoanQuanLyTonTai(String TenDangNhap){
        boolean check = false;
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT TenDangNhapQuanLy FROM dbo.QuanLy";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(TenDangNhap == rs.getString("TenDangNhapQuanLy")) check = true;
            }
            DBConnection.closeConnection(connection);
        } catch (Exception e) {
        }
        return check;
    }
    
    public boolean KiemTraTaiKhoanChuCanHoTonTai(String TenDangNhap){
        boolean check = false;
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT TenDangNhapChuCanHo FROM dbo.ChuCanHo";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(TenDangNhap == rs.getString("TenDangNhapChuCanHo")) check = true;
            }
            DBConnection.closeConnection(connection);
        } catch (Exception e) {
        }
        return check;
    }
    
    public void XoaTaiKhoan(String TenDangNhap){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "DELETE FROM dbo.TaiKhoan WHERE TenDangNhap = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, TenDangNhap);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int TongSoTaiKhoan(){
        int i = 0;
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT COUNT(*) AS 'TongSoTaiKhoan' FROM dbo.TaiKhoan";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                i = Integer.parseInt(rs.getString("TongSoTaiKhoan"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    
    public void TaoTaiKhoanQuanLy(){
        
    }
    
    public void TaoTaiKhoanChuCanHo(){
        
    }
    
    // ĐĂNG NHẬP!
    public int KiemTraDangNhapAdmin(String TenDangNhap, String MatKhau, JFrame frame){
        int i = 0;
        try {
            String tenDangNhap ="";
            String matKhau = "";
            Connection connection = DBConnection.getConnection();
            String query = "SELECT dbo.Function_KiemTraAdmin(?, ?) AS MaQuyen";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, TenDangNhap);
            ps.setString(2, MatKhau);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                i = rs.getInt("MaQuyen");
            }
            DBConnection.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    
    public int KiemTraDangNhapQuanLyVaChuCanHo(String TenDangNhap, String MatKhau, JFrame jFrame){
        int i = 0;
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT dbo.Function_KiemTraQuanlyVaChuCanHo(?, ?) AS MaQuyen";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, TenDangNhap);
            ps.setString(2, MatKhau);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                i = rs.getInt("MaQuyen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    
    // LOẠI CĂN HỘ!
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
            JOptionPane.showMessageDialog(null, "Lỗi rồi, không thêm được loại căn hộ này đâu!");
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
    
    public void XoaLoaiCanHo(String MaLoaiCanHo){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_XoaLoaiCanHo ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaLoaiCanHo);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Xóa loại căn hộ thành công rồi nhé!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không xóa được loại căn hộ này đâu");
        }
    }
    
    // TÒA NHÀ!
    
    
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
    
    public void XoaToaNha(String MaToaNha){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_XoaToaNha ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaToaNha);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Xóa tòa nhà thành công rồi nhé!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa Tòa Nhà này không được bro!");
        }
    }
    
    // CĂN HỘ!
    public void ThemCanHo(String MaCanHo, String TenCanHo, String MaToaNha, String MaLoaiCanHo,
            int DienTich, String ChuCanHo, String GhiChu){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_ThemCanHo ?, ?, ?, ?, ?, ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaCanHo);
            ps.setString(2, TenCanHo);
            ps.setString(3, MaToaNha);
            ps.setString(4, MaLoaiCanHo);
            ps.setInt(5, DienTich);
            ps.setString(6, ChuCanHo);
            ps.setString(7, GhiChu);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Bạn đã thêm mới căn hộ thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi rồi mày! Không thêm được đâu!");
        }
    }
    
    public void SuaCanHo(String MaCanHo, String TenCanHo, String MaToaNha, String MaLoaiCanHo,
            int DienTich, String ChuCanHo, String GhiChu){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_SuaCanHo ?, ?, ?, ?, ?, ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaCanHo);
            ps.setString(2, TenCanHo);
            ps.setString(3, MaToaNha);
            ps.setString(4, MaLoaiCanHo);
            ps.setInt(5, DienTich);
            ps.setString(6, ChuCanHo);
            ps.setString(7, GhiChu);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Bạn đã sửa loại căn hộ thành công!");
        } catch (Exception e) {
        }
    }
    
    public void XoaCanHo(String MaCanHo){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_XoaCanHo ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaCanHo);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Xóa Căn Hộ thành công rồi nhé!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xóa căn hộ này không được đâu!");
        }
    }
    
    // DỊCH VỤ!
    public void ThemDichVu(String MaDichVu, String TenDichVu, int DonGia){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_ThemDichVu ?, ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaDichVu);
            ps.setString(2, TenDichVu);
            ps.setInt(3, DonGia);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Bạn đã thêm mới dịch vụ thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi rồi, không thêm được cái này!");
        }
    }
    
    public void SuaDichVu(String MaDichVu, String TenDichVu, int DonGia){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_SuaDichVu ?, ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaDichVu);
            ps.setString(2, TenDichVu);
            ps.setInt(3, DonGia);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Sửa dịch vụ thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi rồi không sửa được cái này!");
        }
    }
    
    // HÓA ĐƠN!
    public void DanhSachHoaDonChuaThanhToan(){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_DanhSachHoaDonChuaThanhToan";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeQuery();
            DBConnection.closeConnection(connection);
//            JOptionPane.showMessageDialog(null, "HIỂN THỊ DANH SÁCH HOA ĐƠN CHƯA THANH TOÁN THÀNH CÔNG!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void DanhSachHoaDonDaThanhToan(){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_DanhSachHoaDonDaThanhToan";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeQuery();
            DBConnection.closeConnection(connection);
//            JOptionPane.showMessageDsialog(null, "HIỂN THỊ DANH SÁCH HOA ĐƠN ĐÃ THANH TOÁN THÀNH CÔNG!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ThanhToanHoaDon(String MaHoaDon){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_ThanhToanHoaDon ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaHoaDon);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Thanh toán hóa đơn thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi thanh toán hóa đơn");
        }
    }
    
    public int TongSoHoaDon(){
        int i = 0;
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT COUNT(*) AS 'TongSoHoaDon' FROM dbo.HoaDon";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                i = Integer.parseInt(rs.getString("TongSoHoaDon"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public void ThemHoaDon(String MaHoaDon, String MaCanHo, String NgayLapHoaDon){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_ThemHoaDon ?, ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaHoaDon);
            ps.setString(2, MaCanHo);
            ps.setString(3, NgayLapHoaDon);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public void TraCuuHoaDonTheoThangNam(int Thang, int Nam){
//        try {
//            Connection connection = DBConnection.getConnection();
//            String query = "EXEC SP_TraCuuHoaDonTheoThangNam ?, ?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, Thang);
//            ps.setInt(2, Nam);
//            ps.executeQuery();
//            DBConnection.closeConnection(connection);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    // CHI TIẾT HÓA ĐƠN!
//    public void ThemChiTietHoaDon(String MaHoaDon, String MaDichVu, int SoLuong){
//        try {
//            Connection connection = DBConnection.getConnection();
//            String query = "EXEC SP_ThemChiTietHoaDon ?, ?, ?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, MaHoaDon);
//            ps.setString(2, MaDichVu);
//            ps.setInt(3, SoLuong);
//            ps.executeUpdate();
//            DBConnection.closeConnection(connection);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void ThemChiTietHoaDon(String MaHoaDon, String MaDichVu, String SoLuong){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_ThemChiTietHoaDon ?, ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaHoaDon);
            ps.setString(2, MaDichVu);
            ps.setString(3, SoLuong);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
            DBConnection.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi không thêm được chi tiết hóa đơn");
        }
    }
    
    public void SuaChiTietHoaDon(String MaHoaDon, String MaDichVu, int SoLuong){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_SuaChiTietHoaDon ?, ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaHoaDon);
            ps.setString(2, MaDichVu);
            ps.setInt(3, SoLuong);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Sửa dịch vụ thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không sửa được cái này đâu");
        }
    }
    
    public void XoaChiTietHoaDon(String MaHoaDon, String MaDichVu){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_XoaChiTietHoaDon ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaHoaDon);
            ps.setString(2, MaDichVu);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không xóa được!");
        }
    }
}