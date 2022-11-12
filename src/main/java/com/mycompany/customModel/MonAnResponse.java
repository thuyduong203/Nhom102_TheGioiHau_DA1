/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customModel;

import java.math.BigDecimal;
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
public class MonAnResponse {

    private String maMonAn;

    private String tenMonAn;

    private BigDecimal donGia;

    private String donViTinh;

    private String loaiMonAn;

    public Object[] toDataRow(int stt) {
        return new Object[]{stt, loaiMonAn, maMonAn, tenMonAn, donGia, donViTinh};
    }
}
