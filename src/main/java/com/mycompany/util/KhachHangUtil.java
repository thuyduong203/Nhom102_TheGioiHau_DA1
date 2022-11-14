/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

import com.mycompany.domainModel.KhachHang;
import java.util.List;

/**
 *
 * @author Duongntt
 */
public class KhachHangUtil {

    public String zenMaKH(List<KhachHang> listKH) {
        String maKH = "KH";
        int sz = listKH.size();
        return maKH + (sz + 1);
    }
}
