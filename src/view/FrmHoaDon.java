/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import dao.DBConnection;
import dao.ShareData;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ComboboxValue;
import model.LuuTruTam;

/** 
 *
 * @author Vitaliy
 */
public class FrmHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form FrmHoaDon
     */
    controller.Controller ctl = new Controller();
    String MaHoaDon = "";
    String MaCanHo = "";
    float TongTien=0;
    public FrmHoaDon() {
        initComponents();
        DoCanHoVaoCombobox();
        DoDichVuVaoCombobox();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    
    public void DoCanHoVaoCombobox(){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT * FROM CanHo";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbCanHo.getModel();
            cbbModel.removeAllElements();

            while (rs.next()) {
                String MaCanHo = rs.getString("MaCanHo");
                String TenCanHo = rs.getString("TenCanHo");

                ComboboxValue mycbb = new ComboboxValue(MaCanHo, TenCanHo);
                cbbModel.addElement(mycbb);
            }
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Đổ danh sách căn hộ vào combobox thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi đổ danh sách căn hộ vào combobox");
        }
    }
    public void DoDichVuVaoCombobox(){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT * FROM DichVu";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbDichVu.getModel();
            cbbModel.removeAllElements();
            
            while (rs.next()) {
                String MaDichVu = rs.getString("MaDichVu");
                String TenDichVu = rs.getString("TenDichVu");

                ComboboxValue mycbb = new ComboboxValue(MaDichVu, TenDichVu);
                cbbModel.addElement(mycbb);
            }
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Đổ danh sách dịch vụ thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showHoaDonChuaThanhToan(){
        try {
            tblResult.removeAll();
            String[] column = {"MÃ HÓA ĐƠN", "MÃ CĂN HỘ", "TÊN CĂN HỘ", "NGÀY LẬP HÓA ĐƠN", 
            "NGÀY THANH TOÁN HÓA ĐƠN", "TỔNG TIỀN"};
            DefaultTableModel model = new DefaultTableModel(column, 0);
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_DanhSachHoaDonChuaThanhToan";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString("MaHoaDon"));
                vector.add(rs.getString("MaCanHo"));
                vector.add(rs.getString("TenCanHo"));
                vector.add(rs.getString("NgayLapHoaDon"));
                vector.add(rs.getString("NgayThanhToanHoaDon"));
                vector.add(rs.getString("TongTien"));
                model.addRow(vector);
            }
            DBConnection.closeConnection(connection);
            tblResult.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showHoaDonDaThanhToan(){
        try {
            tblResult.removeAll();
            String[] column = {"MÃ HÓA ĐƠN", "MÃ CĂN HỘ", "TÊN CĂN HỘ", "NGÀY LẬP HÓA ĐƠN", 
            "NGÀY THANH TOÁN HÓA ĐƠN", "TỔNG TIỀN"};
            DefaultTableModel model = new DefaultTableModel(column, 0);
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_DanhSachHoaDonDaThanhToan";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString("MaHoaDon"));
                vector.add(rs.getString("MaCanHo"));
                vector.add(rs.getString("TenCanHo"));
                vector.add(rs.getString("NgayLapHoaDon"));
                vector.add(rs.getString("NgayThanhToanHoaDon"));
                vector.add(rs.getString("TongTien"));
                model.addRow(vector);
            }
            DBConnection.closeConnection(connection);
            tblResult.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showChiTietHoaDon(String MaHoaDon){
        float tongTien = 0;
        try {
            tblResultDlg.removeAll();
            String[] column = {"MÃ DỊCH VỤ", "SỐ LƯỢNG", "TỔNG TIỀN"};
            DefaultTableModel model = new DefaultTableModel(column, 0);
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_HienThiChiTietHoaDon ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, MaHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString("MaDichVu"));
                vector.add(rs.getString("SoLuong"));
                vector.add(rs.getString("TongTien"));
                tongTien += Float.parseFloat(rs.getString("TongTien"));
                labelTongTienHoaDon.setText(String.valueOf(tongTien));
                model.addRow(vector);
            }
            DBConnection.closeConnection(connection);
            tblResultDlg.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void showTraCuuHoaDonThangNam(int Thang, int Nam){
        try {
            tblResult.removeAll();
            String[] column = {"MÃ HÓA ĐƠN", "MÃ CĂN HỘ", "TÊN CĂN HỘ", "NGÀY LẬP HÓA ĐƠN", 
            "NGÀY THANH TOÁN HÓA ĐƠN", "TỔNG TIỀN"};
            DefaultTableModel model = new DefaultTableModel(column, 0);
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_TraCuuHoaDonTheoThangNam ?, ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, Thang);
            ps.setInt(2, Nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString("MaHoaDon"));
                vector.add(rs.getString("MaCanHo"));
                vector.add(rs.getString("TenCanHo"));
                vector.add(rs.getString("NgayLapHoaDon"));
                vector.add(rs.getString("NgayThanhToanHoaDon"));
                vector.add(rs.getString("TongTien"));
                model.addRow(vector);
            }
            DBConnection.closeConnection(connection);
            tblResult.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        DlgChiTietHoaDon = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfSoLuongDlg = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultDlg = new javax.swing.JTable();
        btnThemChiTietHoaDonDlg = new javax.swing.JButton();
        btnQuayLaiDlg = new javax.swing.JButton();
        btnLamMoiDlg = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        labelTongTienHoaDon = new javax.swing.JLabel();
        labelMaHoaDon = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelMaCanHo = new javax.swing.JLabel();
        cbbDichVu = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();
        btnHoaDonDaThanhToan = new javax.swing.JButton();
        btnHoaDonChuaThanhToan = new javax.swing.JButton();
        labelTieuDe = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        btnThemChiTietHoaDon = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnThemHoaDon = new javax.swing.JButton();
        tfThang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNam = new javax.swing.JTextField();
        btnTraCuuHoaDonThangNam = new javax.swing.JButton();
        cbbCanHo = new javax.swing.JComboBox<>();

        jButton2.setText("jButton2");

        jLabel2.setText("jLabel2");

        jButton1.setText("jButton1");

        DlgChiTietHoaDon.setTitle("CHI TIẾT HÓA ĐƠN");
        DlgChiTietHoaDon.setMinimumSize(new java.awt.Dimension(600, 450));
        DlgChiTietHoaDon.setModal(true);
        DlgChiTietHoaDon.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                DlgChiTietHoaDonComponentShown(evt);
            }
        });

        jLabel8.setText("HÓA ĐƠN SỐ:");

        jLabel9.setText("TÊN DỊCH VỤ:");

        jLabel10.setText("SỐ LƯỢNG:");

        tfSoLuongDlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSoLuongDlgActionPerformed(evt);
            }
        });

        tblResultDlg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblResultDlg);

        btnThemChiTietHoaDonDlg.setText("THÊM DỊCH VỤ VÀO HÓA ĐƠN");
        btnThemChiTietHoaDonDlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChiTietHoaDonDlgActionPerformed(evt);
            }
        });

        btnQuayLaiDlg.setText("QUAY LẠI");
        btnQuayLaiDlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiDlgActionPerformed(evt);
            }
        });

        btnLamMoiDlg.setText("LÀM MỚI");
        btnLamMoiDlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiDlgActionPerformed(evt);
            }
        });

        jLabel11.setText("TỔNG TIỀN HÓA ĐƠN:");

        labelTongTienHoaDon.setText("$");

        labelMaHoaDon.setText("số hóa đơn");

        jLabel5.setText("CĂN HỘ:");

        labelMaCanHo.setText("căn hộ");

        javax.swing.GroupLayout DlgChiTietHoaDonLayout = new javax.swing.GroupLayout(DlgChiTietHoaDon.getContentPane());
        DlgChiTietHoaDon.getContentPane().setLayout(DlgChiTietHoaDonLayout);
        DlgChiTietHoaDonLayout.setHorizontalGroup(
            DlgChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DlgChiTietHoaDonLayout.createSequentialGroup()
                .addGap(0, 511, Short.MAX_VALUE)
                .addComponent(btnLamMoiDlg))
            .addGroup(DlgChiTietHoaDonLayout.createSequentialGroup()
                .addGroup(DlgChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DlgChiTietHoaDonLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel11)
                        .addGap(44, 44, 44)
                        .addComponent(labelTongTienHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DlgChiTietHoaDonLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DlgChiTietHoaDonLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnThemChiTietHoaDonDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DlgChiTietHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(labelMaCanHo)
                        .addGap(202, 202, 202))
                    .addGroup(DlgChiTietHoaDonLayout.createSequentialGroup()
                        .addGroup(DlgChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DlgChiTietHoaDonLayout.createSequentialGroup()
                                .addComponent(btnQuayLaiDlg)
                                .addGap(128, 128, 128)
                                .addComponent(jLabel8))
                            .addGroup(DlgChiTietHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))
                        .addGroup(DlgChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DlgChiTietHoaDonLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfSoLuongDlg, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DlgChiTietHoaDonLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(labelMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DlgChiTietHoaDonLayout.setVerticalGroup(
            DlgChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DlgChiTietHoaDonLayout.createSequentialGroup()
                .addGroup(DlgChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuayLaiDlg)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiDlg)
                    .addComponent(labelMaHoaDon))
                .addGap(18, 18, 18)
                .addGroup(DlgChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelMaCanHo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(DlgChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tfSoLuongDlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemChiTietHoaDonDlg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DlgChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTongTienHoaDon))
                .addContainerGap())
        );

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        btnQuayLai.setText("QUAY LẠI");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        btnHoaDonDaThanhToan.setText("HÓA ĐƠN ĐÃ THANH TOÁN");
        btnHoaDonDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonDaThanhToanActionPerformed(evt);
            }
        });

        btnHoaDonChuaThanhToan.setText("HÓA ĐƠN CHƯA THANH TOÁN");
        btnHoaDonChuaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonChuaThanhToanActionPerformed(evt);
            }
        });

        labelTieuDe.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelTieuDe.setForeground(new java.awt.Color(0, 0, 153));
        labelTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTieuDe.setText("HÓA ĐƠN ĐÃ THANH TOÁN");

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblResult.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblResultComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(tblResult);

        btnThemChiTietHoaDon.setText("THÊM CHI TIẾT HÓA ĐƠN");
        btnThemChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChiTietHoaDonActionPerformed(evt);
            }
        });

        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnThemHoaDon.setText("TẠO HÓA ĐƠN MỚI");
        btnThemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHoaDonActionPerformed(evt);
            }
        });

        jLabel3.setText("NHẬP THÁNG:");

        jLabel4.setText("NHẬP NĂM:");

        btnTraCuuHoaDonThangNam.setText("TRA CỨU HÓA ĐƠN");
        btnTraCuuHoaDonThangNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuHoaDonThangNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(tfThang, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnQuayLai)
                                .addGap(125, 125, 125)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnHoaDonDaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(tfNam, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTraCuuHoaDonThangNam, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(314, 314, 314))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(101, 101, 101)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 88, Short.MAX_VALUE)
                                    .addComponent(labelTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnHoaDonChuaThanhToan)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbCanHo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThemHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(25, 25, 25)
                        .addComponent(btnThemChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhToan)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuayLai)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(cbbCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHoaDonDaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHoaDonChuaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemHoaDon)
                    .addComponent(btnThemChiTietHoaDon)
                    .addComponent(btnThanhToan))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTraCuuHoaDonThangNam)
                    .addComponent(tfNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // HÓA ĐƠN ĐÃ THANH TOÁN
    private void btnHoaDonDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonDaThanhToanActionPerformed
        labelTieuDe.setText("HÓA ĐƠN ĐÃ THANH TOÁN");
//      ctl.DanhSachHoaDonDaThanhToan();
        showHoaDonDaThanhToan();
    }//GEN-LAST:event_btnHoaDonDaThanhToanActionPerformed
    
    // HÓA ĐƠN CHƯA THANH TOÁN
    private void btnHoaDonChuaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonChuaThanhToanActionPerformed
        labelTieuDe.setText("HÓA ĐƠN CHƯA THANH TOÁN");
        ctl.DanhSachHoaDonChuaThanhToan();
        showHoaDonChuaThanhToan();
    }//GEN-LAST:event_btnHoaDonChuaThanhToanActionPerformed

    private void tblResultComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblResultComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_tblResultComponentShown

    // CLICK ROW
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        tblResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblResult.getSelectedRow();
                labelMaHoaDon.setText((String) tblResult.getValueAt(row, 0));
                labelMaCanHo.setText((String) tblResult.getValueAt(row, 1));
                labelTongTienHoaDon.setText((String) tblResult.getValueAt(row, 5));
            }
        });
        showHoaDonChuaThanhToan();
    }//GEN-LAST:event_formComponentShown

    // QUAY LẠI
    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        FrmQuanLyTrangChu frmQuanLyTrangChu = new FrmQuanLyTrangChu();
        frmQuanLyTrangChu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    // HIỂN THỊ THÊM CHI TIẾT HÓA ĐƠN
    private void btnThemChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChiTietHoaDonActionPerformed
        showChiTietHoaDon(labelMaHoaDon.getText());
        DlgChiTietHoaDon.setVisible(true);
        System.out.println("Sau khi click theme chi tiet, đây sẽ là mã hóa đơn => " + labelMaHoaDon.getText());
    }//GEN-LAST:event_btnThemChiTietHoaDonActionPerformed

    //CLICK ROW DIALOG
    private void DlgChiTietHoaDonComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_DlgChiTietHoaDonComponentShown
