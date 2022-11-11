/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.CaLamViec;
import com.mycompany.repository.impl.CaLamViecRepository;
import com.mycompany.service.ICommonService;
import java.util.List;

/**
 *
 * @author Duongntt
 */
public class CaLamViecService implements ICommonService<CaLamViec, String> {

    private CaLamViecRepository caLamViecRepo = new CaLamViecRepository();

    @Override
    public List<CaLamViec> getAll() {
        return caLamViecRepo.getAll();
    }

    @Override
    public CaLamViec getOne(String id) {
        return caLamViecRepo.getOne(id);
    }

    @Override
    public String add(CaLamViec caLamViec) {
        if (caLamViecRepo.add(caLamViec)) {
            return "thêm thành công";
        } else {
            return "thêm thất bại";
        }
    }

    @Override
    public String update(CaLamViec caLamViec, String id) {
        if (caLamViecRepo.update(caLamViec, id)) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public String remove(String id) {
        if (caLamViecRepo.remove(id)) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }

}
