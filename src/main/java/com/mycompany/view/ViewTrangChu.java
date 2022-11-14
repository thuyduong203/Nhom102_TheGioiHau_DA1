/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.view;

import com.mycompany.customModel.BanResponse;
import com.mycompany.customModel.ComboResponse;
import com.mycompany.customModel.HoaDonChiTietResponse;
import com.mycompany.customModel.HoaDonResponse;
import com.mycompany.customModel.MonAnResponse;
import com.mycompany.domainModel.Ban;
import com.mycompany.domainModel.ComBo;
import com.mycompany.domainModel.GiaoDich;
import com.mycompany.domainModel.HoaDon;
import com.mycompany.domainModel.HoaDonChiTiet;
import com.mycompany.domainModel.MonAn;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.service.impl.HoaDonChiTietResponseService;
import com.mycompany.service.ICommonResponseService;
import com.mycompany.service.ICommonService;
import com.mycompany.service.IHoaDonChiTiet;
import com.mycompany.service.IHoaDonChiTietResponseService;
import com.mycompany.service.impl.BanResponseService;
import com.mycompany.service.impl.BanService;
import com.mycompany.service.impl.ComBoService;
import com.mycompany.service.impl.ComboResponseService;
import com.mycompany.service.impl.GiaoDichService;
import com.mycompany.service.impl.HoaDonChiTietService;
import com.mycompany.service.impl.HoaDonResponseService;
import com.mycompany.service.impl.HoaDonService;
import com.mycompany.service.impl.MonAnResponseService;
import com.mycompany.service.impl.MonAnService;
import com.mycompany.service.impl.NhanVienService;
import com.mycompany.util.HoaDonUtil;
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ViewTrangChu extends javax.swing.JFrame {

    private DefaultTableModel dtmHoaDon = new DefaultTableModel();
    private DefaultTableModel dtmHoaDonCT = new DefaultTableModel();
    private DefaultTableModel dtmBan = new DefaultTableModel();
    private DefaultTableModel dtmMonAn = new DefaultTableModel();
    private DefaultTableModel dtmCombo = new DefaultTableModel();
    private List<MonAnResponse> lstMonAnResponses = new ArrayList<>();
    private List<BanResponse> lstBanResponses = new ArrayList<>();
    private List<HoaDonResponse> lstHoaDonResponses = new ArrayList<>();
    private List<HoaDonChiTietResponse> lstHDCTResponses = new ArrayList<>();
    private List<ComboResponse> lstComboResponses = new ArrayList<>();
    private ICommonResponseService monAnResponseService = new MonAnResponseService();
    private ICommonResponseService banResponseService = new BanResponseService();
    private ICommonResponseService hoaDonResponseService = new HoaDonResponseService();
    private ICommonResponseService comboResponseService = new ComboResponseService();
    private ICommonService hds = new HoaDonService();
    private ICommonService mas = new MonAnService();
    private ICommonService cbs = new ComBoService();
    private ICommonService gds = new GiaoDichService();
    private ICommonService nvs = new NhanVienService();
    private ICommonService monAnService = new MonAnService();
    private ICommonService banService = new BanService();
    private IHoaDonChiTiet hdctService = new HoaDonChiTietService();
    private IHoaDonChiTietResponseService hdctResponseService = new HoaDonChiTietResponseService();
    private int checkTrangThaiHD;
    private int checkTaoHD = 1;
    private int checkMonAn = 1;
    private int checkBtnMonAn = 1;
    private List<HoaDon> listHD = new ArrayList<>();
    private HoaDonService hoaDonService = new HoaDonService();
    private HoaDonUtil hoaDonUtil = new HoaDonUtil();
    // thực thể
    private NhanVien nhanV;

    /**
     * Creates new form View
     */
    public ViewTrangChu(NhanVien nv) {
        initComponents();
        nhanV = nv;
        tbHoaDon.setModel(dtmHoaDon);
        tbHoaDonCT.setModel(dtmHoaDonCT);
        tbBan.setModel(dtmBan);
        String headerHoaDon[] = {"STT", "MÃ HĐ", "MÃ KH", "Ngày Tạo", "Bàn", "Trạng Thái", "Ghi Chú"};
        String headerHoaDonCT[] = {"STT", "Mã món ăn", "Tên món ăn", "Giá món ăn", "Mã combo", "Tên combo", "Giá combo", "Tổng Tiền"};
        String headerBan[] = {"STT", "Mã Bàn", "Số lượng chỗ ngồi", "Khu vực", "Trạng thái"};
        loadTableMonAn();
        dtmHoaDon.setColumnIdentifiers(headerHoaDon);
        dtmHoaDonCT.setColumnIdentifiers(headerHoaDonCT);
        dtmBan.setColumnIdentifiers(headerBan);
        lstBanResponses = banResponseService.getAll();
        lstHoaDonResponses = hoaDonResponseService.getAll();
        lstMonAnResponses = monAnResponseService.getAll();
        showDataMonAn(lstMonAnResponses);
        showDataBan(lstBanResponses);
        showDataHoaDon(lstHoaDonResponses);
        showDataHDCT(lstHDCTResponses);
        btnDoAn.setBackground(Color.GRAY);
        txtChuyenKhoan.setEnabled(false);
        txtTienMat.setEnabled(false);
        txtChuyenKhoan.setText("0");
        txtTienMat.setText("0");
        lbNhanVien.setText(nv.getMa());
//        txtTongTien.setText("0");
//        txtTienThua.setText("0");
//        fillTienThua();
    }

    private void fillTienThua() {
        Double tienThua = 0.0;
        Double tongTienTatCa = Double.valueOf(txtTienMat.getText()) + Double.valueOf(txtChuyenKhoan.getText());
        tienThua = tongTienTatCa - Double.valueOf(txtTongTien.getText());
        txtTienThua.setText(tienThua.toString());
    }

    private void fillTongTien() {
        Double tongTien = Double.valueOf(0);
        for (HoaDonChiTietResponse lstHDCTResponse : lstHDCTResponses) {
            String giaCB = lstHDCTResponse.getDonGiaCombo().toString();
            String giaMA = lstHDCTResponse.getDonGiaMonAn().toString();
            tongTien += (Double.valueOf(giaCB) * 1) + (Double.valueOf(giaMA) * 1);
        }
        txtTongTien.setText(tongTien.toString());
    }

    private void loadTableCombo() {
        String header[] = {"STT", "Mã Combo", "Tên Combo", "Đơn giá"};
        tbMonAn.setModel(dtmCombo);
        dtmCombo.setColumnIdentifiers(header);
    }

    private void loadTableMonAn() {
        String headerMonAn[] = {"STT", "Loại món ăn", "Mã món ăn", "Tên món ăn", "Đơn giá", "Đơn vị tính"};
        tbMonAn.setModel(dtmMonAn);
        dtmMonAn.setColumnIdentifiers(headerMonAn);
    }

    private void showDataMonAn(List<MonAnResponse> monAnResponses) {
        dtmMonAn.setRowCount(0);
        int stt = 0;
        for (MonAnResponse monAnResponse : monAnResponses) {
            stt++;
            dtmMonAn.addRow(monAnResponse.toDataRow(stt));
        }
    }

    private void showDataHDCT(List<HoaDonChiTietResponse> hoaDonChiTietResponses) {
        dtmHoaDonCT.setRowCount(0);
        int stt = 0;
        for (HoaDonChiTietResponse hoaDonChiTietResponse : hoaDonChiTietResponses) {
            stt++;
            dtmHoaDonCT.addRow(hoaDonChiTietResponse.toDataRow(stt));
        }
    }

    private void showDataHoaDon(List<HoaDonResponse> hoaDonResponses) {
        dtmHoaDon.setRowCount(0);
        int stt = 0;
        for (HoaDonResponse hoaDonResponse : hoaDonResponses) {
            stt++;
            dtmHoaDon.addRow(hoaDonResponse.toDataRow(stt));
        }
    }

    private void showDataBan(List<BanResponse> banResponses) {
        dtmBan.setRowCount(0);
        int stt = 0;
        for (BanResponse banResponse : banResponses) {
            stt++;
            dtmBan.addRow(banResponse.toDataRow(stt));
        }
    }

    private void loadDataCombo(List<ComboResponse> comboResponses) {
        dtmCombo.setRowCount(0);
        int stt = 0;
        for (ComboResponse comboResponse : comboResponses) {
            stt++;
            dtmCombo.addRow(comboResponse.toDataRow(stt));
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioTrangThaiHD = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtTienMat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDonCT = new javax.swing.JTable();
        lbMaHDThanhToan = new javax.swing.JLabel();
        lbSoBan = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtSdt = new javax.swing.JTextField();
        btnSearchKhachHang = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        btnThemKhachHang = new javax.swing.JButton();
        btnTaoHD = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        lbMaHD = new javax.swing.JLabel();
        btnThanhToanVaIn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnGiaoCa = new javax.swing.JButton();
        btnDoiMK = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbTenSanPham = new javax.swing.JTextField();
        btnSearchSanPham = new javax.swing.JButton();
        btnDoAn = new javax.swing.JButton();
        btnDoUong = new javax.swing.JButton();
        btnCombo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbMonAn = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbbTang = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBan = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbBan1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbNhanVien = new javax.swing.JLabel();
        lbNgayGio = new javax.swing.JLabel();
        btnTrangChu = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnBan = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();
        btnTachHD = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnTachBan = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbTienMat = new javax.swing.JCheckBox();
        cbChuyenKhoan = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        txtChuyenKhoan = new javax.swing.JTextField();
        radioTatCa = new javax.swing.JRadioButton();
        radioChoThanhToan = new javax.swing.JRadioButton();
        raidoDaThanhToan = new javax.swing.JRadioButton();
        radioDaHuy = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(1242, 620));

        txtTienMat.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtTienMatInputMethodTextChanged(evt);
            }
        });

        tbHoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbHoaDonCT);

        jPanel8.setBackground(new java.awt.Color(255, 153, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("HÓA ĐƠN");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 204, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        btnSearchKhachHang.setBackground(new java.awt.Color(51, 255, 51));
        btnSearchKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearchKhachHang.setText("Search");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("SĐT:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Tên: ");

        btnThemKhachHang.setBackground(new java.awt.Color(153, 153, 153));
        btnThemKhachHang.setText("+");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearchKhachHang)
                            .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKhachHang))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnTaoHD.setBackground(new java.awt.Color(51, 255, 51));
        btnTaoHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoHD.setText("TẠO HĐ");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 153, 51));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("HÓA ĐƠN CT");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbHoaDon);

        btnThanhToanVaIn.setBackground(new java.awt.Color(204, 204, 204));
        btnThanhToanVaIn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhToanVaIn.setText("Thanh Toán & In");

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        btnGiaoCa.setBackground(new java.awt.Color(204, 204, 204));
        btnGiaoCa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGiaoCa.setText("GIAO CA");

        btnDoiMK.setBackground(new java.awt.Color(204, 204, 204));
        btnDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoiMK.setText("ĐỔI MK");

        btnDangXuat.setBackground(new java.awt.Color(204, 204, 204));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangXuat.setText("ĐĂNG XUẤT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnGiaoCa)
                .addGap(18, 18, 18)
                .addComponent(btnDoiMK)
                .addGap(18, 18, 18)
                .addComponent(btnDangXuat)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGiaoCa)
                    .addComponent(btnDangXuat)
                    .addComponent(btnDoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(204, 255, 0));

        jLabel7.setBackground(new java.awt.Color(204, 255, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("MÃ HĐ:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnThanhToan.setBackground(new java.awt.Color(51, 255, 51));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(255, 0, 0));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setText("Hủy");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Mã HĐ: ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Tổng Tiền:");

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên sản phẩm :");

        btnSearchSanPham.setBackground(new java.awt.Color(51, 255, 51));
        btnSearchSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearchSanPham.setText("Search");

        btnDoAn.setBackground(new java.awt.Color(255, 255, 153));
        btnDoAn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoAn.setText("Đồ Ăn");
        btnDoAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoAnActionPerformed(evt);
            }
        });

        btnDoUong.setBackground(new java.awt.Color(204, 204, 204));
        btnDoUong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoUong.setText("Đồ Uống");
        btnDoUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoUongActionPerformed(evt);
            }
        });

        btnCombo.setBackground(new java.awt.Color(204, 204, 204));
        btnCombo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCombo.setText("Combo");
        btnCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComboActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tbMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMonAnMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbMonAn);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(102, 255, 102));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Bàn");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        cbbTang.setBackground(new java.awt.Color(102, 255, 102));
        cbbTang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbTang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tầng 1", "Tầng 2" }));
        cbbTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTangActionPerformed(evt);
            }
        });

        tbBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbBan);

        tbBan1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbBan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBan1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbBan1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lbTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchSanPham))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnDoAn)
                                .addGap(18, 18, 18)
                                .addComponent(btnDoUong)
                                .addGap(18, 18, 18)
                                .addComponent(btnCombo)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchSanPham))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDoAn)
                            .addComponent(btnDoUong)
                            .addComponent(btnCombo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(439, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        lbNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNhanVien.setText("Welcome: Nguyễn Đức Dụng - Nhân Viên");

        lbNgayGio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNgayGio.setText("12:05:13 10-11-2022");

        btnTrangChu.setBackground(new java.awt.Color(255, 255, 153));
        btnTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTrangChu.setText("TRANG CHỦ");
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        btnHoaDon.setBackground(new java.awt.Color(204, 204, 204));
        btnHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHoaDon.setText("HÓA ĐƠN");

        btnKhachHang.setBackground(new java.awt.Color(204, 204, 204));
        btnKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhachHang.setText("KHÁCH HÀNG");

        btnBan.setBackground(new java.awt.Color(204, 204, 204));
        btnBan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBan.setText("BÀN");
        btnBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanActionPerformed(evt);
            }
        });

        btnKhuyenMai.setBackground(new java.awt.Color(204, 204, 204));
        btnKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhuyenMai.setText("KHUYẾN MÃI");

        btnSanPham.setBackground(new java.awt.Color(204, 204, 204));
        btnSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSanPham.setText("SẢN PHẨM");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(204, 204, 204));
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(204, 204, 204));
        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhanVien.setText("NHÂN VIÊN");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNgayGio, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTrangChu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhachHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhuyenMai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSanPham)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbNgayGio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSanPham)
                            .addComponent(btnKhuyenMai)
                            .addComponent(btnBan)
                            .addComponent(btnKhachHang)
                            .addComponent(btnHoaDon)
                            .addComponent(btnTrangChu)
                            .addComponent(btnThongKe)
                            .addComponent(btnNhanVien))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIn.setBackground(new java.awt.Color(204, 204, 204));
        btnIn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIn.setText("In");

        btnTachHD.setBackground(new java.awt.Color(204, 204, 204));
        btnTachHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTachHD.setText("Tách HĐ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Tiền Thừa: ");

        btnTachBan.setBackground(new java.awt.Color(204, 204, 204));
        btnTachBan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTachBan.setText("Tách bàn");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Bàn: ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Tiền mặt:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Loại Thanh Toán: ");

        cbTienMat.setText("Tiền mặt");
        cbTienMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTienMatActionPerformed(evt);
            }
        });

        cbChuyenKhoan.setText("Chuyển khoản");
        cbChuyenKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChuyenKhoanActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Chuyển khoản:");

        radioTrangThaiHD.add(radioTatCa);
        radioTatCa.setText("Tất cả");

        radioTrangThaiHD.add(radioChoThanhToan);
        radioChoThanhToan.setText("Chờ thanh toán");

        radioTrangThaiHD.add(raidoDaThanhToan);
        raidoDaThanhToan.setText("Đã thanh toán");

        radioTrangThaiHD.add(radioDaHuy);
        radioDaHuy.setText("Đã huỷ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(radioTatCa)
                        .addGap(38, 38, 38)
                        .addComponent(radioChoThanhToan)
                        .addGap(29, 29, 29)
                        .addComponent(raidoDaThanhToan)
                        .addGap(46, 46, 46)
                        .addComponent(radioDaHuy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTaoHD))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(lbMaHDThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTienThua)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(36, 36, 36)
                                .addComponent(lbSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(41, 41, 41)
                                .addComponent(cbTienMat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbChuyenKhoan)))
                        .addGap(12, 12, 12)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTachBan)
                        .addGap(18, 18, 18)
                        .addComponent(btnTachHD)
                        .addGap(18, 18, 18)
                        .addComponent(btnIn)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy)
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhToan)
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhToanVaIn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnTaoHD))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(radioTatCa)
                                .addComponent(radioChoThanhToan)
                                .addComponent(raidoDaThanhToan)
                                .addComponent(radioDaHuy)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12)
                                    .addComponent(lbMaHDThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(cbTienMat)
                                    .addComponent(cbChuyenKhoan))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnThanhToanVaIn)
                                    .addComponent(btnThanhToan)
                                    .addComponent(btnHuy)
                                    .addComponent(btnIn)
                                    .addComponent(btnTachHD)
                                    .addComponent(btnTachBan))
                                .addContainerGap())))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbbTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTangActionPerformed
        // TODO add your handling code here:
