/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.GiaoDich;
import com.mycompany.repository.impl.GiaoDichRepository;
import com.mycompany.service.ICommonService;
import java.util.List;

/**
 *
 * @author son45
 */
public class GiaoDichService implements ICommonService<GiaoDich, String> {

    private GiaoDichRepository gdr = new GiaoDichRepository();

    @Override
    public List<GiaoDich> getAll() {
        return gdr.getAll();
    }

    @Override
    public GiaoDich getOne(String ma) {
        return gdr.getOne(ma);
    }

    @Override
    public String add(GiaoDich nv) {
        if (gdr.add(nv)) {
            return "Them thanh cong";
        } else {
            return "them that bai";
        }
    }

    @Override
    public String update(GiaoDich nv, String id) {
        if (gdr.update(nv, id)) {
            return "Update thanh cong";
        } else {
            return "update that bai";
        }
    }

    @Override
    public String remove(String id) {
        if (gdr.remove(id)) {
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

}
