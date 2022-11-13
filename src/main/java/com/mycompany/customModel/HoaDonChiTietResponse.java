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
public class HoaDonChiTietResponse {

    private String maMonAn;

    private String tenMonAn;

    private BigDecimal donGiaMonAn;

    private String maCombo;

    private String tenCombo;

    private BigDecimal donGiaCombo;

    public Object[] toDataRow(int stt) {
//        return new Object[]{stt, maMonAn, tenMonAn, donGiaMonAn,
//            maCombo != null ? maCombo : "", tenCombo != null ? tenCombo : "", donGiaCombo != null ? donGiaCombo : ""};
        return new Object[]{stt, maMonAn, tenMonAn, donGiaMonAn,maCombo==null?"":maCombo,tenCombo==null?"":tenCombo,donGiaCombo==null?"":donGiaCombo};
    }
}
