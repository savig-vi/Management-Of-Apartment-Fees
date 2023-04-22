/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import dao.DBConnection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ComboboxKey;
import model.ComboboxValue;
import model.LoaiCanHo;

/**
 *
 * @author Vitaliy
 */
public class FrmCanHo extends javax.swing.JFrame {

    /**
     * Creates new form FrmCanHo
     */
    Controller ctl = new Controller();

    public FrmCanHo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        DoToaNhaVaoCombobox();
        DoLoaiCanHoVaoCombobox();
        DoChuCanHoVaoCombobox();
    }

    // ĐỔ DANH SÁCH TÒA NHÀ VÀO COMBOBOX
    public void DoToaNhaVaoCombobox() {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT * FROM ToaNha";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbToaNha.getModel();
            cbbModel.removeAllElements();

            while (rs.next()) {
                String MaToaNha = rs.getString("MaToaNha");
                String TenToaNha = rs.getString("TenToaNha");

                ComboboxValue mycbb = new ComboboxValue(MaToaNha, TenToaNha);
                cbbModel.addElement(mycbb);
            }
//            JOptionPane.showMessageDialog(rootPane, "Thêm tòa nhà vào combobox thành kum");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Lỗi lấy tòa nhà vô combobox rồi");
        }
    }

    // ĐỔ DANH SÁCH LOẠI CĂN HỘ VÀO COMBOBOX
    public void DoLoaiCanHoVaoCombobox() {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT * FROM LoaiCanHo";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // TẠO 1 DefaultComboBoxModel
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbLoaiCanHo.getModel();
            cbbModel.removeAllElements(); // XÓA HẾT DỮ LIỆU TRONG COMBOBOX

            // ĐỌC DANH SÁCH LOẠI SẢN PHẨM ĐỂ ĐỔ VÀO COMBOBOX
            while (rs.next()) {
                String MaLoaiCanHo = rs.getString("MaLoaiCanHo");
                String TenLoaiCanHo = rs.getString("TenLoaiCanHo");

                ComboboxValue mycbb = new ComboboxValue(MaLoaiCanHo, TenLoaiCanHo);

                // Thêm mycbb và Combobox loại căn hộ
                cbbModel.addElement(mycbb);
            }
//            JOptionPane.showMessageDialog(rootPane, "Đổ loại căn hộ vô combobox thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Lỗi lấy loại căn hộ vô combobox nhé!");
        }
    }

    // ĐỔ CHỦ CĂN HỘ VÀO COMBOBOX
    public void DoChuCanHoVaoCombobox() {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT TenDangNhapChuCanHo, Ho, Ten FROM ChuCanHo";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbChuCanHo.getModel();
            cbbModel.removeAllElements();

            while (rs.next()) {
                String TenDangNhapChuCanHo = rs.getString("TenDangNhapChuCanHo");
                String HoTenChuCanHo = rs.getString("Ho") + " " + rs.getString("Ten");
                ComboboxKey mycbb = new ComboboxKey(TenDangNhapChuCanHo, HoTenChuCanHo);
                cbbModel.addElement(mycbb);
            }
//            JOptionPane.showMessageDialog(rootPane, "Thêm chủ căn hộ mới vào combobox thành kum");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Thêm chủ căn hộ vào combobox không thành công rồi!");
        }
    }

    public void ThemCanHo() {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_ThemCanHo 'CANHO-MOI', 'Căn hộ mới nha', 'A', 'vip', 200, 200, 'chucanho2', 'Dùng như shit'";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
            DBConnection.closeConnection(connection);
            JOptionPane.showMessageDialog(null, "Bạn đã thêm mới căn hộ thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ĐỔ DỮ LIỆU VÀO TABLE
    public void showDuLieu() {
        try {
            tblResult.removeAll();
            String[] column = {"MÃ CĂN HỘ", "TÊN CĂN HỘ", "TÒA NHÀ", "LOẠI CĂN HỘ", "DIỆN TÍCH", "CHỦ CĂN HỘ", "GHI CHÚ"};
            DefaultTableModel model = new DefaultTableModel(column, 0);
            Connection connection = DBConnection.getConnection();
            String query = "EXEC SP_DanhSachCanHo";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector vector = new Vector();
                vector.add(rs.getString("MaCanHo"));
                vector.add(rs.getString("TenCanHo"));
                vector.add(rs.getString("TenToaNha"));
                vector.add(rs.getString("TenLoaiCanHo"));
                vector.add(rs.getString("DienTich"));
                vector.add(rs.getString("ChuCanHo"));
                vector.add(rs.getString("GhiChu"));
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

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfMaCanHo = new javax.swing.JTextField();
        tfDienTich = new javax.swing.JTextField();
        tfTenCanHo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        tfGhiChu = new javax.swing.JTextField();
        cbbChuCanHo = new javax.swing.JComboBox<>();
        cbbLoaiCanHo = new javax.swing.JComboBox<>();
        cbbToaNha = new javax.swing.JComboBox<>();
        btnXoa = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ CĂN HỘ");

        jLabel2.setText("MÃ CĂN HỘ:");

        btnQuayLai.setText("QUAY LẠI");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        jLabel3.setText("TÊN CĂN HỘ:");

        jLabel4.setText("TÒA NHÀ:");

        jLabel5.setText("LOẠI CĂN HỘ:");

        jLabel6.setText("DIỆN TÍCH:");

        jLabel8.setText("CHỦ CĂN HỘ:");

        jLabel9.setText("GHI CHÚ:");

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblResult);

        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        cbbChuCanHo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbToaNha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbToaNha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbToaNhaActionPerformed(evt);
            }
        });

        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnQuayLai)
                        .addGap(233, 233, 233)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(tfDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMaCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(6, 6, 6)
                                .addComponent(tfTenCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbChuCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbToaNha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbLoaiCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnThem)
                .addGap(157, 157, 157)
                .addComponent(btnSua)
                .addGap(142, 142, 142)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLamMoi)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnQuayLai))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(tfMaCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTenCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLoaiCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbToaNha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(tfDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbChuCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnLamMoi)
                    .addComponent(btnXoa))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ĐÂY LÀ CHỖ CLICK ROW
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        tblResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblResult.getSelectedRow();
                String maCanHo = (String) tblResult.getValueAt(row, 0);
                String tenCanHo = (String) tblResult.getValueAt(row, 1);
                String tenToaNha = (String) tblResult.getValueAt(row, 2);
                String tenLoaiCanHo = (String) tblResult.getValueAt(row, 3);
                String dienTich = (String) tblResult.getValueAt(row, 4);
                String chuCanHo = (String) tblResult.getValueAt(row, 5);
                String tinhTrang = (String) tblResult.getValueAt(row, 6);

                tfMaCanHo.setText(maCanHo);
                tfTenCanHo.setText(tenCanHo);
                tfDienTich.setText(dienTich);
                tfGhiChu.setText(tinhTrang);
                
                ChonToaNhaTrongCombobox(tenToaNha);
                ChonLoaiCanHoTrongCombobox(tenLoaiCanHo);
                ChonChuCanHoTrongCombobox(chuCanHo);
            }
        });
        showDuLieu();
    }//GEN-LAST:event_formComponentShown

    // HÀM CHỌN LOẠI SẢN PHẨM THEO TÊN LOẠI
    private void ChonToaNhaTrongCombobox(String TenToaNha) {
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT * FROM ToaNha WHERE TenToaNha = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, TenToaNha);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String MaToaNha = rs.getString("MaToaNha");
                // CHỌN DÒNG DỮ LIỆU THÌ TỰ ĐỘNG CHỌN COMBOBOX TƯƠNG ỨNG
                ComboboxValue myCbb = new ComboboxValue(MaToaNha, TenToaNha);
                DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbToaNha.getModel();
                cbbModel.setSelectedItem(myCbb);
            }
        } catch (Exception e) {
        }
    }
    
    private void ChonLoaiCanHoTrongCombobox(String TenLoaiCanHo){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT * FROM LoaiCanHo WHERE TenLoaiCanHo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, TenLoaiCanHo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String MaLoaiCanHo = rs.getString("MaLoaiCanHo");
                // CHỌN DÒNG DỮ LIỆU THÌ TỰ ĐỘNG CHỌN COMBOBOX TƯƠNG ỨNG
                ComboboxValue myCbb = new ComboboxValue(MaLoaiCanHo, TenLoaiCanHo);
                DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbLoaiCanHo.getModel();
                cbbModel.setSelectedItem(myCbb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void ChonChuCanHoTrongCombobox(String TenDangNhapChuCanHo){
        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT TenDangNhapChuCanHo FROM ChuCanHo WHERE TenDangNhapChuCanHo = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, TenDangNhapChuCanHo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String Ten = rs.getString("Ten");
                // CHỌN DÒNG DỮ LIỆU THÌ TỰ ĐỘNG CHỌN COMBOBOX TƯƠNG ỨNG
                ComboboxKey myCbb = new ComboboxKey(TenDangNhapChuCanHo, Ten);
                DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbToaNha.getModel();
                cbbModel.setSelectedItem(myCbb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ĐÂY LÀ NÚT THÊM MỚI CĂN HỘ
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String MaToaNha;
        String MaLoaiCanHo;
        String TenDangNhapChuCanHo;

        ComboboxValue MaToaNhaDuocChon = (ComboboxValue) cbbToaNha.getSelectedItem();
        ComboboxValue MaLoaiCanHoDuocChon = (ComboboxValue) cbbLoaiCanHo.getSelectedItem();
        ComboboxKey TenDangNhapChuCanHoDuocChon = (ComboboxKey) cbbChuCanHo.getSelectedItem();

        TenDangNhapChuCanHo = TenDangNhapChuCanHoDuocChon.toString();

        String MaCanHo = tfMaCanHo.getText();
        String TenCanHo = tfTenCanHo.getText();
        MaToaNha = MaToaNhaDuocChon.getKey();
        MaLoaiCanHo = MaLoaiCanHoDuocChon.getKey();
        int DienTich = Integer.parseInt(tfDienTich.getText());
        String GhiChu = tfGhiChu.getText();
        
        ctl.ThemCanHo(MaCanHo, TenCanHo, MaToaNha, MaLoaiCanHo, DienTich, TenDangNhapChuCanHo, GhiChu);
        showDuLieu();
    }//GEN-LAST:event_btnThemActionPerformed

    // ĐÂY LÀ NÚT QUAY LẠI
    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        FrmQuanLyTrangChu frmQuanLyTrangChu = new FrmQuanLyTrangChu();
        frmQuanLyTrangChu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void cbbToaNhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbToaNhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbToaNhaActionPerformed

    // LÀM MỚI
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        tfMaCanHo.setText("");
        tfTenCanHo.setText("");
        tfDienTich.setText("");
        tfGhiChu.setText("");
        showDuLieu();;
    }//GEN-LAST:event_btnLamMoiActionPerformed

    // SỬA
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        ComboboxValue MaToaNhaDuocChon = (ComboboxValue) cbbToaNha.getSelectedItem();
        ComboboxValue MaLoaiCanHoDuocChon = (ComboboxValue) cbbLoaiCanHo.getSelectedItem();
        ComboboxKey TenDangNhapChuCanHoDuocChon = (ComboboxKey) cbbChuCanHo.getSelectedItem();

        String MaCanHo = tfMaCanHo.getText();
        String TenCanHo = tfTenCanHo.getText();
        String MaToaNha = MaToaNhaDuocChon.getKey();
        String MaLoaiCanHo = MaLoaiCanHoDuocChon.getKey();
        int DienTich = Integer.parseInt(tfDienTich.getText());
        String ChuCanHo = TenDangNhapChuCanHoDuocChon.toString();
        String GhiChu = tfGhiChu.getText();
        ctl.SuaCanHo(MaCanHo, TenCanHo, MaToaNha, MaLoaiCanHo, DienTich, ChuCanHo, GhiChu);
        showDuLieu();
    }//GEN-LAST:event_btnSuaActionPerformed

    // XÓA
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        ctl.XoaCanHo(tfMaCanHo.getText());
        showDuLieu();
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCanHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCanHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCanHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCanHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCanHo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbChuCanHo;
    private javax.swing.JComboBox<String> cbbLoaiCanHo;
    private javax.swing.JComboBox<String> cbbToaNha;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField tfDienTich;
    private javax.swing.JTextField tfGhiChu;
    private javax.swing.JTextField tfMaCanHo;
    private javax.swing.JTextField tfTenCanHo;
    // End of variables declaration//GEN-END:variables
}