//        if (cbbTang.getSelectedItem() == "Tầng 2") {
//            btnBan1.setText("Bàn 16");
//        } else {
//            btnBan1.setText("Bàn 1");
//        }
    }//GEN-LAST:event_cbbTangActionPerformed

    private void tbMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMonAnMouseClicked
        // TODO add your handling code here:
        if (checkBtnMonAn == 1) {
            if (checkTrangThaiHD == 1) {
                JOptionPane.showMessageDialog(this, "Không thể thêm sản phẩm");
                return;
            } else if (checkMonAn == 1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hoá đơn");
                return;
            } else {
                int index = tbMonAn.getSelectedRow();
                MonAnResponse mar = lstMonAnResponses.get(index);
                MonAn ma = (MonAn) mas.getOne(mar.getMaMonAn());
                HoaDon hd = (HoaDon) hds.getOne(lbMaHD.getText());
                HoaDonChiTiet hdct = new HoaDonChiTiet(null, ma, hd, null, 1, ma.getDonGia(), 0, BigDecimal.valueOf(0));
                String addHDCT = (String) hdctService.add(hdct);
                lstHDCTResponses = hdctResponseService.getAll(hd);
                showDataHDCT(lstHDCTResponses);
                fillTongTien();
                return;
            }
        }
        if (checkBtnMonAn == 2) {
            //thêm sản phẩm nước uống vào hdct
        } else {
            if (checkTrangThaiHD == 1) {
                JOptionPane.showMessageDialog(this, "Không thể thêm sản phẩm");
            } else if (checkMonAn == 1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hoá đơn");
            } else {
                int index = tbMonAn.getSelectedRow();
                ComboResponse cbr = lstComboResponses.get(index);
                ComBo cb = (ComBo) cbs.getOne(cbr.getMaCB());
                HoaDon hd = (HoaDon) hds.getOne(lbMaHD.getText());
                HoaDonChiTiet hdct = new HoaDonChiTiet(null, null, hd, cb, 0, BigDecimal.valueOf(0), 1, cb.getDonGia());
                String addHDCT = (String) hdctService.add(hdct);
                lstHDCTResponses = hdctResponseService.getAll(hd);
                showDataHDCT(lstHDCTResponses);
                fillTongTien();
            }
        }
    }//GEN-LAST:event_tbMonAnMouseClicked

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        // TODO add your handling code here:
        int index = tbHoaDon.getSelectedRow();
        HoaDonResponse hdr = lstHoaDonResponses.get(index);
        lbMaHD.setText(hdr.getMaHoaDon());
        HoaDon hd = (HoaDon) hds.getOne(lbMaHD.getText());
        lbSoBan.setText(hd.getBan().getMaBan().toString());
        if (hd.getTrangThai() == 0) {
            checkTrangThaiHD = 0;
            checkMonAn = 0;
            lbMaHDThanhToan.setText(hdr.getMaHoaDon());
        } else {
            checkTrangThaiHD = 1;
            lbMaHDThanhToan.setText("");
        }
        lstHDCTResponses = hdctResponseService.getAll(hd);
        showDataHDCT(lstHDCTResponses);
        fillTongTien();
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void tbBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBanMouseClicked
        // TODO add your handling code here:
        int index = tbBan.getSelectedRow();
        BanResponse banResponse = lstBanResponses.get(index);
        lbSoBan.setText(banResponse.getMaBan().toString());
        checkTaoHD = 0;
    }//GEN-LAST:event_tbBanMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        if ("".equals(lbMaHDThanhToan.getText())) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hoá đơn chưa thanh toán");
        } else if (cbChuyenKhoan.isSelected() == false && cbTienMat.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hình thức thanh toán");
        } else if (Double.valueOf(txtTongTien.getText()) > (Double.valueOf(txtTienMat.getText()) + Double.valueOf(txtChuyenKhoan.getText()))) {
            JOptionPane.showMessageDialog(this, "Chưa đủ tiền");
        } else {
            String hinhThucThanhToan = "";
            Double tongTien = Double.valueOf(txtTongTien.getText());
            String ngayThanhToan = new HoaDonUtil().layNgay();
            Ban ban = (Ban) banService.getOne(lbSoBan.getText());
            ban.setTrangThai(0);
            NhanVien nv = (NhanVien) nvs.getOne("NV02");
            HoaDon hd = (HoaDon) hds.getOne(lbMaHDThanhToan.getText());
            hd.setTrangThai(1);
            hd.setBan(ban);
            hd.setNhanVien(nv);
            hd.setTongTien(BigDecimal.valueOf(tongTien));
            hd.setNgayThanhToan(Date.valueOf(ngayThanhToan));
            if (cbTienMat.isSelected() && cbChuyenKhoan.isSelected()) {
                GiaoDich gd = new GiaoDich(null, hd, "Tiền mặt", BigDecimal.valueOf(Double.valueOf(txtTienMat.getText())));
                String addGD = (String) gds.add(gd);
                GiaoDich gd1 = new GiaoDich(null, hd, "Chuyển khoản", BigDecimal.valueOf(Double.valueOf(txtChuyenKhoan.getText())));
                String addGD1 = (String) gds.add(gd1);
                String addHD = (String) hds.update(hd, lbMaHDThanhToan.getText());
                String setTrangThaiBan = (String) banService.update(ban, ban.getMaBan().toString());
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                lstHoaDonResponses = hoaDonResponseService.getAll();
                lstBanResponses = banResponseService.getAll();
                showDataHoaDon(lstHoaDonResponses);
                showDataBan(lstBanResponses);
                return;
            } else if (cbChuyenKhoan.isSelected()) {
                hinhThucThanhToan = "Chuyển khoản";
                GiaoDich gd = new GiaoDich(null, hd, hinhThucThanhToan, BigDecimal.valueOf(Double.valueOf(txtChuyenKhoan.getText())));
                String addGD = (String) gds.add(gd);
                String addHD = (String) hds.update(hd, lbMaHDThanhToan.getText());
                String setTrangThaiBan = (String) banService.update(ban, ban.getMaBan().toString());
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                lstHoaDonResponses = hoaDonResponseService.getAll();
                lstBanResponses = banResponseService.getAll();
                showDataHoaDon(lstHoaDonResponses);
                showDataBan(lstBanResponses);
                return;
            } else {
                hinhThucThanhToan = "Tiền mặt";
                GiaoDich gd = new GiaoDich(null, hd, hinhThucThanhToan, BigDecimal.valueOf(Double.valueOf(txtTienMat.getText())));
                String addGD = (String) gds.add(gd);
                String addHD = (String) hds.update(hd, lbMaHDThanhToan.getText());
                String setTrangThaiBan = (String) banService.update(ban, ban.getMaBan().toString());
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                lstHoaDonResponses = hoaDonResponseService.getAll();
                lstBanResponses = banResponseService.getAll();
                showDataHoaDon(lstHoaDonResponses);
                showDataBan(lstBanResponses);
            }

        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here:
        if ("".equals(lbSoBan.getText())) {
            JOptionPane.showMessageDialog(this, "Chọn bàn trước");
        } else {
            listHD = hoaDonService.getAll();
            String maHD = hoaDonUtil.zenMaThuyDuong(listHD);
            String ngayTao = new HoaDonUtil().layNgay();
            String ngayThanhToan = new HoaDonUtil().layNgay();
            NhanVien nhanVien = (NhanVien) nvs.getOne("NV02");
            Ban ban = (Ban) banService.getOne(lbSoBan.getText());
            ban.setTrangThai(1);
            String setTrangThaiBan = (String) banService.update(ban, ban.getMaBan().toString());
            HoaDon hd = new HoaDon(null, maHD, nhanVien, null, ban, ngayTao, Date.valueOf(ngayThanhToan), null, null, 0);
            JOptionPane.showMessageDialog(this, hds.add(hd));
            lstHoaDonResponses = hoaDonResponseService.getAll();
            lstBanResponses = banResponseService.getAll();
            showDataHoaDon(lstHoaDonResponses);
            showDataBan(lstBanResponses);
        }
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnDoUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoUongActionPerformed
        // TODO add your handling code here:
        btnDoAn.setBackground(Color.WHITE);
        btnDoUong.setBackground(Color.GRAY);
        btnCombo.setBackground(Color.WHITE);

    }//GEN-LAST:event_btnDoUongActionPerformed

    private void btnDoAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoAnActionPerformed
        // TODO add your handling code here:
        checkBtnMonAn = 1;
        btnDoUong.setBackground(Color.WHITE);
        btnDoAn.setBackground(Color.GRAY);
        btnCombo.setBackground(Color.WHITE);
        loadTableMonAn();
        lstMonAnResponses = monAnResponseService.getAll();
        showDataMonAn(lstMonAnResponses);
    }//GEN-LAST:event_btnDoAnActionPerformed

    private void cbTienMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTienMatActionPerformed
        // TODO add your handling code here:
        if (cbTienMat.isSelected()) {
            txtTienMat.setEnabled(true);
        } else {
            txtTienMat.setText("0");
            txtTienMat.setEnabled(false);
        }
    }//GEN-LAST:event_cbTienMatActionPerformed

    private void cbChuyenKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChuyenKhoanActionPerformed
        // TODO add your handling code here:
        if (cbChuyenKhoan.isSelected()) {
            txtChuyenKhoan.setEnabled(true);
        } else {
            txtChuyenKhoan.setText("0");
            txtChuyenKhoan.setEnabled(false);
        }
    }//GEN-LAST:event_cbChuyenKhoanActionPerformed

    private void btnComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComboActionPerformed
        // TODO add your handling code here:
        checkBtnMonAn = 3;
        btnDoUong.setBackground(Color.WHITE);
        btnDoAn.setBackground(Color.WHITE);
        btnCombo.setBackground(Color.GRAY);
        loadTableCombo();
        lstComboResponses = comboResponseService.getAll();
        loadDataCombo(lstComboResponses);
    }//GEN-LAST:event_btnComboActionPerformed

    private void tbBan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBan1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbBan1MouseClicked

    private void txtTienMatInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTienMatInputMethodTextChanged
        // TODO add your handling code here:
