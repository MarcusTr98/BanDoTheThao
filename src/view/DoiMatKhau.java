/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author macth
 */
public class DoiMatKhau extends javax.swing.JFrame {

    /**
     * Creates new form DangNhap
     */
    public DoiMatKhau() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtTenDangNhap2 = new javax.swing.JTextField();
        txtTenDangNhap4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        btnThoat = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtMatKhauMoi = new javax.swing.JTextField();
        txtXacNhanMK = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Đăng nhập");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtTenDangNhap2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDangNhap2ActionPerformed(evt);
            }
        });

        txtTenDangNhap4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDangNhap4ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên đăng nhập");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ĐỔI MẬT KHẨU");

        txtTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDangNhapActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thoat-Photoroom.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login-Photoroom_1.png"))); // NOI18N
        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mật khẩu mới");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Xác nhận mk mới");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtMatKhauMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauMoiActionPerformed(evt);
            }
        });

        txtXacNhanMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXacNhanMKActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login-Photoroom.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel2)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnDoiMatKhau)
                        .addGap(132, 132, 132)
                        .addComponent(btnThoat)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat)
                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhapActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // Chuyển tới DangNhap khi nhấn nút Thoát
        new DangNhap().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        /// Lấy dữ liệu từ các trường nhập liệu
        String tenDangNhap = txtTenDangNhap.getText();
        String email = txtEmail.getText();
        String matKhau = txtMatKhauMoi.getText();
        String xacNhanMK = txtXacNhanMK.getText();

        // Kiểm tra các trường có rỗng không
        if (tenDangNhap.isEmpty() || email.isEmpty() || matKhau.isEmpty() || xacNhanMK.isEmpty()) {
            // Hiển thị thông báo yêu cầu người dùng nhập thông tin
            JOptionPane.showMessageDialog(this, "Yêu cầu người dùng nhập thông tin để đổi mật khẩu", "Lỗi đăng ký", JOptionPane.ERROR_MESSAGE);
        } else if (!matKhau.equals(xacNhanMK)) {
            // Kiểm tra mật khẩu và xác nhận mật khẩu có khớp không
            JOptionPane.showMessageDialog(this, "Mật khẩu và xác nhận mật khẩu không khớp", "Lỗi đăng ký", JOptionPane.ERROR_MESSAGE);
        } else {
            // Hiển thị thông báo đăng ký thành công
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            // Chuyển tới DangNhap
            new DangNhap().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtTenDangNhap2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangNhap2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhap2ActionPerformed

    private void txtMatKhauMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauMoiActionPerformed

    private void txtTenDangNhap4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangNhap4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhap4ActionPerformed

    private void txtXacNhanMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXacNhanMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXacNhanMKActionPerformed

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
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMatKhauMoi;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTenDangNhap2;
    private javax.swing.JTextField txtTenDangNhap4;
    private javax.swing.JTextField txtXacNhanMK;
    // End of variables declaration//GEN-END:variables
}
