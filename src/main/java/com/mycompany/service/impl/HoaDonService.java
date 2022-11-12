/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.Ban;
import com.mycompany.domainModel.HoaDon;
import com.mycompany.domainModel.KhachHang;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.repository.ICommonRepository;
import com.mycompany.repository.impl.HoaDonRepository;
import com.mycompany.service.ICommonService;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonService implements ICommonService<HoaDon, String> {

    private ICommonRepository hdr = new HoaDonRepository();

    @Override
    public List<HoaDon> getAll() {
        return hdr.getAll();
    }

    @Override
    public HoaDon getOne(String ma) {
        return (HoaDon) hdr.getOne(ma);
    }

    @Override
    public String add(HoaDon kh) {
        if ((Boolean) hdr.add(kh)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(HoaDon kh, String ma) {
        if ((Boolean) hdr.update(kh, ma)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String remove(String ma) {
        if ((Boolean) hdr.remove(ma)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

//    public static void main(String[] args) {
//        
//        NhanVien nv = new NhanVien();
//        nv.setId("A6FE78AD-C869-4C07-A70D-2DF2F07EB60D");
//        KhachHang kh = new KhachHang();
//        kh.setId("1D998F16-99A2-46DE-8EC1-18196017A20C");
//        Ban b = new Ban();
//        b.setId("6328E69A-4B84-41D2-A407-B236CBA20867");
//        HoaDon hd= new HoaDon();
//        hd.setMaHoaDon("HD02");
//        hd.setNhanVien(nv);
//        hd.setKhachHang(kh);
//        hd.setBan(b);
//        hd.setNgayTao(Date.valueOf("2022-11-12"));
//        hd.setNgayThanhToan(Date.valueOf("2022-11-12"));
//        hd.setTongTien(BigDecimal.valueOf(10000));
//        hd.setGhiChu("haaaaa");
//        hd.setTrangThai(0);
//        String test = new HoaDonService().remove("HD02");
//        System.out.println(test);
//        List<HoaDon> hoaDons = new HoaDonService().getAll();
//        for (HoaDon hoaDon : hoaDons) {
//            System.out.println(hoaDon.toString());
//        }
//
//    }

}
