/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

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
public class KhachHang {

    private String id;
    
    private String ma;
    
    private String ho;
    
    private String tenDem;
    
    private String ten;
    
    private String gioiTinh;
    
    private Date ngaySinh;
    
    private String sdt;
    
    private String diaChi;
    
    private String thanhPho;
    
    private String quocGia;
    
    private Integer trangThai;
    
}
