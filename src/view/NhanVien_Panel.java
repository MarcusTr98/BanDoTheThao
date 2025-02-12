/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import dao.NhanVienDAO;
import entity.NhanVienEntity;
import java.awt.Color;
import utils.XDate;
import utils.Auth;
import utils.MsgBox;

/**
 *
 * @author manht
 */
public class NhanVien_Panel extends javax.swing.JPanel {

    NhanVienDAO nvDao = new NhanVienDAO();
    int row = -1; // Nơi chưa vị trí nhân viên;

    /**
     * Creates new form NhanVien_Panel
     */
    public NhanVien_Panel() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdoQuanLy = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        txtMatKhau = new javax.swing.JPasswordField();
        txtXacNhanMK = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnChucNang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(0, 51, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Mã nhân viên:");

        txtMaNV.setEditable(false);

        jLabel3.setText("Tên nhân viên:");

        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        jLabel4.setText("Số điện thoại:");

        jLabel5.setText("Địa chỉ:");

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel6.setText("Giới tính:");

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", " " }));
        cboGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhActionPerformed(evt);
            }
        });

        jLabel7.setText("Ngày sinh:");

        jLabel8.setText("Mật khẩu:");

        jLabel9.setText("Xác nhận mật khẩu:");

        jLabel10.setText("Vai trò:");

        buttonGroup1.add(rdoQuanLy);
        rdoQuanLy.setText("Quản lý");

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân viên");

        dateChooser.setDateFormatString("dd/MM/yyyy");

        txtXacNhanMK.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtXacNhanMKFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtXacNhanMK)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoQuanLy)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNhanVien)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(cboGioiTinh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtXacNhanMK)
                    .addComponent(txtMatKhau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoQuanLy)
                    .addComponent(rdoNhanVien))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("DANH SÁCH");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ NV", "TÊN NV", "GIỚI TÍNH", "ĐỊA CHỈ", "SĐT", "NGÀY SINH", "MẬT KHẨU", "VAI TRÒ"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        btnChucNang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setBackground(new java.awt.Color(255, 153, 0));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 153, 0));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 153, 0));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(255, 153, 0));
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/new.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(255, 153, 0));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/first.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(255, 153, 0));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(255, 153, 0));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnFirst.setBackground(new java.awt.Color(255, 153, 0));
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/last.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnChucNangLayout = new javax.swing.GroupLayout(btnChucNang);
        btnChucNang.setLayout(btnChucNangLayout);
        btnChucNangLayout.setHorizontalGroup(
            btnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnChucNangLayout.setVerticalGroup(
            btnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(btnChucNangLayout.createSequentialGroup()
                        .addGroup(btnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnMoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(btnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnThem)
                                .addComponent(btnSua)
                                .addComponent(btnXoa)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChucNang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGioiTinhActionPerformed

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        this.first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        if(evt.getClickCount() == 1) {
            this.row = tblNhanVien.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        this.prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
       this.next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        this.last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        StringBuilder sb = new StringBuilder();
        checkSDT(txtSDT, sb);
        
        String s1 = txtMatKhau.getText();
        String s2 = txtXacNhanMK.getText();
        
        if(s1.equals(s2) == false) {
            MsgBox.showMessageDialog(this, "Mật khẩu không khớp!");
            txtXacNhanMK.setBackground(Color.pink);
            return;
        }
        if(checkValidateForm()) {
            if(sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString(), "INVALID DATA!",JOptionPane.ERROR_MESSAGE);
                return;
            }
            insert();
        }else {
            MsgBox.showMessageDialog(this, "Bạn chưa nhập đầy đủ thông tin!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
         StringBuilder sb = new StringBuilder();
        checkSDT(txtSDT, sb);
        
        String s1 = txtMatKhau.getText();
        String s2 = txtXacNhanMK.getText();
        
        if(s1.equals(s2) == false) {
            MsgBox.showMessageDialog(this, "Mật khẩu không khớp!");
            txtXacNhanMK.setBackground(Color.pink);
            return;
        }
        if(MsgBox.showConfirmDialog(this, "Bạn thực sự muốn cập nhật nhân viên này?")) {
            if(sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString(), "INVALID DATA!",JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.update();
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtXacNhanMKFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtXacNhanMKFocusGained
        txtXacNhanMK.setBackground(Color.white);
    }//GEN-LAST:event_txtXacNhanMKFocusGained

    //Check validate
    public boolean checkValidateForm() {
        if (txtTenNV.getText().isEmpty() || txtMatKhau.getText().isEmpty()
                || txtDiaChi.getText().isEmpty() || txtSDT.getText().isEmpty()
                || txtXacNhanMK.getText().isEmpty()
                || ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
            return false;
        }
        return true;
    }

    // Check trùng Mã nhân viên
    public boolean checkTrungMa(JTextField txt) {
        txt.setBackground(Color.white);
        if (nvDao.selectById(txt.getText()) == null) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            MsgBox.showMessageDialog(this, "Mã nhân viên " + txt.getText() + " Đã tồn tại!!!");
            return false;
        }
    }

    public void init() {

    }

    public String matKhauSao(String pass) {
        String sao = "";
        for (int i = 0; i < pass.length(); i++) {
            sao += "*";
        }
        return sao;
    }

    // Lấy list NV từ CSDL đổ vào bảng
    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVienEntity> listNv = nvDao.selectAll();
            for (NhanVienEntity nv : listNv) {
                Object[] data = {nv.getMaNV(),
                    nv.getTenNV(),
                    nv.isGioiTinh() ? "Nam" : "Nữ",
                    nv.getDiaChi(),
                    nv.getSdt(),
                    XDate.toString(nv.getNgaySinh(), "dd/MM/yyyy"),
                    Auth.user.isVaiTro() ? nv.getMatKhau() : matKhauSao(nv.getMatKhau()), // Chỉ quản lí mới đc xem MK còn nhân viên thì sẽ hiện dấu *
                    nv.isVaiTro() ? "Quản lí" : "Nhân viên"
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            MsgBox.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            e.printStackTrace();
        }
    }

    //Lấy thông tin trên form cho vào đt nhanVien
    NhanVienEntity getForm() {
        NhanVienEntity nv = new NhanVienEntity();
        nv.setMaNV(txtMaNV.getText());
        nv.setTenNV(txtTenNV.getText());
        nv.setGioiTinh(cboGioiTinh.getSelectedIndex() == 0);
        nv.setDiaChi(txtDiaChi.getText());
        nv.setSdt(txtSDT.getText());
        String ngay = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        nv.setNgaySinh(XDate.toDate(ngay, "dd/MM/yyyy"));
        nv.setMatKhau(txtMatKhau.getText());
        boolean vaiTro = true; // set Vai trò mặc định là NV
        if (rdoQuanLy.isSelected()) {
            vaiTro = true; // Quản lí
        } else {
            vaiTro = false; //Nhân viên;
        }
        return nv;
    }

    // Đưa dữ liệu lên form
    void setForm(NhanVienEntity nv) {
        txtMaNV.setText(nv.getMaNV());
        txtTenNV.setText(nv.getTenNV());
        txtSDT.setText(nv.getSdt());
        txtDiaChi.setText(nv.getDiaChi());
        cboGioiTinh.setSelectedIndex(nv.isGioiTinh() ? 0 : 1);
        dateChooser.setDate(nv.getNgaySinh());
        txtMatKhau.setText(nv.getMatKhau());
        if (nv.isVaiTro() == true) {
            rdoQuanLy.setSelected(true);
        } else {
            rdoNhanVien.setSelected(true);
        }
        txtXacNhanMK.setText(nv.getMatKhau());
    }

    // Cập nhật trạng thái của form
    void updateStatus() {
        boolean edit = (this.row >= 0); // Đang chọn 1 hàng nào đó -> trạng thái edit
        boolean first = (this.row == 0); //Đang ở bản ghi đầu tiên
        boolean last = (this.row == tblNhanVien.getRowCount() - 1); // Đang ở bản ghi cuối cùng

        //Trạng thái form
        txtMaNV.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(last);

        //Trạng thái điều hướng
        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }

    //Điền thông tin nhanVien lên form theo vị trí row
    void edit() {
        try {
            String maNV = (String) tblNhanVien.getValueAt(this.row, 0);
            NhanVienEntity nv = nvDao.selectById(maNV);
            this.setForm(nv);
            this.updateStatus();
        } catch (Exception e) {
            MsgBox.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            e.printStackTrace();
        }
    }

    void first() {
        this.row = 0;
        this.edit();
        tblNhanVien.setRowSelectionInterval(row, row);

    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
            tblNhanVien.setRowSelectionInterval(row, row);
        }
    }

    void next() {
        if (this.row < tblNhanVien.getRowCount() - 1) {
            this.row++;
            this.edit();
            tblNhanVien.setRowSelectionInterval(row, row);
        }
    }

    void last() {
        this.row = tblNhanVien.getRowCount() - 1;
        this.edit();
        tblNhanVien.setRowSelectionInterval(row, row);
    }

    // Xóa form
    void clearForm() {
        this.setForm(new NhanVienEntity());
        this.row = -1;
        this.updateStatus();
        rdoNhanVien.setSelected(true);
        txtTenNV.setBackground(Color.white);
        cboGioiTinh.setSelectedIndex(0);
        txtMaNV.setBackground(Color.white);
        txtXacNhanMK.setText("");
        txtMaNV.setEditable(false);
    }

    // Lấy thông tin trên form để thêm nhân viên - quản lí vào CSDL
    void insert() {
        NhanVienEntity nv = getForm();
        try {
            nvDao.insert(nv);
            this.fillTable();
            this.clearForm();
            MsgBox.showMessageDialog(this, "Thêm mới nhân viên thành công!!!");
        } catch (Exception e) {
            MsgBox.showMessageDialog(this, "Thêm mới nhân viên thất bại!!!");
            e.printStackTrace();
        }
    }

    // Lấy thông tin trên form để update NhanVien theo maNV
    void update() {
        NhanVienEntity nv = getForm();
        try {
            nvDao.update(nv);
            this.fillTable();
            this.clearForm();
            MsgBox.showMessageDialog(this, "Cập nhật nhân viên thành công!!!");
        } catch (Exception e) {
            MsgBox.showMessageDialog(this, "Cập nhật nhân viên thất bại!!!");
            e.printStackTrace();
        }
    }

    //Lấy maNV trên form, xóa nv theo maNV
    void delete() {
        if (!Auth.isManager()) { //Check nếu là trưởng phòng thì mới có quyền xóa
            MsgBox.showMessageDialog(this, "Bạn không có quyền xóa nhân viên!");
        } else {
            String maNV = txtMaNV.getText();
            if (maNV.equals(Auth.user.getMaNV())) {
                MsgBox.showMessageDialog(this, "Bạn không được xóa chính mình!!");
            } else if (MsgBox.showConfirmDialog(this, "Bạn thực sự muốn xóa nhân viên này?")) {
                try {
                    nvDao.delete(maNV);
                    this.fillTable();
                    this.clearForm();
                    MsgBox.showMessageDialog(this, "Xóa nhân viên thành công!");
                } catch (Exception e) {
                    MsgBox.showMessageDialog(this, "Không thể xóa nhân viên!");
                }
            }
        }
    }

    //Check SĐT
    public static boolean checkSDT(JTextField field, StringBuilder sb) {
        boolean ok = true;
        //biểu thức chính quy kiểm tra số điện thoại VN tìm từ trên mạng
        Pattern pattern = Pattern.compile("(0?)(3[2-9]|5[6|8|9]"
                + "|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$");
        Matcher matcher = pattern.matcher(field.getText());

        if (!matcher.find()) {
            sb.append("Số điện thoại không hợp lệ");
            ok = false;
        }
        return ok;
    }

    final static String DATE_FORMAT = "dd/MM/yyyy";

    public static boolean checkNgaySinh(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    void viewTable(){
        tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(140);
        tblNhanVien.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblNhanVien.getColumnModel().getColumn(3).setPreferredWidth(90);
        tblNhanVien.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblNhanVien.getColumnModel().getColumn(5).setPreferredWidth(70);
        tblNhanVien.getColumnModel().getColumn(6).setPreferredWidth(70);
        tblNhanVien.getColumnModel().getColumn(7).setPreferredWidth(70);
        tblNhanVien.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnChucNang;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoQuanLy;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JPasswordField txtXacNhanMK;
    // End of variables declaration//GEN-END:variables
}
