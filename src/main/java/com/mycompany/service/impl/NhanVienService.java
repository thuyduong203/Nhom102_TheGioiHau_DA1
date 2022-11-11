/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.NhanVien;
import com.mycompany.repository.impl.NhanVienRepository;
import com.mycompany.service.ICommonService;
import java.util.List;

/**
 *
 * @author Duongntt
 */
public class NhanVienService implements ICommonService<NhanVien, String> {

    private NhanVienRepository nvRepo = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return nvRepo.getAll();
    }

    @Override
    public NhanVien getOne(String ma) {
        return nvRepo.getOne(ma);
    }

    @Override
    public String add(NhanVien nv) {
        if (nvRepo.add(nv)) {
            return "Them thanh cong";
        } else {
            return "them that bai";
        }
    }

    @Override
    public String update(NhanVien nv, String id) {
        if (nvRepo.update(nv, id)) {
            return "Update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String remove(String id) {
        if (nvRepo.remove(id)) {
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

}
