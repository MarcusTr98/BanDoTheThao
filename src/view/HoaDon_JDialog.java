/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;
import entity.*;
import dao.*;
import java.util.*;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import utils.XDate;



/**
 *
 * @author HP
 */
public class HoaDon_JDialog extends javax.swing.JDialog {
HoaDonDAO dao= new HoaDonDAO();
HoaDonChiTietDAO hdctDAO= new HoaDonChiTietDAO();
int row=-1; // Hàng được chọn trên bảng
    /**
     * Creates new form HoaDon_JDialog
     */
    public HoaDon_JDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fillTableHoaDon();
        fillTableHoaDonChiTiet();
    }
public void fillTableHoaDon(){
    DefaultTableModel mode= (DefaultTableModel) tblHoaDon.getModel();
    mode.setRowCount(0);
    for (HoaDonEntity hd : dao.selectAll()) {
        Object[] data={hd.getMaHDBan(),hd.getMaNV(),hd.getNgayBan(),hd.getMaKH(),hd.isTinhTrang_ThanhToan()? "Đã thanh toán":"Chưa thanh toán"};
        mode.addRow(data);
    }
    tblHoaDon.setModel(mode);
}
public void fillTableHoaDonChiTiet(){
    DefaultTableModel model= (DefaultTableModel) tblHoaDonChiTiet.getModel();
    model.setRowCount(0);
    for (HoaDonChiTietEntity hdct : hdctDAO.selectAll()) {
        Object[]data={hdct.getMaHDCT(),hdct.getMaHDBan(),hdct.getMaSP(),hdct.getTenSP(),hdct.getSoLuong(),hdct.getGiamGia(),hdct.getThanhTien()};
        model.addRow(data);
    }
    tblHoaDonChiTiet.setModel(model);
}
public HoaDonEntity getFormHoaDon(){
    String maHD=txtMaHD.getText();
    int maNV=Integer.parseInt(txtMaNV.getText());
    Date date=XDate.toDate(txtNgayBan.getText() ,"yyyy-MM-dd" );
    int maKH=Integer.parseInt(txtMaKH.getText());
    boolean tinhTrang_ThanhToan=rdoThanhToan.isSelected();
   HoaDonEntity hd = new HoaDonEntity(maHD, maNV, date, maKH, tinhTrang_ThanhToan);
    return hd;
}
public void setFormHoaDon(HoaDonEntity hd){
    NhanVienEntity nv = new NhanVienEntity();
    KhachHangEntity kh= new KhachHangEntity();
    txtMaHD.setText(hd.getMaHDBan());
    txtMaNV.setText(String.valueOf(hd.getMaNV()));
    txtMaKH.setText(String.valueOf(hd.getMaKH()));
    txtNgayBan.setText(String.valueOf(hd.getNgayBan()));
    if(hd.isTinhTrang_ThanhToan()==true){
        rdoThanhToan.setSelected(rootPaneCheckingEnabled);
    }else{
        rdoChuaThanhToan.setSelected(rootPaneCheckingEnabled);
    }
    txtTenNV.setText(nv.getTenNV());
    txtTenKH.setText(kh.getTenKH());
  
}
public void insert (){
    dao.insert(this.getFormHoaDon());
    fillTableHoaDon();
}
public void update(){
    dao.update(this.getFormHoaDon());
    fillTableHoaDon();
}
public void delete(){
    String maHD=txtMaHD.getText();
    dao.delete(maHD);
    fillTableHoaDon();
}
public void clearForm(){
    txtMaHD.setText("");
    txtMaNV.setText("");
    txtMaKH.setText("");
    txtNgayBan.setText("");
    buttonGroup1.clearSelection();
//    rdoDaThanhToan.setSelected(false);
//    rdoChuaThanhToan.setSelected(false);
}
public void first(){
    this.row=0;
    this.editHoaDon();
}
public void prev(){
    if(this.row>0){
       this.row--;
        this.editHoaDon();
    }
}
public void next(){
    if(this.row<tblHoaDon.getRowCount()-1){
        this.row++;
        this.editHoaDon();
    }
}
public void last(){
    this.row=tblHoaDon.getRowCount()-1;
    this.editHoaDon();
}
public void editHoaDon(){
    String maHD= (String) tblHoaDon.getValueAt(row, 0);
    HoaDonEntity hd= dao.selectById(maHD);
    this.setFormHoaDon(hd);
}



