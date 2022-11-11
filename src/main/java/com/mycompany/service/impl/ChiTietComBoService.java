/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.ChiTietComBo;
import com.mycompany.domainModel.ComBo;
import com.mycompany.domainModel.MonAn;
import com.mycompany.repository.IChiTietComBoRepository;
import com.mycompany.repository.impl.ChiTietComBoRepository;
import com.mycompany.service.IChiTietComBoService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChiTietComBoService implements IChiTietComBoService<ChiTietComBo, String, Integer, ComBo, MonAn> {

    private IChiTietComBoRepository ctcbr = new ChiTietComBoRepository();

    @Override
    public List<ChiTietComBo> getAll() {
        return ctcbr.getAll();
    }

    @Override
    public String add(ChiTietComBo ctcb) {
        if ((Boolean) ctcbr.add(ctcb)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ChiTietComBo chiTietComBo, ComBo comBo, MonAn monAn) {
        if ((Boolean) ctcbr.update(chiTietComBo, comBo, monAn)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String remove(ChiTietComBo ctcb, ComBo comBo, MonAn monAn) {
        if ((Boolean) ctcbr.remove(ctcb, comBo, monAn)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }
    public static void main(String[] args) {
        MonAn ma = new MonAn();
        ma.setId("F140701F-1D94-49E6-97EC-46CDAB6D9EC6");
        ComBo comBo = new ComBo();
        comBo.setId("E791ED65-7819-44F0-BFF3-BEE9795F6E5D");
        ChiTietComBo ctcb = new ChiTietComBo(null, comBo, ma, 20);
        String test = new ChiTietComBoService().update(ctcb,comBo,ma);
        System.out.println(test);
    }

}
