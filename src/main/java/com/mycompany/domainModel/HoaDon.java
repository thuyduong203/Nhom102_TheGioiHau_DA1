/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoaDon {
    private String id;
    
    private String maHoaDon;
    
    private NhanVien nhanVien;
    
    private KhachHang khachHang;
    
    private Date ngayTao;
    
    private Date ngayThanhToan;
    
    private BigDecimal tienKhachDua;
    
    private String ghiChu;
    
    private Integer trangThai;
    
}