//        fillTienThua();
    }//GEN-LAST:event_txtTienMatInputMethodTextChanged

    private void btnBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanActionPerformed
        // TODO add your handling code here:
        ViewBan viewBan = new ViewBan(nhanV);
        this.dispose();
        viewBan.setVisible(true);
    }//GEN-LAST:event_btnBanActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        ViewNhanVien viewNhanVien = new ViewNhanVien(nhanV);
        this.dispose();
        viewNhanVien.setVisible(true);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        ViewThongKe viewThongKe = new ViewThongKe(nhanV);
        this.dispose();
        viewThongKe.setVisible(true);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        // TODO add your handling code here:
        ViewSanPham viewSanPham = new ViewSanPham(nhanV);
        this.dispose();
        viewSanPham.setVisible(true);
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrangChuActionPerformed

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
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewTrangChu().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBan;
    private javax.swing.JButton btnCombo;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoAn;
    private javax.swing.JButton btnDoUong;
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JButton btnGiaoCa;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnSearchKhachHang;
    private javax.swing.JButton btnSearchSanPham;
    private javax.swing.JButton btnTachBan;
    private javax.swing.JButton btnTachHD;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThanhToanVaIn;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JCheckBox cbChuyenKhoan;
    private javax.swing.JCheckBox cbTienMat;
    private javax.swing.JComboBox<String> cbbTang;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbMaHDThanhToan;
    private javax.swing.JLabel lbNgayGio;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JLabel lbSoBan;
    private javax.swing.JTextField lbTenSanPham;
    private javax.swing.JRadioButton radioChoThanhToan;
    private javax.swing.JRadioButton radioDaHuy;
    private javax.swing.JRadioButton radioTatCa;
    private javax.swing.ButtonGroup radioTrangThaiHD;
    private javax.swing.JRadioButton raidoDaThanhToan;
    private javax.swing.JTable tbBan;
    private javax.swing.JTable tbBan1;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbHoaDonCT;
    private javax.swing.JTable tbMonAn;
    private javax.swing.JTextField txtChuyenKhoan;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienMat;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
