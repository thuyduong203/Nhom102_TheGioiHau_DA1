/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.KhuyenMaiChiTiet;
import com.mycompany.repository.impl.KhuyenMaiChiTietRepository;
import com.mycompany.service.ICommonService;
import java.util.List;

/**
 *
 * @author Duongntt
 */
public class KhuyenMaiChiTietService implements ICommonService<KhuyenMaiChiTiet, String> {

    private KhuyenMaiChiTietRepository khuyenMaiChiTietRepo = new KhuyenMaiChiTietRepository();

    @Override
    public List<KhuyenMaiChiTiet> getAll() {
        return khuyenMaiChiTietRepo.getAll();
    }

    @Override
    public KhuyenMaiChiTiet getOne(String id) {
        return khuyenMaiChiTietRepo.getOne(id);
    }

    @Override
    public String add(KhuyenMaiChiTiet khuyenMaiChiTiet) {
        if (khuyenMaiChiTietRepo.add(khuyenMaiChiTiet)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhuyenMaiChiTiet kh, String id) {
        if (khuyenMaiChiTietRepo.update(kh, id)) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public String remove(String id) {
        if (khuyenMaiChiTietRepo.remove(id)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

}
