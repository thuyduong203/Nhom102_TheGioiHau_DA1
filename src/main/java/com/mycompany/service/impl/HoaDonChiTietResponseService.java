/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.HoaDonChiTietResponse;
import com.mycompany.domainModel.HoaDon;
import com.mycompany.repository.ICommonResponseRepository;
import com.mycompany.repository.impl.HoaDonChiTietResponseRepository;
import com.mycompany.service.ICommonResponseService;
import java.util.List;
import com.mycompany.repository.IHoaDonChiTietResponseRepository;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietResponseService implements com.mycompany.service.IHoaDonChiTietResponseService<HoaDonChiTietResponse, HoaDon> {

    private final IHoaDonChiTietResponseRepository hdctrr = new HoaDonChiTietResponseRepository();

    @Override
    public List<HoaDonChiTietResponse> getAll(HoaDon hoaDon) {
        return hdctrr.getAll(hoaDon);
    }

    public static void main(String[] args) {
        HoaDon hd = new HoaDon();
        hd.setId("7E52228F-F719-4E7D-9BCF-FB1F2DDAB7C4");
        List<HoaDonChiTietResponse> chiTietResponses = new HoaDonChiTietResponseService().getAll(hd);
        for (HoaDonChiTietResponse chiTietResponse : chiTietResponses) {
            System.out.println(chiTietResponse);
        }
    }
}