// Bảng hóa đơn chi tiết
public HoaDonChiTietEntity getFormHDCT(){
    String maHDBan=txtMaHDBan.getText();
    String maSP=txtMaSP.getText();
    int soLuong =Integer.parseInt(txtSoLuong.getText());
    float giamGia=Float.parseFloat(txtGiamGia.getText());
    HoaDonChiTietEntity hdct= new HoaDonChiTietEntity(ABORT, maHDBan, maSP, maSP, soLuong, giamGia, ABORT);
    return hdct;
}

public void setFormHDCT(HoaDonChiTietEntity hdct){
    txtMaHoaDonCT.setText(String.valueOf(hdct.getMaHDCT()));
    txtMaHDBan.setText(hdct.getMaHDBan());
    txtSoLuong.setText(String.valueOf(hdct.getSoLuong()));
    txtMaSP.setText(hdct.getMaSP());
  txtGiamGia.setText(String.valueOf(hdct.getGiamGia()));
  txtTenSP.setText(hdct.getTenSP());
}

public void clearFormHDCT(){
     txtMaHoaDonCT.setText("");
    txtMaHDBan.setText("");
    txtSoLuong.setText("");
    txtMaSP.setText("");
  txtGiamGia.setText("");
  txtTenSP.setText("");
}
public void editHDCT(){
    int maHDCT=(int) tblHoaDonChiTiet.getValueAt(row, 0);
    HoaDonChiTietEntity hdct= hdctDAO.selectById(maHDCT);
    this.setFormHDCT(hdct);
}
public void firstCT(){
    this.row=0;
    this.editHDCT();
}
public void prevCT(){
    if(this.row>0){
       this.row--;
        this.editHDCT();
    }
}
public void nextCT(){
    if(this.row<tblHoaDonChiTiet.getRowCount()-1){
        this.row++;
        this.editHDCT();
    }
}
public void lastCT(){
    this.row=tblHoaDonChiTiet.getRowCount()-1;
    this.editHDCT();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgayBan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtTenKH = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        rdoThanhToan = new javax.swing.JRadioButton();
        rdoChuaThanhToan = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btnThemHDCT = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtMaHoaDonCT = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        btnSuaHDCT = new javax.swing.JButton();
        btnXoaHDCT = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMaHDBan = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        btnFirst1 = new javax.swing.JButton();
        btnPrev1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chung"));

        jLabel3.setText("MÃ NHÂN VIÊN :");

        jLabel8.setText("ĐỊA CHỈ :");

        jLabel4.setText("TÊN NHÂN VIÊN :");

        jLabel1.setText("MÃ HÓA ĐƠN :");

        jLabel6.setText("TÊN KHÁCH HÀNG :");

        jLabel2.setText("NGÀY BÁN :");

        jLabel7.setText("MÃ KHÁCH HÀNG :");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ HÓA ĐƠN", "MÃ NHÂN VIÊN", "NGÀY BÁN", "MÃ KHÁCH HÀNG", "THANH TOÁN"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnXoa.setBackground(new java.awt.Color(255, 204, 0));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete-button.png"))); // NOI18N
        btnXoa.setText("Delete");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(255, 204, 0));
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/new.png"))); // NOI18N
        btnMoi.setText("New");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(255, 204, 0));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/them.png"))); // NOI18N
        btnThem.setText("Save");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 204, 0));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sua.png"))); // NOI18N
        btnSua.setText("Edit");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel9.setText("TÌNH TRẠNG THANH TOÁN :");

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Xem tất cả hóa đơn?");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel5.setText("---------THÊM NHANH KHÁCH HÀNG---------");

        btnFirst.setBackground(new java.awt.Color(255, 204, 0));
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/last.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(255, 204, 0));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(255, 204, 0));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(255, 204, 0));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/first.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoThanhToan);
        rdoThanhToan.setText("Đã thanh toán");

        buttonGroup1.add(rdoChuaThanhToan);
        rdoChuaThanhToan.setText("Chưa thanh toán");
        rdoChuaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChuaThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)
                            .addComponent(jCheckBox1))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdoThanhToan)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoChuaThanhToan)))))
                        .addGap(44, 44, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(rdoThanhToan)
                    .addComponent(rdoChuaThanhToan))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jCheckBox1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hóa đơn", null, jPanel1, "");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chung"));

        btnThemHDCT.setBackground(new java.awt.Color(255, 204, 0));
        btnThemHDCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/them.png"))); // NOI18N
        btnThemHDCT.setText("Save");
        btnThemHDCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHDCTActionPerformed(evt);
            }
        });

        jLabel10.setText("MÃ HDCT :");

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HDCT", "Mã HD", "Mã SP", "Tên Sản Phẩm", "Số lượng", "Giảm Giá", "Thành tiền"
            }
        ));
        tblHoaDonChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChiTietMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDonChiTiet);

        btnSuaHDCT.setBackground(new java.awt.Color(255, 204, 0));
        btnSuaHDCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sua.png"))); // NOI18N
        btnSuaHDCT.setText("Edit");
        btnSuaHDCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHDCTActionPerformed(evt);
            }
        });

        btnXoaHDCT.setBackground(new java.awt.Color(255, 204, 0));
        btnXoaHDCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete-button.png"))); // NOI18N
        btnXoaHDCT.setText("Delete");
        btnXoaHDCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDCTActionPerformed(evt);
            }
        });

        btnIn.setBackground(new java.awt.Color(255, 204, 0));
        btnIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/in.png"))); // NOI18N
        btnIn.setText("In");

        jLabel15.setText("MÃ SP :");

        jLabel16.setText("TÊN SP :");

        jLabel17.setText("MÃ HD :");

        jLabel18.setText("SỐ LƯỢNG :");

        jLabel19.setText("GIẢM GIÁ :");

        btnFirst1.setBackground(new java.awt.Color(255, 204, 0));
        btnFirst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/last.png"))); // NOI18N
        btnFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst1ActionPerformed(evt);
            }
        });

        btnPrev1.setBackground(new java.awt.Color(255, 204, 0));
        btnPrev1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btnPrev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrev1ActionPerformed(evt);
            }
        });

        btnNext1.setBackground(new java.awt.Color(255, 204, 0));
        btnNext1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/next.png"))); // NOI18N
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        btnLast1.setBackground(new java.awt.Color(255, 204, 0));
        btnLast1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/first.png"))); // NOI18N
        btnLast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHoaDonCT, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaHDBan, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnThemHDCT)
                .addGap(18, 18, 18)
                .addComponent(btnSuaHDCT)
                .addGap(18, 18, 18)
                .addComponent(btnXoaHDCT)
                .addGap(18, 18, 18)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(btnFirst1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrev1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLast1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHoaDonCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel16))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtMaHDBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemHDCT)
                            .addComponent(btnSuaHDCT)
                            .addComponent(btnXoaHDCT))
                        .addComponent(btnIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnFirst1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrev1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLast1)))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Chi tiết hóa đơn", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            this.row=tblHoaDon.getSelectedRow();
            this.editHoaDon();
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnThemHDCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHDCTActionPerformed
        hdctDAO.insert(this.getFormHDCT());
        fillTableHoaDonChiTiet();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemHDCTActionPerformed

    private void btnXoaHDCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDCTActionPerformed
        // TODO add your handling code here:
        int maHDCT=Integer.parseInt(txtMaHoaDonCT.getText());
        hdctDAO.delete(maHDCT);
        fillTableHoaDonChiTiet();
    }//GEN-LAST:event_btnXoaHDCTActionPerformed

    private void btnSuaHDCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHDCTActionPerformed
        // TODO add your handling code here:
        hdctDAO.update(this.getFormHDCT());
        fillTableHoaDonChiTiet();
    }//GEN-LAST:event_btnSuaHDCTActionPerformed

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        // TODO add your handling code here:
        firstCT();
    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void btnPrev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev1ActionPerformed
        // TODO add your handling code here:
        prevCT();
    }//GEN-LAST:event_btnPrev1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
        nextCT();
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        // TODO add your handling code here:
        lastCT();
    }//GEN-LAST:event_btnLast1ActionPerformed

    private void tblHoaDonChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChiTietMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            this.row=tblHoaDonChiTiet.getSelectedRow();
            this.editHDCT();
        }
    }//GEN-LAST:event_tblHoaDonChiTietMouseClicked

    private void rdoChuaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChuaThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoChuaThanhToanActionPerformed

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDon_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HoaDon_JDialog dialog = new HoaDon_JDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnPrev1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaHDCT;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemHDCT;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaHDCT;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoChuaThanhToan;
    private javax.swing.JRadioButton rdoThanhToan;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHDBan;
    private javax.swing.JTextField txtMaHoaDonCT;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNgayBan;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
