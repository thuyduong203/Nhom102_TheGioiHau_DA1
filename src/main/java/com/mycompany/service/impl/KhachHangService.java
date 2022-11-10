/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.KhachHang;
import com.mycompany.repository.impl.KhachHangRepository;
import java.util.List;
import com.mycompany.repository.ICommonRepository;

/**
 *
 * @author Admin
 */
public class KhachHangService implements com.mycompany.service.ICommonService<KhachHang,String> {

    private final ICommonRepository khr = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return khr.getAll();
    }

    @Override
    public KhachHang getOne(String ma) {
        return (KhachHang) khr.getOne(ma);
    }

    @Override
    public String add(KhachHang kh) {
        if ((Boolean) khr.add(kh)) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }

    }

    @Override
    public String update(KhachHang kh, String ma) {
        if ((Boolean) khr.update(kh, ma)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String remove(String ma) {
        if ((Boolean) khr.remove(ma)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }
}
