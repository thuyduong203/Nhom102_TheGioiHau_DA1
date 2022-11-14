/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

import com.mycompany.domainModel.HoaDon;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class HoaDonUtil {

    public String zenMa() {
        String ma = "HD";
        Random rd = new Random();

        for (int i = 0; i < 6; i++) {
            ma += rd.nextInt(10);
        }
        //dsad
        return ma;
    }
    public String zenMaThuyDuong(List<HoaDon> listHD) {
        String ma = "HD";
        Random rd = new Random();
        return ma + String.valueOf(listHD.size() + 1);
    }
    
    public String layNgay() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String namThangNgay = year + "-" + month + "-" + day;
        return namThangNgay;
    }
    
}
