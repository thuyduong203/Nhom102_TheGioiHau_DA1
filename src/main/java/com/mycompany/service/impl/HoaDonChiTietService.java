/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.HoaDon;
import com.mycompany.domainModel.HoaDonChiTiet;
import com.mycompany.repository.impl.HoaDonChiTietRepository;
import com.mycompany.service.IHoaDonChiTiet;
import java.util.List;
import com.mycompany.service.ICommonService;
import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietService implements IHoaDonChiTiet<HoaDonChiTiet, String, HoaDon> {

    private final com.mycompany.repository.IHoaDonChiTiet hdctr = new HoaDonChiTietRepository();
    private HoaDonChiTietRepository hdctRep = new HoaDonChiTietRepository();

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hdctr.getAll();
    }

    @Override
    public HoaDonChiTiet getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(HoaDonChiTiet kh) {
        if ((Boolean) hdctr.add(kh)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(HoaDonChiTiet kh, HoaDon ma) {
        if ((Boolean) hdctr.update(kh, ma)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String remove(HoaDon ma) {
        if ((Boolean) hdctr.remove(ma)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

    public BigDecimal tongTienHD(List<HoaDonChiTiet> listHDCT) {
        return hdctRep.tinhTongTien(listHDCT);
    }

    public List<HoaDonChiTiet> getHDCTByHD(HoaDon hoaDon) {
        return hdctRep.getHDCTByHD(hoaDon);
    }

}