//        tblResultDlg.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int row = tblResultDlg.getSelectedRow();
//                
//                String maDichVu = (String) tblResultDlg.getValueAt(row, 0);
//                tfMaDichVuDlg.setText(maDichVu);
//                
//                String soLuong = (String) tblResultDlg.getValueAt(row, 1);
//                tfSoLuongDlg.setText(soLuong);
//                
//            }
//        });
//        tfMaHoaDonDlg.setText(tfMaHoaDon.getText());
//        tfMaHoaDonDlg.setEditable(false);
//        showChiTietHoaDon(tfMaHoaDonDlg.getText());
    }//GEN-LAST:event_DlgChiTietHoaDonComponentShown

    //THÊM CHI TIẾT HÓA ĐƠN
    private void btnThemChiTietHoaDonDlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChiTietHoaDonDlgActionPerformed
        String MaDichVu;
        ComboboxValue MaDichVuDuocChon = (ComboboxValue) cbbDichVu.getSelectedItem();
        MaDichVu = MaDichVuDuocChon.getKey();
        
        if((Integer.parseInt(tfSoLuongDlg.getText()) == 0) || (Integer.parseInt(tfSoLuongDlg.getText()) < 0)){
            JOptionPane.showMessageDialog(null, "Số lượng phải > 0");
            tfSoLuongDlg.requestFocus();
            return;
        }
        
        if (tfSoLuongDlg.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Số lượng chưa nhập!");
            tfSoLuongDlg.requestFocus();
            return;
        }
          
        if(tfSoLuongDlg.getText().matches("\\d+")){
//            ctl.ThemChiTietHoaDon(labelMaHoaDon.getText(), tfMaDichVuDlg.getText(), tfSoLuongDlg.getText());
            ctl.ThemChiTietHoaDon(labelMaHoaDon.getText(), MaDichVu, tfSoLuongDlg.getText());
            showChiTietHoaDon(labelMaHoaDon.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Nhập lại! Số lượng phải là số");
            return;
        }
        
        
    }//GEN-LAST:event_btnThemChiTietHoaDonDlgActionPerformed

    //LÀM MỚI
    private void btnLamMoiDlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiDlgActionPerformed
        tfSoLuongDlg.setText("");
        showChiTietHoaDon(labelMaHoaDon.getText());
    }//GEN-LAST:event_btnLamMoiDlgActionPerformed

    //QUAY LẠI
    private void btnQuayLaiDlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiDlgActionPerformed
        DlgChiTietHoaDon.setVisible(false);
        showHoaDonChuaThanhToan();
    }//GEN-LAST:event_btnQuayLaiDlgActionPerformed

    //THANH TOÁN HÓA ĐƠN
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if(Float.parseFloat(labelTongTienHoaDon.getText()) > 0){
            ctl.ThanhToanHoaDon(labelMaHoaDon.getText());
            JOptionPane.showMessageDialog(null, "Thanh toán thành công rồi nhé!");
            showHoaDonChuaThanhToan();
        } else JOptionPane.showMessageDialog(null, "Tiền chưa có để thanh toán!");
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTraCuuHoaDonThangNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraCuuHoaDonThangNamActionPerformed
        if(tfThang.getText().matches("\\d+") && tfNam.getText().matches("\\d+")){
            showTraCuuHoaDonThangNam(Integer.parseInt(tfThang.getText()), Integer.parseInt(tfNam.getText()));
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Tháng hoặc năm nhập sai rồi!");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTraCuuHoaDonThangNamActionPerformed

    // THÊM HÓA ĐƠN MỚI
    private void btnThemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHoaDonActionPerformed
        String MaCanHo;
        
        ComboboxValue MaCanHoDuocChon = (ComboboxValue) cbbCanHo.getSelectedItem();
        MaCanHo = MaCanHoDuocChon.getKey();
        
        int TongSoHoaDon = ctl.TongSoHoaDon();
        TongSoHoaDon++;
        String MaHoaDon = "HD" + String.valueOf(TongSoHoaDon);
        
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate= formatter.format(date);
        
        ctl.ThemHoaDon(MaHoaDon, MaCanHo, strDate);
        showHoaDonChuaThanhToan();
    }//GEN-LAST:event_btnThemHoaDonActionPerformed

    private void tfSoLuongDlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSoLuongDlgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSoLuongDlgActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DlgChiTietHoaDon;
    private javax.swing.JButton btnHoaDonChuaThanhToan;
    private javax.swing.JButton btnHoaDonDaThanhToan;
    private javax.swing.JButton btnLamMoiDlg;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnQuayLaiDlg;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemChiTietHoaDon;
    private javax.swing.JButton btnThemChiTietHoaDonDlg;
    private javax.swing.JButton btnThemHoaDon;
    private javax.swing.JButton btnTraCuuHoaDonThangNam;
    private javax.swing.JComboBox<String> cbbCanHo;
    private javax.swing.JComboBox<String> cbbDichVu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelMaCanHo;
    private javax.swing.JLabel labelMaHoaDon;
    private javax.swing.JLabel labelTieuDe;
    private javax.swing.JLabel labelTongTienHoaDon;
    private javax.swing.JTable tblResult;
    private javax.swing.JTable tblResultDlg;
    private javax.swing.JTextField tfNam;
    private javax.swing.JTextField tfSoLuongDlg;
    private javax.swing.JTextField tfThang;
    // End of variables declaration//GEN-END:variables
}
