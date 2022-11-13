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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoaDonResponse {

    private String maHoaDon;

    private String maKhachHang;

    private String ngayTao;

    private Integer maBan;

    private Integer trangThai;

    private String ghiChu;
    
    public Object[] toDataRow(int stt) {
        return new Object[]{stt, maHoaDon, maKhachHang!=null?maKhachHang:"", ngayTao, maBan, checkTrangThai(trangThai), ghiChu};
    }

    private String checkTrangThai(int trangThai) {
        if (trangThai == 0) {
            return "Chờ thanh toán";
        } else if (trangThai == 1) {
            return "Đã thanh toán";
        } else {
            return "Đã huỷ";
        }
    }

}
