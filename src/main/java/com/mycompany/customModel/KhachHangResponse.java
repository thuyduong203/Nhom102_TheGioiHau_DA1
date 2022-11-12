/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customModel;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Admin
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class KhachHangResponse {

    private String ma;

    private String hoTen;

    private String gioiTinh;

    private Date ngaySinh;

    private String sdt;

    private String diaChi;

    private String thanhPho;

    private String quocGia;
    
//    public Object[] toDataRow() {
//        return new Object[]{ma, hoTen, gioiTinh, ngaySinh, sdt, diaChi, thanhPho, quocGia};
//    }
}
