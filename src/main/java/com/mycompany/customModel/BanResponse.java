/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customModel;

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
public class BanResponse {

    private Integer maBan;

    private Integer soLuongChoNgoi;

    private String tenKhuVuc;

    private Integer trangThai;

    public Object[] toDataRow(int stt) {
        return new Object[]{stt, maBan, soLuongChoNgoi, tenKhuVuc, trangThai == 0 ? "Còn trống" : "Đã có khách"};
    }
}
