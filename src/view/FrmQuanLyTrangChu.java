/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Vitaliy
 */
public class FrmQuanLyTrangChu extends javax.swing.JFrame {

    /**
     * Creates new form FrmQuanLyTrangChu
     */
    public FrmQuanLyTrangChu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnQuanLyToaNha = new javax.swing.JButton();
        btnQuanLyLoaiCanHo = new javax.swing.JButton();
        btnQuanLyHoaDon = new javax.swing.JButton();
        btnQuanLyCanHo = new javax.swing.JButton();
        btnQuanLyDichVu = new javax.swing.JButton();
        btnThongKeDoanhThu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("TRANG CHỦ QUẢN LÝ");

        btnQuanLyToaNha.setText("QUẢN LÝ TÒA NHÀ");
        btnQuanLyToaNha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyToaNhaActionPerformed(evt);
            }
        });

        btnQuanLyLoaiCanHo.setText("QUẢN LÝ LOẠI CĂN HỘ");
        btnQuanLyLoaiCanHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyLoaiCanHoActionPerformed(evt);
            }
        });

        btnQuanLyHoaDon.setText("QUẢN LÝ HÓA ĐƠN");
        btnQuanLyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyHoaDonActionPerformed(evt);
            }
        });

        btnQuanLyCanHo.setText("QUẢN LÝ CĂN HỘ");
        btnQuanLyCanHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyCanHoActionPerformed(evt);
            }
        });

        btnQuanLyDichVu.setText("QUẢN LÝ DỊCH VỤ");
        btnQuanLyDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyDichVuActionPerformed(evt);
            }
        });

        btnThongKeDoanhThu.setText("THỐNG KÊ DOANH THU");

        btnThoat.setText("THOÁT");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnDangXuat.setText("ĐĂNG XUẤT");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setText("ĐỔI MẬT KHẨU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnQuanLyDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addComponent(btnQuanLyToaNha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnDoiMatKhau))
                .addGap(31, 31, 31)
                .addComponent(btnDangXuat)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThoat)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnQuanLyLoaiCanHo, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                        .addComponent(btnQuanLyCanHo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThongKeDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuanLyToaNha, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuanLyLoaiCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnQuanLyCanHo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuanLyDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThongKeDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat)
                    .addComponent(btnDangXuat)
                    .addComponent(btnDoiMatKhau))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // TÒA NHÀ!
    private void btnQuanLyToaNhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyToaNhaActionPerformed
        FrmToaNha frmToaNha = new FrmToaNha();
        frmToaNha.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuanLyToaNhaActionPerformed

    // LOẠI CĂN HỘ!
    private void btnQuanLyLoaiCanHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyLoaiCanHoActionPerformed
        FrmLoaiCanHo frmLoaiCanHo = new FrmLoaiCanHo();
        frmLoaiCanHo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuanLyLoaiCanHoActionPerformed

    // CĂN HỘ!
    private void btnQuanLyCanHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyCanHoActionPerformed
        FrmCanHo frmCanHo = new FrmCanHo();
        frmCanHo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuanLyCanHoActionPerformed

    // THOÁT
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        Object[] options = {"Oke đăng xuất đi!", "Không đừng đăng xuất!"};
        int option =  JOptionPane.showOptionDialog(rootPane, "Bạn có chắc chắn muốn đăng xuất không?", "ĐĂNG XUẤT?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (option == JOptionPane.YES_OPTION){
            FrmDangNhap frmDangNhap = new FrmDangNhap();
            frmDangNhap.setVisible(true);
            this.dispose();
        } else {
            return;
        }
    }//GEN-LAST:event_btnDangXuatActionPerformed

    // HÓA ĐƠN
    private void btnQuanLyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyHoaDonActionPerformed
        FrmHoaDon frmHoaDon = new FrmHoaDon();
        frmHoaDon.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuanLyHoaDonActionPerformed

    
    // QUẢN LÝ DỊCH VỤ
    private void btnQuanLyDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyDichVuActionPerformed
        FrmDichVu frmDichVu = new FrmDichVu();
        frmDichVu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuanLyDichVuActionPerformed

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
            java.util.logging.Logger.getLogger(FrmQuanLyTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQuanLyTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQuanLyTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQuanLyTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQuanLyTrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnQuanLyCanHo;
    private javax.swing.JButton btnQuanLyDichVu;
    private javax.swing.JButton btnQuanLyHoaDon;
    private javax.swing.JButton btnQuanLyLoaiCanHo;
    private javax.swing.JButton btnQuanLyToaNha;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKeDoanhThu;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
