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
public class NhanVien {

    private String id;

    private String ma;

    private ChucVu chucVu;

    private String ho;

    private String tenDem;

    private String ten;

    private String gioiTinh;

    private String soDienThoai;

    private Date ngaySinh;

    private String matKhau;

    private Integer trangThai;
    
}
