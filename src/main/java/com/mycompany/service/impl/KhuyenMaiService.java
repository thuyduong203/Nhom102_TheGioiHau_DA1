/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.KhuyenMai;
import com.mycompany.repository.impl.KhuyenMaiRepository;
import com.mycompany.service.ICommonService;
import java.util.List;

/**
 *
 * @author Duongntt
 */
public class KhuyenMaiService implements ICommonService<KhuyenMai, String> {

    private KhuyenMaiRepository kmRepo = new KhuyenMaiRepository();

    @Override
    public List<KhuyenMai> getAll() {
        return kmRepo.getAll();
    }

    @Override
    public KhuyenMai getOne(String ma) {
        return kmRepo.getOne(ma);
    }

    @Override
    public String add(KhuyenMai kh) {
        if (kmRepo.add(kh)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhuyenMai kh, String ma) {
        if (kmRepo.update(kh, ma)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String remove(String ma) {
        if (kmRepo.remove(ma)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

}
