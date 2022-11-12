/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

import java.util.Calendar;
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
        return ma;
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
