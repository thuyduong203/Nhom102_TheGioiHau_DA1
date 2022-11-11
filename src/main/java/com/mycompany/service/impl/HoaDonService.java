/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

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

    public static void main(String[] args) {
        NhanVien nv = new NhanVien();
        nv.setId("E26EFCD1-8F31-446A-B791-5A11F3ED0C2A");
        KhachHang kh = new KhachHang();
        kh.setId("09D9DF89-6F3E-4DD1-8B1E-55E1835F3CEC");
        HoaDon hd = new HoaDon(null, "HD04", nv, kh, Date.valueOf("2022-11-11"), Date.valueOf("2022-11-11"), BigDecimal.valueOf(500000), "Tiền mặt", BigDecimal.valueOf(500000), "HIiii", 0);
        String test = new HoaDonService().add(hd);
        System.out.println(test);
    }

}
