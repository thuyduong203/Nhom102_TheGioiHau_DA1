/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

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
public class ChucVu {

    private String id;

    private String ma;

    private String ten;

    private Integer trangThai;

    public Object[] toDataRow() {
        return new Object[]{ma, ten, trangThai == 1 ? "Chưa xoá" : "Đã xoá"};
    }
}
